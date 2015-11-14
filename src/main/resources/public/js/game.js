$( document ).ready(function() {
    $("#new-game").click(function() {
        $.get( "/newGame", function() {
        }).fail(function() {
            alert( "failed to start a new game" );
          })
    });
});