package com.nts.reservation.dto.response;

import java.util.List;

import com.nts.reservation.dto.database.Category;

public class CategoryResponse {
	private List<Category> items;

	public List<Category> getItems() {
		return items;
	}

	public void setItems(List<Category> items) {
		this.items = items;
	}
}
