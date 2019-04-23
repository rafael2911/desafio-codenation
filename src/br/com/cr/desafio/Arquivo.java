package br.com.cr.desafio;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Arquivo {
	
	public void gerarJson(String nomrDoArquivo, String conteudo) throws IOException {
		OutputStream fos = new FileOutputStream(nomrDoArquivo);
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        
        bw.write(conteudo);
        
        bw.close();
	}
	
}
