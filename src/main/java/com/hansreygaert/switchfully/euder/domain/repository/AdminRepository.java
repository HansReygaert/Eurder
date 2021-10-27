package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {
	private List<Administrator> administrators;



	public List<Administrator> getAdministrators() {
		return administrators;
	}
}
