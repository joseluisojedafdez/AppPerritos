package com.i4bchile.appperritos.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.model.Favorites;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesAdapterVH>{
    private List<Favorites> favoritesList;
    private static final String TAG = "Infolog";
    public FavoritesAdapter(List<Favorites> favoritesList) {
        this.favoritesList = favoritesList;
    }

    @NonNull
    @Override
    public FavoritesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: la lista de favoritos tiene "+favoritesList.size()+" elementos");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_favorites,parent,false);

        return new FavoritesAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapterVH holder, int position) {

            Favorites favorite =favoritesList.get(position);
            Log.d(TAG, "onBindViewHolder position: "+position+" "+favorite.toString());
            holder.bind(favorite);
    }

    public void updateFavorites (List<Favorites> pFavoritesList){
        Log.d(TAG, "updateFavorites: en Adapter"+favoritesList.toString());
        favoritesList.clear();
        favoritesList.addAll(pFavoritesList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: la lista de favoritos tiene "+favoritesList.size()+" elementos");
        return favoritesList.size();
    }



    public class FavoritesAdapterVH extends RecyclerView.ViewHolder{
        private ImageView imgFavorite;
        private TextView breedFavorite;
        private TextView timeStamp;
        private Context context;

        public FavoritesAdapterVH(@NonNull View itemView) {
            super(itemView);
            breedFavorite=itemView.findViewById(R.id.tv_breed_favorite);
            timeStamp=itemView.findViewById(R.id.tv_time_stamp);
            imgFavorite=itemView.findViewById(R.id.img_breed);
            context=itemView.getContext();
        }

        public void bind(Favorites favorite) {
            Log.d(TAG, "bind favorito: "+favorite);
            breedFavorite.setText(favorite.getBreed().toUpperCase());
            timeStamp.setText(favorite.getTimeStamp());
            Glide.with(context).
                    load(favorite.getUrlImage()).
                    override(500,500).
                    into(imgFavorite);
        }
    }
}
