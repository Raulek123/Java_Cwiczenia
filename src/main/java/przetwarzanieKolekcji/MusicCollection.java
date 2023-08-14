package przetwarzanieKolekcji;

import java.util.List;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );
        int allTimeMusic = calculateTotalTimeByGenre(songs, Song.Genre.POP);
        long metallicaTrack = countTracksByArtistName(songs, "metallica");
        System.out.println("Łączny czas piosenek popowych na playliście (w sekundach): " + allTimeMusic);
        System.out.println("Liczba piosenek Metalliki na playliście: " + metallicaTrack);
    }

    private static int calculateTotalTimeByGenre(List<Song> songList, Song.Genre genre) {
        return songList.stream()
                .filter(song -> song.getGenre().equals(genre))
                .mapToInt(Song::getLength)
                .sum();
    }

    private static long countTracksByArtistName(List<Song> songList, String name) {
        return songList.stream()
                .filter(song -> song.getArtist().toLowerCase().contains(name))
                .count();
    }

    private static List<Song> filterAndDistinctMusicByGenre
}