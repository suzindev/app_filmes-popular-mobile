package br.com.suzintech.filmespopulares.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.suzintech.filmespopulares.R;
import br.com.suzintech.filmespopulares.data.mapper.FilmeMapper;
import br.com.suzintech.filmespopulares.data.network.ApiService;
import br.com.suzintech.filmespopulares.data.network.response.FilmeResult;
import br.com.suzintech.filmespopulares.ui.adapter.ListaFilmeAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListaFilmeAdapter filmesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraToolbar();
        configuraAdapter();

        obtemFilmes();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void configuraAdapter() {
        recyclerView = findViewById(R.id.main_lista_filmes);

        filmesAdapter = new ListaFilmeAdapter();

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(filmesAdapter);
    }

    private void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("8006b6a9af753f6c739b1254bc6f670f")
                .enqueue(new Callback<FilmeResult>() {
                    @Override
                    public void onResponse(Call<FilmeResult> call, Response<FilmeResult> response) {
                        if (response.isSuccessful()) {
                            filmesAdapter.setFilmes(
                                    FilmeMapper.deResponseParaDominio(
                                            response.body().getResultado()));
                        } else {
                            mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmeResult> call, Throwable t) {
                        mostraErro();
                    }
                });
    }

    private void mostraErro() {
        Toast.makeText(this, "Erro ao obter lista de filmes", Toast.LENGTH_SHORT).show();
    }
}