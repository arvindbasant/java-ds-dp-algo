package javase.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.Arrays.asList;

public class Album {
    public Album() {
    }

    class Member {
        private String name;
        private String origin;

        public Member(String name, String origin) {
            this.name = name;
            this.origin = origin;
        }
    }

    class Artist {
        private String name;
        private String origin;

        public List<Member> getMembers() {
            return members;
        }

        private List<Member> members;

        public Artist(String name, String origin, List<Member> members) {
            this.name = name;
            this.origin = origin;
            this.members = members;
        }

        public Artist(String name, String origin) {
            this.name = name;
            this.origin = origin;
        }
    }

    class Track {
        private Artist artist;
        private int length;

        public Track(Artist artist, int length) {
            this.artist = artist;
            this.length = length;
        }
    }

    private String name;

    public Album(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    private List<Track> tracks;

    List<Album> getAlbumsWithLessThan4Tracks(List<Album> albums) {
        return albums.stream()
                .filter(album -> album.getTracks().size() < 4)
                .collect(Collectors.toList());
    }

    List<Album> createAlbums() {
        List<Album> albums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<Track> tracks = new ArrayList<>();
            Artist artist = new Artist("name" + i, "origin" + i);
            for (int j = 0; j < i + 1; j++) {
                Track track = new Track(artist, i + (int) Math.random());
                tracks.add(track);
            }
            Album album = new Album("album name" + i, tracks);
            albums.add(album);
        }
        return albums;

    }

    List<Artist> getListOfArtists() {
        List<Artist> artists = new ArrayList<>();
        IntStream.range(0, 10).forEach(value -> {
            artists.add(new Artist("name" + value, "origin" + value,
                    asList(new Member("name" + value + Math.random() + 1, "origin" + value * +Math.random() + 2),
                            new Member("name" + value + Math.random() + 1, "origin" + value * +Math.random() + 2))));

        });
        return artists;
    };

    public static void main(String[] args) {
        Album album = new Album();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch(input) {
            case "1":
                List<Album> albums = album.createAlbums();
                album.getAlbumsWithLessThan4Tracks(albums).stream().forEach(album1 -> System.out.println(album1.name));
                break;
            case "2":
                List<Artist> artists = album.getListOfArtists();
                System.out.println(artists
                    .stream()
                    .flatMap(artist -> artist.getMembers().stream())
                    .count());
                break;
//                System.out.println(artists
//                        .stream()
//                        .map(artist -> artist.getMembers().stream())
//                        .count());
            case "3":
                System.out.println("Arvind".chars()
                        .filter(c -> Character.isLowerCase(c))
                        .count());
                break;
            case "4":
//                /Find the String with the largest number of lowercase letters from a
//List<String>. You can return an Optional<String> to account for the empty list
//case.
                List<String> strings = asList("qw","we","java","JAVASCript","li sp","re ily","artists","Stream");
//                Optional<String> result = strings.stream().map(str -> str.chars().filter(c -> Character.isLowerCase(c))).max(Comparator.comparing(str -> str.count()));

                System.out.println(strings.stream()
                        .min(Comparator.comparing(str -> str.length())).get());
                System.out.println(strings.stream()
                        .max(Comparator.comparing(str -> str.chars().filter(c -> Character.isLowerCase(c)).count())).get());
                album.getTracks()
                        .stream()
                        .mapToInt(track -> track.length)
                        .summaryStatistics();

//                        Stream.of(1,2,3).filter()

        }



    }

}

// [[art [memm]], [art [memm]]

// [mem1, mem2, mem3]