package pl.elabo.flingchallenge.app;

import android.app.Application;

import pl.elabo.flingchallenge.BuildConfig;
import timber.log.Timber;

public class FlingChallengeApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		if (BuildConfig.DEBUG) {
			Timber.plant(new Timber.DebugTree());
		}
	}

}
