package com.jerSey.Client;
//import java.util.Date;



//import java.text.SimpleDateFormat;
import org.codehaus.jettison.json.JSONException;

//"{\"ID\":\"Client1\",\"VALUE\":\"apple\"}"

public class Controller {
	 
	private static String info = "{\"ID\":\"client1\", \"Lifetime\":\"700\",\"LWM2M Version\":\"1.0\","
		+ "\"Objects\":\"1-1,2-1\"}";


	
public static void main(String[] args) throws InterruptedException, JSONException,ClassNotFoundException {
	
	//	args[0] = "manage";
	//	args[1] = "read";
		String clientname = "watchC";
		
	
	//	if (args[0].equals("manage"))
		{
		
			DeviceManage D1 = new DeviceManage();
		
		//	if (args[1].equals("read"))
		//		D1.read(clientname);
		
		//	if (args[1].equals("update"))
				D1.update(clientname);
		//	if (args[1].equals("delete"))
		//		D1.delete(clientname);
		//	if  (args[1].equals("create"))
		//		D1.create("watchC");
			
		}
		
	/*
		
		if (args[0].equals("boot"))
		{
			String choice = args[1];
			Database db1 =new Database();
			Bootstrap M1 = new Bootstrap(); 
	  
			if (choice.equals("factoryBoot"))
			{
				try{
					M1.selfBoot(db1);
				}catch(ClassNotFoundException e){
					e.printStackTrace();}
			}
			else if (choice.equals("serverBoot"))
			{	  
			    try{
			    	M1.bootFromServer("client1",db1);
			    }catch(ClassNotFoundException e){
			    	e.printStackTrace();}
			}
		}
	 
		if (args[0].equals("register"))
		{
			Registration L1 = new Registration();	
			if (args[1].equals("add"))
				L1.register(info);
			if (args[1].equals("update"))
				L1.update("client1");
			if (args[1].equals("delete"))
				L1.deRegister("client1");
		}   
	    
	*/

	}
}

	
