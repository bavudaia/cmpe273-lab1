package org.bala.simpleservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private int id;
	private String data;
	
	public Client(){}
	
	public Client(int id, String data)
	{
		this.id = id;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
