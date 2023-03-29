package com.rogeriofrsouza.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Classe utilitária
public class URL {

	// Decodifica a string recebida no parâmeotro da URL
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
