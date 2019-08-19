package com.nts.reservation.dto;

import java.util.List;

public class DisplayReserve {

	private DisplayInfo displayInfo;
	private List<ProductImage> productImages;
	private List<ProductPrice> productPrices;

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}
}
