package pt.ulusofona.aed.deisiRockstar2021;

public class Artista {
    String id;
    String nome;

    public Artista(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    Artista() {
    }

    @Override
    public String toString() {
        return "Artista: " + nome;
    }
}
