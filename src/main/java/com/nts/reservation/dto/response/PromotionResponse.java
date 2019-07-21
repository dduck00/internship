package com.nts.reservation.dto.response;

import java.util.List;

import com.nts.reservation.dto.database.Promotion;

public class PromotionResponse {
	private List<Promotion> items;

	public List<Promotion> getItems() {
		return items;
	}

	public void setItems(List<Promotion> items) {
		this.items = items;
	}
}
