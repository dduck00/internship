function AjaxInit() {
    $.ajaxSetup({
        error: AjaxError
    });
}

function AjaxError(response, event) {
    if (response.status == 404) {
        alert('잘못된 공연정보를 요청하였습니다.');
    }
}