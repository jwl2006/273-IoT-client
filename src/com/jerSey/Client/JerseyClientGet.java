package com.jerSey.Client;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class JerseyClientGet {

	public void ClientGet(String client_name)
	   {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/com.youtube.rest/api/webservice/get/"+client_name);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("GET() Response from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

	}
	}
