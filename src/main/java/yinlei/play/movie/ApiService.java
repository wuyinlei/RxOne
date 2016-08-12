package yinlei.play.movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface ApiService {

    @GET("rank")
    Call<Movice> loadMovice(@Query("area") String area,@Query("key") String apiley);

    @GET("rank")
    Observable<Movice> getMoviceData(@Query("area") String area,@Query("key") String apiley);


}
