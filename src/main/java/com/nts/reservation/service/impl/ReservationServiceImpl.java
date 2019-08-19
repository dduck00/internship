package com.nts.reservation.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.ReservationDao;
import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	private static final Pattern EMAIL_PATTERN = Pattern.compile(
		"/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/");
	private static final Pattern PHONE_PATTERN = Pattern.compile("/01([0-9])+-([0-9]{3,4})+-([0-9]){4}/");
	private final ReservationDao reservationDao;

	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	@Transactional
	public void addReservation(ReservationInfo reservationInfo) {

		String email = reservationInfo.getReservationEmail();
		String phone = reservationInfo.getReservationTelephone();

		if (email.length() <= 0 || EMAIL_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("Wrong Email");
		}

		if (phone.length() <= 0 || PHONE_PATTERN.matcher(phone).matches()) {
			throw new IllegalArgumentException("Wrong Phone");
		}

		reservationDao.insertReservationInfo(reservationInfo);

		reservationDao.insertReservationInfoPrice(reservationInfo);
	}

	@Override
	public void cancelReservation(int id, String email) {
		if (reservationDao.updateReservationCancel(id, email) <= 0) {
			throw new DataRetrievalFailureException("update Fail");
		}
	}

	@Override
	public Map<String, List<ReservationInfo>> getReservationMap(String email) {
		List<ReservationInfo> reservationInfolist = reservationDao.selectReservationList(email);
		LocalDate nowDate = LocalDate.now();

		List<ReservationInfo> cancelList = new ArrayList<>();
		List<ReservationInfo> doneList = new ArrayList<>();
		List<ReservationInfo> readyList = new ArrayList<>();

		for (ReservationInfo reservationInfo : reservationInfolist) {

			if (reservationInfo.isCancelFlag()) {
				cancelList.add(reservationInfo);
			} else if (reservationInfo.getReservationDate() != null
				&& reservationInfo.getReservationDate().isAfter(nowDate)) {
				readyList.add(reservationInfo);
			} else {
				doneList.add(reservationInfo);
			}

		}

		Map<String, List<ReservationInfo>> reservationInfoMap = new HashMap<>();

		reservationInfoMap.put("CANCEL_RESERVATION", cancelList);
		reservationInfoMap.put("DONE_RESERVATION", doneList);
		reservationInfoMap.put("READY_RESERVATION", readyList);

		return reservationInfoMap;
	}

}
