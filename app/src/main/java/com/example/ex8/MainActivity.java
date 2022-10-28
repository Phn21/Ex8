package com.example.ex8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age = findViewById(R.id.ageED);
        name = findViewById(R.id.nameED);

    }



    public void save(View view) {

        SaveData saveData = new SaveData();
        saveData.execute();

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }


    class SaveData extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            task = new Task();
            task.setName(name.getText().toString());
            task.setAge(age.getText().toString());

            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().taskDao().insert(task);

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
        }
    }

    public void view(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void change(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
    }
}