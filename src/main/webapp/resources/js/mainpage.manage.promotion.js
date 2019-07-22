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
    let middleInit = PROMOTION_LIST.children('li:nth-child(1)');
    let backInit = PROMOTION_LIST.children('li:nth-child(2)');
    function run(front, middle, back) {
        if (front !== 0) {
            front.css('transition', '');
            front.css('left', '418px');
        }
        middle.css('left', '-418px');
        back.css('left', '-0px');
        count++;

        front = middle;
        middle = back;
        back = PROMOTION_LIST.children(`li:nth-child(${count % 11 + 1})`)
        setTimeout(() => {
            back.css('transition', 'all 3s');
            run(front, middle, back);
        }, 5000);
    }

    middleInit.css('transition', 'all 3s');
    backInit.css('transition', 'all 3s');
    middleInit.css('left', '0px');
    setTimeout(() => {
        run(0, middleInit, backInit);
    }, 5000)
}