package com.rezajax.college.boy2.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.rezajax.college.boy2.Downloader.CatParser;
import com.rezajax.college.boy2.Downloader.JSONDownloader;
import com.rezajax.college.boy2.R;

import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String url_cat = "http://rezajax.ir/boy2/get_cat.php";
    private final String url_powerpoint = "";

    View v;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Home");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }


//
//    public void make_category_list () {
//
//        Thread t1 = new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//
//                        JSONDownloader downloader = new JSONDownloader();
//                        String tmp = downloader.downloadURL( url_cat );
//
//                        CatParser catParser = new CatParser();
//
//                        List<HashMap<String , Object>> cats;
//                        cats = catParser.parse( tmp );
//
//                        String[] from = {"name" , "sum" }; //"name" , "PowerPoint" , "learn" , "sum"
//                        int[] to = { R.id.name_cat, R.id.amount_cat };
//
//                        if (getActivity()!=null) {
//
//                            SimpleAdapter myAdapter = new SimpleAdapter(
//                                    getActivity(), cats, R.layout.cat_list_row, from, to
//                            );
//
//                            final ListView lv = (ListView) v.findViewById(R.id.category_list);
//
//                            lv.setAdapter(myAdapter);
//                        }
//
//
//
//
//                       /* getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//
//
//                            }
//                        });*/
//
//
//                    }
//                }
//        );
//
//
//        t1.start();
//
//
//    }

}