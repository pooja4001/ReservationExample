package com.cg.reservation.exception;

public class ReservationAlreadyPresentException extends RuntimeException {
	public ReservationAlreadyPresentException (String s) {
		super(s);
}
}