package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Temple;
import com.main.reposetory.TempleReposetory;
@Service
public class TempleServiceImpl implements TempleService {
	@Autowired
	private TempleReposetory reposetory;

	@Override
	public Temple addData(Temple temple) {		
		return reposetory.save(temple);
	}

	@Override
	public Temple getTemple(int id) {
		
		
		return reposetory.findById(id).orElse(null);
	}

	@Override
	public List<Temple> getAllTemple() {
	  
		return reposetory.findAll();
	}

	@Override
	public Temple updat(int id, Temple temple) {
		Temple found=reposetory.findById(id).orElse(null);
		if (temple!=null) {
			return reposetory.save(temple);
		}
		return null;
	}
	

}
