package br.com.cr.desafio;

import java.util.ArrayList;

public class Decoder {
	
	private ArrayList<String> caracteres = new ArrayList<>();
	
	public Decoder() {
		caracteres.add("a");   // 0
		caracteres.add("b");   // 1
		caracteres.add("c");   // 2
		caracteres.add("d");   // 3
		caracteres.add("e");   // 4
		caracteres.add("f");   // 5
		caracteres.add("g");   // 6
		caracteres.add("h");   // 7
		caracteres.add("i");   // 8
		caracteres.add("j");   // 9
		caracteres.add("k");   // 10
		caracteres.add("l");   // 11
		caracteres.add("m");   // 12
		caracteres.add("n");   // 13
		caracteres.add("o");   // 14
		caracteres.add("p");   // 15
		caracteres.add("q");   // 16
		caracteres.add("r");   // 17
		caracteres.add("s");   // 18
		caracteres.add("t");   // 19
		caracteres.add("u");   // 20
		caracteres.add("v");   // 21
		caracteres.add("w");   // 22
		caracteres.add("x");   // 23
		caracteres.add("y");   // 24
		caracteres.add("z");   // 25
	}
	
public String decodificar(String textoCodificado, int nCasas) {
		
		char[] chars = textoCodificado.toLowerCase().toCharArray();
		String textoDecodificado = "";
		
		for (char c : chars) {
			// recebe a posicao do caracter atual
			Integer cont = caracteres.indexOf(""+c)+1;
			
			// verifica se contador é diferente de 0 (valor retornado para elementos não encontrados no arraylist)
			if(cont != 0) {
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
		
		// caso a posicao seja negativa
		if(somatorio<=0) {
			somatorio += 26;
		};
		
		return caracteres.get(somatorio-1);
	}
	
}
