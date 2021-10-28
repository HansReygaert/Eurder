package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminRepository {
	private final Map<String, Administrator> administrators;

	@Autowired
	public AdminRepository() {
		this.administrators = new HashMap<>();
		Administrator testAdmin = new Administrator("testAdmin");
		administrators.put(testAdmin.getUuid(), testAdmin);
	}

	public Administrator getAdministratorById(String uuid){
		Administrator admin = administrators.get(uuid);
		System.out.println(admin);
		return administrators.get(uuid);
	}
}
