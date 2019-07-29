package javase.lambdas;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class ComparatorLambda {

    public static void main(String[] args) {

        class Track{
            private String artist;
            private int length;

            Track(String artist, int length) {
                this.artist = artist;
                this.length = length;
            }

            private int getLength() {
                return length;
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };


        Comparator<String> comparatorLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        List<String> list = asList("***", "**", "*****");
//        String s = list.stream().min(Comparator.comparing(val -> val.length())).get();
//        System.out.println(s);
//
//        List<Track> tracks = asList(new Track("Bakai", 524),
//                new Track("Violets for Your Furs", 378),
//                new Track("Time Was", 451));
//        asList()
//        Track shortestTrack = tracks.stream()
//                .min(Comparator.comparing(track -> track.getLength()));
                //.get();
        list.sort(comparatorLambda);
        comparatorLambda.compare("check","tyui");

        for (String s: list){
            System.out.println(s);
        }
    }
}
