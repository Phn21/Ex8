package com.example.ex8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GetTasks getTasks = new GetTasks();
        getTasks.execute();

    }

    class GetTasks extends AsyncTask<Void, Void, List<Task>>{

        @Override
        protected List<Task> doInBackground(Void... voids) {

            List<Task> taskList = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().getAll();

            return taskList;
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {
            super.onPostExecute(tasks);

            RVAdapter rvAdapter = new RVAdapter(MainActivity2.this,tasks);
            recyclerView.setAdapter(rvAdapter);
        }
    }
}