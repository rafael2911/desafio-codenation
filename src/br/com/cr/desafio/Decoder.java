package br.com.cr.desafio;

import java.util.ArrayList;

public class Decoder {
	
	private ArrayList<String> caracteres = new ArrayList<>();
	
	public Decoder() {
		caracteres.add(null);
		caracteres.add("a");   // 1
		caracteres.add("b");   // 2
		caracteres.add("c");   // 3
		caracteres.add("d");   // 4
		caracteres.add("e");   // 5
		caracteres.add("f");   // 6
		caracteres.add("g");   // 7
		caracteres.add("h");   // 8
		caracteres.add("i");   // 9
		caracteres.add("j");   // 10
		caracteres.add("k");   // 11
		caracteres.add("l");   // 12
		caracteres.add("m");   // 13
		caracteres.add("n");   // 14
		caracteres.add("o");   // 15
		caracteres.add("p");   // 16
		caracteres.add("q");   // 17
		caracteres.add("r");   // 18
		caracteres.add("s");   // 19
		caracteres.add("t");   // 20
		caracteres.add("u");   // 21
		caracteres.add("v");   // 22
		caracteres.add("w");   // 23
		caracteres.add("x");   // 24
		caracteres.add("y");   // 25
		caracteres.add("z");   // 26
	}
	
public String decodificar(String textoCodificado, int nCasas) {
		
		char[] chars = textoCodificado.toLowerCase().toCharArray();
		String textoDecodificado = "";
		
		for (char c : chars) {
			// recebe a posicao do caracter atual
			Integer cont = caracteres.indexOf(""+c);
			
			// verifica se contador é diferente de -1 (valor retornado para elementos não encontrados no arraylist)
			if(cont != -1) {
				// chama o metodo para buscar o caracter correto passando a posicao atual e o decressor
				textoDecodificado = textoDecodificado+buscaCaracterCorreto(cont, nCasas);
			}else {
				// escreve o elemento não localizado no array
				textoDecodificado = textoDecodificado+c;
			}
		}
		
		return textoDecodificado;
	}
	
	private String buscaCaracterCorreto(Integer cont, int nCasas) {
		// recebe a posicao descrescida
		Integer somatorio = cont-nCasas;
		
		// caso a posicao seja menor ou igual a zero
		if(somatorio<=0) {
			somatorio += 26;
		};
		
		return caracteres.get(somatorio);
	}
	
}
