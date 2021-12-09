package com.DoCor.Services.Vista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DoCor.Model.Vista.VistaList;
import com.DoCor.Repository.Vista.VistaListRepository;

@Service
public class VistaListService {

	@Autowired
	private VistaListRepository listRepository;

	public List<VistaList> list() {
		List<VistaList> list = new ArrayList<VistaList>();
		listRepository.findAll().forEach(list::add);
		return list;
	}
}
