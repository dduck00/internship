$(document).ready(() => {
    const checkBoxList = $('input:checkbox');
    const textArea = $('textarea');
    const commentLength = $('#commentLength');

    checkBoxList.click((event) => {
        for (let checkBox of checkBoxList) {
            checkBox.checked = false;
        }

        const clickedTarget = event.currentTarget

        for (let index = 0; index < clickedTarget.value; index++) {
            checkBoxList[index].checked = true;
        }
        $('span.star_rank').text(clickedTarget.value);
        $('#score').val(clickedTarget.value);

        if (clickedTarget.value !== 0) {
            $('span.star_rank.gray_star').toggleClass('gray_star');
        }
    })

    $('.review_write_info > span').click((event) => {
        $('.review_write_info').css('visibility', 'hidden');
        textArea.css('visibility', 'visible');
        textArea.focus();
    })

    textArea.keyup((event) => {
        commentLength.text(textArea.val().length);
        if (textArea.val().length > 400) {
            alert("400자 미만으로 입력해주세요");
        }
    })

    $('#reviewImageFileOpenInput').change((evt) => {
        const image = evt.target.files[0];

        if (!isValidImageType(image)) {
            alert("Upload 실패! jpg, png, jpeg만 가능합니다.")
            $('#reviewImageFileOpenInput').val("");
            return;
        }

        document.querySelector(".item_thumb").src = window.URL.createObjectURL(image);
        $('#img_item').show();
    })

    $('#img_delete').click((evt) => {
        $('#img_item').hide();
        $('#reviewImageFileOpenInput').val("");
    })

    $('form').submit((event) => {
        if (textArea.val().length > 400) {
            alert("400자 미만으로 입력해주세요");
            return false;
        }
        return true;
    })
});

function isValidImageType(image) {
    const result = (['image/jpeg',
        'image/png',
        'image/jpg'].indexOf(image.type) > -1);
    return result;
}
