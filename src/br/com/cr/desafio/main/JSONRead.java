package br.com.cr.desafio.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.cr.desafio.Decoder;

public class JSONRead {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        String cifrado;
        String decifrado;
        String resumoCriptografico;
        FileWriter writeFile = null;
 
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(
            		"answer.json"));
             
            //Salva nas variaveis os dados retirados do arquivo
            cifrado = (String) jsonObject.get("cifrado");
 
            Decoder decoder = new Decoder();
            decifrado = decoder.decodificar(cifrado, 11);
            resumoCriptografico = DigestUtils.sha1Hex(decifrado);
            
            jsonObject.put("decifrado", decifrado);
            jsonObject.put("resumo_criptografico", resumoCriptografico);
            
            writeFile = new FileWriter("answer.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            
            System.out.println("Cifrado: " + cifrado);
            System.out.println("Decifrado: " + decifrado);
            System.out.println("Resumo: " + resumoCriptografico);
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
	}
	
}
