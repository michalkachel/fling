package pl.elabo.flingchallenge.util;

import pl.elabo.flingchallenge.app.AppConstants;

public class UrlUtil {

	public static String photoUrl(long imageId) {
		return String.format("%s%s%d", AppConstants.BASE_URL, AppConstants.PHOTOS_SLUG, imageId);
	}

}
