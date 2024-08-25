package br.com.hazforge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.hazforge.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		return person;
	}
	
	public Person findById(String id) {
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Matheus");
		person.setLastName("F Cardoso");
		person.setAddress("Minha casa");
		person.setGender("Male");
		return person;
		
	}
	
	public List<Person> findAll() {
		logger.info("Finding all persons!");
		
		List<Person> persons = new ArrayList<>();
		 
		for (int i = 0; i < 8 ; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
		
	}
	
	public void delete(String id) {
		logger.info("Deleting one persons!");;
	}

	private Person mockPerson(int id) {
		Person person = new Person();
		
		person.setId(Long.valueOf(id));
		person.setFirstName("Person name " + id);
		person.setLastName("Last name " + id);
		person.setAddress("Some address in Brasil " + id);
		person.setGender( id % 2 == 0 ?  "Male" : "Female"  );
		return person;
	}

	
}
