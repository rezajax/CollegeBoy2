package com.rezajax.college.boy2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    boolean like;


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
                intent.putExtra("text", postset.get(myViewHolder.getAdapterPosition()).getText());
                intent.putExtra("name", postset.get(myViewHolder.getAdapterPosition()).getName());
                mContext.startActivity(intent);

                Toast.makeText(mContext, String.format("LinearLayout_post%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();;
            }
        });

        myViewHolder.mImageViewLike.setClickable(true);
        myViewHolder.mImageViewLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like) {
                    myViewHolder.mImageViewLike.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    like = false;
                } else {
                    myViewHolder.mImageViewLike.setImageResource(R.drawable.ic_favorite_red);
                    like = true;
                }
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView mTextViewName = holder.mTextViewName;
        TextView mTextViewHeader = holder.mTextViewHeader;
        TextView mTextViewSeen = holder.mTextViewSeen;
        TextView mTextViewDate = holder.mTextViewDate;
        TextView mTextViewUserName = holder.mTextViewUserName;
        TextView mTextViewCatName = holder.mTextViewCatName;
        LinearLayout mLinearLayout = holder.mProfile;



        ImageView imageView = holder.mImageView;
////        textViewName.setText(R.string.app_name);
////        textViewName.setText(R.string.navigation_drawer_open);
        imageView.setImageResource(R.drawable.kratos);

        mTextViewName.setText(postset.get(position).getName());
        mTextViewHeader.setText(postset.get(position).getHeader());
        mTextViewSeen.setText(postset.get(position).getRate());
        mTextViewDate.setText(postset.get(position).getDate());
        mTextViewUserName.setText(postset.get(position).getUser_name());
        mTextViewCatName.setText(postset.get(position).getCat_name());


        if (Integer.parseInt(postset.get(position).getIs_stu()) == 0) {
            mLinearLayout.setBackgroundColor(Color.parseColor("#DC143C"));
        }


    }

    @Override
    public int getItemCount() {
        return postset.size();
    }


//    ----------------------------------------------------------------------------------------------

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewName;
        TextView mTextViewHeader;
        TextView mTextViewText ;
        TextView mTextViewSeen ;
        TextView mTextViewFile ;
        TextView mTextViewDate ;
        TextView mTextViewUserName ;
        TextView mTextViewCatName ;

        TextView mTextViewLike;
        ImageView mImageViewLike;

        LinearLayout mProfile;
        LinearLayout mPost;

        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.mTextViewName = itemView.findViewById(R.id.card_text_name);
            this.mTextViewHeader = itemView.findViewById(R.id.card_text_header);
            this.mTextViewText = itemView.findViewById(R.id.card_text_text);
            this.mTextViewSeen = itemView.findViewById(R.id.card_text_seen);
            this.mTextViewDate = itemView.findViewById(R.id.card_date);
            this.mTextViewUserName = itemView.findViewById(R.id.card_user_name);
            this.mTextViewCatName = itemView.findViewById(R.id.card_cat_name);


            this.mTextViewLike = itemView.findViewById(R.id.card_text_like);
            this.mImageViewLike = itemView.findViewById(R.id.card_image_like);

            this.mProfile = itemView.findViewById(R.id.card_profile);
            this.mPost = itemView.findViewById(R.id.card_post);

            this.mImageView = itemView.findViewById(R.id.card_image);
        }
    }


}


