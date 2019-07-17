package com.nts.reservation.dao;

public class PromotionSqls {
	public static final String PROMOTION_SELECT_PROMOTION = "SELECT * from promotion;";
	public static final String PROMOTION_SELECT_PRODUCT_IMAGE = "SELECT product_image.id, product_image.product_id, product_image.type, product_image.file_id FROM product_image INNER JOIN promotion ON promotion.product_id = product_image.product_id AND product_image.type = 'th'";
	public static final String PROMOTION_SELECT_PRODUCT_FILE_INFO = "select file_info.id, file_info.file_name, file_info.save_file_name, file_info.content_type, file_info.delete_flag, file_info.create_date, file_info.modify_date from file_info inner join ("
		+ PROMOTION_SELECT_PRODUCT_IMAGE + ") as F on file_info.id = F.file_id;";
}
