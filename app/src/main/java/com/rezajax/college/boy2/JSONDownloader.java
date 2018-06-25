package com.rezajax.college.boy2;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONDownloader {

    public String downloadURL(String strUrl )
    {
        String data = "";

        try
        {
            URL url = new URL( strUrl );

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setReadTimeout(10000);

            connection.setConnectTimeout(15000);

            connection.setRequestMethod("GET");

            connection.setDoInput(true);

            connection.connect();

            InputStream myStream = connection.getInputStream();

            BufferedReader br = new BufferedReader( new InputStreamReader( myStream ) );

            StringBuilder sb = new StringBuilder();

            String line;

            while ( ( line = br.readLine() ) != null )
            {
                sb.append( line );
            }

            data = sb.toString();

            br.close();

            connection.disconnect();

            myStream.close();
        }
        catch ( Exception e )
        {
              Log.i( "MatiMessage" , "error in JSONDownloader in downloadURL() -> " + e.toString() );
        }

        return data;
    }

}
