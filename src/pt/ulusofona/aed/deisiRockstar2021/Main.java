package pt.ulusofona.aed.deisiRockstar2021;

import java.util.ArrayList;
import java.io.*;

public class Main {
    private static ArrayList<Song> songs = new ArrayList<>();
    private static ArrayList<Artista> artistas = new ArrayList<>();
    private static ArrayList<Song> details = new ArrayList<>();
    static ParseInfo piSongs;
    static ParseInfo piSongArtists;
    static ParseInfo piSongDetails;

    public static int getSong(String id) {
        for (int i = 0; i < songs.size(); i++) {

                return i;

        }
        return -1;
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }

    public static ParseInfo getParseInfo(String fileName) {

        switch (fileName) {
            case "songs.txt":
                return piSongs;
            case "song_artists.txt":
                return piSongArtists;
            case "song_details.txt":
                return piSongDetails;
            default:
                return null;
        }

    }

    public static void loadFiles() throws IOException {
        songs.clear();
        ArrayList<String> txtSongs = Reader.read("songs.txt");
        ArrayList<String> txtSongArtists = Reader.read("song_artists.txt");
        ArrayList<String> txtSongDetails = Reader.read("song_details.txt");


        if (txtSongs == null || txtSongArtists == null || txtSongDetails == null) {
            throw new IOException();
        }

        parseSongs(txtSongs);
        parseArtists(txtSongArtists);
        parseSongDetails(txtSongDetails);
    }

    public static void parseSongs(ArrayList<String> lines) {
        songs = new ArrayList<>();
        int lidas = 0;
        int ignoradas = 0;
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            String[] campos = currentLine.split("@");
            if (campos.length == 3) {

                lidas++;
            } else {
                ignoradas++;
            }
        }
        piSongs = new ParseInfo("songs.txt", lidas, ignoradas);
    }

    public static void parseArtists(ArrayList<String> lines) {
        int lidas = 0;
        int ignoradas = 0;
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            String[] campos = currentLine.split("@");
            if (campos.length == 2) {

                // int idx = getSong(campos[0]);
                //if (idx != -1) {
                if (campos[1].startsWith("[")) {
                    String nome = campos[1].trim().substring(2, campos[1].trim().length() - 2);
                    Artista artista = new Artista(campos[0], nome);
                    //      songs.get(idx).artistas.add(artista);

                } else if (campos[1].startsWith("\"[")) {
                    String[] nomes = campos[1].substring(2, campos[1].length() - 2).split(",");
                    for (int j = 0; j < nomes.length; j++) {
                        Artista artista = new Artista(campos[0], nomes[j].substring(1, nomes[j].length() - 1));

                        //        songs.get(idx).artistas.add(artista);
                    }
                }
                lidas++;
            } else {
                ignoradas++;
            }
            //  } else{
            //    ignoradas++;
            //}
        }

        piSongArtists = new ParseInfo("song_artists.txt", lidas, ignoradas);

    }

    public static void parseSongDetails(ArrayList<String> lines) {
        int lidas = 0;
        int ignoradas = 0;
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            String[] campos = currentLine.split("@");

            if (campos.length == 7) {
                //int idx = getSong(campos[0]);
                // if (idx != -1) {
                // Song song = songs.get(idx);
                Song detail = new Song();

                detail.duracaoDotema = Integer.parseInt(campos[1].trim());
                detail.letraExplicita = Integer.parseInt(campos[2].trim()) == 1;
                detail.popularidade = Integer.parseInt(campos[3].trim());
                detail.dancabilidade = Float.parseFloat(campos[4].trim());
                detail.vivacidade = Float.parseFloat(campos[5].trim());
                detail.volumeMedio = Float.parseFloat(campos[6].trim());

                lidas++;
                //   } //else {
                //   ignoradas++;
                //}
            } else {
                ignoradas++;
            }
        }
        piSongDetails = new ParseInfo("song_details.txt", lidas, ignoradas);
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            loadFiles();
            System.out.println(getParseInfo("songs.txt"));
            System.out.println(getSongs().size());
            System.out.println((getParseInfo("song_details.txt")));
            System.out.println(getParseInfo("song_artists.txt"));
        } catch (IOException e) {
            System.out.println("Deu");
        }
    }
}
