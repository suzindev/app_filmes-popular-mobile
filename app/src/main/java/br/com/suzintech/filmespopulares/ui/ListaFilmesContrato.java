package br.com.suzintech.filmespopulares.ui;

import java.util.List;

import br.com.suzintech.filmespopulares.data.model.Filme;

public interface ListaFilmesContrato {

    interface ListaFilmesView {
        void mostraFilmes(List<Filme> lista);

        void mostraErro();
    }

    interface ListaFilmesPresenter {
        void obtemFilmes();

        void destruirView();
    }
}
