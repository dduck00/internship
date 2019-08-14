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

		List<ReservationInfo> cancelList = new ArrayList<>();
		List<ReservationInfo> doneList = new ArrayList<>();
		List<ReservationInfo> readyList = new ArrayList<>();

		for (ReservationInfo reservationInfo : reservationInfolist) {
			if (reservationInfo.isCancelFlage()) {
				cancelList.add(reservationInfo);
				continue;
			}
			if (reservationInfo.getReservationDateToLocalDate().isAfter(LocalDate.now())) {
				readyList.add(reservationInfo);
			} else {
				doneList.add(reservationInfo);
			}

		}

		reservationInfoMap.put("CANCEL_RESERVATION", cancelList);
		reservationInfoMap.put("DONE_RESERVATION", doneList);
		reservationInfoMap.put("READY_RESERVATION", readyList);

		return reservationInfoMap;
	}

}
