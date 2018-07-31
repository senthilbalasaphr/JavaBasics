package com.sen.basicjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class HttpClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials("b0001@SFPART026186", "welcome3$");
		provider.setCredentials(AuthScope.ANY, credentials);
		

		
		
		HttpClient httpClient = HttpClientBuilder.create()
				  .setDefaultCredentialsProvider(provider)
				  .build();
		
		HttpGet getRequest = new HttpGet(
				"https://apisalesdemo4.successfactors.com/odata/v2/EmpJob?$filter=userId+eq+'US54'");
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
					System.out.println(output);
				}

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
