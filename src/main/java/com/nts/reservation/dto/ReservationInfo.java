package com.nts.reservation.dto;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;

@Alias("ReservationInfo")
public class ReservationInfo {
	private int id;
	private boolean cancelFlage;
	private int productId;
	private int displayInfoid;
	private DisplayInfo displayInfo;
	private LocalDate createDate;
	private LocalDate modifyDate;
	private int reservationInfoId;
	private String reservationDate;
	private String reservationEmail;
	private String reservationName;
	private String reservationTelephone;
	private List<ReservationInfoPrice> reservationInfoPrice;
	private int totalPrice;

	public boolean isCancelFlage() {
		return cancelFlage;
	}

	public void setCancelFlage(boolean cancelFlage) {
		this.cancelFlage = cancelFlage;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

	public int getDisplayInfoid() {
		return displayInfoid;
	}

	public void setDisplayInfoid(int displayInfoid) {
		this.displayInfoid = displayInfoid;
	}

	public LocalDate getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public LocalDate getReservationDateToLocalDate() {
		return LocalDate.parse(StringUtils.substringBefore(reservationDate, " "));
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationTelephone() {
		return reservationTelephone;
	}

	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ReservationInfoPrice> getReservationInfoPrice() {
		return reservationInfoPrice;
	}

	public void setReservationInfoPrice(List<ReservationInfoPrice> reservationInfoPrice) {
		this.reservationInfoPrice = reservationInfoPrice;
	}

}
