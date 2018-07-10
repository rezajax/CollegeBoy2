package com.rezajax.college.boy2.Downloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserParser
{
    public  List<List<String>>  parse(String json )
    {
        List<List<String>> all_post = new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "user" );

            for( int i = 0; i < jArr.length(); i ++ )
            {
                List<String> user = new ArrayList<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                user.add( temp.getString("appid") );
                user.add( temp.getString( "stuid" ) );
                user.add( temp.getString( "pass" ) );
                user.add( temp.getString( "name" ) );
                user.add( temp.getString( "family" ) );
                user.add( temp.getString( "image" ) );
                user.add( temp.getString( "course" ) );
                user.add( temp.getString( "email" ) );
                user.add( temp.getString( "phone" ) );
                user.add( temp.getString( "date" ) );
                user.add( temp.getString( "cat_id" ) );

                all_post.add( user );
            }
        }
        catch ( Exception e )
        {
              Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_post );
    }
}
