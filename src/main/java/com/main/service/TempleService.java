package com.main.service;

import java.util.List;

import com.main.entity.Temple;

public interface TempleService {
	public Temple addData(Temple temple);
	public Temple getTemple(int id);
	public List<Temple> getAllTemple();
	public Temple updat(int id, Temple temple);
}
