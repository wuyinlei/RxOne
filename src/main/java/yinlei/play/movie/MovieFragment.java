package yinlei.play.movie;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import yinlei.play.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    String apikey = "5706ce9264d54f6c887e2c0c54d9f8bf";
    String baseUrl = "http://apis.haoservice.com/lifeservice/boxoffice/";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private MovieAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);
        initView();
//        get();
        getByRxJava();
        return view;
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swipeRefreshLayout.setEnabled(false);
    }

    private void getByRxJava() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Observable<Movice> observable = service.getMoviceData("CN",apikey);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Movice>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(getContext(), "onCompleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                        Log.e("MovieFragment", "onFailure: ", e);
                    }

                    @Override
                    public void onNext(Movice movice) {
                        adapter = new MovieAdapter();
                        List<Movice.ResultBean> resultBeans = movice.getResult();
                        adapter.setResultBeen(resultBeans);
                        recyclerView.setAdapter(adapter);
                    }
                });

    }

    private void get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        swipeRefreshLayout.setRefreshing(true);
        service.loadMovice("CN", apikey).enqueue(new Callback<Movice>() {
            @Override
            public void onResponse(Call<Movice> call, Response<Movice> response) {
                if (response.body() != null) {
                    Movice movice = response.body();
                    List<Movice.ResultBean> resultBeans = movice.getResult();
//                    if (resultBeans != null && resultBeans.size() > 0) {
//                        for (int i = 0; i < resultBeans.size(); i++) {
//                            Movice.ResultBean resultBean = resultBeans.get(i);
//                            Log.d("MovieFragment", "电影名字：" + resultBean.getName());
//                        }
//                    }
                    swipeRefreshLayout.setRefreshing(false);
                    adapter = new MovieAdapter();
                    adapter.setResultBeen(resultBeans);
                    recyclerView.setAdapter(adapter);
                } else {
                    swipeRefreshLayout.setRefreshing(false);
                    Log.d("MovieFragment", "onPresponse: body = null");
                }
            }

            @Override
            public void onFailure(Call<Movice> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("MovieFragment", "onFailure: ", t);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
