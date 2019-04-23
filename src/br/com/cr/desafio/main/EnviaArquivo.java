package br.com.cr.desafio.main;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EnviaArquivo {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
//		File file = new File("answer.json");
//	    
//		HttpClient httpClient = HttpClients.createDefault();
//		
//		HttpPost httppost = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=e5643667cacd78d26f042710b744c161d9e5a2d8");
//		
//		FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
//
//		// 
//		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//		builder.addPart("upfile", fileBody);
//		HttpEntity entity = builder.build();
//		//
//		httppost.setEntity(entity);
//		HttpResponse response = httpClient.execute(httppost);
//		
//		System.out.println(response);
		
		
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=e5643667cacd78d26f042710b744c161d9e5a2d8");

            FileBody bin = new FileBody(new File("answer.json"));
            StringBody comment = new StringBody("Arquivo json", ContentType.TEXT_PLAIN);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("answer", bin)
                    .addPart("comment", comment)
                    .build();


            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
	}
}
