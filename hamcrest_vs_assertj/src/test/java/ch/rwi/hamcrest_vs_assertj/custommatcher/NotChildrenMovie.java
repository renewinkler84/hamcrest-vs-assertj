package ch.rwi.hamcrest_vs_assertj.custommatcher;

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
public class NotChildrenMovie extends TypeSafeMatcher<Integer> {


    public void describeTo(Description description) {
        description.appendText("Movie is not for children.");
    }

    @Override
    protected boolean matchesSafely(Integer ageRating) {
        return ageRating >= 18;
    }

    @Factory
    public static <T> Matcher<Integer> notChildrenMovie() {
        return new NotChildrenMovie();
    }


}
