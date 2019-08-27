const escapeCharMap = {
    '&': '&amp;',
    '<': '&lt;',
    '>': '&gt;',
    '"': '&quot;',
    "'": '&#39;',
    '/': '&#x2F;',
    '`': '&#x60;',
    '=': '&#x3D;'
};

const commentImageList = (commentImage) => {
    return `
<div class="thumb_area">
<a class="thumb" title="이미지 크게 보기"> <img width="90" height="90"
        class="img_vertical_top"
        src="/get-img/comment/${commentImage.reservationUserCommentId}"
        alt="리뷰이미지"> </a> <span class="img_count"
    style="display:none;">1</span>
</div>`}

const commentList = (comment, reservationDate) => {
    return `
<li class="list_item">
<div>
    <div class="review_area ${imageToggle}">
        ${imageCode}
        <h4 class="resoc_name">${displayDescription}</h4>
        <p class="review" >${comment.comment}</p>
    </div>
    <div class="info_area">
        <div class="review_info"> <span class="grade">${comment.score}</span> <span
                class="name">${comment.reservationEmail}</span> <span class="date">${reservationDate} 방문</span>
        </div>
    </div>
</div>
</li>`}

let displayDescription = '';
let imageCode = '';
let imageToggle = '';

function initCommentSection(responseText) {
    $('div.grade_area strong span').text(responseText.averageScore.toFixed(1));
    $('em.graph_value').css('width', `${responseText.averageScore * 20}%`);
    $('.join_count em.green').text(`${responseText.comments.length}건`);
    displayDescription = (responseText.displayInfo === undefined) ? responseText.productDescription : responseText.displayInfo.productDescription;
}

function importComment(comment) {
    if (comment === undefined) {
        return false;
    }

    imageCode = ''

    for (let commentImage of comment.commentImages) {
        imageCode += commentImageList(commentImage)
    }

    imageToggle = (imageCode.length === 0) ? 'no_img' : '';
    comment.comment = convertComment(comment.comment);
    
    $('ul.list_short_review').append(commentList(comment, convertDate(comment.reservationDate)));
}

function convertComment(comment){
	return comment.replace(/[&<>"'`=\/]/g, (s) => { return escapeCharMap[s]; }).replace(/[\n]/g, '<br>');
}

function convertDate(date) {
    return `${date.year}.${date.monthValue}.${date.dayOfMonth}.`
}