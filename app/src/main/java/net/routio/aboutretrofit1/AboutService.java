package net.routio.aboutretrofit1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AboutService {

    @GET()
    Call<About> getAbouts();

    @GET
    Call<About> getAbouts(@Url String url);
}
