package dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.Person;

public interface PersonDao {
int insertPerson(UUID id, Person person);
default int insertPerson(Person person) {
	UUID id = UUID.randomUUID();
	return insertPerson(id, person);
}
List<Person> selectAllPeople();
Optional <Person> selectPersonById(UUID id);
int deletPersonById(UUID id);
int updatePersonalById(UUID id,Person peson);
}
