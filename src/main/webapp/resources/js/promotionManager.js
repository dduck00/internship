const TEMPLATE_PROMOTION = $('#promotionItem').text();

function toPromotion(responseText) {
    const promotionList = responseText.items;
    let promotionListHTML = "";
    for (let promotion of promotionList) {
        promotionListHTML += TEMPLATE_PROMOTION.replace("{productId}", promotion.productId)
    }
    return promotionListHTML;
}

function promotionAnimation() {
    let count = 1;
    let showPromotionInit = PROMOTION_LIST.children('li:nth-child(1)');
    let readyPromotionInit = PROMOTION_LIST.children('li:nth-child(2)');
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

    showPromotionInit.toggleClass('moving');
    readyPromotionInit.toggleClass('moving');
    showPromotionInit.css('left', '0px');
    setTimeout(() => {
        run(0, showPromotionInit, readyPromotionInit);
    }, 5000)
}