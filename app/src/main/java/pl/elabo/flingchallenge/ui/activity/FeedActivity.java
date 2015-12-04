package pl.elabo.flingchallenge.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

	@Bind(R.id.feed_recycler_view)
	RecyclerView mFeedRecyclerView;

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

		mFeedPresenter.onCreate();
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
	public void initList() {
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		mFeedRecyclerView.setLayoutManager(layoutManager);
		mFeedRecyclerViewAdapter = new FeedRecyclerViewAdapter();
		mFeedRecyclerView.setAdapter(mFeedRecyclerViewAdapter);
	}

	@Override
	public void showItems(List<Item> items) {
		mFeedRecyclerViewAdapter.setFeedItems(items);
	}
}
