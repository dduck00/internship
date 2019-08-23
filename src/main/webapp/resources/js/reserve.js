const PHONE_REGULAR = /01([0-9])+-([0-9]{3,4})+-([0-9]){4}/;
const EMAIL_REGULAR = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
const submitButton = $('div.bk_btn_wrap button');
const ticket = {
    'A': "성인",
    'Y': "청소년",
    'B': "유아",
    'S': "셋트",
    'D': "장애인",
    'C': "지역주민",
    'E': "얼리버드",
    'V': "VIP",
    'R': "R석"
}

$(document).ready(() => {
    if ($('#chk3').is(":checked")) {

        $('div.bk_btn_wrap').toggleClass('disable');
        submitButton.removeAttr('disabled');
    }

    $('form').submit((event) => {
        const EMAIL_VALID = EMAIL_REGULAR.test($('#email').val());
        const PHONE_VALID = PHONE_REGULAR.test($('#tel').val());

        if (EMAIL_VALID && PHONE_VALID) {
            return true;
        }

        alert(`${EMAIL_VALID ? "" : '이메일'}${EMAIL_VALID || PHONE_VALID ? "" : '과 '}${PHONE_VALID ? "" : '핸드폰번호'}이(가) 입력 형식에 맞지 않습니다`);
        return false;
    })

    let priceInfoText = '';

    for (let ticketInfo of $('.qty')) {
        const price = ticketInfo.querySelector('.price');
        $(price).text($(price).attr('value'));

        const priceType = ticketInfo.querySelector('.priceType');
        $(priceType).text(ticket[$(priceType).attr('value')]);

        priceInfoText += `${$(priceType).text()} ${$(price).text()}원 <br>`
    }
    $('#price_info').html(priceInfoText)

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

        if (submitButton.attr('disabled')) {
            submitButton.removeAttr('disabled');
        } else {
            submitButton.attr('disabled', true);
        }
    })
});