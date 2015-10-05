package com.jerSey.Client;
//import java.util.Date;


//import java.text.SimpleDateFormat;
import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;

//"{\"ID\":\"Client1\",\"VALUE\":\"apple\"}"

public class Controller {
public static void main(String[] args) throws InterruptedException, JSONException {
 /*
	String info = "{\"ID\":\"client1\", \"Lifetime\":\"86400\",\"LWM2M Version\":\"1.0\","
 		+ "\"Objects\":\"1-1,2-1\"}";
		
 */    
//	Registration L1 = new Registration();	
 //    L1.register(info);
  //   L1.update("client1");
 //    L1.deRegister("client1");


	Database db1 =new Database();
	try{
		db1.establishJDBC();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}{}
	
	/*
	Bootstrap M1 = new Bootstrap(); 
	   String info=M1.boot("client1");
	    System.out.println("Your bootstrap information: ");
		System.out.println(info);
*/

 /* 
	
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
	 
	*/
	 
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
	
