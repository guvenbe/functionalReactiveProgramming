package com.basicsstrong.listandmapfunctionalstyle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Movie {

    private String name;
    private int releaseYear;
    private String industry;

    public Movie(String name, int releaseYear, String industry) {

        this.setName(name);
        this.setReleaseYear(releaseYear);
        this.setIndustry(industry);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }


    @Override
    public String toString() {
        return "Movie [name=" + name + ", releaseYear=" + releaseYear + ", industry=" + industry + "]";
    }

}


public class ListFunctionalOperations {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight",2015,"Hollywood"),
                new Movie("Avengers: Infinity War",2018,"Hollywood"),
                new Movie("Inception",2010,"Hollywood"),
                new Movie("Forest Gump",1994,"Hollywood"),
                new Movie("3 Idiots",2009,"Bollywood"),
                new Movie("Beauty and the beast",2017,"Hollywood"),
                new Movie("Slumdog Millionaire",2008,"Bollywood")
        );


        //Traversal
        movies.forEach(System.out::println);
        //sorting uses comparable
        System.out.println("_____________________________");
        movies.sort((o1,o2)->o2.getReleaseYear()-o1.getReleaseYear());
        movies.forEach(System.out::println);

        //Filtering
        System.out.println("_____________________________");
        movies.stream()
                .filter(movie -> movie.getIndustry().equalsIgnoreCase("Bollywood"))
                .forEach(System.out::println);

        //Mapping
        System.out.println("_____________________________");
        movies.stream()
                .map(movie -> movie.getName())
                .forEach(System.out::println);

        Optional<String> moviewString = movies.stream()
                .map(m -> m.getName())
                .reduce((m1, m2) -> m1 + "|" + m2);

        System.out.println("_____________________________");
        System.out.println(moviewString);




    }
}
