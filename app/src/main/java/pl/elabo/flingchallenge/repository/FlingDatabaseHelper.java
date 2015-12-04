package pl.elabo.flingchallenge.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nl.qbusict.cupboard.CupboardBuilder;
import nl.qbusict.cupboard.CupboardFactory;
import pl.elabo.flingchallenge.app.AppConstants;
import pl.elabo.flingchallenge.model.Item;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class FlingDatabaseHelper extends SQLiteOpenHelper {

	static {
		CupboardFactory.setCupboard(new CupboardBuilder().useAnnotations().build());
		cupboard().register(Item.class);
	}

	public FlingDatabaseHelper(Context context) {
		super(context, AppConstants.Database.NAME, null, AppConstants.Database.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		cupboard().withDatabase(sqLiteDatabase).createTables();
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		cupboard().withDatabase(sqLiteDatabase).upgradeTables();
	}
}
