package ru.netology.manager;

import ru.netology.domain.MoviesInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MoviesManager {
    int feedLength = 10;

    private MoviesInfo[] movies = new MoviesInfo[0];

    public void add(MoviesInfo movie) {
        int resultLength = movies.length + 1;
        MoviesInfo[] tmp = new MoviesInfo[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public int setFeedLength(int newFeedLength) {
        if (newFeedLength < 0) {
            return feedLength;
        }
        feedLength = newFeedLength;
        return feedLength;
    }

    public MoviesInfo[] getFeed() {
        int resultLength;
        if (movies.length > feedLength) {
            resultLength = feedLength;
        } else {
            resultLength = movies.length;
        }
        MoviesInfo[] result = new MoviesInfo[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public MoviesManager(int maxLength) {
        this.feedLength = maxLength;
    }
}
