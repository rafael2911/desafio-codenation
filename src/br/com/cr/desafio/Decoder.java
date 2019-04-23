package br.com.cr.desafio;

import java.util.HashMap;
import java.util.Map;

public class Decoder {
	
	private Map<String, Integer> charInt = new HashMap<>();
	private Map<Integer, String> intChar = new HashMap<>();
	
	public Decoder() {
		intChar.put(1, "a");
		intChar.put(2, "b");
		intChar.put(3, "c");
		intChar.put(4, "d");
		intChar.put(5, "e");
		intChar.put(6, "f");
		intChar.put(7, "g");
		intChar.put(8, "h");
		intChar.put(9, "i");
		intChar.put(10, "j");
		intChar.put(11, "k");
		intChar.put(12, "l");
		intChar.put(13, "m");
		intChar.put(14, "n");
		intChar.put(15, "o");
		intChar.put(16, "p");
		intChar.put(17, "q");
		intChar.put(18, "r");
		intChar.put(19, "s");
		intChar.put(20, "t");
		intChar.put(21, "u");
		intChar.put(22, "v");
		intChar.put(23, "w");
		intChar.put(24, "x");
		intChar.put(25, "y");
		intChar.put(26, "z");
		
		charInt.put("a", 1);
		charInt.put("b", 2);
		charInt.put("c", 3);
		charInt.put("d", 4);
		charInt.put("e", 5);
		charInt.put("f", 6);
		charInt.put("g", 7);
		charInt.put("h", 8);
		charInt.put("i", 9);
		charInt.put("j", 10);
		charInt.put("k", 11);
		charInt.put("l", 12);
		charInt.put("m", 13);
		charInt.put("n", 14);
		charInt.put("o", 15);
		charInt.put("p", 16);
		charInt.put("q", 17);
		charInt.put("r", 18);
		charInt.put("s", 19);
		charInt.put("t", 20);
		charInt.put("u", 21);
		charInt.put("v", 22);
		charInt.put("w", 23);
		charInt.put("x", 24);
		charInt.put("y", 25);
		charInt.put("z", 26);
	}
	
	public String decodificar(String textoCodificado, int nCasas) {
		char[] caracteres = textoCodificado.toLowerCase().toCharArray();
		String textoDecodificado = "";
		
		for (char c : caracteres) {
			Integer cont = charInt.get(""+c);
			
			if(cont != null) {
				textoDecodificado = textoDecodificado+buscaCaracterCorreto(cont, nCasas);
			}else {
				textoDecodificado = textoDecodificado+c;
			}
		}
		
		return textoDecodificado;
	}

	private String buscaCaracterCorreto(Integer cont, int nCasas) {
		
		Integer somatorio = cont-nCasas;
		
		if(somatorio<0) {
			somatorio += 26;
		};
		
		if(somatorio == 0) {
			somatorio = 26;
		}
		
		return intChar.get(somatorio);
	}
	
}
