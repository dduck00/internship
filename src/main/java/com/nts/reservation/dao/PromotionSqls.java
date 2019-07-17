package com.nts.reservation.dao;

public class PromotionSqls {
	public static final String PROMOTION_SELECT_PROMOTION = "SELECT * from promotion;";
	public static final String PROMOTION_SELECT_PRODUCT = "SELECT product_id AS id, category_id, description, content, event, create_date, modify_date FROM product INNER JOIN promotion ON promotion.product_id = product.id";
	public static final String PROMOTION_SELECT_DISPLAY_INFO = "SELECT display_info.id, display_info.product_id, display_info.opening_hours, display_info.place_name, display_info.place_street, display_info.tel, display_info.homepage, display_info.email, display_info.create_date, display_info.modify_date FROM display_info INNER JOIN ("
		+ PROMOTION_SELECT_PRODUCT + ") AS N ON display_info.product_id = N.id;";
	public static final String PROMOTION_SELECT_DISPLAY_INFO_IMAGE = "SELECT display_info_image.id, display_info_image.display_info_id, display_info_image.file_id from display_info_image inner join ("
		+ PROMOTION_SELECT_DISPLAY_INFO + ") AS M on display_info_image.display_info_id = M.id;";
	public static final String PROMOTION_SELECT_PRODUCT_IMAGE = "SELECT product_image.id, product_image.product_id, product_image.type, product_image.file_id from product_image inner join ("
		+ PROMOTION_SELECT_DISPLAY_INFO_IMAGE
		+ ") as T on product_image.product_id = T.id and product_image.type = 'th';";
	public static final String PROMOTION_SELECT_PRODUCT_FILE_INFO = "select file_info.id, file_info.file_name, file_info.save_file_name, file_info.content_type, file_info.delete_flag, file_info.create_date, file_info.modify_date from file_info inner join ("
		+ PROMOTION_SELECT_PRODUCT_IMAGE + ") as F on file_info.id = F.file_id;";
}
