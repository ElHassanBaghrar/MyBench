package mybench.parisnanterre.fr.mybench;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class ConnexionActivity extends AppCompatActivity {

    private EditText BENCH_TITLE, BENCH_POSITION, BENCH_ENVIRONNEMENT, BENCH_POLLUTION, BENCH_BRUIT;
    private Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        try
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_connexion);

            // recuperation des elements venant de la vue

            BENCH_TITLE = (EditText)findViewById(R.id.BENCH_TITLE);
            BENCH_POSITION = (EditText)findViewById(R.id.BENCH_POSITION);
            BENCH_ENVIRONNEMENT = (EditText)findViewById(R.id.BENCH_ENVIRONNEMENT);
            BENCH_POLLUTION = (EditText)findViewById(R.id.BENCH_POLLUTION);
            BENCH_BRUIT = (EditText)findViewById(R.id.BENCH_BRUIT);
            bouton = (Button)findViewById(R.id.bouton);


            bouton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View view) {

                    // l'operation de communication doit se faire en arriere plan d'ou l'utilisation de l'asynctask

                    new AddBench().execute("create",BENCH_TITLE.getText().toString(),
                            BENCH_POSITION.getText().toString(),
                            BENCH_ENVIRONNEMENT.getText().toString(),
                            BENCH_POLLUTION.getText().toString(),
                            BENCH_BRUIT.getText().toString());

                }
            });
        }
        catch (Exception e)
        {
            Log.i("Erreur 1", e.toString());
        }


    }


    // Asynctask destine a l'operation d'arriere plan

    private class AddBench extends AsyncTask<String, Void, String> {
        @TargetApi(Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... args) {

            HttpBench httpBench = new HttpBench();

            try {
                return httpBench.Create(args[0],args[1],args[2],args[3], args[4],args[5]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            if(result != null) Log.e("ERROR",result);

            Toast.makeText(getApplicationContext(),"operation reussie "+result,Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPreExecute() {

            // Things to be done before execution of long running operation. For
            // example showing ProgessDialog

        }
    }

}