package com.gl365.gd.common;

import com.google.gson.Gson;

public class JsonUtils {
	
	public static String toJsonString(Object object) {
		return new Gson().toJson(object);
	}
}
