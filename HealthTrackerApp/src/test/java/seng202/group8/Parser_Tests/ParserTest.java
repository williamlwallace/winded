package seng202.group8.Parser_Tests;

import org.junit.After;
import org.junit.Before;

import seng202.group8.parser.Parser;
import seng202.group8.user.User;

public class ParserTest {
    private Parser parserTest;

    @Before
    public void setUp() throws Exception {
        User userTest = new User("Joel", 19, 72.0, 167.0);
        Parser parserTest =  new Parser("seng202_2018_example_data.csv", userTest);
    }

    @After
    public void tearDown() {
        parserTest = null;
    }
}
