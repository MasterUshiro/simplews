package ua.com.simplews.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.simplews.domain.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Person findByUsername(String username);

}



