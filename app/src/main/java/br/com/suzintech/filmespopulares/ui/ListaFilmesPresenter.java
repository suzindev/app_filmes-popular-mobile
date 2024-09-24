package br.com.suzintech.filmespopulares.ui;

import br.com.suzintech.filmespopulares.data.mapper.FilmeMapper;
import br.com.suzintech.filmespopulares.data.network.ApiService;
import br.com.suzintech.filmespopulares.data.network.response.FilmeResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance()
                .obterFilmesPopulares("8006b6a9af753f6c739b1254bc6f670f")
                .enqueue(new Callback<FilmeResult>() {
                    @Override
                    public void onResponse(Call<FilmeResult> call, Response<FilmeResult> response) {
                        if (response.isSuccessful()) {
                            view.mostraFilmes(FilmeMapper.deResponseParaDominio(response.body().getResultado()));
                        } else {
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmeResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
