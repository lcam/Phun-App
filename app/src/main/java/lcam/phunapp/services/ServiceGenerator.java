package lcam.phunapp.services;


import android.util.Log;

import java.util.List;

import lcam.phunapp.model.Events;
import lcam.phunapp.presenter.GridPresenter;
import lcam.phunapp.view.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String API_BASE_URL = "https://raw.githubusercontent.com/phunware/";
    private EventClient eventClient;
    private GridPresenter presenter;
    private List<Events> data;

    public ServiceGenerator(MainActivity mainActivity) {
        presenter = new GridPresenter(mainActivity, this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        eventClient = retrofit.create(EventClient.class);
    }

    public void loadData() {
        Call<List<Events>> call = eventClient.loadInfo();
        // asynchronous call to API
        call.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Call<List<Events>> call, Response<List<Events>> response) {
                //JSONResponse jsonResponse = response.body();
                List<Events> data = response.body();
                presenter.updateView(data);
            }

            @Override
            public void onFailure(Call<List<Events>> call, Throwable t) {
                Log.d("Error", t.getMessage());
                presenter.updateViewFailed();
            }
        });
    }
}
