package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{  
}