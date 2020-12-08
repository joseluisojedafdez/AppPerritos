package com.i4bchile.appperritos.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.i4bchile.appperritos.R;

import java.util.List;

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.PicturesAdapterVH> {
    private List<String> listOfPictures;
    private OnItemLongClickListener listener;

    public List<String> getListOfPictures() {
        return listOfPictures;
    }


    public PicturesAdapter(List<String> listOfPictures, OnItemLongClickListener listener) {
        this.listOfPictures = listOfPictures;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PicturesAdapter.PicturesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pictures,parent,false);

        return new PicturesAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PicturesAdapter.PicturesAdapterVH holder, int position) {
        String picture=listOfPictures.get(position);

        holder.bind(picture);
    }

    @Override
    public int getItemCount() {
        return listOfPictures.size();
    }

    public void updatePictures(List<String> picture){
        listOfPictures.clear();
        listOfPictures.addAll(picture);
        notifyDataSetChanged();
    }

    public class PicturesAdapterVH extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        private ImageView imgPictures;
        private Context context;

        public PicturesAdapterVH(@NonNull View itemView) {
            super(itemView);
            imgPictures=itemView.findViewById(R.id.img_pictures);
            context=itemView.getContext();
            itemView.setOnLongClickListener(this);

        }




        public void bind(String picture) {
            Glide.with(context).load(picture).override(500,500).into(imgPictures);


        }


        @Override
        public boolean onLongClick(View v) {

            int position=getAdapterPosition();
            listener.onLongClick(position);
            return true;

        }
    }
    }

