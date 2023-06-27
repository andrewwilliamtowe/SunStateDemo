package com.SunState.demo.TemperatureEntry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TemperatureEntry
{
	@Id
	@GeneratedValue
	private long id;
	private float fahrenheit_temp;
	private long time_stamp;

	public float getCelsius_temp()
	{
		return (fahrenheit_temp
				- 32) / 1.8f;
	}

	public static class TemperatureEntryBuilder
	{
		public TemperatureEntryBuilder celsius_temp( float celsius )
		{
			this.fahrenheit_temp = (celsius * 1.8F)
					+ 32F;
			return this;
		}
	}
}
