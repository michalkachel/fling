package pl.elabo.flingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import pl.elabo.flingchallenge.model.base.BaseModel;

public class Item extends BaseModel implements Serializable {

	@SerializedName("ImageID")
	protected long mImageId;

	@SerializedName("Title")
	protected String mTitle;

	@SerializedName("UserID")
	protected long mUserId;

	@SerializedName("UserName")
	protected String mUserName;

	public long getImageId() {
		return mImageId;
	}

	public String getTitle() {
		return mTitle;
	}
}
