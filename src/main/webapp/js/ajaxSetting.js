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
            let listProduct =  setProduct(requestProduct.responseText);
            console.log(requestProduct.responseText)
            document.querySelector('#content_count').innerHTML = listProduct[0];
            document.querySelector('#left_side').innerHTML = listProduct[1];
            document.querySelector('#right_side').innerHTML = listProduct[2];
        }
    }

    requestPromotion.onreadystatechange = () => {
        if (requestPromotion.status >= 400) {
            alert("서버 오류 발생");
            return;
        }

        if (requestPromotion.readyState === 4) {
            document.querySelector('#promotion_section').innerHTML = setPromotion(requestPromotion.responseText)
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