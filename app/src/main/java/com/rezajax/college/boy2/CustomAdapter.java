package com.rezajax.college.boy2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rezajax.college.boy2.Model.DataModel;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> postset;
    Context mContext;
    boolean like;
    public Vibrator vib;

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

        vib = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        like = true;


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

                if (postset.get(myViewHolder.getAdapterPosition()).getName().equals("فیبر نوری")) {

                    intent.putExtra("image", "R.drawable.plc");
                    Toast.makeText(mContext, String.format("plc" + R.drawable.plc, myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();;
                } else {
                   // intent.putExtra("image", R.drawable.college2);
                }
                mContext.startActivity(intent);

                Toast.makeText(mContext, String.format("LinearLayout_post%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();;
            }
        });


        myViewHolder.like.setClickable(true);
        myViewHolder.like.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (like) {
                     myViewHolder.mImageViewLike.setImageResource(R.drawable.ic_favorite_red);


                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                         vib.vibrate(VibrationEffect.createOneShot(15,VibrationEffect.DEFAULT_AMPLITUDE));
                     }else{
                         //deprecated in API 26
                         vib.vibrate(15);
                     }
                     int likenum = Integer.parseInt(myViewHolder.mTextViewLike.getText().toString()) + 1;
                     myViewHolder.mTextViewLike.setText(likenum + "");

                     like = false;
                 } else {
                     myViewHolder.mImageViewLike.setImageResource(R.drawable.ic_favorite_border_black_24dp);

                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                         vib.vibrate(VibrationEffect.createOneShot(15,VibrationEffect.DEFAULT_AMPLITUDE));
                     }else{
                         //deprecated in API 26
                         vib.vibrate(15);
                     }

                     int likenum = Integer.parseInt(myViewHolder.mTextViewLike.getText().toString()) - 1;
                     myViewHolder.mTextViewLike.setText(likenum + "");

                     like = true;
                 }
             }
        });


        return myViewHolder;
    }

    private boolean hasImage(@NonNull ImageView view) {
        Drawable drawable = view.getDrawable();
        boolean hasImage = (drawable != null);

        if (hasImage && (drawable instanceof BitmapDrawable)) {
            hasImage = ((BitmapDrawable)drawable).getBitmap() != null;
        }

        return hasImage;
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
        //TextView mTextViewLike = holder.mTextViewLike;        text number of like



        ImageView imageView = holder.mImageView;
////        textViewName.setText(R.string.app_name);
////        textViewName.setText(R.string.navigation_drawer_open);
        imageView.setImageResource(R.drawable.electronic);

        if (postset.get(position).getName().equals("فیبر نوری")) {

            imageView.setImageResource(R.drawable.plc);
        }

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

        LinearLayout like;


        public MyViewHolder(View itemView) {
            super(itemView);
            Typeface typeface = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/Shabnam.ttf");

            this.mTextViewName = itemView.findViewById(R.id.card_text_name);
            this.mTextViewName.setTypeface(typeface);

            this.mTextViewHeader = itemView.findViewById(R.id.card_text_header);
            this.mTextViewHeader.setTypeface(typeface);

            this.mTextViewText = itemView.findViewById(R.id.card_text_text);

            this.mTextViewSeen = itemView.findViewById(R.id.card_text_seen);
            this.mTextViewSeen.setTypeface(typeface);

            this.mTextViewDate = itemView.findViewById(R.id.card_date);
            this.mTextViewDate.setTypeface(typeface);

            this.mTextViewUserName = itemView.findViewById(R.id.card_user_name);
            this.mTextViewUserName.setTypeface(typeface);

            this.mTextViewCatName = itemView.findViewById(R.id.card_cat_name);
            this.mTextViewCatName.setTypeface(typeface);


            this.mTextViewLike = itemView.findViewById(R.id.card_text_like);
            this.mTextViewLike.setTypeface(typeface);

            this.mImageViewLike = itemView.findViewById(R.id.card_image_like);

            this.like = itemView.findViewById(R.id.linear_like);

            this.mProfile = itemView.findViewById(R.id.card_profile_linear);
            this.mPost = itemView.findViewById(R.id.card_post);

            this.mImageView = itemView.findViewById(R.id.card_image);
        }
    }


}


