package cl.cutiko.retroexample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cl.cutiko.retroexample.networks.GetJoke;

public class MainActivity extends AppCompatActivity {

    /*WRONG
    private RandomJoke randomJoke;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //WRONG
        /*randomJoke = new RandomJoke();
        randomJoke.execute("something");*/

        new RandomJoke().execute("explicit");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*ChuckRequest chuckRequest = new Interceptor().get();
                Call<ChuckJoke> call = chuckRequest.getRandom("explicit");
                call.enqueue(new Callback<ChuckJoke>() {
                    @Override
                    public void onResponse(Call<ChuckJoke> call, Response<ChuckJoke> response) {

                    }

                    @Override
                    public void onFailure(Call<ChuckJoke> call, Throwable t) {

                    }
                });*/

                /*WRONG
                randomJoke.execute("something else");*/

                new RandomJoke().execute("explicit");
            }
        });
    }


    class RandomJoke extends GetJoke {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String joke) {
            progressDialog.dismiss();
            TextView textView = findViewById(R.id.exampleTv);
            textView.setText(joke);
        }
    }
}
