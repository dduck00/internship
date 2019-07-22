const TEMPLATE_PRODUCT = $('#itemList').text();

function setProduct(productDataJSON) {
    const productCount = productDataJSON.totalCount;
    const productData = productDataJSON.items;
    let inserteToHtml = ["", ""];

    for (let index = 0; index < productData.length; index++) {
        inserteToHtml[index % 2] += matchTemplateProduct(productData[index]);
    }

    let datasetOfContent = PRODUCT_LIST.data('count');
    
    if ((typeof datasetOfContent) === 'undefined') {
        PRODUCT_LIST.data('count', productData.length);
    }
    else {
        PRODUCT_LIST.data('count', parseInt(datasetOfContent) + productData.length);
    }
    return [productCount, inserteToHtml];
}

function matchTemplateProduct(product) {
    return eval('`' + TEMPLATE_PRODUCT + '`')
}

function sendProductTransaction() {
    let transactionText = `/api/products?categoryId=${$('.anchor.active').parent().data('category')}`;
    let datasetOfContent = PRODUCT_LIST.data('count');

    if ((typeof datasetOfContent) !== 'undefined') {
        transactionText += `&start=${datasetOfContent}`;
    }

    $.get(transactionText, (responseText) => {
        let listProduct = setProduct(responseText);
        PRODUCT_COUNT.text(listProduct[0]);
        PRODUCT_LEFT_LIST.append(listProduct[1][0]);
        PRODUCT_RIGHT_LIST.append(listProduct[1][1]);
    
        if (PRODUCT_LIST.data('count') === PRODUCT_COUNT.text()) {
            BUTTON_MORE.hidden = true;
        }
    
        PRODUCT_COUNT.append('개');
    }).fail(()=>{
        alert("서버 오류!");
    });
}