package com.Infinix.hackerbills.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Infinix.hackerbills.repositories.BillRepository;
import com.Infinix.hackerbills.model.Bills;
import com.Infinix.hackerbills.exception.ResourceNotFoundException;

@Service
public class BillService {
	
		@Autowired
		private BillRepository billRepository;
		
		public BillService() {

		}
		
		public Bills addbill(Bills bill) {
			return this.billRepository.save(bill);
		}
		
		public List<Bills> viewAllbills() {
			return this.billRepository.findAll();
		}
		
		public ResponseEntity<Bills> viewbillById(Integer billId)
				throws ResourceNotFoundException {
			Bills bill = billRepository.findById(billId)
					.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: " + billId));
			return ResponseEntity.ok().body(bill);

		}
		
		public ResponseEntity<Bills> updatebill(Integer billId,Bills billDetails) throws ResourceNotFoundException {
			Bills bill = billRepository.findById(billId)
					.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: " + billId));
			bill.setBilledTo(billDetails.getBilledTo());
			bill.setBillNumber(billDetails.getBillNumber());
			bill.setBilledDate(billDetails.getBilledDate());
			bill.setDueDate(billDetails.getDueDate());
			bill.setBilledPrice(billDetails.getBilledPrice());
			bill.setTaxOnBill(billDetails.getTaxOnBill());
			bill.setTotalPrice(billDetails.getTotalPrice());

			return ResponseEntity.ok(this.billRepository.save(bill));
		}
		
		public Map<String, Boolean> removebill(Integer billId)
				throws ResourceNotFoundException {
			Bills bill = billRepository.findById(billId)
					.orElseThrow(() -> new ResourceNotFoundException("bill not found for this id :: " + billId));
			this.billRepository.delete(bill);
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			response.put("deleted", Boolean.TRUE);
			return response;

		}
}
