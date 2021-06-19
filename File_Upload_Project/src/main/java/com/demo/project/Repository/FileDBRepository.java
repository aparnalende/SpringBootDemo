package com.demo.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}