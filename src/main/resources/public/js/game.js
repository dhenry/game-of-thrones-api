$( document ).ready(function() {
    $("#new-game").click(function() {
        $.get( "/newGame", function() {
        }).fail(function() {
            alert( "failed to start a new game" );
        })
    });

    $("#play-one").click(function() {
        $.get( "/roundOneCard", function(card) {
            $("#round-one-last-played").src = "/img/1_" + card.id + "@2x.png";
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });

    $("#play-two").click(function() {
        $.get( "/roundTwoCard", function(card) {
            $("#round-two-last-played").src = "/img/2_" + card.id + "@2x.png";
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });

    $("#play-three").click(function() {
        $.get( "/roundThreeCard", function(card) {
            $("#round-three-last-played").src = "/img/3_" + card.id + "@2x.png";
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });
});