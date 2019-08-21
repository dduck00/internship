function buttonSetting() {
    $('li._detail').click(navButtonClickEvent)
    $('li._path').click(navButtonClickEvent)

    $('a.bk_more._open').click(moreButtonClickEvent);
    $('a.bk_more._close').click(moreButtonClickEvent);

    $('.nxt_inn').click(ProductImageClickEvent)
    $('.prev_inn').click(ProductImageClickEvent)
}

function navButtonClickEvent(clickedEvent) {
    let toShowTab;
    let toHideTab;

    if (clickedEvent.currentTarget.classList.contains('_path')) {
        toShowTab = $('div.detail_location.hide');
        toHideTab = $('div.detail_area_wrap');
    } else {
        toShowTab = $('div.detail_area_wrap.hide');
        toHideTab = $('div.detail_location');
    }

    if (toShowTab.length === 0) {
        return;
    }

    swapActiveClass($('.anchor:not(.active)'), $('.anchor.active'))

    toShowTab.toggleClass('hide');
    toHideTab.toggleClass('hide');
}


function swapActiveClass(notActive, active) {
    notActive.toggleClass('active');
    active.toggleClass('active');
}

function moreButtonClickEvent(clickedEvent) {
    if (clickedEvent.currentTarget.classList.contains('_open')) {
        $('a.bk_more._close').css('display', '');
    } else {
        $('a.bk_more._open').css('display', '');
    }

    clickedEvent.currentTarget.style.display = "none"
    $('div.section_store_details div.store_details').toggleClass('close3');
}

function ProductImageClickEvent(clickedEvent) {
    const NEXT_PIXEL = (clickedEvent.currentTarget.className === 'prev_inn') ? 418 : -418;
    const NOW_VIEW_INDEX = $('ul.detail_swipe').data('viewing');
    const nowView = $(`ul.detail_swipe li:nth-child(${(NOW_VIEW_INDEX % 2) ? 2 : 1})`);
    const nextView = $(`ul.detail_swipe li:nth-child(${(NOW_VIEW_INDEX % 2) ? 1 : 2})`);
    nextView.css('transition', '');
    nowView.css('transition', 'all 3s');
    nextView.css('left', `${NEXT_PIXEL}px`);
    setTimeout(() => {
        nextView.css('transition', 'all 3s');
        nowView.css('left', `${NEXT_PIXEL * -1}px`);
        nextView.css('left', '0px');
    }, 1);

    $('ul.detail_swipe').data('viewing', parseInt(NOW_VIEW_INDEX) + 1);
    $('.figure_pagination span.num:not(.off)').text((NOW_VIEW_INDEX % 2) ? 1 : 2);
}