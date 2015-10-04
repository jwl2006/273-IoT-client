package com.jerSey.Client;

import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Bootstrap {

	

   public String boot(String clientName) throws JSONException
	{
	    
	    Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/com.youtube.rest/api/bootstrap/get/"+clientName);;

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		
		if (response.getStatus() != 200  && response.getStatus() != 204) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String output = response.getEntity(String.class);

        
       
    
		return output;
		
   }
};
	
