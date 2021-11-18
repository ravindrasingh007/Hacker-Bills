package com.Infinix.hackerbills.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Infinix.hackerbills.model.Bills;
import com.Infinix.hackerbills.exception.ResourceNotFoundException;
import com.Infinix.hackerbills.services.BillService;


@RestController
@RequestMapping("/")
public class BillController {
	
	@Autowired
	private BillService billService;

	@PostMapping("bills")
	public Bills addbill(@RequestBody Bills bill) {
		return billService.addbill(bill);
	}

	@GetMapping("bills")
	public List<Bills> viewAllbills() {
		return billService.viewAllbills();
	}

	@GetMapping("bills/{id}")
	public ResponseEntity<Bills> viewbillById(@PathVariable(value = "id") Integer billId)
			throws ResourceNotFoundException {
		return billService.viewbillById(billId);
	}

	@PutMapping("bills/{id}")
	public ResponseEntity<Bills> updatebill(@PathVariable(value = "id") Integer billId,
			@Validated @RequestBody Bills billDetails) throws ResourceNotFoundException {
		return billService.updatebill(billId, billDetails);
	}

	@DeleteMapping("bills/{id}")
	public Map<String, Boolean> removebill(@PathVariable(value = "id") Integer billId)
			throws ResourceNotFoundException {
		return billService.removebill(billId);
	}

}
