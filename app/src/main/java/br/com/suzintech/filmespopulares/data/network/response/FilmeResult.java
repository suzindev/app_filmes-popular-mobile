package br.com.suzintech.filmespopulares.data.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilmeResult {

    @SerializedName("results")
    private final List<FilmeResponse> resultado;

    public FilmeResult(List<FilmeResponse> resultado) {
        this.resultado = resultado;
    }

    public List<FilmeResponse> getResultado() {
        return resultado;
    }
}
