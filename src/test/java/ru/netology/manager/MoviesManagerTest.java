package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import ru.netology.domain.*;


public class MoviesManagerTest {
    private MoviesManager manager = new MoviesManager();
    private MoviesInfo first = new MoviesInfo(0, "Бладшот", "боевик", "link", false);
    private MoviesInfo second = new MoviesInfo(1, "Вперёд", "мульфильм", "link", false);
    private MoviesInfo third = new MoviesInfo(2, "Отель 'Белград'", "комедия", "link", false);
    private MoviesInfo forth = new MoviesInfo(3, "Джентельмены", "боевик", "link", false);
    private MoviesInfo fifth = new MoviesInfo(4, "Человек-невидимка", "ужасы", "link", false);
    private MoviesInfo sixth = new MoviesInfo(5, "Тролли. Мировой тур", "Мультфильм", "link", true);
    private MoviesInfo seventh = new MoviesInfo(6, "Номер один", "комедия", "link", true);
    private MoviesInfo eighth = new MoviesInfo(7, "Хабр", "триллер", "link", false);
    private MoviesInfo ninth = new MoviesInfo(8, "Ведьмак", "любовная комедия", "link", true);
    private MoviesInfo tenth = new MoviesInfo(9, "Захват", "боевик", "link", true);
    private MoviesInfo eleventh = new MoviesInfo(10, "Name", "comedy", "link", true);


    @Test
    void shouldGetTenMoviesForFeed() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        MoviesInfo[] actual = manager.getFeed();
        MoviesInfo[] expected = new MoviesInfo[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetTenMoviesForFeedAboveMax() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        MoviesInfo[] actual = manager.getFeed();
        MoviesInfo[] expected = new MoviesInfo[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFourMovieForFeed() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        MoviesInfo[] actual = manager.getFeed();
        MoviesInfo[] expected = new MoviesInfo[]{forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetOneMovieForFeed() {
        MoviesManager manager = new MoviesManager();
        MoviesInfo first = new MoviesInfo(0, "Бладшот", "боевик", "link", false);
        manager.add(first);

        MoviesInfo[] actual = manager.getFeed();
        MoviesInfo[] expected = new MoviesInfo[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNoMoviesForFeed() {
        MoviesManager manager = new MoviesManager();

        MoviesInfo[] actual = manager.getFeed();
        MoviesInfo[] expected = new MoviesInfo[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setMaxLengthUnderZero() {
        int nowFeedLength = -1;
        manager.setFeedLength(nowFeedLength);
        int expected = 10;
        int actual = manager.getFeedLength();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setMaxLengthZero() {
        int nowFeedLength = 0;
        manager.setFeedLength(nowFeedLength);
        int expected = 0;
        int actual = manager.getFeedLength();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setMaxLengthOverZero() {
        int nowFeedLength = 1;
        manager.setFeedLength(nowFeedLength);
        int expected = 1;
        int actual = manager.getFeedLength();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setMaxLengthRandom() {
        int nowFeedLength = 13;
        manager.setFeedLength(nowFeedLength);
        int expected = 13;
        int actual = manager.getFeedLength();
        Assertions.assertEquals(expected, actual);
    }

}