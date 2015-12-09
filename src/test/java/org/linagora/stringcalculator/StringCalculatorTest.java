package org.linagora.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    /**
    *    1. An empty (or null) string returns zero ("" -> 0)
    *    2. A single number returns the value ("3" -> 3)
    *    3. Two numbers, comma delimited, returns the sum ("3,4" -> 7)
    *    4. Two numbers, newline delimited, returns the sum ("3\n4" -> 7)
    *    5. Three numbers, delimited either way, returns the sum ("3,4\n2" -> 9)
    *    6. Negative numbers throw an exception ("3,4\-2" -> Exception)
    *    7. Numbers greater than 1000 are ignored ("3,4\n1002" -> 7)
    **/

    private StringCalculator testee;

    @Before
    public void setup() {
        testee = new StringCalculator();
    }

    @Test
    public void calculateShouldReturnZeroWhenEmptyString() {
        assertThat(testee.calculate("")).isEqualTo(0);
    }

    @Test
    public void calculateShouldReturnZeroWhenNullString() {
        assertThat(testee.calculate(null)).isEqualTo(0);
    }

    @Test
    public void calculateShouldReturnTheValueWhenSingleNumber() {
        assertThat(testee.calculate("3")).isEqualTo(3);
    }

    @Test
    public void calculateShouldReturnTheSumWhenTwoNumbersCommaDelimited() {
        assertThat(testee.calculate("3,4")).isEqualTo(7);
    }

    @Test
    public void calculateShouldReturnTheSumWhenTwoNumbersNewlineDelimited() {
        assertThat(testee.calculate("3\n4")).isEqualTo(7);
    }

    @Test
    public void calculateShouldReturnTheSumWhenThreeNumbersMixedDelimited() {
        assertThat(testee.calculate("3,4\n2")).isEqualTo(9);
    }

    @Test(expected=IllegalArgumentException.class)
    public void calculateShouldThrowAnExceptionWhenNegativeNumber() {
        testee.calculate("3,4\n-2");
    }

    @Test
    public void calculateShouldIgnoreNumberWhenGreaterThan1000() {
        assertThat(testee.calculate("3,4\n1002")).isEqualTo(7);
    }
}
