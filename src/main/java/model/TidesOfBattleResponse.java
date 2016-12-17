package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hendavid on 12/16/16.
 */
public class TidesOfBattleResponse {

    public String speech;
    public String displayText;
    public Object data;
    public List contextOut;
    public String source;

    public TidesOfBattleResponse(String player1, String player2, String tides1, String tides2) {
        speech = String.format("%s drew a %s, %s drew a %s", player1, tides1, player2, tides2);
        displayText = speech;
        data = new Object();
        contextOut = new ArrayList();
        source = "";
    }
}
