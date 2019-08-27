const TEMPLATE_PRODUCT = $('#itemList').text();

function toProduct(productDataJSON) {
    const productCount = productDataJSON.totalCount;
    const productList = productDataJSON.items;
    let productLength = productList.length;

    let productHtmlList = ["", ""];

    for (let index = 0; index < productLength; index++) {
        productHtmlList[index % 2] += matchTemplateProduct(productList[index]);
    }

    let productCountShow = PRODUCT_LIST.data('count');

    if (productCountShow !== undefined) {
        productLength += parseInt(productCountShow);
    }

    PRODUCT_LIST.data('count', productLength);

    return [productCount, productHtmlList];
}

function matchTemplateProduct(product) {
    return eval('`' + TEMPLATE_PRODUCT + '`')
}

function sendProductTransaction() {
    let uriSendTranscation = `/api/products?categoryId=${$('.anchor.active').parent().data('category')}`;
    let productCountShow = PRODUCT_LIST.data('count');

    if (productCountShow !== undefined) {
        uriSendTranscation += `&start=${productCountShow}`;
    }

    $.get(uriSendTranscation, (responseText) => {
        let listProduct = toProduct(responseText);
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