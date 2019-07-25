const TEMPLATE_PROMOTION = $('#promotionItem').text();

function setPromotion(responseText) {
    const promotionList = responseText.items;
    let inserteToHtml = "";
    for (let promotion of promotionList) {
        inserteToHtml += TEMPLATE_PROMOTION.replace("{productImageUrl}", promotion.productImageUrl)
    }
    return inserteToHtml;
}

function promotion_animation() {
    let count = 1;
    let middlePromotionInit = PROMOTION_LIST.children('li:nth-child(1)');
    let backPromotionInit = PROMOTION_LIST.children('li:nth-child(2)');
    function run(passedPromotion, showPromotion, readyPromotion) {
        if (passedPromotion !== 0) {
            passedPromotion.toggleClass('moving');
            passedPromotion.css('left', '418px');
        }
        showPromotion.css('left', '-418px');
        readyPromotion.css('left', '0px');
        count++;

        passedPromotion = showPromotion;
        showPromotion = readyPromotion;
        readyPromotion = PROMOTION_LIST.children(`li:nth-child(${count % 11 + 1})`)
        setTimeout(() => {
            readyPromotion.toggleClass('moving');
            run(passedPromotion, showPromotion, readyPromotion);
        }, 5000);
    }

    middlePromotionInit.toggleClass('moving');
    backPromotionInit.toggleClass('moving');
    middlePromotionInit.css('left', '0px');
    setTimeout(() => {
        run(0, middlePromotionInit, backPromotionInit);
    }, 5000)
}