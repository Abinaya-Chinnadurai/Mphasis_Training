package com.Java.Agent;

import java.sql.*;
import java.util.*;

public class AgentDAO {
    Connection con;
    PreparedStatement pst;
    Agent agent = new Agent();
	public void InsertAgentDAO(Agent agent) throws SQLException {
		con=ConnectionHelper.getConnection();
		String cmd = "insert into agentexam (agentid,name,city,gender,maritalstatus,premium)"
				+ "values(?,?,?,?,?,?)";	
		pst = con.prepareStatement(cmd);
		pst.setInt(1, agent.getAgentID());
		pst.setString(2,agent.getName());
		pst.setString(3, agent.getCity());
		pst.setString(4, agent.getGender());
		pst.setString(5, agent.getMS());
		pst.setDouble(6, agent.getPremium());
		pst.executeUpdate();
		System.out.println("\n********Agent Added*********\n");
	}
	
	public Agent SearchAgentDAO(int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from agentexam where agentid=?";
		pst= con.prepareStatement(cmd);
		pst.setInt(1,id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			agent.setAgentID(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setCity(rs.getString("city"));
			agent.setGender(rs.getString("gender"));
			agent.setMS(rs.getString("maritalstatus"));
			agent.setPremium(rs.getDouble("premium"));
			
			if(agent != null) {
				System.out.println(agent);
			}else {
				System.out.println("\n*****No Such Agent*****\n");
			}
		}
		return agent;
				
	}
	public void DeleteAgentDAO(int did) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "delete from agentexam where agentid=?";
		pst= con.prepareStatement(cmd);
		pst.setInt(1,did);
		pst.executeUpdate();
		System.out.println("\n******Agent Deleted*****\n");		
	}
	public Agent[] ShowAgent() throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from agentexam";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()) {
			agent = new Agent();
			agent.setAgentID(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setGender(rs.getString("gender"));
			agent.setMS(rs.getString("maritalstatus"));
			agent.setCity(rs.getString("city"));
			agent.setPremium(rs.getDouble("premium"));
			agentList.add(agent);
		}
	    return agentList.toArray(new Agent[agentList.size()]);
		
	}
	public void UpdateNameDAO(String name, int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update agentexam set name=? where agentid=?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, name);
		pst.setInt(2,id);	
		pst.executeUpdate();
		System.out.println("\n***Name Updated***\n");
	}

	public void UpdateCityDAO(String city, int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update agentexam set city=? where agentid=?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, city);
		pst.setInt(2,id);	
		pst.executeUpdate();
		System.out.println("\n***City Updated***\n");		
	}

	public void UpdateGenderDAO(String gen, int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update agentexam set gender=? where agentid=?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, gen);
		pst.setInt(2,id);	
		pst.executeUpdate();
		System.out.println("\n***Gender Updated***\n");		
	}

	public void UpdateMSDAO(String ms, int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update agentexam set maritalstatus=? where agentid=?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, ms);
		pst.setInt(2,id);	
		pst.executeUpdate();
		System.out.println("\n***Marital Status Updated***\n");		
	}

	public void UpdatePremiumDAO(double prem, int id) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Update agentexam set premium=? where agentid=?";
		pst = con.prepareStatement(cmd);
		pst.setDouble(1, prem);
		pst.setInt(2,id);	
		pst.executeUpdate();
		System.out.println("\n***Premium Updated***\n");		
	}

}

























