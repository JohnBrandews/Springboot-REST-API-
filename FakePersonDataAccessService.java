package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import model.Person;
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
private static List<Person> DB = new ArrayList<>();
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id,person.getName()));
		return 1;
	}
	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		
		return  DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
	@Override
	public int deletPersonById(UUID id) {
	Optional<Person> personMaybe = selectPersonById(id);
	if(personMaybe.isEmpty()) {
		return 0;
	}
	DB.remove(personMaybe.get());
		return 1;
	}
	@Override
	public int updatePersonalById(UUID id, Person update) {
		return selectPersonById(id).map(person ->{
			int indexOfPersonToUpdate = DB.indexOf(person);
			if(indexOfPersonToUpdate >= 0) {
				DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
				return 1;
			}
			return 0;
		})
		.orElse(0);
	}

}
