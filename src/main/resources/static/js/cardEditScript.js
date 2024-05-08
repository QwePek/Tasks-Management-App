var popupBackground = $("#popup_background");
var popupWindow = $("#popup_window");
var popupTitle = $("#popup_title");
var popupDescription = $("#popup_description");
var popupExit = $("#popup_exit");

$(document).ready(function() {
    $(popupTitle[0]).val('');
    
    function updatePopupTitleHeight() {
        var currHeight = popupWindow.height() - popupTitle.height();
        popupTitle.height(0);
        popupTitle.height(popupTitle[0].scrollHeight);
        popupWindow.height(currHeight + popupTitle.height());
    }

    popupTitle.on("input", function() {
        updatePopupTitleHeight();
    });

    updatePopupTitleHeight();

    popupExit.on("click", function() { 
        popupBackground.removeClass("show");
    });
});

//Declaring globally function so it can be accessed inside columnCardsScript
window.addEditButtonFunctionality = function() {
    $(".editButton").on("click", function() {
        $.ajax({
            type: 'GET',
            url: '/api/card/1',
            success: function(card) {
                $(popupTitle[0]).val(card.title);
                $(popupDescription[0]).val(card.description);
                popupBackground.addClass("show");
            },
            error: function(xhr, status, error) {
                console.error('Error fetching card data:', error);
            }
        });
    })
};