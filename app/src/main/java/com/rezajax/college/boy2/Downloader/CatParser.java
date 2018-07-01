package com.rezajax.college.boy2.Downloader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatParser
{
    public List<HashMap<String , Object>> parse(String json )
    {
        List<HashMap<String , Object>> all_cats =
                new ArrayList<>();

        try
        {
            JSONObject jObj = new JSONObject( json );

            JSONArray jArr = jObj.getJSONArray( "cat" );

            for( int i = 0; i < jArr.length(); i ++ )
            {
                HashMap<String , Object> cat = new HashMap<>();

                JSONObject temp = (JSONObject) jArr.get( i );

                cat.put( "id" , temp.getString("id") );
                cat.put( "name" , temp.getString( "name" ) );
                cat.put( "PowerPoint" , "[" + temp.getString( "PowerPoint" ) + "]" );
                cat.put( "learn" , "[" + temp.getString( "learn" ) + "]" );
                cat.put( "sum" , "[" + temp.getString( "sum" ) + "]" );

                all_cats.add( cat );
            }
        }
        catch ( Exception e )
        {
              Log.i("jax", "error in CatParser in parser() -> " + e.toString() );
        }

        return ( all_cats );
    }
}
