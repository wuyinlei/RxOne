// (c)2016 Flipboard Inc, All Rights Reserved.

package yinlei.play.daima;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<GankBean> getBeauties(@Path("number") int number, @Path("page") int page);
}
