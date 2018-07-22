package com.rezajax.college.boy2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rezajax.college.boy2.Model.DataModel;

import java.util.ArrayList;
import java.util.HashMap;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> postset;
    Context mContext;
    boolean like;
    public Vibrator vib;

    public CustomAdapter(Context mContext,ArrayList<DataModel> postset ) { //creator method متد ایجاد کننده ,constructor method متد سازنده
        this.mContext = mContext;
        this.postset = postset;
    }

    public CustomAdapter(Context mContext ) { //creator method متد ایجاد کننده ,constructor method متد سازنده
        this.mContext = mContext;
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
                Toast.makeText(mContext, String.format("LinearLayout_profile%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();
            }
        });

        myViewHolder.mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //removeItem(myViewHolder.getAdapterPosition());
                Intent intent = new Intent(mContext , ScrollingActivity.class);
                intent.putExtra("text", postset.get(myViewHolder.getAdapterPosition()).getText());
                intent.putExtra("name", postset.get(myViewHolder.getAdapterPosition()).getName());

                if (postset.get(myViewHolder.getAdapterPosition()).getName().equals("فیبر نوری")) {

                    intent.putExtra("image", "R.drawable.plc");
                    Toast.makeText(mContext, String.format("plc" + R.drawable.plc, myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                } else {
                   // intent.putExtra("image", R.drawable.college2);
                }
                //mContext.startActivity(intent);

                Toast.makeText(mContext, String.format("LinearLayout_post%d", myViewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();

                addItem(myViewHolder.getAdapterPosition(), new DataModel("سلام",
                        "سلام",
                        "سلام",
                        "3",
                        "a",
                        "a",
                        "2018-07-12 17:26:56",
                        "دکتر محمدی",
                        "الکترونیک",
                        "1"
                ));
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


        return myViewHolder; //return new MyViewHolder(view);
    }

    private boolean hasImage(@NonNull ImageView view) {
        Drawable drawable = view.getDrawable();
        boolean hasImage = (drawable != null);

        if (hasImage && (drawable instanceof BitmapDrawable)) {
            hasImage = ((BitmapDrawable)drawable).getBitmap() != null;
        }

        return hasImage;
    }

    /*public void updateData(ArrayList<DataModel> dataModel) {
        postset.clear();
        postset.addAll(dataModel);
        notifyDataSetChanged();
    }*/
    public void updateData(HashMap<String, Object>... updateModel) {
        String imgUrl = (String) updateModel[0].get( "image" );
        int position = (Integer) updateModel[0].get( "position" );
        //Resources resources = new Resources();

        int cacheResId = mContext.getResources().getIdentifier(imgUrl , null, null);
        int cacheResId1 = mContext.getResources().getIdentifier("plc",
                "drawable",
                mContext.getPackageName());

        Log.i("intImg" , "cacheResId" + cacheResId1 );
        Log.i("intImg" , "intImg" + imgUrl );

//        postset.get(position).setImage(Resources.getIdentifier(imgUrl , "drawable", getPackageName()));
        notifyDataSetChanged();

        //postset.clear();
        //postset.addAll(dataModel);
        //notifyDataSetChanged();
    }

    /*public void display(ImageView img, String url, final ProgressBar spinner) {
        imageLoader.displayImage(url, img, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                spinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }
    */
    public void addItem(int position, DataModel dataModel) {
        postset.add(position, dataModel);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        postset.remove(position);
        notifyItemRemoved(position);
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
        ImageView mImageViewPost = holder.mImageView;
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

        //Log.i("intImg" , postset.get(position).getImage() + "" );
        int cacheResId1 = mContext.getResources().getIdentifier("electronic",
                "drawable",
                mContext.getPackageName());
        Log.i("Res" , "myRes: " + cacheResId1 + " intRes: " + R.drawable.electronic);
        mImageViewPost.setImageResource(cacheResId1); //R.drawable.plc

//      mImageViewPost.setImageResource(Integer.parseInt(postset.get(position).getImage()));

        /*if (postset.get(position).getImage() != null) {
            mimageViewPost.setImageResource(Integer.parseInt( postset.get(position).getImage()));
        } else {
            mimageViewPost.setImageResource(R.drawable.profile);
        }*/

        Log.i("is",postset.get(position).getIs_stu() );
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


