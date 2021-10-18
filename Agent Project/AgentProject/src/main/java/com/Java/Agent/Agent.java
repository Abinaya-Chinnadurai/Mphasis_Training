package com.Java.Agent;

public class Agent {
	
	private int AgentID;
	private String Name;
	private String City;
	private String Gender;
	private String MS;
	private double Premium;
	
	public Agent() {}

	public Agent(int agentID, String name, String city, String gender, String mS, double premium) {
		super();
		AgentID = agentID;
		Name = name;
		City = city;
		Gender = gender;
		MS = mS;
		Premium = premium;
	}

	public int getAgentID() {
		return AgentID;
	}

	public void setAgentID(int agentID) {
		AgentID = agentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMS() {
		return MS;
	}

	public void setMS(String mS) {
		MS = mS;
	}

	public double getPremium() {
		return Premium;
	}

	public void setPremium(double premium) {
		Premium = premium;
	}

	@Override
	public String toString() {
		return "AgentID=" + AgentID + ", Name=" + Name + ", City=" + City + ", Gender=" + Gender + ", MaritalStatus=" + MS
				+ ", Premium=" + Premium+"\n";
	}
	
	
}
