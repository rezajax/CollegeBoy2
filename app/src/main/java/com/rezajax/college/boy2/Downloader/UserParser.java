package com.rezajax.college.boy2.Downloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserParser
{
    public HashMap<String , String> parse(String json )
    {
        HashMap<String , String> all_cats =
                new HashMap<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "user" );


            JSONObject temp = (JSONObject) jArr.get( 0 );

            all_cats.put( "appid" , temp.getString("appid") );
            all_cats.put( "stuid" , temp.getString( "stuid" ) );
            all_cats.put( "pass" , temp.getString( "pass" ) );
            all_cats.put( "name" , temp.getString( "name" ) );
            all_cats.put( "family" , temp.getString( "family" ) );
            all_cats.put( "image" , temp.getString( "image" ) );
            all_cats.put( "course" , temp.getString( "course" ) );
            all_cats.put( "email" , temp.getString( "email" ) );
            all_cats.put( "phone" , temp.getString( "phone" ) );
            all_cats.put( "date" , temp.getString( "date" ) );
            all_cats.put( "cat_id" , temp.getString( "cat_id" ) );

        }
        catch ( Exception e )
        {
            Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_cats );
    }
}

/*

    public  List<HashMap<String, String>>  parse(String json )
    {
        List<HashMap<String, String>>  all_user = new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "user" );

            for( int i = 0; i < jArr.length(); i ++ )
            {
                HashMap<String, String> user = new HashMap<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                user.put( "appid" , temp.getString("appid") );
                user.put( "stuid" , temp.getString( "stuid" ) );
                user.put( "pass" , temp.getString( "pass" ) );
                user.put( "name" , temp.getString( "name" ) );
                user.put( "family" , temp.getString( "family" ) );
                user.put( "image" , temp.getString( "image" ) );
                user.put( "course" , temp.getString( "course" ) );
                user.put( "email" , temp.getString( "email" ) );
                user.put( "phone" , temp.getString( "phone" ) );
                user.put( "date" , temp.getString( "date" ) );
                user.put( "cat_id" , temp.getString( "cat_id" ) );

                all_user.add( user );
            }
        }
        catch ( Exception e )
        {
            Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_user );
    }
}

*/

