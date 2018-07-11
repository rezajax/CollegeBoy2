package com.rezajax.college.boy2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rezajax.college.boy2.Downloader.JSONDownloader;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class addActivity extends AppCompatActivity {

    private final String strUrl = "http://rezajax.ir/boy2/set_user.php?appid=test&stuid=9600&pass=test&name=%D8%B9%D9%84%DB%8C$family=%D8%AD%DB%8C%D8%AF%D8%B1%DB%8C&image=a&course=%D8%B9%D9%85%D8%B1%D8%A7%D9%86&email=ali.com&phone=19&cat_id=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                JSONDownloader downloader = new JSONDownloader();
//
//                String tmpPost = downloader.downloadURL( strUrl );

                URL url = null;
                try {
                    url = new URL(strUrl);
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream os=httpURLConnection.getOutputStream();

                } catch (Exception e ) {
                    e.printStackTrace();
                }



                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
