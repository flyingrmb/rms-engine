package com.ppmoney.asset.rms.engine.web;

import com.ppmoney.asset.rms.engine.entity.Student;
import com.ppmoney.asset.rms.engine.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by paul on 2018/5/15.
 */
@RestController
public class HomepageController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/")
    public List<Student> home() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
