$(document).ready(function() {
    // Wywołanie funkcji po załadowaniu dokumentu
    getBoards();
});

// Function to retrieve boards from the backend
window.getBoards = function() {
    $.ajax({
        type: 'GET',
        url: '/api/boards/4',
        success: function(board) {
            const boardHtml = generateBoard(board);
            $('#container').append(boardHtml);

            columnFunction();
            updateColumnHeights();
            addEditButtonFunctionality();
        },
        error: function(xhr, status, error) {
            console.error('Error fetching boards:', error);
        }
    });
}

function generateBoard(board) {
    let html = "";
    board.columns.forEach(function(column) {
        html += '<div class="column" id="column' + column.id + '">\n' +
            '<li>\n' +
            '<div>\n' +
            '<input type="text" class="columnHeader" placeholder="Column name" value="' + column.name + '">\n' +
            '<button class="addButton">+</button>\n' +
            '</div>\n' +
            '<ol class="columnCards">\n';
        column.cards.forEach(function(card) {
            html += '<li class="card" data-card-id="' + card.id + '">' + card.title + '<span class="editButton">Edit</span></li>\n';
        });
        html += '</ol>\n</li>\n</div>';
    });

    return html;
}