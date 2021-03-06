package ch.rwi.hamcrest_vs_assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 *
 * 
 *
 * @author René Winkler
 * @version $Id: $
 * @since 0.0.1, 2015
 */
public class StringAssertionExample {

    private static final String DEV = "Developer";

    @Test
    public void testStrings_JUnit() {
        assertNotNull(DEV);
        assertFalse("".equals(DEV));
        assertTrue(DEV.startsWith("Dev"));
        assertTrue(DEV.contains("elo"));
        assertEquals(1, countOccurrences(DEV, "v"));
        assertEquals(9, DEV.length());
    }

    private int countOccurrences(String strToSearch, String sequenceToSearch) {
        int occurences = 0;
        for (int i = 0; i <= (strToSearch.length() - sequenceToSearch.length()); i++) {
            if (strToSearch.substring(i, i + sequenceToSearch.length()).equals(sequenceToSearch)) {
                occurences++;
            }
        }
        return occurences;

    }


    @Test
    public void testStrings_Hamcrest() {
        assertThat(DEV, is(notNullValue()));
        assertThat(DEV, not(isEmptyString()));
        assertThat(DEV, startsWith("Dev"));
        assertThat(DEV, containsString("elo"));
        assertThat(countOccurrences(DEV, "v"), equalTo(1));
        assertThat(DEV.length(), equalTo(9));
    }

    // note: expected and actual value are reversed in hamcrest


    @Test
    public void testStrings_WithAssertJ() {
        assertThat(DEV).isNotNull().isNotEmpty().startsWith("Dev").contains("elo").containsOnlyOnce("v").hasSize(9);
    }
}
