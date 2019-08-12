package com.nts.reservation.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.reservation.dao.ReservationDao;
import com.nts.reservation.dto.ReservationInfo;
import com.nts.reservation.dto.ReservationInfoList;
import com.nts.reservation.dto.ReservationInfoPrice;
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
	public void addReservation(Map<String, String[]> requestMap) {
		ReservationInfo reservationInfo = makeReservationInfo(requestMap);
		reservationDao.insertReservationInfo(reservationInfo);

		for (String requestKey : requestMap.keySet()) {

			try {
				reservationDao
					.insertReservationInfoPrice(makeReservationInfoPrice(requestKey, requestMap, reservationInfo));
			} catch (NumberFormatException e) {
				continue;
			}

		}
	}

	@Override
	public void updateReservation(Map<String, String[]> requestMap) {}

	private ReservationInfo makeReservationInfo(Map<String, String[]> requestMap) {

		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setProductId(Integer.parseInt(requestMap.get("productId")[0]));
		reservationInfo.setDisplayInfoId(Integer.parseInt(requestMap.get("displayInfoid")[0]));
		reservationInfo.setReservationEmail(requestMap.get("email")[0]);
		reservationInfo.setReservationName(requestMap.get("name")[0]);
		reservationInfo.setReservationTelephone(requestMap.get("tel")[0]);
		return reservationInfo;
	}

	private ReservationInfoPrice makeReservationInfoPrice(String requestKey, Map<String, String[]> requestMap,
		ReservationInfo reservationInfo) throws NumberFormatException {

		ReservationInfoPrice reservationInfoPrice = new ReservationInfoPrice();
		reservationInfoPrice.setProductPriceId(Integer.parseInt(requestKey));
		reservationInfoPrice.setCount(Integer.parseInt(requestMap.get(requestKey)[0]));
		reservationInfoPrice.setReservationInfoId(reservationInfo.getId());
		return reservationInfoPrice;
	}

	@Override
	public ReservationInfoList getReservationList(String email) {
		ReservationInfoList reservationInfoList = new ReservationInfoList();
		reservationInfoList.setReservations(reservationDao.selectReservationList(email));
		reservationInfoList.setSize(reservationInfoList.getReservations().size());

		return reservationInfoList;
	}

}
