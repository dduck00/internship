function reservationCancelEvent(cancelReservation) {
    $('#cancel_popup_display_name').text(cancelReservation.querySelector('h4').innerText);
    $('#cancel_popup_date').text(cancelReservation.querySelector('ul li > em').innerText);
    $('#cancel_popup_display_name').data('id', cancelReservation.querySelector('em').innerText);
    $('.popup_booking_wrapper').css('display', 'block');
    $('#yes_button').unbind();
    $('#yes_button').click(() => {

        $(event.currentTarget.closest('.popup_booking_wrapper')).css('display', 'none');
        $.ajax({
            url: '/api/reservation',
            type: 'PUT',
            dataType: 'json',
            data: `${cancelReservation.querySelector('em').innerText}`,
            contentType: "application/json"
        })
            .fail(function () {
                alert("Update Fail");
            })
            .always(function () {
                location.reload();
            });
    });
}

function setTotalCount() {
    let totalCount = 0;
    const countTags = $('.figure');

    for (let indexOfTag = 1; indexOfTag < 4; indexOfTag++) {
        totalCount += parseInt(countTags[indexOfTag].innerText);
    }
    countTags[0].innerText = totalCount;
}

$(document).ready(() => {
    setTotalCount();

    if ($('.figure').text() === '0000') {
        $('.wrap_mylist').css('display', 'none');
    } else {
        $('.err').css('display', 'none');
    }

    $('.booking_cancel > button').click((event) => {
        reservationCancelEvent(event.currentTarget.closest('.card_detail'));
    });

    $('#x_button').click((event) => {
        $(event.currentTarget.closest('.popup_booking_wrapper')).css('display', 'none');
    });

    $('#no_button').click((event) => {
        $(event.currentTarget.closest('.popup_booking_wrapper')).css('display', 'none');
    });

})