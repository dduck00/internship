function setProduct(responseText) {
    const productDataJSON = JSON.parse(responseText);
    const productCount = productDataJSON.totalCount;
    const productData = productDataJSON.items;
    let inserteToHtml = ["", ""];

    for (let index = 0; index < productData.length; index++) {
        inserteToHtml[index % 2] += matchTemplateProduct(productData[index]);
    }

    let datasetOfContent = PRODUCT_LIST.dataset.count
    if ((typeof datasetOfContent) === 'undefined') {
        PRODUCT_LIST.dataset.count = productData.length;
    }
    else {
        PRODUCT_LIST.dataset.count = parseInt(datasetOfContent) + productData.length;
    }
    return [productCount, inserteToHtml];
}

function matchTemplateProduct(product) {
    return TEMPLATE_PRODUCT.replace("{id}", product.productId)
        .replace("{description}", product.productDescription)
        .replace("{description}", product.productDescription)
        .replace("{placeName}", product.placeName)
        .replace("{content}", product.productContent)
        .replace("{img}", product.productImageUrl);
}

function sendProductTransaction() {
    let transactionText = `/api/products?categoryId=${document.querySelector('.anchor.active').parentElement.dataset.category}`;
    let datasetOfContent = PRODUCT_LIST.dataset.count

    if ((typeof datasetOfContent) !== 'undefined') {
        transactionText += `&start=${datasetOfContent}`;
    }

    requestProduct.open("GET", transactionText);
    requestProduct.send();
}