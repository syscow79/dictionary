package com.syscow.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    		String line;
    		while ((line = br.readLine()) != null) {
    			System.out.println(line);
				line = line.replaceAll("[,:;(){}=*/<>@]", " ");
				line = line.replaceAll("\\s+", " ");
				line = line.replaceAll("\\s", " ");
				line = line.replaceAll(" +", " ");
				Pattern pattern = Pattern.compile(" +");
				String[] words = pattern.split(line);
				System.out.println(words);
    		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
