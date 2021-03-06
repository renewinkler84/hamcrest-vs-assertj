package ch.rwi.hamcrest_vs_assertj;

import static ch.rwi.hamcrest_vs_assertj.custommatcher.LongerThanTwoHours.longerThanTwoHours;
import static ch.rwi.hamcrest_vs_assertj.custommatcher.MovieAssert.assertThat;
import static ch.rwi.hamcrest_vs_assertj.custommatcher.NotChildrenMovie.notChildrenMovie;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import hamcrest_vs_assertj.Movie;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * 
 *
 * @author u211732 (René Winkler)
 * @version $Id: $
 * @since 0.0.1, 2015
 */
public class CustomMatcherExample {


    private Movie movie = new Movie();

    private static final String DIE_HARD = "A Good Day to Die Hard";
    private static final int RUNNING_TIME = 137;
    private static final int AGE_RATING = 18;


    @Before
    public void setUp() {
        movie.setTitle(DIE_HARD);
        movie.setRunningTime(RUNNING_TIME);
        movie.setAgeRating(AGE_RATING);
    }

    @Test
    public void testMovie_JUnit() {
        assertEquals(DIE_HARD, movie.getTitle());
        assertTrue(movie.getRunningTime() > 120);
        assertTrue(movie.getAgeRating() >= 18);
    }


    @Test
    public void testMovie_Hamcrest() {
        assertThat(movie.getTitle(), equalTo(DIE_HARD));
        assertThat(movie, is(longerThanTwoHours()));
        assertThat(movie.getAgeRating(), is(notChildrenMovie()));
    }


    @Test
    public void testList_WithAssertJ() {
        assertThat(movie).hasTitle(DIE_HARD).isLongerThanTwoHours().isNotChildrenMovie();
    }
}
