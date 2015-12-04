package pl.elabo.flingchallenge.mvp.view;

import java.util.List;

import pl.elabo.flingchallenge.model.Item;
import pl.elabo.flingchallenge.mvp.view.base.BaseView;

public interface FeedView extends BaseView {

	void initList();

	void showItems(List<Item> items);

}
