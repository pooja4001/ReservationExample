package com.cg.reservation.service;



import java.util.Optional;

import com.cg.reservation.entity.ReservationEntity;

public interface ReservationService {

	public String addReservation(ReservationEntity reservation);
	
	public ReservationEntity modifyReservation(ReservationEntity reservation);
	
	public Iterable<ReservationEntity> viewAllReservation();
	//public ReservationEntity viewAllReservation(ReservationEntity reservation);
	
	public Optional<ReservationEntity> viewReservationByReservationNo(long reservation_no);
	
	//public String cancelReservation(ReservationEntity reservation);

	public void cancelReservation(long reservation_no);
	
}
