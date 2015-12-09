package org.linagora.stringcalculator;

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
}
