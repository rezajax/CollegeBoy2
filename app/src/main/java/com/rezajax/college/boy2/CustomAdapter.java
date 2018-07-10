package com.rezajax.college.boy2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> postset;
    Context mContext;


    public CustomAdapter(Context mContext,ArrayList<DataModel> postset ) { //creator method
        this.mContext = mContext;
        this.postset = postset;
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

        myViewHolder.mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext , ScrollingActivity.class);
                intent.putExtra("message", postset.get(myViewHolder.getAdapterPosition()).getMessage());
                mContext.startActivity(intent);

                Toast.makeText(mContext, String.format("LinearLayout_post%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();;
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView mTextViewName = holder.mTextViewName;
        TextView mTextViewHeader = holder.mTextViewHeader;
        TextView mTextViewMassege = holder.mTextViewMassege;

        ImageView imageView = holder.mImageView;

////        textViewName.setText(R.string.app_name);
////        textViewName.setText(R.string.navigation_drawer_open);
        imageView.setImageResource(R.drawable.kratos);

        mTextViewName.setText(postset.get(position).getName());
        mTextViewHeader.setText(postset.get(position).getHeader());


    }

    @Override
    public int getItemCount() {
        return postset.size();
    }


//    ----------------------------------------------------------------------------------------------

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewName;
        TextView mTextViewHeader;
        TextView mTextViewMassege ;

        LinearLayout mProfile;
        LinearLayout mPost;

        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mTextViewName = itemView.findViewById(R.id.card_text_name);
            this.mTextViewHeader = itemView.findViewById(R.id.card_text_header);
            this.mTextViewMassege = itemView.findViewById(R.id.card_text_message);

            this.mProfile = itemView.findViewById(R.id.card_profile);
            this.mPost = itemView.findViewById(R.id.card_post);

            this.mImageView = itemView.findViewById(R.id.card_image);
        }
    }


}


