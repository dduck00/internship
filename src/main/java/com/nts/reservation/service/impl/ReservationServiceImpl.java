package com.nts.reservation.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.ReservationDao;
import com.nts.reservation.dto.ReservationInfo;
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
	public void cancelReservation(int id, String email) {
		reservationDao.updateReservationCancel(id, email);
	}

	@Override
	public Map<String, List<ReservationInfo>> getReservationMap(String email) {
		List<ReservationInfo> reservationInfolist = reservationDao.selectReservationList(email);

		Map<String, List<ReservationInfo>> reservationInfoMap = new HashMap<>();

		reservationInfoMap.put("CANCEL_RESERVATION", new ArrayList<>());
		reservationInfoMap.put("DONE_RESERVATION", new ArrayList<>());
		reservationInfoMap.put("READY_RESERVATION", new ArrayList<>());

		for (ReservationInfo reservationInfo : reservationInfolist) {
			if (reservationInfo.isCancelFlage()) {
				reservationInfoMap.get("CANCEL_RESERVATION").add(reservationInfo);
				continue;
			}
			if (reservationInfo.getReservationDateToLocalDate().isAfter(LocalDate.now())) {
				reservationInfoMap.get("READY_RESERVATION").add(reservationInfo);
			} else {
				reservationInfoMap.get("DONE_RESERVATION").add(reservationInfo);
			}

		}
		return reservationInfoMap;
	}

}
