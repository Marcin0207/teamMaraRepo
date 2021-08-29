package com.example.projectMara.adapter.repository;

import com.example.projectMara.domain.model.Copy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CopyDao extends CrudRepository<Copy, Integer> {

    List<Copy> findAll();

}