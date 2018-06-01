package com.pittes.client;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.pittes.binding.Employee;

public class Test {

	public static void main(String[] args) throws JAXBException {
		//Marshalling : converting Java obj into XML
		Employee employee = new Employee();
		employee.setEmpNo(37);
		employee.setName("Eric");
		employee.setSalary(50000.0);
		
		// create JAXBContext object, using newInstance() from JAXBContext class
		// the newInstance() is a static factory method
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		
		// create Marshaller object from JAXBContext
		Marshaller marshaller = context.createMarshaller();
		
		// call marshal(-) from marshaller object
//		marshaller.marshal(employee, System.out);
		
		// store the generated XML in a file
		File file = new File("emp.xml");
		marshaller.marshal(employee, file);
		System.out.println("done");
		
		// get the generated XML in the form of String by using StringWriter
		StringWriter writer = new StringWriter();
		marshaller.marshal(employee, writer);
		String xml = writer.toString();
		System.out.println(xml);

	}

}
