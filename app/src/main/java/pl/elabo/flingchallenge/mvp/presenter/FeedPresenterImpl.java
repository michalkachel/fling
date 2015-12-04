package pl.elabo.flingchallenge.mvp.presenter;


import java.util.List;

import pl.elabo.flingchallenge.model.Item;
import pl.elabo.flingchallenge.mvp.presenter.base.BasePresenter;
import pl.elabo.flingchallenge.mvp.view.FeedView;
import pl.elabo.flingchallenge.network.RestClient;
import pl.elabo.flingchallenge.repository.DatabaseRepository;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class FeedPresenterImpl extends BasePresenter<FeedView> implements FeedPresenter {

	private Call<List<Item>> mFeedCall;

	public FeedPresenterImpl(FeedView view) {
		super(view);
	}

	@Override
	public void onCreate() {
		getView().initList();
	}

	@Override
	public void onResume() {
		if (getView().isInternetAvailable()) {
			requestFeed();
		} else {
			loadFeedFromDatabase();
		}
	}

	@Override
	public void onPause() {
		cancelCalls();
	}

	private void loadFeedFromDatabase() {
		List<Item> items = DatabaseRepository.allItems();
		getView().showItems(items);
	}

	private void requestFeed() {
		cancelCalls();
		mFeedCall = RestClient.getFeedApi().feed();
		mFeedCall.enqueue(new Callback<List<Item>>() {
			@Override
			public void onResponse(Response<List<Item>> response, Retrofit retrofit) {
				final List<Item> items = response.body();
				if (response.isSuccess() && items != null) {
					saveItems(items);
					getView().showItems(items);
				} else {
					loadFeedFromDatabase();
				}
			}

			@Override
			public void onFailure(Throwable t) {
				t.printStackTrace();
				if (isCausedByCancel(t)) {
					getView().showError(t);
					loadFeedFromDatabase();
				}
			}
		});
	}

	private void saveItems(List<Item> items) {
		for (Item item : items) {
			item.save();
		}
	}

	private boolean isCausedByCancel(Throwable t) {
		return t.getMessage() != null && t.getMessage().equals("Canceled");
	}

	private void cancelCalls() {
		RestClient.getHttpClient().getDispatcher().getExecutorService().execute(new Runnable() {
			@Override
			public void run() {
				if (mFeedCall != null) {
					mFeedCall.cancel();
				}
			}
		});
	}
}
