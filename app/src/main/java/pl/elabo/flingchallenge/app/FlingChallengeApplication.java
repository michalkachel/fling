package pl.elabo.flingchallenge.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import pl.elabo.flingchallenge.BuildConfig;
import pl.elabo.flingchallenge.repository.DatabaseRepository;
import pl.elabo.flingchallenge.repository.FlingDatabaseHelper;
import timber.log.Timber;

public class FlingChallengeApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		if (BuildConfig.DEBUG) {
			Timber.plant(new Timber.DebugTree());
		}

		initDatabaseAndRepository();
	}

	private void initDatabaseAndRepository() {
		FlingDatabaseHelper databaseHelper = new FlingDatabaseHelper(this);
		SQLiteDatabase database = databaseHelper.getWritableDatabase();
		DatabaseRepository.init(database);
	}

}
