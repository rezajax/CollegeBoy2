package com.rezajax.college.boy2.Downloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostParser
{
    public  List<HashMap<String, String>>  parse(String json )
    {
        List<HashMap<String, String>>  all_post = new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "post" );  //ads change to post

            for( int i = 0; i < jArr.length(); i ++ )
            {
                HashMap<String, String> post = new HashMap<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                post.put("name", temp.getString("name"));
                post.put("header", temp.getString( "header" ) );
                post.put("text", temp.getString( "text" ) );
                post.put("rate", temp.getString( "rate" ) );
                post.put("file", temp.getString( "file" ) );
                post.put("date", temp.getString( "date" ) );
                post.put("user_name", temp.getString( "user_name" ) );
                post.put("cat_name", temp.getString( "cat_name" ) );
                post.put("is_stu", temp.getString( "is_stu" ) );

                all_post.add( post );
            }
        }
        catch ( Exception e )
        {
            Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_post );
    }
}




/*public class PostParser
{
    public  List<List<String>>  parse(String json )
    {
        List<List<String>> all_post = new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "post" );  //ads change to post

            for( int i = 0; i < jArr.length(); i ++ )
            {
                List<String> post = new ArrayList<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                post.add( temp.getString("name") );
                post.add( temp.getString( "header" ) );
                post.add( temp.getString( "text" ) );
                post.add( temp.getString( "rate" ) );
                post.add( temp.getString( "file" ) );
                post.add( temp.getString( "date" ) );
                post.add( temp.getString( "user_name" ) );
                post.add( temp.getString( "cat_name" ) );

                all_post.add( post );
            }
        }
        catch ( Exception e )
        {
            Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_post );
    }
}*/









/*

public class PostParser
{
    public List<HashMap<String , Object>> parse(String json )
    {
        List<HashMap<String , Object>> all_cats =
                new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "ads" );  //ads change to post

            for( int i = 0; i < jArr.length(); i ++ )
            {
                HashMap<String , Object> post = new HashMap<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                post.put( "name" , temp.getString("name") );
                post.put( "header" , temp.getString( "header" ) );
                post.put( "text" , temp.getString( "text" ) );
                post.put( "rate" , temp.getString( "rate" ) );
                post.put( "file" , temp.getString( "file" ) );
                post.put( "date" , temp.getString( "date" ) );
                post.put( "cat_id" , temp.getString( "cat_id" ) );

                all_cats.add( post );
            }
        }
        catch ( Exception e )
        {
            Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_cats );
    }
}
*/
