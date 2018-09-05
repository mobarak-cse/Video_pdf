package com.motheriloveyou.butterfly.videoplayer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pdf extends AppCompatActivity {

    PDFView pdfView;
    private ProgressBar progSaveProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

          pdfView = findViewById(R.id.pdfView);
          progSaveProgress = (ProgressBar) findViewById(R.id.saveProgressid) ;

        new RetrievePDFStream().execute("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf");
    }


      class RetrievePDFStream extends AsyncTask<String,Void,InputStream>
        {

            @Override
            protected InputStream doInBackground(String... strings) {
                InputStream inputStream =null;

                try {


                    URL url = new URL(strings[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                    if(urlConnection.getResponseCode()==200){
                        inputStream = new BufferedInputStream(urlConnection.getInputStream());


                    }

                }

                catch (IOException e){
                    return null;
                }

                return  inputStream;
            }

            @Override
            protected void onPreExecute() {
                progSaveProgress.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(InputStream inputStream) {
                pdfView.fromStream(inputStream).load();
                progSaveProgress.setVisibility(View.INVISIBLE);
            }


        }



}
