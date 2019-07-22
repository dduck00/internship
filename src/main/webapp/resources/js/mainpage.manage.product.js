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

    $.get(transactionText, productRequestHandler);
}