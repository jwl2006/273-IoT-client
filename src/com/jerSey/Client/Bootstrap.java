package com.jerSey.Client;

import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;




import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Bootstrap {

private static String defaultValue = "('client1','Haier','00/00/0000','30-34-40','http://localhost:8080/com.youtube.rest/api/register')";
    
    
    public void selfBoot (Database db1) throws ClassNotFoundException 
	{
    	System.out.println("Set to default information!");
    	System.out.println("The default value is: ");
    	System.out.println(defaultValue);
    	db1.delete("client1");
    	db1.insert(defaultValue);
    	System.out.println("Self boot done!");
	}

    public void bootFromServer(String clientName,Database db1) throws JSONException,ClassNotFoundException 
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
		System.out.println("Server Bootstrap information: ");  
		System.out.println(output);  
		String query = db1.parseData(output);
		System.out.println("QUERY"); 
		System.out.println(query); 
		db1.delete("client1");
		db1.insert(query);
		System.out.println("Information saved in Mysql!");
		System.out.println("Server boot done!");
		
   }
};
	
