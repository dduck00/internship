//import jqurey from "jquery";

$(document).ready(() => {
    const checkBoxList = $('input:checkbox')
    checkBoxList.click((event) => {
        for(let checkBox of checkBoxList){
            checkBox.checked = false;
        }

        const clickedTarget = event.currentTarget

        for (let index = 0; index < clickedTarget.value; index++) {
            checkBoxList[index].checked = true;
        }
        $('span.star_rank').text(clickedTarget.value);

        if(clickedTarget.value !== 0){
            $('span.star_rank.gray_star').toggleClass('gray_star');
        }
    })

    $('.review_write_info > span').click((event)=>{
        $('.review_write_info > span').css('visibility', 'hidden');
        $('textarea').focus();
    })
});