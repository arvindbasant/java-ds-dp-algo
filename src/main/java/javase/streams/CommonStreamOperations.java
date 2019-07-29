package javase.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class CommonStreamOperations {
    static class AddNumbers {
         static int addUp(Stream<Integer> numbers) {
            return numbers.reduce(0, (acc, number) -> acc + number);
        }
    }

    static class Album {
        List<Artist> artists;

        List<Artist> getArtists() {
            return artists;
        }

        static List<String> getArtistNamesAndOrigins(List<Artist> artists) {
            return artists
                    .stream()
                    .flatMap(artist -> Stream.of(artist.name, artist.origin))
                    .collect(Collectors.toList());
        }

    }

    static class Artist {
        String name;
        String origin;

        Artist(String name, String origin) {
           this.name = name;
           this.origin = origin;
        }
    }

    public static void main(String[] args) {
        System.out.println(AddNumbers.addUp(asList(1,2,3,4,5,6).stream()));
        Album.getArtistNamesAndOrigins(asList(new Artist("A.R Rahman", "India"),
                new Artist("Linkin park", "US"))).stream().forEach(System.out::println);
        System.out.println(Character.isDigit('1'));
    }
}
