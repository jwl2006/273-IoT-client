package com.jerSey.Client;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

//"{\"ID\":\"Client1\",\"VALUE\":\"apple\"}"

public class Controller {

public static void main(String[] args) throws InterruptedException, JSONException {
	    
    Myclient client1 = new Myclient(); 
	
    String input ="post";
	   
	if (input.equals("post"))
	{
//	    while(true)
//	    {
	String curTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
	
	JSONObject obj = new JSONObject();
	
	obj.put("ID", "client1");
	
	obj.put("VALUE", curTime);
	String temp = obj.toString();
	System.out.println(temp);
	client1.ClientPost(temp);
	
//	Thread.sleep(5000);
	      }
//	}
	     
	
	if (input.equals("get"))
	      {
	    	  client1.ClientGet("client1");
	      }
	 
	 }
}

	//    Myclient client2 = new Myclient();  
	 //   client2.ClientPost(args[1]);   
	/*
	    while(true){
	    client1.ClientGet();
	    Thread.sleep(3000);
	  //  client2.ClientGet();
	 //   Thread.sleep(3000);
	    }
	  */  
	
