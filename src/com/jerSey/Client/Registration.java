package com.jerSey.Client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Registration {
	 public void register(String input) {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/registration/register");
			

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);
              
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
             
			
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();
			  }
		}
	
	 public void update (String input)
	 {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/registration/update");
			

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);
              
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
             
			
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();
			  } 	 
	 }
	 
	 public void deRegister (String input)
	 {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/registration/deregister");
			

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);
              
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
             
			
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();
			  } 	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
