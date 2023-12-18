jQuery(function ($) {
    var path = window.location.href;

    $('ul a').each(function () {
        if (this.href === path) {
            $(this).addClass('tpactive');
        }
    });
});
