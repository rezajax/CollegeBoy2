package com.rezajax.college.boy2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<HashMap<String , Object>> postset;


    public CustomAdapter(List<HashMap<String , Object>> post ) {
        this.postset = post;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.mTextViewName;
        TextView textViewMessage = holder.mTextViewVersion;
        ImageView imageView = holder.mImageView;

        textViewName.setText(R.string.app_name);
        textViewName.setText(R.string.navigation_drawer_open);
        imageView.setImageResource(R.drawable.profile);
    }

    @Override
    public int getItemCount() {
        return 100;
    }


//    ----------------------------------------------------------------------------------------------

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewName ;
        TextView mTextViewVersion;
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mTextViewName = itemView.findViewById(R.id.card_text_header);
            this.mTextViewVersion = itemView.findViewById(R.id.card_text_message);
            this.mImageView = itemView.findViewById(R.id.card_image);
        }
    }


}


