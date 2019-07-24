const TEMPLATE_PROMOTION = $('#promotionItem').text();

function setPromotion(responseText) {
    const promotionDataJSON = responseText.items;
    let inserteToHtml = "";
    for (let promotionData of promotionDataJSON) {
        inserteToHtml += TEMPLATE_PROMOTION.replace("{productImageUrl}", promotionData.productImageUrl)
    }
    return inserteToHtml;
}

function promotion_animation() {
    let count = 1;
    let middlePromotionInit = PROMOTION_LIST.children('li:nth-child(1)');
    let backPromotionInit = PROMOTION_LIST.children('li:nth-child(2)');
    function run(passedPromotion, showPromotion, readyPromotion) {
        if (passedPromotion !== 0) {
            passedPromotion.css('transition', '');
            passedPromotion.css('left', '418px');
        }
        showPromotion.css('left', '-418px');
        readyPromotion.css('left', '-0px');
        count++;

        passedPromotion = showPromotion;
        showPromotion = readyPromotion;
        readyPromotion = PROMOTION_LIST.children(`li:nth-child(${count % 11 + 1})`)
        setTimeout(() => {
            readyPromotion.css('transition', 'all 3s');
            run(passedPromotion, showPromotion, readyPromotion);
        }, 5000);
    }

    middlePromotionInit.css('transition', 'all 3s');
    backPromotionInit.css('transition', 'all 3s');
    middlePromotionInit.css('left', '0px');
    setTimeout(() => {
        run(0, middlePromotionInit, backPromotionInit);
    }, 5000)
}