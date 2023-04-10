package com.consumeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumeapi.ModelObject.Repos;
@Repository
public interface ReposRepository extends JpaRepository<Repos, Integer>{

}
