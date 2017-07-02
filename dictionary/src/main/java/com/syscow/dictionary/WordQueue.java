package com.syscow.dictionary;

import java.util.ArrayList;
import java.util.List;

public class WordQueue<T> {
	List<T> queue = new ArrayList<>();
	Integer maxItemNumber = 0;
	
	public WordQueue(Integer maxItemNumber) {
		this.maxItemNumber = maxItemNumber;
	}

	public void push(T item) {
		if (queue.size() >= maxItemNumber) {
			queue.remove(0);
		}
		queue.add(item);
	}
	
	public String getAllWords() {
		String result = "";
		for (T word : queue) {
			result += word + " ";
		}
		result = result.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
		return result;
	}
	
}
