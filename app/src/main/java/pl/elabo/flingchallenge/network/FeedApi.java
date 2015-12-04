package pl.elabo.flingchallenge.network;


import pl.elabo.flingchallenge.model.Item;
import retrofit.Call;
import retrofit.http.GET;

public interface FeedApi {

	@GET("")
	Call<Item> feed();

}
