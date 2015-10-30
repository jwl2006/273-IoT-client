package com.jerSey.Client;

import org.codehaus.jettison.json.JSONException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeviceManage {

	public void read(String clientName) throws JSONException,ClassNotFoundException 
	{
		
				Database db1 =new Database();
				String infoRetrived = db1.readFromClientDB(clientName);
				System.out.println("*" + infoRetrived);
				Client client = Client.create();

				WebResource webResource = client.
						resource("http://localhost:8080/com.youtube.rest/api/manage/read");
			
				ClientResponse response = webResource.type("application/json")
						.post(ClientResponse.class, infoRetrived);
          
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
			
				String output = response.getEntity(String.class);
		
				System.out.println(output);
				System.out.println("Information saved in Server DB");
	}
	
	
	 public void update (String clientName) throws JSONException,ClassNotFoundException
	 {
			try {

				System.out.println("input^: "+clientName);
				
			
		//		String ret = "{"+"Object-Instance-1:"+clientName+"}";
				Client client = Client.create();

				WebResource webResource = client.
						resource("http://localhost:8080/com.youtube.rest/api/manage/update");
			
				ClientResponse response = webResource.type("application/json")
						.post(ClientResponse.class, clientName);
          
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
			
				String output = response.getEntity(String.class);
	//			System.out.println(clientName;
				
				Database db2 = new Database();
				String updatedInfo = db2.parseDeviceInfo(output);
	//			db2.dropTable(clientName);
				db2.insert(updatedInfo, clientName);

			  } catch (Exception e) {

				e.printStackTrace();
			  } 	 
	 }
	
	 
	 
	 
	 public void create (String newclient)
	 {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/manage/create");
			

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, newclient);
             
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
            
				System.out.println("Created account on server");
			
				String output = response.getEntity(String.class);
				
				
		//		System.out.println(output);
				Database db2 = new Database();
				db2.create(newclient);
				String info = db2.parseDeviceInfo(output);
				
				System.out.println(info);
				db2.insert(info,newclient);
	//			System.out.println(output);

			  } catch (Exception e) {

				e.printStackTrace();
			  } 	 
	 }
	
	
	 public void delete (String input)
	 {
			try {

				Client client = Client.create();

				WebResource webResource = client
				   .resource("http://localhost:8080/com.youtube.rest/api/manage/delete");
			

				ClientResponse response = webResource.type("application/json")
				   .post(ClientResponse.class, input);
              
				if (response.getStatus() != 201) {
					throw new RuntimeException("Failed : HTTP error code : "
					     + response.getStatus());
				}
             
				System.out.println("Deleting account");
			
				
				
				String targetDeletionName = response.getEntity(String.class);
				System.out.println("****"+targetDeletionName);
				Database db2 = new Database();
				
				db2.delete(targetDeletionName);
				
				System.out.println("client deleted");
				System.out.println(targetDeletionName);
				System.out.println("Delete client Done!");
				

			  } catch (Exception e) {

				e.printStackTrace();
			  } 	 
	 }
	
	
	
}
