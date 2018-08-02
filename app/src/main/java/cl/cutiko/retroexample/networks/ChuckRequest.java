package cl.cutiko.retroexample.networks;

import cl.cutiko.retroexample.models.ChuckJoke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChuckRequest {

    /*@GET("random")
    Call<ChuckJoke> getRandom();*/

    /*@GET("random/{PETER}")
    Call<ChuckJoke> getRandom(@Path("PETER") String PETER);*/

    @GET("random")
    Call<ChuckJoke> getRandom(@Query("category") String cat);

}
