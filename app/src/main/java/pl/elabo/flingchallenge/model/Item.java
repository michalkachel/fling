package pl.elabo.flingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Item {

	@SerializedName("ID")
	protected long mId;

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