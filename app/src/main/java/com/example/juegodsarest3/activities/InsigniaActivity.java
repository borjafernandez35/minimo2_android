package com.example.juegodsarest3.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Insignia;
import com.example.juegodsarest3.models.Ranking;
import com.example.juegodsarest3.models.Swagger;
import com.example.juegodsarest3.models.TablaInsignia;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsigniaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptadorInsignias adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ProgressBar theProgressBar;
    private final String TAG = InicialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = (RecyclerView) findViewById(R.id.my_new_recycler_view_ranking);
        theProgressBar = (ProgressBar) findViewById(R.id.progressBarRanking);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AdaptadorInsignias();
        recyclerView.setAdapter(adapter);
        doApiCall();


        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        adapter.remove(viewHolder.getAdapterPosition());
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    private void doApiCall() {
        Swagger swagger = Swagger.retrofit.create(Swagger.class);
        Call<List<Insignia>> call = swagger.getlistaInsigniaUsuario();

        theProgressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<List<Insignia>>() {
            @Override
            public void onResponse(Call<List<Insignia>> call, Response<List<Insignia>> response) {
                theProgressBar.setVisibility(View.INVISIBLE);

                adapter.setData(response.body());


            }



            @Override
            public void onFailure(Call<List<Insignia>> call, Throwable t) {


                String msg = "Error con el retrofit: "+t.toString();
                Log.d(TAG,msg);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
            }
        });
    }
}
