const starList = $('input:checkbox');

function StarComponent(star) {
    this.scoreComponent = $('#score');
    this.scoreText = $('span.star_rank');

    $(star).click((event) => this.clickListener(event));
}

StarComponent.prototype.setScore = function (value) {
    this.scoreText.text(value);
    this.scoreComponent.val(value);
    if (value !== 0) {
        $('span.star_rank.gray_star').toggleClass('gray_star');
    }
}

StarComponent.prototype.initScore = function () {
    for (let star of starList) {
        star.checked = false;
    }
}

StarComponent.prototype.clickListener = function (event) {
    this.initScore();
    const clickedTarget = event.currentTarget

    for (let index = 0; index < clickedTarget.value; index++) {
        starList[index].checked = true;
    }

    this.setScore(clickedTarget.value);
}


$(document).ready(() => {
    const textArea = $('textarea');
    const commentLength = $('#commentLength');

    for (let star of starList) {
        new StarComponent(star);
    }

    $('.review_write_info > span').click((event) => {
        $('.review_write_info').css('visibility', 'hidden');
        textArea.css('visibility', 'visible');
        textArea.focus();
    })

    textArea.keydown((event) => {
        commentLength.text(textArea.val().length);
        if (!(event.keyCode == 8 || event.keyCode == 46) && textArea.val().length >= 400) {
            alert("400자 미만으로 입력해주세요");
            event.preventDefault();
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
        if (textArea.val().length < 5) {
            alert("5자 이상으로 입력해주세요");
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
