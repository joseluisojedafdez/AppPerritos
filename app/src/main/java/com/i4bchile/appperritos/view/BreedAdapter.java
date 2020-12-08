package com.i4bchile.appperritos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.i4bchile.appperritos.R;

import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.BreedAdapterVH> {
    private List<String> listOfBreeds;
    private OnItemClickListener listener;

    public BreedAdapter(List<String> listOfBreeds, OnItemClickListener pListener) {
        this.listOfBreeds = listOfBreeds;
        this.listener=pListener;
    }

    public List<String> getListOfBreeds() {
        return listOfBreeds;
    }

    @NonNull
    @Override
    public BreedAdapter.BreedAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_breed,parent,false);

        return new BreedAdapterVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BreedAdapter.BreedAdapterVH holder, int position) {
            String breed=listOfBreeds.get(position);

            holder.bind(breed);

    }

    @Override
    public int getItemCount() {
        return listOfBreeds.size();
    }

    public void updateBreeds(List<String> breeds){
            listOfBreeds.clear();
            listOfBreeds.addAll(breeds);
            notifyDataSetChanged();
    }



    public class BreedAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvBreed;


        public BreedAdapterVH(@NonNull View itemView) {
            super(itemView);
            tvBreed=itemView.findViewById(R.id.img_pictures);
            itemView.setOnClickListener(this);

        }
        public void bind(String breed){
           tvBreed.setText(breed.toUpperCase());

        }

        @Override
        public void onClick(View v) {
            int position= getAdapterPosition();
            listener.onClick(position);
        }
    }

}
