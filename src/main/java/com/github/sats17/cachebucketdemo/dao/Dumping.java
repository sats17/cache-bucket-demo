package com.github.sats17.cachebucketdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sats17.cachebucketdemo.model.Dump;

@Repository
public interface Dumping extends JpaRepository<Dump, Integer> {

}
