package com.jerSey.Client;




import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Myclient {
	public void ClientGet(String clientName)
	   {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/com.youtube.rest/api/webservice/get/"+clientName);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			
			if (response.getStatus() != 200  && response.getStatus() != 204) {
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
	
      public void ClientPost(String input) {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/webservice/post");
				

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);

				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}

				System.out.println(" Here in POST() Server Side ...\n");
				String output = response.getEntity(String.class);
				System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();
			  }
		}
 
      
      public void Register(String ID)throws InterruptedException{
    
    	  Client client = Client.create();
    	  
    	  WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/webservice/post");
    	  ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, ID);
    	  System.out.println("Registering.....");
    	  Thread.sleep(5000);
    		if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
    		String output = response.getEntity(String.class);
    		if (output.equals("2.04 Changed"))
    			System.out.println("Registered success");
    		else if (output.equals("4.00 Bad Request"))
    			System.out.println("Not Registered, Contact Admin");
      }
          
 }
	
	
	
	
	
	
	
	

