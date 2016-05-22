package com.ramanprabhakar.goshopping;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ramanprabhakar.goshopping.model.Doc;
import com.ramanprabhakar.goshopping.model.ServerResponse;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvNext;
    RecyclerView rvHome;
    RVAdapter rvAdapter;
    ArrayList<Doc> docs = new ArrayList<Doc>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvHome = (RecyclerView)findViewById(R.id.rv_home);
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rvAdapter = new RVAdapter(MainActivity.this);
        rvHome.setAdapter(rvAdapter);

        getData();

        tvNext = (TextView)findViewById(R.id.tv_next_page);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpService.getInstance().getHomePage2(AppConstants.ASTERISK, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.START_31, AppConstants.JSON, new Callback<ServerResponse>() {
                    @Override
                    public void success(ServerResponse serverResponse, Response response) {
                        com.ramanprabhakar.goshopping.model.Response responseBody = serverResponse.getResponse();
                        docs = responseBody.getDocs();

                        if(!docs.isEmpty()){
                            updateRVAdapter(docs);
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void getData() {
        HttpService.getInstance().getHomePage1(AppConstants.ASTERISK, AppConstants.FL_LIST , AppConstants.ROWS_30, AppConstants.JSON ,new Callback<ServerResponse>() {
            @Override
            public void success(ServerResponse serverResponse, Response response) {
                com.ramanprabhakar.goshopping.model.Response responseBody = serverResponse.getResponse();
                docs = responseBody.getDocs();

                if(!docs.isEmpty()){
                    updateRVAdapter(docs);
                }

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void updateRVAdapter(ArrayList<Doc> docs) {
        rvAdapter.getList().clear();
        rvAdapter.setList(docs);
        rvAdapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, "Adapter Set", Toast.LENGTH_SHORT).show();
    }
}




