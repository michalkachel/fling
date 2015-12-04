package pl.elabo.flingchallenge.network;


import java.util.List;

import pl.elabo.flingchallenge.model.Item;
import retrofit.Call;
import retrofit.http.GET;

public interface FeedApi {

	@GET("/")
	Call<List<Item>> feed();

}
