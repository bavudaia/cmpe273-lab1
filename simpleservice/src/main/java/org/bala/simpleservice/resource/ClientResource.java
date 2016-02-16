package org.bala.simpleservice.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bala.simpleservice.model.Client;
import org.bala.simpleservice.services.ClientService;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {
	private ClientService clientService = new ClientService();
	
	@POST
	public String postClientData(Client client)
	{
		String data = clientService.postClientData(client);
		return data;
	}
	
	@GET
	public List<Client> getAllClients()
	{
		return clientService.getAllClients();
	}
	
	@Path("/{clientId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClientData(@PathParam ("clientId") int clientId)
	{
		System.out.println(clientId);
		return clientService.getClientById(clientId);
	}
}
