package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {

    Class findClassByTitleIgnoreCase(String title);

    Class findClassById(Long id);

    List<Class> findAll();

}
