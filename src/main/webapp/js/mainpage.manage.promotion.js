function setPromotion(responseText) {
    const promotionDataJSON = JSON.parse(responseText).items;
    let inserteToHtml = "";
    for (let index = 0; index < 11; index++) {
        inserteToHtml += TEMPLATE_PROMOTION.replace("{productImageUrl}", promotionDataJSON[index].productImageUrl);
    }
    return inserteToHtml;
}

function promotion_animation() {
    let count = 1;
    let middleInit = document.querySelector(`#promotion_section li:nth-child(1)`);
    let backInit = document.querySelector(`#promotion_section li:nth-child(2)`);
    function run(front, middle, back) {
        if (front !== 0) {
            front.style.transition = "";
            front.style.left = "418px";
        }
        middle.style.left = "-418px";
        back.style.left = "0px";
        count++;

        front = middle;
        middle = back;
        back = document.querySelector(`#promotion_section li:nth-child(${count % 11 + 1})`)
        setTimeout(() => {
            back.style.transition = "all 3s";
            run(front, middle, back);
        }, 5000);
    }

    middleInit.style.transition = "all 3s";
    backInit.style.transition = "all 3s";
    middleInit.style.left = "0px";
    setTimeout(() => {
        run(0, middleInit, backInit);
    }, 5000)
}