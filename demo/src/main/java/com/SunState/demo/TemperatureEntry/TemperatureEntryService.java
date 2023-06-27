package com.SunState.demo.TemperatureEntry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TemperatureEntryService
{
	@Autowired
	private ITemperatureEntryRepository repo;

	public void save( @RequestBody TemperatureEntry employee )
	{
		repo.save(employee);
	}

	public List<TemperatureEntry> findAll()
	{
		return repo.findAll();
	}

	public TemperatureEntry findById( @PathVariable Long id )
	{
		return repo.findById(id).get();
	}

	public void deleteById( @PathVariable Long id )
	{
		repo.deleteById(id);
	}
}
