$(document).ready(() => {
    if ($('#chk3').is(":checked")) {
        $('div.bk_btn_wrap').toggleClass('disable');
        submitButton.removeAttr('disabled');

    }
    for (let ticketInfo of $('.qty')) {
        const price = ticketInfo.querySelector('.price');
        $(price).text($(price).attr('value'))
        const priceType = ticketInfo.querySelector('.priceType');
        let priceTypeText = "";
        switch ($(priceType).attr('value')) {
            case 'A':
                priceTypeText = "성인"
                break;
            case 'Y':
                priceTypeText = "청소년"
                break;
            case 'B':
                priceTypeText = "유아"
                break;
            case 'S':
                priceTypeText = "셋트"
                break;
            case 'D':
                priceTypeText = "장애인"
                break;
            case 'C':
                priceTypeText = "지역주민"
                break;
            case 'E':
                priceTypeText = "얼리버드"
                break;
            case 'V':
                priceTypeText = "VIP"
                break;
            case 'R':
                priceTypeText = "R석"
                break;
            case 'B':
                priceTypeText = "B석"
                break;
            case 'S':
                priceTypeText = "S석"
                break;
            case 'D':
                priceTypeText = "평일"
                break;
        }
        $(priceType).text(priceTypeText)
    }

    $('div.agreement:not(.all) > a').click((event))
    for (let agreementText of $('div.agreement:not(.all)')) {
        agreementText.querySelector('a').addEventListener('click', (event, agreementTextTag = agreementText) => {
            $(agreementTextTag).toggleClass('open');
            $(agreementTextTag.querySelector('i.fn')).toggleClass('fn-up2');
        });
    }

    $('a.btn_plus_minus').click((event) => {
        const parent = event.currentTarget.closest('div.qty');
        const price = parseInt($(parent.querySelector('.price')).text().replace(',', ''));
        const value = $(parent.querySelector('input'));
        if (event.currentTarget.classList.contains('disabled')) {
            return;
        }

        if (event.currentTarget.classList.contains('ico_plus3')) {
            value.val(parseInt(value.val()) + 1);
            $(parent.querySelector('.ico_minus3')).removeClass('disabled');
            $('#totalCount').text(parseInt($('#totalCount').text()) + 1);
        } else {
            value.val(parseInt(value.val()) - 1);
            if (value.val() === '0') {
                $(parent.querySelector('.ico_minus3')).addClass('disabled');
            }
            $('#totalCount').text(parseInt($('#totalCount').text()) - 1);
        }
        $(parent.querySelector('.total_price')).text(parseInt(value.val()) * price);

    })

    $('#chk3').change((event) => {
        $('div.bk_btn_wrap').toggleClass('disable');
        const submitButton = $('div.bk_btn_wrap button');
        if (submitButton.attr('disabled')) {
            submitButton.removeAttr('disabled');
        } else {
            submitButton.attr('disabled', true);
        }
    })
});