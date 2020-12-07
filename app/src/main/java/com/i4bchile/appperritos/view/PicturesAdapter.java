package com.i4bchile.appperritos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.i4bchile.appperritos.R;

import java.util.List;

public class PicturesAdapter extends RecyclerView.Adapter<PicturesAdapter.PicturesAdapterVH> {
    private List<String> listOfPictures;
    private OnItemClickListener listener;

    public List<String> getListOfPictures() {
        return listOfPictures;
    }


    public PicturesAdapter(List<String> listOfPictures, OnItemClickListener listener) {
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

    public class PicturesAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public PicturesAdapterVH(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tvPictures);


        }

        @Override
        public void onClick(View v) {

        }


        public void bind(String picture) {
            textView.setText(picture);


        }
    }
}
