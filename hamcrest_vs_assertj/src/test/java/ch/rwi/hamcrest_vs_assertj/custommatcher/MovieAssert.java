package ch.rwi.hamcrest_vs_assertj.custommatcher;

import hamcrest_vs_assertj.Movie;

import org.assertj.core.api.AbstractAssert;

/**
 *
 * 
 *
 * @author u211732 (René Winkler)
 * @version $Id: $
 * @since 0.0.1, 2015
 */

// 1 - inherits from AbstractAssert !
public class MovieAssert extends AbstractAssert<MovieAssert, Movie> {

    // 2 - Write a constructor to build your assertion class with the object you want make assertions on.
    public MovieAssert(Movie actual) {
        super(actual, MovieAssert.class);
    }

    // 3 - A fluent entry point to your specific assertion class, use it with static import.
    public static MovieAssert assertThat(Movie actual) {
        return new MovieAssert(actual);
    }


    // 4 - a specific assertion !
    public MovieAssert hasTitle(String title) {
        // check that actual Movie we want to make assertions on is not null.
        isNotNull();

        // check condition
        if (!actual.getTitle().equals(title)) {
            failWithMessage("Expected movie's title to be <%s> but was <%s>", title, actual.getTitle());
        }

        // return the current assertion for method chaining
        return this;
    }


    // 4 - another specific assertion !
    public MovieAssert isLongerThanTwoHours() {
        // check that actual Movie we want to make assertions on is not null.
        isNotNull();

        // check condition
        if (!(actual.getRunningTime() > 120)) {
            failWithMessage("Expected movie's duration longer than 120min but was <%s>", actual.getRunningTime());
        }

        // return the current assertion for method chaining
        return this;
    }

    // 4 - another specific assertion !
    public MovieAssert isNotChildrenMovie() {
        // check that actual Movie we want to make assertions on is not null.
        isNotNull();

        // check condition
        if (!(actual.getAgeRating() >= 18)) {
            failWithMessage("Movie should not be intended for children, but is released from <%s> years", actual.getAgeRating());
        }

        // return the current assertion for method chaining
        return this;
    }

}
