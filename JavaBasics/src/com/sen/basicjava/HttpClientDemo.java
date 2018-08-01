package com.sen.basicjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String res="";
		
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials("b0001@SFPART026186", "welcome3$");
		provider.setCredentials(AuthScope.ANY, credentials);
		

		
		
		HttpClient httpClient = HttpClientBuilder.create()
				  .setDefaultCredentialsProvider(provider)
				  .build();
		
		HttpGet getRequest = new HttpGet(
			//	"https://apisalesdemo4.successfactors.com/odata/v2/EmpJob?$select=userId,jobCode,payScaleLevel,division&$filter=userId+eq+'US54'");
	"https://apisalesdemo4.successfactors.com/odata/v2/EmpJob?$select=userId,jobCode,payScaleLevel,division");
			getRequest.addHeader("accept", "application/json");

			try {
				HttpResponse response = httpClient.execute(getRequest);
				
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
					   + response.getStatusLine().getStatusCode());
				}

				BufferedReader br = new BufferedReader(
		                         new InputStreamReader((response.getEntity().getContent())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
				//	System.out.println(output);
					res = res+output;
					
				}
				
				System.out.println(res);
				
			ObjectMapper objectMapper = new ObjectMapper();
				
				
			
			JsonNode rootNode = objectMapper.readTree(res);
			
			JsonNode results = rootNode.path("d").path("results");
			
	//	System.out.println(results);
			
			Iterator<JsonNode> elements = results.elements();
			while(elements.hasNext()){
				String data = elements.next().toString();
				JsonNode rootNode1 = objectMapper.readTree(data);
				System.out.println(rootNode1.path("userId").asText());
				System.out.println(rootNode1.path("division").asText());
				System.out.println(rootNode1.path("jobCode").asText());
				System.out.println(rootNode1.path("payScaleLevel").asText());
		
				
		
				

			}
			
			
//			JsonNode results = rootNode.path("results");
//			
				
//			d d1= objectMapper.readValue(res,d.class);
//				
//			System.out.println(d1.getD());
				/*
				results res1 = d1.getRes();

				
				
			System.out.println(res1.getUserId());
				System.out.println(res1.getDivision());
				System.out.println(res1.getJobCode());
				System.out.println(res1.getPayScaleLevel()); 
				*/
				
			// 	
				

				httpClient.getConnectionManager().shutdown();
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
