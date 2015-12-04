package pl.elabo.flingchallenge.ui.activity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import butterknife.Bind;
import pl.elabo.flingchallenge.R;
import pl.elabo.flingchallenge.model.Item;
import pl.elabo.flingchallenge.mvp.presenter.FeedPresenter;
import pl.elabo.flingchallenge.mvp.presenter.FeedPresenterImpl;
import pl.elabo.flingchallenge.mvp.view.FeedView;
import pl.elabo.flingchallenge.ui.activity.base.BaseActivity;
import pl.elabo.flingchallenge.ui.adapter.FeedRecyclerViewAdapter;

public class FeedActivity extends BaseActivity implements FeedView {

	public static final String LAYOUT_MANEGER_STATE_KEY = "layout_manager_state_key";
	public static final String ITEMS_STATE_KEY = "items_state_key";

	@Bind(R.id.feed_recycler_view)
	RecyclerView mFeedRecyclerView;

	private RecyclerView.LayoutManager mLayoutManager;
	private FeedRecyclerViewAdapter mFeedRecyclerViewAdapter;

	private FeedPresenter mFeedPresenter;

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (mFeedPresenter == null) {
			mFeedPresenter = new FeedPresenterImpl(this);
		}

		if (savedInstanceState == null) {
			mFeedPresenter.onCreate();
		} else {
			mFeedPresenter.onCreate((List<Item>) savedInstanceState.getSerializable(ITEMS_STATE_KEY));
			mLayoutManager.onRestoreInstanceState(savedInstanceState.getParcelable(LAYOUT_MANEGER_STATE_KEY));
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		mFeedPresenter.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mFeedPresenter.onPause();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putParcelable(LAYOUT_MANEGER_STATE_KEY, mLayoutManager.onSaveInstanceState());
		outState.putSerializable(ITEMS_STATE_KEY, (Serializable) mFeedRecyclerViewAdapter.getItems());
		super.onSaveInstanceState(outState);
	}

	@Override
	public void initList() {
		mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mFeedRecyclerView.setLayoutManager(mLayoutManager);
		mFeedRecyclerViewAdapter = new FeedRecyclerViewAdapter();
		mFeedRecyclerView.setAdapter(mFeedRecyclerViewAdapter);
	}

	@Override
	public void showItems(List<Item> items) {
		mFeedRecyclerViewAdapter.setFeedItems(items);
	}

	@Override
	public boolean isInternetAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
