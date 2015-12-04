package pl.elabo.flingchallenge.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pl.elabo.flingchallenge.model.Item;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DatabaseRepository {

	private static SQLiteDatabase sDatabase;

	public static void init(SQLiteDatabase db) {
		sDatabase = db;
	}

	public static SQLiteDatabase getDatabase() {
		return sDatabase;
	}

	public static List<Item> allItems() {
		List<Item> allItems = new ArrayList<>();
		Cursor itemsCursor = cupboard().withDatabase(sDatabase).query(Item.class).getCursor();
		try {
			for (Item wardrobeItem : cupboard().withCursor(itemsCursor).iterate(Item.class)) {
				allItems.add(wardrobeItem);
			}
		} finally {
			itemsCursor.close();
		}

		return allItems;
	}

}
