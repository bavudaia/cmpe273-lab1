

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClient {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		try
		{
			int choice=0,flag=0;
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			do
			{
				System.out.println("MAIN MENU");
				System.out.println("1. Enter Client");
				//System.out.println("2. Get all clients");
				System.out.println("2. Get client by client id");
				System.out.println("3. Exit");
				System.out.println("Choose one number: ");
				choice = Integer.parseInt(br.readLine());

				switch(choice)
				{
				case  1: {
					System.out.println("1. Enter Client id : ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("1. Enter Data : ");
					String data = br.readLine();

					sendPostRequest(generateClient(id, data));
					break;}
			/*	case 2:{
					sendGETRequest(); break;
				}*/
				case 2 :{
					System.out.println("2. Enter Client id : ");
					String id = br.readLine();
					sendGETRequest(id);
					break;
				}
				case 3: {flag =1;break;}
				}
			}while(flag==0);
		}
		catch(JsonProcessingException e){
			System.out.println("Error While converting object to JSON string: "+ e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("IO Exception occured: "+ e.getMessage());
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Invalid number : "+ e.getMessage());
		}

	}
/*
	private static void sendGETRequest() throws JsonProcessingException
	{
		//String url = getBaseUrl()+"/"+clientId;
		Client client = ClientBuilder.newClient();
		WebTarget webTarget =  client.target(getBaseUrl());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList resultList = response.readEntity(ArrayList.class);

		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(resultList);

		System.out.println(jsonResult);
	}
*/
	private static void sendGETRequest(String clientId ) throws JsonProcessingException
	{
		//String url = getBaseUrl()+"/"+clientId;
		Client client = ClientBuilder.newClient();
		WebTarget webTarget =  client.target(getBaseUrl()).path(clientId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ClientWrapper result = response.readEntity(ClientWrapper.class);

		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);

		System.out.println(jsonResult);
	}

	private static void sendPostRequest(ClientWrapper requestData )
	{
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(getBaseUrl());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(requestData, MediaType.APPLICATION_JSON));
		System.out.print("Status : ");
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));	
	}

	private static ClientWrapper generateClient (int id, String data)
	{
		ClientWrapper client= new ClientWrapper(id, data);
		return client;
	}

	private static String getBaseUrl()
	{
		return "http://localhost:8080/simpleservice/webapi/clients";
	}


}
