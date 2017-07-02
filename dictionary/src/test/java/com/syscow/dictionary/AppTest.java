package com.syscow.dictionary;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AppTest {
    
	@Test
	public void testSimpleWordLine()
    {	
		//when
    	String line = "your attention";
    	List<String> wordsExceptedWords = Arrays.asList("your", "attention");
    	
    	//other
    	List<String> words = App.readWordsFromALine(line);
    	
    	//then
    	assertEquals(wordsExceptedWords, words);
    }
	
	@Test
	public void testHtmlLineWordLine()
    {	
		//when
    	String line = "<font color=\"#E5E5E5\">your attention</font>";

    	List<String> wordsExceptedWords = Arrays.asList("font", "color", "your", "attention", "font");
    	
    	List<String> words = App.readWordsFromALine(line);

    	//then
    	assertEquals(wordsExceptedWords, words);
    }
	
}
