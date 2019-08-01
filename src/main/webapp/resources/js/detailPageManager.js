function buttonSetting() {
    $('li._detail').click(() => {
        const detailArea = $('div.detail_area_wrap.hide');
        if (detailArea.length === 0) {
            return;
        }
        swapActiveClass($('.anchor:not(.active)'), $('.anchor.active'))

        detailArea.toggleClass('hide');
        $('div.detail_location').toggleClass('hide');
    })

    $('li._path').click(() => {
        const detailLocation = $('div.detail_location.hide');
        if (detailLocation.length === 0) {
            return;
        }
        swapActiveClass($('.anchor:not(.active)'), $('.anchor.active'))

        detailLocation.toggleClass('hide');
        $('div.detail_area_wrap').toggleClass('hide');
    })

    $('a.bk_more._open').click((clickedEvent) => {
        clickedEvent.currentTarget.style.display = "none"
        $('a.bk_more._close').css('display', '');
        $('div.section_store_details div.store_details').toggleClass('close3');
    })

    $('a.bk_more._close').click((clickedEvent) => {
        clickedEvent.currentTarget.style.display = "none"
        $('a.bk_more._open').css('display', '');
        $('div.section_store_details div.store_details').toggleClass('close3');
    })

    $('.nxt_inn').click(ProductImageClickEvent)
    $('.prev_inn').click(ProductImageClickEvent)
}

function swapActiveClass(notActive, active) {
    notActive.toggleClass('active');
    active.toggleClass('active');
}

function ProductImageClickEvent(clickedEvent) {
    const NEXT_PIXEL = (clickedEvent.currentTarget.className === 'prev_inn') ? 418 : -418;
    const nowViewIndex = $('ul.detail_swipe').data('viewing');
    const nowView = $(`ul.detail_swipe li:nth-child(${(nowViewIndex % 2) ? 2 : 1})`);
    const nextView = $(`ul.detail_swipe li:nth-child(${(nowViewIndex % 2) ? 1 : 2})`);
    nextView.css('transition', '');
    nowView.css('transition', 'all 3s');
    nextView.css('left', `${NEXT_PIXEL}px`);
    setTimeout(() => {
        nextView.css('transition', 'all 3s');
        nowView.css('left', `${NEXT_PIXEL * -1}px`);
        nextView.css('left', '0px');
    }, 1);
    $('ul.detail_swipe').data('viewing', parseInt(nowViewIndex) + 1);
    $('.figure_pagination span.num:not(.off)').text((nowViewIndex % 2) ? 1 : 2);
}