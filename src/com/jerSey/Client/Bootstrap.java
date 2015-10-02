package com.jerSey.Client;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Bootstrap {

	try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/com.bootstrapserver/api/bootstrap/request");

		ClientResponse response = webResource.accept("application/json")
                   .get(ClientResponse.class);

		
		if (response.getStatus() != 200  && response.getStatus() != 204) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String output = response.getEntity(String.class);
        JSONObject obj = new JSONObject(output);
        String id= obj.optString("ID");
        String value = obj.optString("VALUE");
		System.out.println(value+ " Your ID is: " + id);

	  } catch (Exception e) {

		e.printStackTrace();

	  }
	
}
