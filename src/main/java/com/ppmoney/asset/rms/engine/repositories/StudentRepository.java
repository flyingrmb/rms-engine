package com.ppmoney.asset.rms.engine.repositories;

import com.ppmoney.asset.rms.engine.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by paul on 2018/5/20.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAll();
}
