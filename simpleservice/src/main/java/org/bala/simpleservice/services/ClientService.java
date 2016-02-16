package org.bala.simpleservice.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bala.simpleservice.database.DataBase;
import org.bala.simpleservice.model.Client;

public class ClientService {
	public String postClientData(Client client)
	{
		
		if(client == null)
			return null;
		DataBase.clientMap.put(client.getId(), client);
		return client.getData();
	}
	
	public Client getClientById(int clientId){
		System.out.println(clientId);
		return DataBase.clientMap.get(clientId);
	}
	
	public List<Client> getAllClients()
	{
		Collection<Client> clients = DataBase.clientMap.values();
		return new ArrayList<>(clients); 
	}
}
