package pl.elabo.flingchallenge.model.base;

import com.google.gson.annotations.SerializedName;

import pl.elabo.flingchallenge.repository.DatabaseRepository;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public abstract class BaseModel {

	@SerializedName("ID")
	protected Long _id;

	public void save() {
		_id = cupboard().withDatabase(DatabaseRepository.getDatabase()).put(this);
	}

}
