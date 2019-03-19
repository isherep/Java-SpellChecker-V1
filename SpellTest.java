
import java.io.IOException;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class SpellTest.
 *
 * @author  Iryna
 * @version 3/14/18
 */

//add test for each answer in a requirenment question 
public class SpellTest{
    /**
     * Default constructor for test class SpellTest
     */
    public SpellTest()    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }

    /**
     * Tests if the dictionary set contains all the words from the file
     * This test assums that the dictionary is correct if its size is equal to the file size
     * 
     */
    @Test
    public void testDictionary() throws IOException{    
        int fileSize = SpellChecker.countLinesInTextFile("words.txt");
        SpellChecker check = new SpellChecker("words.txt");

        //assertEquals(fileSize, check.getDictionary().size());  
    }

    @Test
    public void shouldReturnOriginalIfCorrect()throws IOException{
        SpellChecker check = new SpellChecker("words.txt");

        assertEquals("apple",check.checkWord("apple")) ;
        // assertEquals("Englisher",check.checkWord("Englisher")) ;
        assertEquals("Aani",check.checkWord("Aani")) ; 
        assertEquals("imaginableness",check.checkWord("imaginableness")) ;
        assertEquals("phototelegraphically",check.checkWord("phototelegraphically")) ;
        assertEquals("separativeness",check.checkWord("separativeness")) ;
   }

    @Test
    public void shouldReturnNoCorrectionsFoundIfNoCorrec() throws IOException{
        SpellChecker check = new SpellChecker("words.txt");
        assertEquals("No Correction Found", check.checkWord("abcdefghijklmnop"));
        assertEquals("No Correction Found", check.checkWord("aabcdedfegwgaesbwtfghijklmnop"));
        assertEquals("No Correction Found", check.checkWord("abcd"));

    }

    @Test
    public void shouldFindClosestMatchingWord() throws IOException{
        SpellChecker check = new SpellChecker("words.txt");

        assertEquals("apple", check.findClosestMatchingWord("ApppLLee"));
        //testing the worse case scenario - when the characters are subliated over numerous times in numerous locations
        assertEquals("apple", check.findClosestMatchingWord("ApppLLee"));
        assertEquals("apple", check.findClosestMatchingWord("ApppLLee"));

    }

    @Test
    public void shouldFindClosestMatchingWordInWorseCaseScenario() throws IOException{
        SpellChecker check = new SpellChecker("words.txt");
        assertEquals("Aaru", check.findClosestMatchingWord("AAAAAAAAAaaaaaarrrrrrrrruuuuuuuu"));
        assertEquals("abdominohysterectomy", check.findClosestMatchingWord("AaaAAaabbBBBbbBbdddddddDDoOOOOOOmmmmmmmiiiiiiiiiiiNNNNNnnnnoooooooohhhhhhhyyyyyyyyyyysssssssstttteeeerrrreeeeccccttttoooomMMyYYYY"));

    }


    @Test
    public void shouldRemoveSingleDuplicate(){
        assertEquals("aple",SpellChecker.makeCanonical("apple")) ;
        assertEquals("abaf",SpellChecker.makeCanonical("abaff")) ;
        assertEquals("aba",SpellChecker.makeCanonical("aba")) ;
    }

    @Test
    public void shouldRemoveMultipleDuplicate(){
        assertEquals("asba",SpellChecker.makeCanonical("assbaa")) ;
        assertEquals("autosupresion",SpellChecker.makeCanonical("autosuppression")) ;

    }
    
    @Test
    public void testLevenhstein() throws IOException{
        SpellChecker check = new SpellChecker("words.txt");
        assertEquals(1, check.modifiedLevenshteinDistance("appple","apple")); 
        assertEquals(4, check.modifiedLevenshteinDistance("apppleeee", "apple"));
        assertEquals(5, check.modifiedLevenshteinDistance("jjeeaannss", "jeans"));
        assertEquals(1, check.modifiedLevenshteinDistance("Ninevitish", "ninevitish")); 
        assertEquals(6, check.modifiedLevenshteinDistance("IIIIIIInermes", "Inermes"));

    }

}
