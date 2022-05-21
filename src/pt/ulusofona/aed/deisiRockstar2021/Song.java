package pt.ulusofona.aed.deisiRockstar2021;

import pt.ulusofona.aed.deisiRockstar2021.Artista;

import java.util.ArrayList;

public class Song {
    String id;
    String titulo;
    ArrayList<Artista> artistas;
    int anoDeLancamento;
    int duracaoDotema;
    boolean letraExplicita;
    int popularidade;
    float dancabilidade;
    float vivacidade;
    float volumeMedio;

    public Song(String id, String titulo, ArrayList<Artista> artistas, int anoDeLancamento,
                int duracaoDotema, Boolean letraExplicita, int popularidade, float dancabilidade, float vivacidade,
                float volumeMedio) {
        this.id = id;
        this.titulo = titulo;
        this.artistas = artistas;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoDotema = duracaoDotema;
        this.letraExplicita = letraExplicita;
        this.popularidade = popularidade;
        this.dancabilidade = dancabilidade;
        this.vivacidade = vivacidade;
        this.volumeMedio = volumeMedio;
    }

    public Song(String id, String titulo, int anoDeLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.artistas = new ArrayList<>();
    }

    public Song() {
    }

    @Override
    public String toString() {
        return id + " | " + titulo + " | " + anoDeLancamento;
    }
}

