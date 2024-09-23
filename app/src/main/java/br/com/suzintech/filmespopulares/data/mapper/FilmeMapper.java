package br.com.suzintech.filmespopulares.data.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.suzintech.filmespopulares.data.model.Filme;
import br.com.suzintech.filmespopulares.data.network.response.FilmeResponse;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> response) {
        return response.stream()
                .map(m -> new Filme(m.getTituloOriginal(), m.getCaminhoPoster()))
                .collect(Collectors.toList());
    }
}
