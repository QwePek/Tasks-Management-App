var popupBackground = $("#popup_background");
var popupWindow = $("#popup_window");
var popupTitle = $("#popup_title");
var popupExit = $("#popup_exit");

$(document).ready(function() {
    addEditButtonFunctionality();
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
        popupBackground.addClass("show");
        console.log("click");
    })
};