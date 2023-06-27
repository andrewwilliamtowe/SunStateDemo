package com.SunState.demo.TemperatureEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemperatureEntryRepository extends JpaRepository<TemperatureEntry, Long>
{

}
