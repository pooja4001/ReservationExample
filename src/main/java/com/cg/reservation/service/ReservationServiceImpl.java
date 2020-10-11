package com.cg.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.reservation.entity.ReservationEntity;
import com.cg.reservation.entity.ReservationStatus;
import com.cg.reservation.exception.ReservationAlreadyPresentException;
import com.cg.reservation.exception.ReservationInvalidException;
import com.cg.reservation.repository.ReservationRepo;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationRepo reservationRepo;

	@Autowired
	public ReservationServiceImpl(ReservationRepo reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	@Override
	public String addReservation(ReservationEntity reservation) {
		if (reservationRepo.findById(reservation.getReservation_no()).isPresent()) {

			throw new ReservationAlreadyPresentException(
					"Reservation with ReservationNo: " + reservation.getReservation_no() + " is already present!!!!");
		} else {
			reservationRepo.save(reservation);
		}
		return ("Reservation with ReservationNo: " + reservation.getReservation_no() + " is added!!!!");
	}

	/*
	 * Will work on this
	 */
	@Override
	public ReservationEntity modifyReservation(ReservationEntity reservation) {
		// TODO Auto-generated method stub
		if (!reservationRepo.findById(reservation.getReservation_no()).isPresent()) {
			// throw new ReservationAlreadyPresentException("Reservation with
			// reservation_no:"+reservation.getReservation_no()+"is already present!!");
			if ((reservation.getReservation_status() == ReservationStatus.BOOKED)) {
				reservationRepo.save(reservation);
				return reservation;

			}
			throw new ReservationAlreadyPresentException(
					"Reservation with reservation_no:" + reservation.getReservation_no() + "is already present!!");
		}
		return reservation;
	}

	// ReservationRepo.save(reservation);
	// return reservation;
	// }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public Iterable<ReservationEntity> viewAllReservation() {
		// TODO Auto-generated method stub
		// public ReservationEntity viewAllReservation(ReservationEntity reservation) {
		List<ReservationEntity> resList = (List<ReservationEntity>) reservationRepo.findAll();
		if (resList.isEmpty()) {
			throw new ReservationInvalidException("Reservation is Null!! ");
		}
		return resList;
	}

	@Override
	public Optional<ReservationEntity> viewReservationByReservationNo(long reservation_no) {

		if (reservationRepo.existsById(reservation_no)) {
			return reservationRepo.findById(reservation_no);
		}
//		else if (ReservationRepo.findById(reservation_no).isEmpty())
//		{
		// throw new ReservationAlreadyPresentException("Reservation is Not Found!! ");
//		}
		else {
			throw new ReservationInvalidException("Reservation is Not Found!! ");
		}

	}

//
//		if (ReservationRepo.existsById(reservation_no))
//		{		
//		
//		if (ReservationRepo.equals(ReservationStatus.BOOKED))	
//			{
//				ReservationRepo.deleteById(reservation_no);
//				// System.out.println("Reservation Cancelled!!!");
//			}
////			else {
////				throw new ReservationInvalidException("Reservation is Invalid");
////			}
//		} 
//		else {
//			throw new ReservationInvalidException("Reservation is Invalid");
//		
	@Override
	public void cancelReservation(long reservation_no) {
		reservationRepo.findById(reservation_no).ifPresentOrElse(reservation -> {
			if (ReservationStatus.BOOKED.equals(reservation.getReservation_status())) {
				reservationRepo.deleteById(reservation.getReservation_no());
			}
		}, () -> {
			throw new ReservationInvalidException(String.format("Reservation %s is invalid", reservation_no));
		});
	}
}
