package com.rezajax.college.boy2.Downloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.SimpleAdapter;

import com.rezajax.college.boy2.CustomAdapter;
import com.rezajax.college.boy2.Model.DataModel;
import com.rezajax.college.boy2.R;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageDownloaderTask extends
        AsyncTask<HashMap<String, Object> , Void , HashMap<String, Object>> {
    Context mContextBaseContext;
    ArrayList<DataModel> mDataModels;

    String imgUrl;
    int position;


    public ImageDownloaderTask(Context mContextBaseContext, ArrayList<DataModel> mDataModels)  {
        this.mContextBaseContext = mContextBaseContext;
        this.mDataModels = mDataModels;
    }

    @Override
    protected HashMap<String, Object> doInBackground(HashMap<String, Object>... params)
    {
        InputStream myStream;

        imgUrl = (String) params[0].get( "image_path" );
        position = (Integer) params[0].get( "position" );


        if (!imgUrl.equals("http://rezajax.ir/boy2/img/emp")) {
            Log.i("img", imgUrl);

            try {
                URL url = new URL(imgUrl);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setDoInput(true);

                connection.connect();

                myStream = connection.getInputStream();

                File cacheDirectory = mContextBaseContext.getCacheDir();

                File temp = new File(cacheDirectory.getPath()
                        + "/image_" + position + ".png"); // + "_" + add_someting_dire

                FileOutputStream outStream = new FileOutputStream(temp);

                Bitmap b = BitmapFactory.decodeStream(myStream);

                b.compress(Bitmap.CompressFormat.PNG, 100, outStream);

                outStream.flush();

                outStream.close();

                HashMap<String, Object> bitmap = new HashMap<>();

                //if (temp.exists()) {

                bitmap.put("image", temp.getPath());
                //Log.i("intImg" , temp.getPath() );
                bitmap.put("position", position);

                return bitmap;
                //}

            } catch (Exception e) {
                Log.i("MatiMessage", "error in ImageDownloaderTask -> " + e.toString());


            }

        }

        HashMap<String, Object> bitmap = new HashMap<>();

        bitmap.put("image", "emp");
        bitmap.put("position", position);
        return bitmap;

        //Log.i("intImg" , "return null" );
        //return null;
    }

    @Override
    protected void onPostExecute(HashMap<String, Object> result) {
        //super.onPostExecute(stringObjectHashMap);

        //@Nullable String imgUrl = (String) result.get(  "image" );
        //int position = (Integer) result.get( "position" );

//        Log.i("intImg" , result.get( "image" ) + "" );

        if (result.get( "image" ) != "emp" ) { //or position


            //Log.i("intImg" , result.get( "image" ) + "" );

//            AlertController.RecycleListView
//            SimpleAdapter simpleAdapter = (SimpleAdapter) new CustomAdapter.
            CustomAdapter customAdapter = new CustomAdapter(mContextBaseContext);
            customAdapter.updateData( result );
        }

    }
}
