package com.syscow.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try (BufferedReader br = new BufferedReader(new FileReader("TheScribeOath.srt"))) {
    		Map<String, Integer> wordMap = new HashMap<>();
    		String line;
    		while ((line = br.readLine()) != null) {
				List<String> words = readWordsFromALine(line);
				for (String word : words) {
					word = word.toLowerCase();
					if (wordMap.containsKey(word)) {
						wordMap.put(word, wordMap.get(word) + 1);
					} else {
						wordMap.put(word, 1);
					}
				}
    		}
    		
    		for (String word : wordMap.keySet()) {
    			System.out.println(word + " : " + wordMap.get(word));
    		}
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public static List<String> readWordsFromALine(String line) {
		line = line.replaceAll("[,:;(){}=*/<>@]", " ");
		line = line.replaceAll("\\s+", " ");
		line = line.replaceAll("\\s", " ");
		line = line.replaceAll(" +", " ");
		Pattern pattern = Pattern.compile(" +");
		String[] words = pattern.split(line);
		List<String> returnWords = new ArrayList<String>();
		for (String word : words) {
			if (containOnlyAZ(word)) {
				returnWords.add(word.toLowerCase());
			}
		}
		return returnWords;
	}
    
	private static boolean containOnlyAZ(String word) {
		return word.matches("[a-z ]+");
	}
}
