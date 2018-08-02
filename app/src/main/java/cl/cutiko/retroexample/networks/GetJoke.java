package cl.cutiko.retroexample.networks;

import android.os.AsyncTask;

import java.io.IOException;

import cl.cutiko.retroexample.models.ChuckJoke;
import retrofit2.Response;

public class GetJoke extends AsyncTask<String, Integer, String> {

    @Override
    protected void onPreExecute() {
        //I have access to the UI
    }

    @Override
    protected void onPostExecute(String s) {
        //I have access to the UI
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //I have access to the ui
        //values[0]
    }

    @Override
    protected String doInBackground(String... strings) {
        //publishProgress(4, 3, 2);
        //publishProgress(4);

        String result = "Didn't work";
        String category = strings[0];

        ChuckRequest request = new Interceptor().get();
        retrofit2.Call<ChuckJoke> call = request.getRandom(category);
        try {
            Response<ChuckJoke> response = call.execute();
            if (response.code() == 200 && response.isSuccessful()) {
                ChuckJoke chuckJoke = response.body();
                if (chuckJoke != null) {
                    result = chuckJoke.getValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
