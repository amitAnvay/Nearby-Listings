package mytime.amit.com.mytimedemo.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mytime.amit.com.mytimedemo.R;
import mytime.amit.com.mytimedemo.adapters.DealListAdapter;
import mytime.amit.com.mytimedemo.model.Deal;
import mytime.amit.com.mytimedemo.util.MyTimeService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class DealsListActivity extends AppCompatActivity {

    @Bind(R.id.deal_recycler_view)
    RecyclerView dealListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_list);

        ButterKnife.bind(this);


        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mytime.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyTimeService service = retrofit.create(MyTimeService.class);
        Call<List<Deal>> repos = service.listRepos();
        repos.enqueue(new Callback<List<Deal>>() {

            @Override
            public void onResponse(Response<List<Deal>> response, Retrofit retrofit) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    //  Toast.makeText(getApplicationContext(), "Message Received" + response.isSuccess(), Toast.LENGTH_SHORT).show();
                    ArrayList<Deal> deals = (ArrayList<Deal>) response.body();
                    dealListRecyclerView.setAdapter(new DealListAdapter(getApplicationContext(),deals));
                } else {

                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
                Log.d("MainActivity", "Failed = " + t.getMessage());
            }
        });



        dealListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        dealListRecyclerView.setAdapter(new dealListAdapter(this));

    }

}
