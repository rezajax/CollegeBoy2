package com.rezajax.college.boy2.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rezajax.college.boy2.CustomAdapter;
import com.rezajax.college.boy2.Downloader.CatParser;
import com.rezajax.college.boy2.Downloader.JSONDownloader;
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

    private final String url_cat = "http://rezajax.ir/boy2/get_cat.php";
    private final String url_powerpoint = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recycler, container, false);




                        JSONDownloader downloader = new JSONDownloader();
                        String tmp = downloader.downloadURL( url_cat );

                        CatParser catParser = new CatParser();

                        List<HashMap<String , Object>> cats;
                        cats = catParser.parse( tmp );

                        List<HashMap<String , Object>> all_cats =
                                new ArrayList<>();
                        HashMap<String , Object> cat = new HashMap<>();

                        cat.put( "name" , "name" );
                        cat.put( "messege" , "messege"  );
                        cat.put( "image" , "[" + "image" );


                        all_cats.add( cat );



                        int a = 1;


                        myOnClickListener = new MyonClickListener(getActivity());

                        sRecyclerView = v.findViewById(R.id.my_recycler);
                        //myOnClickListener = new MyonClickListener(MainActivity.this);
                        mCustomAdapter = new CustomAdapter(cats);
                        mLayoutManager= new LinearLayoutManager(getActivity());
//                        RecyclerView.LayoutManager mLayoutManager =
//                                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        sRecyclerView.setLayoutManager(mLayoutManager);
                        sRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        sRecyclerView.setAdapter(mCustomAdapter);

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
