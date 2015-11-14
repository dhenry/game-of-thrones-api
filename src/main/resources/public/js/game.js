$( document ).ready(function() {
    $("#new-game").click(function() {
        $.get( "/newGame", function() {
        }).fail(function() {
            alert( "failed to start a new game" );
        })
    });

    $("#play-one").click(function() {
        $.getJSON( "/roundOneCard", function(card) {
            $("#round-one-last-played").attr("src", "/img/1_" + card.id + "@2x.png");
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });

    $("#play-two").click(function() {
        $.getJSON( "/roundTwoCard", function(card) {
            $("#round-two-last-played").attr("src", "/img/2_" + card.id + "@2x.png");
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });

    $("#play-three").click(function() {
        $.getJSON( "/roundThreeCard", function(card) {
            $("#round-three-last-played").attr("src", "/img/3_" + card.id + "@2x.png");
         }).fail(function() {
            alert( "failed to play a card" );
          });
    });
});