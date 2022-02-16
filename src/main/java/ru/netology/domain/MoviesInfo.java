package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesInfo {
    private int id;
    private int movieId;
    private String movieName;
    private String genre;
    private String imageUrl;
    private boolean premierIsTomorrow;

    public MoviesInfo(int i, String movieName, String genre, String link, boolean b) {
    }
}
