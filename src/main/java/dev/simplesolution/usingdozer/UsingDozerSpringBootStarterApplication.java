package dev.simplesolution.usingdozer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.dozermapper.core.Mapper;

import dev.simplesolution.usingdozer.model.DestinationContact;
import dev.simplesolution.usingdozer.model.SourceContact;

@SpringBootApplication
public class UsingDozerSpringBootStarterApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(UsingDozerSpringBootStarterApplication.class);
	
	@Autowired
	private Mapper mapper; 
	
	public static void main(String[] args) {
		SpringApplication.run(UsingDozerSpringBootStarterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Your Application code will be place here.
		logger.info("Starting Application...");
		
		SourceContact sourceContact = new SourceContact();
		sourceContact.setId(73);
		sourceContact.setName("Sophie");
		sourceContact.setPhone("1234567890");
		sourceContact.setEmail("testing@simplesolution.dev");
		sourceContact.setAddress("New York city");
		
		DestinationContact destinationContact = new DestinationContact();
		
		// Map source object to destination object 
		mapper.map(sourceContact, destinationContact);
		
		// Logging destination object data 
		logger.info(destinationContact.getIdentity().toString());
		logger.info(destinationContact.getFullName());
		logger.info(destinationContact.getPhoneNumber());
		logger.info(destinationContact.getEmailAddress());
		logger.info(destinationContact.getAddressLine());
	}

}
