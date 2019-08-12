package com.nts.reservation.dao;

import org.springframework.stereotype.Repository;

import com.nts.reservation.dto.ReservationInfo;

@Repository
public interface ReservationDao {
	int insertReservationInfo(ReservationInfo nri);
}
