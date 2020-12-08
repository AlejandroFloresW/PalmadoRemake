package uca.edu.palmado;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    public List<Pokemons> pokemonsList;

    public Adapter(List<Pokemons> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wordlist_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( final ViewHolder holder, final int position) {
        holder.nombrePokemon.setText(pokemonsList.get(position).getNombre());
        holder.imgPok.setImageResource(pokemonsList.get(position).getIdImg());

        holder.imgFav.setTag("unselected");
        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.imgFav.getTag() == "unselected"){
                    holder.imgFav.setColorFilter(Color.RED);
                    holder.imgFav.setTag("selected");
                    Snackbar.make(v, "Añadiste a " + pokemonsList.get(position).getNombre()
                            + " a favoritos", Snackbar.LENGTH_SHORT).show();
                } else {
                    holder.imgFav.setColorFilter(Color.TRANSPARENT);
                    holder.imgFav.setTag("unselected");
                    Snackbar.make(v, "Quitaste a " + pokemonsList.get(position).getNombre() +
                            " de favoritos", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idPokemon;
        private TextView nombrePokemon;
        private TextView descPokemon;
        private ImageView imgPok;
        private ImageButton imgFav;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idPokemon = (TextView) itemView.findViewById(R.id.idPokemonFragment);
            nombrePokemon = (TextView) itemView.findViewById(R.id.nombrePokemon);
            descPokemon = (TextView) itemView.findViewById(R.id.descPokemonFragment);
            imgPok = (ImageView) itemView.findViewById(R.id.ImgPokemon);
            imgFav = (ImageButton) itemView.findViewById(R.id.imgFav);
        }
    }
}
