let displayDescription = '';

function importComment(comment) {
    if (comment === undefined) {
        return false;
    }

    let imageCode = ''

    for (let commentImage of comment.commentImages) {
        imageCode += eval('`' + $('#commentImageList').text() + '`')
    }

    let imageToggle = imageCode.length === 0 ? 'no_img' : '';
    let reservationDate = convertDate(comment.reservationDate);

    $('ul.list_short_review').append(eval('`' + $('#commentList').text() + '`'));
}


function convertDate(date) {
    return `${date.year}.${date.monthValue}.${date.dayOfMonth}.`
}