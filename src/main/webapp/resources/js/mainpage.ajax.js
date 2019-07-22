const TEMPLATE_PROMOTION = $('#promotionItem').text();
const TEMPLATE_PRODUCT = $('#itemList').text();


function productRequestHandler(responseText) {
    let listProduct = setProduct(responseText);
    PRODUCT_COUNT.text(listProduct[0]);
    PRODUCT_LEFT_LIST.append(listProduct[1][0]);
    PRODUCT_RIGHT_LIST.append(listProduct[1][1]);

    if (PRODUCT_LIST.data('count') === PRODUCT_COUNT.text()) {
        BUTTON_MORE.hidden = true;
    }

    PRODUCT_COUNT.append('개');
}

function promotionRequestHandler(responseText) {
    PROMOTION_LIST.append(setPromotion(responseText))
    promotion_animation();
}