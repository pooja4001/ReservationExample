package com.cg.reservation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reservation_info")
public class ReservationEntity {

	public ReservationEntity() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reservation_no;

	private String guest_name;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate arrival_date;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate departure_date;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate booking_date;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate modified_date;

	@Enumerated(EnumType.STRING)
	public ReservationStatus reservation_status;

	public ReservationStatus getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(ReservationStatus reservation_status) {
		this.reservation_status = reservation_status;
	}

	private String active = "Y";

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Long getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(Long reservation_no) {
		this.reservation_no = reservation_no;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public LocalDate getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(LocalDate arrival_date) {
		this.arrival_date = arrival_date;
	}

	public LocalDate getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(LocalDate departure_date) {
		this.departure_date = departure_date;
	}

	public LocalDate getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.booking_date = booking_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "ReservationEntity [reservation_no=" + reservation_no + ", guest_name=" + guest_name + ", arrival_date="
				+ arrival_date + ", departure_date=" + departure_date + ", booking_date=" + booking_date
				+ ", modified_date=" + modified_date + ", reservation_status=" + reservation_status + ", active="
				+ active + "]";
	}

}
