package com.cg.reservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.reservation.entity.ReservationEntity;
import com.cg.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	
	
	private ReservationService reservationservice; 
	
	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationservice = reservationService;
	}
	
	
	
	 
	@PostMapping("/addReservation")
	public void addReservation(@RequestBody ReservationEntity reservation)
	{
		reservationservice.addReservation(reservation);
		
	}
	
	@GetMapping("/viewReservation/{reservation_no}")
	public Optional<ReservationEntity> viewReservationByReservationNo(@PathVariable("reservation_no") long reservation_no){
	
		return reservationservice.viewReservationByReservationNo(reservation_no);
		
	}
	
	@GetMapping("/viewAllReservation")
	//@ExceptionHandler(value = ReservationInvalidException.class)
	public Iterable<ReservationEntity> viewAllReservation()
	{
		return reservationservice.viewAllReservation();
	}
	
	@PutMapping("/modifyReservation")
	public void modifyReservation(@RequestBody ReservationEntity reservation)
	{
		reservationservice.modifyReservation(reservation);
	}
//	
//	@DeleteMapping("/cancelReservation")
//	public void cancelReservation(@PathVariable("reservation_no") ReservationEntity reservation)
//	{
//		reservationservice.cancelReservation(reservation);
//	}
//	
	@DeleteMapping("/cancelReservation/{reservation_no}")
	public ResponseEntity<Void> cancelReservation(@PathVariable("reservation_no") long reservation_no)
	{
		reservationservice.cancelReservation(reservation_no);
		return ResponseEntity.noContent().build();
	}
	
}
