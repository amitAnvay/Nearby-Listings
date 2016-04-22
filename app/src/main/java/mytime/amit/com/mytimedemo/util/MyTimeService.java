package mytime.amit.com.mytimedemo.util;

import java.util.List;

import mytime.amit.com.mytimedemo.model.Deal;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Amit_Gupta on 3/22/16.
 */
public interface MyTimeService {

//        @GET("/api/v1/deals.json?what={what}&when={when}&where={latLong}")
//        Call<List<Deal>> listRepos(@Path("what") String what,@Path("when") String when,@Path("latLong") String latLong );

        @GET("/api/v1/deals.json?/what=Massage&when=Anytime&where=34.052200,-118.242800")
        Call<List<Deal>> listRepos();
}
