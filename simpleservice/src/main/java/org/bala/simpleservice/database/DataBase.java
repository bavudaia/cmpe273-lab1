package org.bala.simpleservice.database;

import java.util.HashMap;
import java.util.Map;

import org.bala.simpleservice.model.Client;

public class DataBase {
	public static Map<Integer, Client> clientMap ;
	
	static{
		clientMap = new HashMap<>();
		Client c1 = new Client();
		c1.setId(1);
		c1.setData("Client1");
		clientMap.put(1,c1);
		Client c2 = new Client();
		c2.setId(2);
		c2.setData("Client2");
		clientMap.put(2,c2);		
	}
}
