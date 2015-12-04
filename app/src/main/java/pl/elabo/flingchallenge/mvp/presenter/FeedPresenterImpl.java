package pl.elabo.flingchallenge.mvp.presenter;


import pl.elabo.flingchallenge.mvp.presenter.base.BasePresenter;
import pl.elabo.flingchallenge.mvp.view.base.BaseView;

public class FeedPresenterImpl extends BasePresenter<BaseView> implements FeedPresenter {

	public FeedPresenterImpl(BaseView view) {
		super(view);
	}

	@Override
	public void onCreate() {

	}
}
