const TEMPLATE_PROMOTION = document.querySelector('#promotionItem').innerText;
const TEMPLATE_PRODUCT = document.querySelector('#itemList').innerText;

const requestProduct = new XMLHttpRequest();
const requestPromotion = new XMLHttpRequest();
const requestCategory = new XMLHttpRequest();

function ajaxSetting() {
    requestProduct.onreadystatechange = () => {
        if (requestProduct.status >= 400) {
            alert("서버 오류 발생");
            return;
        }

        if (requestProduct.readyState === 4) {
            let listProduct = setProduct(requestProduct.responseText);
            PRODUCT_COUNT.innerHTML = listProduct[0];
            PRODUCT_LEFT_LIST.innerHTML += listProduct[1][0];
            PRODUCT_RIGHT_LIST.innerHTML += listProduct[1][1];

            if (PRODUCT_LIST.dataset.count === PRODUCT_COUNT.innerHTML) {
                BUTTON_MORE.hidden = true;
            }

            PRODUCT_COUNT.innerHTML += '개'
        }
    }

    requestPromotion.onreadystatechange = () => {
        if (requestPromotion.status >= 400) {
            alert("서버 오류 발생");
            return;
        }

        if (requestPromotion.readyState === 4) {
            PROMOTION_LIST.innerHTML = setPromotion(requestPromotion.responseText)
            promotion_animation();
        }
    }

    requestCategory.onreadystatechange = () => {
        if (requestCategory.status >= 400) {
            alert("서버 오류 발생");
            return;
        }

        if (requestCategory.readyState === 4) {
            console.log(requestCategory.responseText)
        }
    }
}