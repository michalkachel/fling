package pl.elabo.flingchallenge.mvp.presenter;

import java.util.List;

import pl.elabo.flingchallenge.model.Item;

public interface FeedPresenter {

	void onCreate();

	void onCreate(List<Item> items);

	void onResume();

	void onPause();

}
