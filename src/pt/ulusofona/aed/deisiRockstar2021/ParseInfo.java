package pt.ulusofona.aed.deisiRockstar2021;

public class ParseInfo {
    String nome;
    int lidas;
    int ignoradas;

    public ParseInfo(String nome, int lidas, int ignoradas) {
        this.nome = nome;
        this.lidas = lidas;
        this.ignoradas = ignoradas;
    }

    @Override
    public String toString() {
        return "OK: " + lidas + ", Ignored: " + ignoradas;
    }
}
