package pl.elabo.flingchallenge.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.elabo.flingchallenge.R;
import pl.elabo.flingchallenge.mvp.view.base.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

	@Nullable
	@Bind(R.id.toolbar)
	Toolbar mToolbar;

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
		//// TODO: 04.12.15 implement notification manager
	}
}
