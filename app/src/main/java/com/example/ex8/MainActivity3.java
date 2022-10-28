package com.example.ex8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        task = new Task();
    }

    public void delete(View view) {
        DeleteData deleteData = new DeleteData();
        deleteData.execute();
    }


    class DeleteData extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().delete(task);

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(MainActivity3.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            super.onPostExecute(unused);
            finish();
            startActivity(new Intent(MainActivity3.this, MainActivity.class));
        }
    }
}