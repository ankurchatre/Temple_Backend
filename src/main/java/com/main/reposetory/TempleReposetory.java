package com.main.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Temple;

public interface TempleReposetory extends JpaRepository<Temple, Integer> {

}
