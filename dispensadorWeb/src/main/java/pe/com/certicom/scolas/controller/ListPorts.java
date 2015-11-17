package pe.com.certicom.scolas.controller;

import javax.comm.*;
import java.util.*;
public class ListPorts {
	
	public static void main (String args[])
	{
		Enumeration port_list = CommPortIdentifier.getPortIdentifiers();		
		System.out.println("no entra  ala lista de puertos: "+port_list.hasMoreElements());
		while (port_list.hasMoreElements())
		{
			CommPortIdentifier port_id = (CommPortIdentifier)port_list.nextElement();
		
			if (port_id.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				System.out.println ("Serial port: " + port_id.getName());
			}
			else if (port_id.getPortType() == CommPortIdentifier.PORT_PARALLEL)
			{
				System.out.println ("Parallel port: " + port_id.getName());
			}
			else
				System.out.println ("Other port: " + port_id.getName());
		}
	} // main
} // class PortList

