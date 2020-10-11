package com.cg.reservation.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.reservation.entity.ReservationEntity;
import com.cg.reservation.entity.ReservationStatus;

public interface ReservationRepo extends CrudRepository<ReservationEntity, Long>{

	//ReservationStatus findAll(ReservationStatus booked);



	

	//Optional<ReservationEntity> findById(ReservationStatus booked);

	//void cancelReservation(ReservationEntity reservation);

	//void deleteById(ReservationEntity reservation);

	//Optional<ReservationEntity> findAllById(ReservationStatus booked);

	//Object findById(ReservationStatus booked);

	

}
