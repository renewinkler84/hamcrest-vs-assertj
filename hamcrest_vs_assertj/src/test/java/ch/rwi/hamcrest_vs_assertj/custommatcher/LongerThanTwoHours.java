package ch.rwi.hamcrest_vs_assertj.custommatcher;

import hamcrest_vs_assertj.Movie;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 *
 * 
 *
 * @author u211732 (René Winkler)
 * @version $Id: $
 * @since 0.0.1, 2015
 */
public class LongerThanTwoHours extends TypeSafeMatcher<Movie> {


    public void describeTo(Description description) {
        description.appendText("Movie's duration ist shorter than 120min.");
    }

    @Override
    protected boolean matchesSafely(Movie movie) {
        return movie.getRunningTime() > 120;
    }

    @Factory
    public static <T> Matcher<Movie> longerThanTwoHours() {
        return new LongerThanTwoHours();
    }


}
