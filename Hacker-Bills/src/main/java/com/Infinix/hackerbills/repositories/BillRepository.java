package com.Infinix.hackerbills.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Infinix.hackerbills.model.Bills;

@Repository
public interface BillRepository extends JpaRepository<Bills, Integer> {
	
}
