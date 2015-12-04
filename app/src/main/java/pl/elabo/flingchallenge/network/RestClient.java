package pl.elabo.flingchallenge.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import pl.elabo.flingchallenge.app.AppConstants;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RestClient {

	private static RestClient sRestClient;

	private OkHttpClient mOkHttpClient;
	private FeedApi mFeedApi;

	public RestClient() {
		mOkHttpClient = new OkHttpClient();
		Gson gson = new GsonBuilder()
				.create();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(AppConstants.BASE_URL)
				.client(mOkHttpClient)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.build();

		mFeedApi = retrofit.create(FeedApi.class);
	}

	private static RestClient getInstance() {
		if (sRestClient == null) {
			sRestClient = new RestClient();
		}
		return sRestClient;
	}

	public static FeedApi getFeedApi() {
		return getInstance().mFeedApi;
	}

	public static OkHttpClient getHttpClient() {
		return getInstance().mOkHttpClient;
	}
}
