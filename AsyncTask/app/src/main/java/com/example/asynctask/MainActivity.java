package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CongViec().execute();
            }
        });
    }
    public class CongViec extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt.setText("Start!" + "\n");
        }


        @Override
        protected String doInBackground(Void... voids) {

            for(int i = 1; i <= 5; i++){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                publishProgress("Việc " + i + "\n");
            }

            return "End!";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txt.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txt.append(values[0]);
        }
    }
}