package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class SalesService {

	@Autowired
	private SaleRepository saleRepository;

	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		//LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min;
		LocalDate max;
		try {
			min = LocalDate.parse(minDate);
		} catch (Exception e) {
			min = LocalDate.parse("1900-01-01");
		}
		try {
			max = LocalDate.parse(maxDate);
		} catch (Exception e) {
			max = LocalDate.parse("2050-01-01");
		}
		Page<Sale> salePage = saleRepository.findSales(min, max, pageable);
		return salePage;
	}
}
