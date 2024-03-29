package com.firebase_database;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;

    public ImagesAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_card, parent, false);
        return new ImageViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int position) {

        Upload uploadCurrent = mUploads.get(position);
        imageViewHolder.textViewName.setText(uploadCurrent.getmName());
        Picasso.get()
                .load(uploadCurrent.getmImageUrl())
                .fit()
                .centerCrop()
                .into(imageViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }
}
