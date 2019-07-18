function promotion_animation() {
    let count = 1;
    let middlet = document.querySelector(`#promotion_section li:nth-child(1)`);
    let backt = document.querySelector(`#promotion_section li:nth-child(2)`);
    function run(front, middle, back) {
        if (front !== 0) {
            front.style.transition = "";
            front.style.left = "418px";
        }
        middle.style.left = "-418px";
        back.style.left = "0px";
        count++;

        front = middle;
        middle = back;
        back = document.querySelector(`#promotion_section li:nth-child(${count % 11 + 1})`)
        setTimeout(() => {
            back.style.transition = "all 3s";
            run(front, middle, back);
        }, 5000);
    }

    middlet.style.transition = "all 3s";
    backt.style.transition = "all 3s";
    middlet.style.left = "0px";
    setTimeout(() => {
        run(0, middlet, backt);
    }, 5000)
}