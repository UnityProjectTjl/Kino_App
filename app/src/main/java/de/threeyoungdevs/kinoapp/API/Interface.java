package de.threeyoungdevs.kinoapp.API;

import java.util.List;

import de.threeyoungdevs.kinoapp.Model.Cinema;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface
{
    @GET("/wp/v2/posts")
    Call<List<Cinema>> listRepos();
}
