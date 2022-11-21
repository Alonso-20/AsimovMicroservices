package com.asimov.directorservice;

import com.asimov.directorservice.entity.Director;
import com.asimov.directorservice.repository.DirectorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class DirectorRepositoryMockTest {
    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void whenFindAllDirectors_thenReturnListOfDirectors(){
        Director director01 = Director.builder()
                .first_name("John")
                .age(18)
                .email("hola@gmail.com")
                .password("password")
                .phone("999999999").build();

        directorRepository.save(director01);

        List<Director> directors = directorRepository.findAll();
        Assertions.assertThat(directors.size()).isEqualTo(2);
    }
}
