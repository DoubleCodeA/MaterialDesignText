package com.idouble.materialdesigntext;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/3/23.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private List<Picture> pictures;
    private Context context;
    public PictureAdapter(List<Picture> pictures){
        this.pictures = pictures;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private CardView    cardView;

        public ViewHolder(View itemView) {
            super (itemView);
            imageView = (ImageView)itemView.findViewById (R.id.picture_iamge);
            textView = (TextView)itemView.findViewById (R.id.picture_name);
            cardView = (CardView)itemView;
        }
    }

   @Override
    public PictureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext ();
        }
        View view = LayoutInflater.from (context).inflate (R.layout.picture_item,parent,false);
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(PictureAdapter.ViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        //holder.imageView.setImageResource (position);
        holder.textView.setText (picture.getName ());

        Glide.with (context).load (picture.getImageId ()).into (holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictures.size ();
    }
}
