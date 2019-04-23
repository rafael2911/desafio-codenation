package br.com.cr.desafio.main;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.cr.desafio.Arquivo;

public class ClientWS {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=e5643667cacd78d26f042710b744c161d9e5a2d8");
		
		try {
			httpGet.setHeader("accept", "text/json");
		    //httpGet.setHeader("Authorization", "Basic QWxhZGRpbjpPcGVuU2VzYW1l");
		             
		    HttpResponse response = httpClient.execute( httpGet );
		              
		    HttpEntity entity = response.getEntity();
		             
		    String content = EntityUtils.toString(entity);
		             
		    Arquivo arquivo = new Arquivo();
		    arquivo.gerarJson("answer.json", content);
		             
		         
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    httpGet.releaseConnection();;
		}
		
	}
	
}
