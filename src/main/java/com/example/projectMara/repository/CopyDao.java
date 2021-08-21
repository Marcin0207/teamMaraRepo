package com.example.projectMara.repository;

import com.example.projectMara.domain.model.Copy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopyDao extends CrudRepository<Copy, Integer> {

    List<Copy> findAll();

}
