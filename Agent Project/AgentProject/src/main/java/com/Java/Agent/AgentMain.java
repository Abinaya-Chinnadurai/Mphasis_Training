package com.Java.Agent;

import java.sql.SQLException;
import java.util.*;

public class AgentMain {

	public static void main(String[] args) {
		int choice;
		Agent agent = new Agent();
          Scanner scan = new Scanner(System.in);
         do {
          System.out.println("OPERATIONS:");
          System.out.println("-----------");
          System.out.println("1.Show Agents\n2.Add Agent\n3.Update Agent\n4.Search Agent\n5.Delete Agent\n6.Exit");
          System.out.println("Enter Your Choice: ");
          choice = scan.nextInt();
          switch(choice) {
          
          case 1:
        	  Agent[] arrAgent;
        	  try {
        		  arrAgent = new AgentDAO().ShowAgent();
        		  for (Agent agent2 : arrAgent) {
					System.out.println(agent2);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	break;
          case 2:
              System.out.println("Enter Agent ID:");
        	  agent.setAgentID(scan.nextInt());
        	  System.out.println("Enter Agent Name: ");
        	  agent.setName(scan.next());
        	  System.out.println("Enter City: ");
        	  agent.setCity(scan.next());
        	  System.out.println("Enter Gender(MALE/FEMALE): ");
        	  agent.setGender(scan.next());
        	  System.out.println("Enter Marital Status(y/n):");
        	  agent.setMS(scan.next());
        	  System.out.println("Enter Premium: ");
        	  agent.setPremium(scan.nextDouble());
        	  
        	  try {
				new AgentDAO().InsertAgentDAO(agent);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
          case 3:
            System.out.println("Enter Agent ID: ");
            int aid = scan.nextInt();
            try {
				Agent newAgent = new AgentDAO().SearchAgentDAO(aid);
				if(newAgent == null) {
					System.out.println("\nNo Such Agent To Update\n");
				}else {
					System.out.println("Enter the field You Want to Update(name/city/gender/maritalstatus/premium):");
					String field = scan.next();
					switch(field) {
					case "name":
						System.out.println("Enter Name:");
						String name = scan.next();
						new AgentDAO().UpdateNameDAO(name,newAgent.getAgentID());
						break;
					case "city":
						System.out.println("Enter City:");
						String city = scan.next();
						new AgentDAO().UpdateCityDAO(city,newAgent.getAgentID());
						break;
					case "gender":
						System.out.println("Enter Gender(MALE/FEMALE):");
						String gen = scan.next();
						new AgentDAO().UpdateGenderDAO(gen,newAgent.getAgentID());
						break;
					case "maritalstatus":
						System.out.println("Enter Marital Status(y/n):");
						String ms = scan.next();
						new AgentDAO().UpdateMSDAO(ms,newAgent.getAgentID());
						break;
					case "premium":
						System.out.println("Enter Premium:");
						double prem = scan.nextDouble();
						new AgentDAO().UpdatePremiumDAO(prem,newAgent.getAgentID());
						break;
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	break;  
          case 4:
           System.out.println("Enter Agent ID: ");
        	  int id = scan.nextInt();
        	  
        	  try {
				new AgentDAO().SearchAgentDAO(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            break;
          case 5:
        	  System.out.println("Enter Agent ID: ");
        	  int did = scan.nextInt();
        	  try {
				new AgentDAO().DeleteAgentDAO(did);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
          case 6:
        	  System.exit(1);
        	  break;
          }
         }while(choice<7);
          
	}

}

















