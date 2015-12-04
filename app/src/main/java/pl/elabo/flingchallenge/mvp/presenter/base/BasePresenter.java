package pl.elabo.flingchallenge.mvp.presenter.base;

import pl.elabo.flingchallenge.mvp.view.base.BaseView;

public abstract class BasePresenter<T extends BaseView> {
	private T mView;

	public BasePresenter(T view) {
		mView = view;
	}

	protected T getView() {
		return mView;
	}

}
