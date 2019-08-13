package com.nts.reservation.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.ReservationDao;
import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoList;
import com.nts.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private final ReservationDao reservationDao;

	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	@Transactional
	public void addReservation(ReservationInfo reservationInfo) {
		reservationDao.insertReservationInfo(reservationInfo);

		reservationDao.insertReservationInfoPrice(reservationInfo.getId(), reservationInfo.getReservationInfoPrice());
	}

	@Override
	public void updateReservation(Map<String, String[]> requestMap) {}

	@Override
	public ReservationInfoList getReservationList(String email) {
		ReservationInfoList reservationInfoList = new ReservationInfoList();
		reservationInfoList.setReservations(reservationDao.selectReservationList(email));
		reservationInfoList.setSize(reservationInfoList.getReservations().size());

		return reservationInfoList;
	}

}
