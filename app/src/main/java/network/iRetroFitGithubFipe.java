package network;

import java.util.List;

import model.Veiculo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface iRetroFitGithubFipe {

    @GET("/users/{usuario}")
    Call<Veiculo> getVeiculo(@Path("veiculo") String veiculo);

    @GET("/users/{usuario}/followers")
    Call<List<Veiculo>> getSeguidores(@Path("veiculo") String veiculo);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://parallelum.com.br/fipe/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
