package ua.com.simplews.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.simplews.domain.Languages;

public interface LanguagesRepo extends JpaRepository<Languages, Long> {

    Languages findByCode(String code);

}



