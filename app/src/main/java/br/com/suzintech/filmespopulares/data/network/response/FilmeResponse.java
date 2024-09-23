package br.com.suzintech.filmespopulares.data.network.response;

import com.google.gson.annotations.SerializedName;

public class FilmeResponse {

    @SerializedName("poster_path")
    private final String caminhoPoster;

    @SerializedName("original_title")
    private final String tituloOriginal;

    public FilmeResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }
}
