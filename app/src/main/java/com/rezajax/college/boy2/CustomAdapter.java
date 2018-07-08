package com.rezajax.college.boy2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<HashMap<String , Object>> postset;
    Context mContext;


    public CustomAdapter(Context mContext, List<HashMap<String , Object>> post ) { //creator method
        this.mContext = mContext;
        this.postset = post;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        final MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, String.format("LinearLayout_profile%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();;
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView textViewName = holder.mTextViewName;
        TextView textViewMessage = holder.mTextViewVersion;
        ImageView imageView = holder.mImageView;

//        textViewName.setText(R.string.app_name);
//        textViewName.setText(R.string.navigation_drawer_open);
        imageView.setImageResource(R.drawable.kratos);
    }

    @Override
    public int getItemCount() {
        return 100;
    }


//    ----------------------------------------------------------------------------------------------

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mProfile;
        TextView mTextViewName ;
        TextView mTextViewVersion;
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mProfile = itemView.findViewById(R.id.card_profile);
            this.mTextViewName = itemView.findViewById(R.id.card_text_header);
            this.mImageView = itemView.findViewById(R.id.card_image);
        }
    }


}


