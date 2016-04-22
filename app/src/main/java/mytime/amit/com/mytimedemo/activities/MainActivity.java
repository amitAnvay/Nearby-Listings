package mytime.amit.com.mytimedemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mytime.amit.com.mytimedemo.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onFetchDealButtonClick(View view){
        Intent i = new Intent(MainActivity.this, DealsListActivity.class);
        startActivity(i);
    }
}
