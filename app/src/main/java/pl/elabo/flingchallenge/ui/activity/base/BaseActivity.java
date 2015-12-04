package pl.elabo.flingchallenge.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.elabo.flingchallenge.R;
import pl.elabo.flingchallenge.mvp.view.base.BaseView;
import pl.elabo.flingchallenge.util.NotificationManager;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

	@Nullable
	@Bind(R.id.toolbar)
	Toolbar mToolbar;

	@Nullable
	@Bind(R.id.toolbar_progress_bar)
	ProgressBar mProgressBar;

	@LayoutRes
	protected abstract int getLayoutId();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);

		if (mToolbar != null) {
			setSupportActionBar(mToolbar);
		}
	}

	@Override
	public void showError(Throwable throwable) {
		NotificationManager.showMessage(this, getString(R.string.message_error_occured_colon) + throwable.getMessage(), true);
	}

	@Override
	public void showProgress() {
		if (mProgressBar != null) {
			mProgressBar.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void hideProgress() {
		if (mProgressBar != null) {
			mProgressBar.setVisibility(View.GONE);
		}
	}
}
