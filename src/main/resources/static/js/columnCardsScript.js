$(document).ready(function() {
    // Wywołanie funkcji po załadowaniu dokumentu
    updateColumnHeights();
});

var containerDiv = $("#container");

// Funkcja do aktualizacji szerokości kolumn
function updateColumnHeights() {
    $('.column > li').each(function(i, elem) {
        var newHeight = 15;
        var cards = $(this).find(".card");
        cards.each(function(i, elem) {
            if($(elem).hasClass("card-dragging"))
                return;

            newHeight += $(elem).outerHeight();
            newHeight += 10; //Margin
        });
        
        if(cards.length == 0)
            newHeight = 15;

        var headerTxt = $(elem).find('.columnHeader');
        if(headerTxt.length !== 0)
            newHeight += headerTxt.height();
        $(this).css('height', newHeight + 'px');
    });
}

function updateAllCardsFunctionality() {
    $( ".card" ).each(function(i, elem) {
        addFunctionalityToCard(elem);
    });
}

function updateCardExtensions() {
    var cols = $(".columnCards")
    for(let j =0;j<cols.length;j++) {
        var cards = $(cols[j]).find(".card");
        if(cards.length==0)
            $(cols[j]).append($("<span>", { "class": "cardExtension"}));
            
        for(let i =0;i<cards.length;i++) {
            if(i == 0)
                $(cards[i]).before($("<span>", { "class": "cardExtension"}));
            
            $(cards[i]).after($("<span>", { "class": "cardExtension"}));
        }
    }
}

$( function() {
    $( ".card" ).each(function(i, elem) {
        addFunctionalityToCard(elem);
    });

    $(".column").each(function(i, elem) {
        addDroppableColumnBetween(elem);
    });
} );

function addDroppableColumnBetween(elemAdd) {
    $(elemAdd).droppable({
        drop: function( event, ui ) {
            var elemInfo = getIDToDropTo($(this).find(".columnCards")[0], event.clientY, ui.draggable[0]);
            
            console.log(elemInfo);
            if(elemInfo[1] == "append")
                elemInfo[0].append(ui.draggable[0]);
            else if(elemInfo[1] == "after")
                elemInfo[0].after(ui.draggable[0]);
            else if(elemInfo[1] == "before")
                elemInfo[0].before(ui.draggable[0]);

            requestAnimationFrame(function() {
                updateColumnHeights();
                updateAllCardsFunctionality();
                addEditButtonFunctionality();
            });
        }
    });
}

function addFunctionalityToCard(card) {
    $(card).draggable({
        revert: "invalid",
        containment: "document",
        helper: "clone",
        zIndex: 100,
        start: function(event, ui) {
            $(ui.helper).addClass("card-dragging");

            $(this).remove();
            requestAnimationFrame(function() {
                updateColumnHeights();
                updateCardExtensions()
            });
        },
        stop: function(event, ui) {
            $(".cardExtension").each(function(i,el) {
                el.remove();
            });
        },
        drag: function(event, ui) {
            $(".cardExtension").each(function(i,el) {
                $(el).removeClass("activated");
            });

            //Calculate current hovered column
            var columnHovered = null;
            var mouseXPos = event.clientX
            $(".column").each(function(i, elem) { 
                if(mouseXPos > $(elem).position().left) {
                    columnHovered = elem;
                }
            });
            if(columnHovered == null)
                columnHovered = ui.helper.parent();
            else
                columnHovered = $(columnHovered).find(".columnCards")[0];
        
            var elem = getIDToDropTo(columnHovered, event.clientY, card);
            if(elem[1] == "before")
                $(elem[0]).prev("span").addClass("activated");
            else if(elem[1] == "after")
                $(elem[0]).next("span").addClass("activated");
            else {
                var spanFound = $(columnHovered).find("span")[0];
                $(spanFound).addClass("activated");
            }
        }
    });
}

//Get id to drop to depending on column
//TODOMAYBE: ADD TO MOUSEPOS SCROLLY
function getIDToDropTo(columnCards, mousePos, dropElement) {
    var cards = $(columnCards).find(".card");
    var found = false;
    if(cards.length == 0) {
        //$(columnCards).append(dropElement);
        return [columnCards, "append"];
    }
    else {
        var elemAfter = cards[0];
        for(let i = 0; i < cards.length; i++) {
            if($(cards[i]).hasClass("card-dragging")) {
                continue;
            }
            var cardPositionY = $(cards[i]).position().top;
            var cardHeight = $(cards[i]).outerHeight();
            if(mousePos > cardPositionY + cardHeight / 2) {
                elemAfter = cards[i];
                found = true;
            }
        }

        if(found)
            return [elemAfter, "after"];
            //elemAfter.after(dropElement);
        else
            return [elemAfter, "before"];
            //elemAfter.before(dropElement);
    }
}

$(".addButton").on("click", function() {
    currColumn = $(this).parent().next();
    addNewCard(currColumn);
    updateColumnHeights();
});

function addNewCard(column) {
    var newElem = $('<li class="card">New card<span class="editButton">Edit</span></li>');
    $(column).append(newElem);
    addFunctionalityToCard(newElem);
    addEditButtonFunctionality();
    console.log(newElem);
}