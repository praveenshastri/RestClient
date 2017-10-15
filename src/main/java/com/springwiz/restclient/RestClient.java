package com.springwiz.restclient;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class RestClient 
{
	private static String DEFAULT_FILE = "E:/springwiz/restclient/resources/seeded_excel_for_java_test.xlsx";  
    public static void main( String[] args )
    {
        RestClient restClient = new RestClient();
        restClient.uploadFile(DEFAULT_FILE);
    }
    
    private void uploadFile(String filePath){
    	org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
    	HttpPost post = new HttpPost("http://localhost:8080/upload");    
    	try {
    		File file = new File(filePath);
    		if(file.exists() && !file.isDirectory()){
	    		FileBody fileBody = new FileBody(file);    		
	    		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
	    		builder.addPart("file", fileBody);
	    		HttpEntity entity = builder.build();
	
	    		post.setEntity(entity);
				HttpResponse response = client.execute(post);
				response.getStatusLine();
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println("STATUS CODE > "+response.getStatusLine().getStatusCode());
				System.out.println("STATUS DESCRIPTION > "+responseBody);
    		}else
    			System.out.println("INVALID FILE. PLEASE PASS VALID INPUT FILE");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
