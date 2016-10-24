package lcam.phunapp.services;


import java.util.List;

import lcam.phunapp.model.Events;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EventClient {
    // https://raw.githubusercontent.com/phunware/
    // dev-interview-homework/master/feed.json
    @GET("dev-interview-homework/master/feed.json")
    Call<List<Events>> loadInfo();
}
