package com.nts.reservation.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
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
	public Map<String, ReservationInfo> getReservationMap(String email) {
		ReservationInfoList reservationInfoList = new ReservationInfoList();
		reservationInfoList.setReservations(reservationDao.selectReservationList(email));
		reservationInfoList.setSize(reservationInfoList.getReservations().size());

		Map<String, ReservationInfo> reservationInfoMap = new HashMap<>();

		for (ReservationInfo reservationInfo : reservationInfoList.getReservations()) {
			if (reservationInfo.isCancelFlage()) {
				reservationInfoMap.put("CANCEL_RESERVATION", reservationInfo);
				continue;
			}

			if (reservationInfo.getReservationDate().isAfter(LocalDate.now())) {
				reservationInfoMap.put("DONE_RESERVATION", reservationInfo);
			} else {
				reservationInfoMap.put("READY_RESERVATION", reservationInfo);
			}

		}
		return reservationInfoMap;
	}

}
