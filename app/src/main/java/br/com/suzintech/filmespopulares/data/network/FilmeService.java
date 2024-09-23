package br.com.suzintech.filmespopulares.data.network;

import br.com.suzintech.filmespopulares.data.network.response.FilmeResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {

    @GET("movie/popular")
    Call<FilmeResult> obterFilmesPopulares(@Query("api_key") String chaveApi);
}
