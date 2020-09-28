package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassService {

    private ClassRepository classRepo;


    @Autowired
    public void setClassRepository(ClassRepository classRepo) {
        this.classRepo = classRepo;
    }

    @Transactional
    public boolean addClass(Class klass) {
        if (classRepo.findClassByTitleIgnoreCase(klass.getTitle()) != null) {
            klass.setId(Long.MIN_VALUE);
            System.out.println("Error");
            return false;
        }
        classRepo.save(klass);
        return true;
    }

    @Transactional
    public Class findClassById(Long id) {
        return classRepo.findClassById(id);
    }

    @Transactional
    public List<Class> findAll() {
        List<Class> classes = classRepo.findAll();
        return classes;
    }


}