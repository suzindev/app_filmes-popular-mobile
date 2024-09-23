package br.com.suzintech.filmespopulares.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.suzintech.filmespopulares.R;
import br.com.suzintech.filmespopulares.data.model.Filme;

public class ListaFilmeAdapter extends RecyclerView.Adapter<ListaFilmeAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;

    public ListaFilmeAdapter() {
        this.filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return filmes != null && !filmes.isEmpty() ? filmes.size() : 0;
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTituloFilme;
        private ImageView imagePosterFilme;

        public ListaFilmesViewHolder(View itemView) {
            super(itemView);

            txtTituloFilme = itemView.findViewById(R.id.item_txtTituloFilme);
            imagePosterFilme = itemView.findViewById(R.id.item_imagePosterFilme);
        }

        public void bind(Filme filme) {
            txtTituloFilme.setText(filme.getTitulo());
            Picasso.get().load("https://image.tmdb.org/t/p/w342/" + filme.getCaminhoPoster()).into(imagePosterFilme);
        }
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
        notifyDataSetChanged();
    }
}
