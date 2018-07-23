package com.rezajax.college.boy2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class addActivity extends AppCompatActivity {

    private final String strUrl1 = "http://rezajax.ir/boy2/set_user.php?appid=test&stuid=9600&pass=test&name=%D8%B9%D9%84%DB%8C$family=%D8%AD%DB%8C%D8%AF%D8%B1%DB%8C&image=a&course=%D8%B9%D9%85%D8%B1%D8%A7%D9%86&email=ali.com&phone=19&cat_id=5";
    private final String strUrl2 = "rezajax.ir/boy2/set_post.php?name=یک فایل تست&header=این جا هیچی نیست&text=متنی وجود ندارد";
    private final String strUrl = "rezajax.ir/boy2/set_post.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String str_name = "name=یک فایل تست";
        final String str_header = "header=این جا هیچی نیست";
        final String str_text = "text=متنی وجود ندارد";
        final String and = "&";
        final String sum = str_name + and + str_header + and + str_text;

        final String urlInsertPost = strUrl + str_name + "&" + str_header + "&" + str_text ; //strUrl + str_name + "&" + str_header + "&" + str_text ;

                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                JSONDownloader downloader = new JSONDownloader();
//
//                String tmpPost = downloader.downloadURL( strUrl );


                /*try {
                    URL url = new URL(strUrl);
                    String type = "application/json";
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", type);
                    httpURLConnection.connect();

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", "سلام");
                    jsonObject.put("header", "خوبی");
                    jsonObject.put("text", "عشق");

                    DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                    wr.writeBytes(jsonObject.toString());
                    wr.flush();
                    wr.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                /*URL url = null;
                try {

//                    HttpParams params = new HttpParams() {
//                    };


                    url = new URL(urlInsertPost);

                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

                    String urlParams = str_name + and + str_header + and + str_text;
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("USER-AGENT" , "Mozilla/5.0");
                    httpURLConnection.setRequestProperty("ACCEPT-LANGUAGE" , "en-US,en;0.5");
                    //httpURLConnection.setReadTimeout(10000);

                    httpURLConnection.setDoOutput(true);
                    DataOutputStream outputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    outputStream.writeBytes(urlParams);
                    outputStream.flush();
                    outputStream.close();

                } catch (Exception e ) {
                    e.printStackTrace();
                }*/

                String[] ali = new String[2];
                ali[0] = strUrl;
                ali[1] = sum;
                AsyncTask<String, String, String> execute = new CallAPI();

                execute.execute(strUrl, sum);

                /*Log.i("STATUS" , "emp1");

                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Log.i("STATUS" , "emp2");

                            URL url = new URL(strUrl); //in the real code, there is an ip and a port
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setRequestProperty("Content-Type", "application/json");
                            conn.setRequestProperty("Accept","application/json");
                            conn.setDoOutput(true);
                            conn.setDoInput(true);
                            conn.connect();

                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("name", "hi");
                            jsonObject.put("header", "hellow");
                            jsonObject.put("text", "loooove code");


                            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                            os.writeBytes(URLEncoder.encode(jsonObject.toString(), "UTF-8"));

                            os.flush();
                            os.close();

                            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
                            Log.i("STATUS" , conn.getResponseMessage());
                            Log.i("STATUS" , "emp0");

                            conn.disconnect();
                        } catch (Exception e) {

                        }

                    }
                });

                thread.start();*/


                //new upload();




                Snackbar.make(view, "مقاله ارسال شد", Snackbar.LENGTH_LONG) //"Replace with your own action"
                        .setAction("Action", null).show();
            }
        });
    }

    public class CallAPI extends AsyncTask<String, String, String> {

        public CallAPI(){
            //set context variables if required
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0]; // URL to call
            String data = params[1]; //data to post
            OutputStream out = null;
            Log.i("STATUS" , "urlString: " + params[0] + "data: " + params[1]);

            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                out = new BufferedOutputStream(urlConnection.getOutputStream());

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                out.close();

                urlConnection.connect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return urlString;
        }
    }
}
