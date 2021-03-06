package ch.rwi.hamcrest_vs_assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.data.Index;
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
public class ListAssertionExample {

    private List<String> animals = new ArrayList<String>();

    private static final String ELEPHANT = "Elephant";
    private static final String MONKEY = "Monkey";
    private static final String LION = "Lion";
    private static final String NASHORN = "Nashorn";
    private static final String CROCODILE = "Crocodile";

    @Before
    public void setUp() {
        animals.add(ELEPHANT);
        animals.add(MONKEY);
        animals.add(LION);
        animals.add(NASHORN);
        animals.add(CROCODILE);
    }

    @Test
    public void testList_JUnit() {
        assertNotNull(animals);
        assertTrue(animals.size() > 0);
        assertTrue(animals.contains(LION));
        assertTrue(doesNotContainsDuplicates(animals));
        assertEquals(NASHORN, animals.get(3));
        assertEquals(5, animals.size());
    }

    private int countOccurrences(List<String> listToSearch, String elementToSearch) {
        int occurences = 0;
        for (int i = 0; i < listToSearch.size(); i++) {
            if (listToSearch.get(i).equals(elementToSearch)) {
                occurences++;
            }
        }
        return occurences;
    }

    private boolean doesNotContainsDuplicates(List<String> listToSearch) {
        for (String elementToSearch : listToSearch) {
            if (countOccurrences(listToSearch, elementToSearch) > 1) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void testList_Hamcrest() {
        assertThat(animals, is(notNullValue()));
        assertThat(animals, is(not(empty())));
        assertThat(animals, hasItem(LION));
        assertThat(doesNotContainsDuplicates(animals), equalTo(true));
        assertThat(animals.get(3), equalTo(NASHORN));
        assertThat(animals.size(), equalTo(5));
    }


    @Test
    public void testList_WithAssertJ() {
        assertThat(animals).isNotNull().isNotEmpty().contains(LION).doesNotHaveDuplicates().
                contains(NASHORN, Index.atIndex(3)).hasSize(5);
    }

}
