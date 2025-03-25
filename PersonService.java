package service;

import dao.PersonRepository;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personRepository.findById(id);
    }

    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(UUID id, Person newPerson) {
        newPerson.setId(id); // Ensure the ID is set
        return personRepository.save(newPerson);
    }
}