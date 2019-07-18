const TEMPLATE_PROMOTION = `<li class="item" style="background-image: url(/{productImageUrl});">
    <a href="#">
        <span class="img_btm_border"></span>
        <span class="img_right_border"></span>
        <span class="img_bg_gra"></span>
        <div class="event_txt">
            <h4 class="event_txt_tit"></h4>
            <p class="event_txt_adr"></p>
            <p class="event_txt_dsc"></p>
        </div>
    </a>
</li>`;

const TEMPLATE_PRODUCT = `<li class="item">
    <a href="/detail?id={id}" class="item_book">
        <div class="item_preview">
            <img alt="{description}" class="img_thumb" src="/{img}">
            <span class="img_border"></span>
        </div>
        <div class="event_txt">
            <h4 class="event_txt_tit"> <span>{description}</span> <small class="sm">{placeName}</small> </h4>
            <p class="event_txt_dsc">{content}</p>
        </div>
    </a>
</li>`