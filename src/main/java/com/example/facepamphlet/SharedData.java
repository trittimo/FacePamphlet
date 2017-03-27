package com.example.facepamphlet;

import java.util.HashMap;

public class SharedData {	
	private HashMap<String, Object> dataMap = new HashMap<>();
	
	public <T> T getData(String key, Class<T> type) {
		if (!contains(key)) {
			return null;
		}
		return type.cast(dataMap.get(key));
	}
	
	public void setData(String key, Object data) {
		dataMap.put(key, data);
	}
	
	public void removeData(String key) {
		dataMap.remove(key);
	}
	
	public boolean contains(String key) {
		return dataMap.containsKey(key);
	}
}
