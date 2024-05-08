const popupBackground = $("#popup_background");
const popupWindow = $("#popup_window");
const popupTitle = $("#popup_title");
const popupDescription = $("#popup_description");
const popupExit = $("#popup_exit");
const popupSave = $("#popup_save");

let currentCard = null;

$(document).ready(function() {
    $(popupTitle[0]).val('');
    
    function updatePopupTitleHeight() {
        const currHeight = popupWindow.height() - popupTitle.height();
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

    popupSave.on("click", function() {
        const cardId = currentCard.data("card-id");
        const updatedCardData = {
            id: cardId,
            title: $(popupTitle[0]).val(),
            description: $(popupDescription[0]).val(),
            creationDate: "2024-05-10",
            dueDate: "2024-05-15"
        };
        popupBackground.addClass("wait");

        $.ajax({
            type: 'PUT',
            url: '/api/card/' + cardId,
            contentType: 'application/json',
            data: JSON.stringify(updatedCardData),
            success: function(card) {
                console.log(updatedCardData);
                popupBackground.removeClass("wait");
            },
            error: function(xhr, status, error) {
                console.error('Error updating card data with id ' + cardId, error);
                popupBackground.removeClass("wait");
            }
        });
    });
});

//Declaring globally function so it can be accessed inside columnCardsScript
window.addEditButtonFunctionality = function() {
    $(".editButton").on("click", function() {
        currentCard = $(this).closest(".card");
        const cardId = $(currentCard).data("card-id");
        $.ajax({
            type: 'GET',
            url: '/api/card/' + cardId,
            success: function(card) {
                $(popupTitle[0]).val(card.title);
                $(popupDescription[0]).val(card.description);
                popupBackground.addClass("show");
            },
            error: function(xhr, status, error) {
                console.error('Error fetching card data with id ' + cardId, error);
            }
        });
    })
};