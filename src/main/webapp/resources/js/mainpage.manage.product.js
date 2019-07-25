const TEMPLATE_PRODUCT = $('#itemList').text();

function setProduct(productDataJSON) {
    const productCount = productDataJSON.totalCount;
    const productList = productDataJSON.items;
    const productLength = productList.length;
    
    let listForInsertToHTML = ["", ""];

    for (let index = 0; index < productLength; index++) {
        listForInsertToHTML[index % 2] += matchTemplateProduct(productList[index]);
    }

    let countOfProductInHTML = PRODUCT_LIST.data('count');

    if ((typeof countOfProductInHTML) === 'undefined') {
        PRODUCT_LIST.data('count', productLength);
    }
    else {
        PRODUCT_LIST.data('count', parseInt(countOfProductInHTML) + productLength);
    }
    return [productCount, listForInsertToHTML];
}

function matchTemplateProduct(product) {
    return eval('`' + TEMPLATE_PRODUCT + '`')
}

function sendProductTransaction() {
    let uriForSendTransaction = `/api/products?categoryId=${$('.anchor.active').parent().data('category')}`;
    let countOfProductInHTML = PRODUCT_LIST.data('count');

    if ((typeof countOfProductInHTML) !== 'undefined') {
        uriForSendTransaction += `&start=${countOfProductInHTML}`;
    }

    $.get(uriForSendTransaction, (responseText) => {
        let listProduct = setProduct(responseText);
        PRODUCT_COUNT.text(listProduct[0]);
        PRODUCT_LEFT_LIST.append(listProduct[1][0]);
        PRODUCT_RIGHT_LIST.append(listProduct[1][1]);

        if (PRODUCT_LIST.data('count') === parseInt(PRODUCT_COUNT.text())) {
            BUTTON_MORE.hide()
        }

        PRODUCT_COUNT.append('개');
    }).fail(() => {
        alert("서버 오류!");
    });
}