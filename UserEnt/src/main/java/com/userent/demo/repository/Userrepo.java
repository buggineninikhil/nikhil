package com.userent.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userent.demo.entity.UsrEntity;

@Repository
public interface Userrepo extends JpaRepository<UsrEntity, Long> {
	List<UsrEntity> findByPasswordAndRole(String password,String role);

}
