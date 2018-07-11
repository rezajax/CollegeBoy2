package com.rezajax.college.boy2.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rezajax.college.boy2.CustomAdapter;
import com.rezajax.college.boy2.DataModel;
import com.rezajax.college.boy2.Downloader.CatParser;
import com.rezajax.college.boy2.Downloader.JSONDownloader;
import com.rezajax.college.boy2.Downloader.PostParser;
import com.rezajax.college.boy2.Downloader.UserParser;
import com.rezajax.college.boy2.MainActivity;
import com.rezajax.college.boy2.R;
import com.rezajax.college.boy2.ScrollingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class RecyclerFragment extends Fragment {

    View v;

    private static RecyclerView.Adapter sAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static RecyclerView sRecyclerView;
    static View.OnClickListener myOnClickListener;

    private CustomAdapter mCustomAdapter;

    private final String url_cat = "http://rezajax.ir/boy2/get_powerpoint_by_cat.php?cat=1&sort=DESC";
    private final String url_user = "http://rezajax.ir/boy2/user.php?username=rezajax&password=1122";
    private final String url_powerpoint = "";

    List<HashMap<String, String>> post;
    HashMap<String, String> user;
    ArrayList<DataModel> mDataModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recycler, container, false);

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {



                        JSONDownloader downloader = new JSONDownloader();

                        String tmpPost = downloader.downloadURL( url_cat );
                        PostParser postParser = new PostParser();
                        post = postParser.parse( tmpPost );
                        //Log.i("jax" , "RecyclerFragment Post.Size: " + post.size() +"" );

                        String tmpUser = downloader.downloadURL( url_cat );
                        UserParser userParser = new UserParser();
                        user = userParser.parse( tmpUser );

                        //user.get("image");


                        HashMap<String , String> mapPost = new HashMap<>();
                        mDataModels = new ArrayList<>();


                        for (int i = 0 ; i < post.size() ; i++) {
                            //List<String> list1 = post.get(i);
                            mapPost = post.get(i);

                            mDataModels.add(new DataModel(mapPost.get("name")
                                    , mapPost.get("header"),
                                    mapPost.get("text"),
                                    mapPost.get("rate"),
                                    mapPost.get("file"),
                                    mapPost.get("date"),
                                    mapPost.get("user_name"),
                                    mapPost.get("cat_name"),
                                    mapPost.get("is_stu")
                                    ));
                            Log.i("jax" , "RecyclerFragment List.Size: " + mapPost.size() +"" );
                            Log.i("jax" , "RecyclerFragment List.Size: " + mapPost.get("cat_name") +"" );
                        }
/*

                        List<HashMap<String , Object>> all_cats =
                                new ArrayList<>();
                        HashMap<String , Object> cat = new HashMap<>();

                        cat.put( "name" , "name" );
                        cat.put( "messege" , "messege"  );
                        cat.put( "image" , "[" + "image" );


                        all_cats.add( cat );



                        int a = 1;

*/
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myOnClickListener = new MyonClickListener(getActivity());

                                sRecyclerView = v.findViewById(R.id.my_recycler); //ok
                                //myOnClickListener = new MyonClickListener(MainActivity.this);
                                mCustomAdapter = new CustomAdapter(getContext(), mDataModels);
                                mLayoutManager= new LinearLayoutManager(getActivity()); //ok
//                              RecyclerView.LayoutManager mLayoutManager =
//                              new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                                sRecyclerView.setLayoutManager(mLayoutManager);
                                sRecyclerView.setItemAnimator(new DefaultItemAnimator());
                                sRecyclerView.setAdapter(mCustomAdapter);

                            }
                        });



                    }
                }
        );


        t1.start();


        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    private class MyonClickListener implements View.OnClickListener {
        private final Context mContext;

        public MyonClickListener(Context context) {
            this.mContext = context;
        }

        @Override
        public void onClick(View v) {

//            int selectedItemPosition = sRecyclerView.getChildPosition(v);
//            RecyclerView.ViewHolder viewHolder = sRecyclerView.findViewHolderForPosition(selectedItemPosition);

            int selectedItemPosition = sRecyclerView.getChildLayoutPosition(v);
            RecyclerView.ViewHolder viewHolder = sRecyclerView.findViewHolderForLayoutPosition(selectedItemPosition);

            TextView textView = viewHolder.itemView.findViewById(R.id.card_text_header);


            Intent intent = new Intent(getActivity() , ScrollingActivity.class);

            getActivity().startActivity(intent);





            Toast.makeText(getActivity(), selectedItemPosition + "", Toast.LENGTH_LONG).show();
        }
    }




}
