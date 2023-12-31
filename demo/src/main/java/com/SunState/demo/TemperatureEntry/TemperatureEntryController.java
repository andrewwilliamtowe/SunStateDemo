package com.SunState.demo.TemperatureEntry;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/TemperatureEntry")
public class TemperatureEntryController
{

	private TemperatureEntryService service;

	public TemperatureEntryController( TemperatureEntryService service )
	{
		this.service = service;
	}

	@PostMapping("/saveTemperatureEntry")
	public String saveTempEntry( @RequestBody TemperatureEntry entry )
	{
		service.save(entry);
		return "Entry Saved";
	}

	@PostMapping("/enterCelsius")
	public String saveCelsius( @RequestBody String celsius_string )
	{
		float celsius = Float.parseFloat(celsius_string);
		TemperatureEntry entry = TemperatureEntry.builder().celsius_temp(celsius).time_stamp(System.currentTimeMillis()).build();
		service.save(entry);
		return entry.getFahrenheit_temp()
				+ " Degrees Fahrenheit";
	}

	@PostMapping("/enterFahrenheit")
	public String saveFahrenheit( @RequestBody String fahrenheit_string )
	{
		float fahrenheit = Float.parseFloat(fahrenheit_string);
		TemperatureEntry entry = TemperatureEntry.builder().fahrenheit_temp(fahrenheit).time_stamp(System.currentTimeMillis()).build();
		service.save(entry);
		return entry.getCelsius_temp()
				+ " Degrees Celsius";
	}

	@GetMapping("/getAllTempEntries")
	@QueryMapping
	public List<TemperatureEntry> getAll()
	{
		return service.findAll();
	}

	@GetMapping("/getAverageFahrenheit")
	public String getAverageFahrenheit()
	{

		Double fahrenheit_average = service.findAll().stream().mapToDouble(TemperatureEntry::getFahrenheit_temp).average().orElse(Double.NaN);

		return fahrenheit_average
				+ " Degrees Fahrenheit";
	}

	@GetMapping("/getAverageCelsius")
	public String getAverageCelsius()
	{

		Double celsius_average = service.findAll().stream().mapToDouble(TemperatureEntry::getCelsius_temp).average().orElse(Double.NaN);

		return celsius_average
				+ " Degrees Celsius";
	}

	@GetMapping("/getAverageForLastWeek")
	public String getAverageForLastWeek()
	{

		Double fahrenheit_average = service.findAll().stream().filter(e -> e.getTime_stamp() > (System.currentTimeMillis()
				- (7 * 24 * 60 * 60 * 1000))).mapToDouble(TemperatureEntry::getFahrenheit_temp).average().orElse(Double.NaN);

		return fahrenheit_average
				+ " Degrees Fahrenheit; "
				+ ((fahrenheit_average
						- 32) / 1.8d)
				+ " Degrees Celsius";
	}

	@GetMapping("/getById/{id}")
	@QueryMapping
	public TemperatureEntry getById( @PathVariable Long id )
	{
		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String delete( @PathVariable Long id )
	{
		service.deleteById(id);
		return "Entry Deleted";
	}
}
