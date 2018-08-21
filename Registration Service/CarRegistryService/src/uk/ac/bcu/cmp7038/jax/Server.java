/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.bcu.cmp7038.jax;

import javax.xml.ws.Endpoint;
import java.util.Scanner;
/**
 *
 * @author cmp7038User
 */
public class Server {
    	   protected Server() throws Exception {
	        // START SNIPPET: publish
	        System.out.println("Starting Server");
	        CarRegistryImpl implementor = new CarRegistryImpl();
	        String address = "http://cmp7038-PC:9999/car-reg";
	        Endpoint.publish(address, implementor);
	        // END SNIPPET: publish
	    }

	    public static void main(String args[]) throws Exception {
	        new Server();
                Scanner reader = new Scanner(System.in);
	        System.out.println("Server ready...");	        
	        System.out.println("Press any key to exit....");
                reader.nextLine();
                reader.close();
	        System.exit(0);
	    }
}
