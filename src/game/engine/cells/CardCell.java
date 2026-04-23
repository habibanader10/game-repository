package game.engine.cells;

import game.engine.Board;
import game.engine.cards.Card;
import game.engine.monsters.Monster;
import java.util.ArrayList;
//onland correction

public class CardCell extends Cell {
    private static ArrayList<Card> cards;

	
	public CardCell(String name) {
        super(name);
    }
	//draw cards and and preforns action draw cards hya eli bt shuffle w btreload
    public void onLand(Monster landingMonster, Monster opponentMonster) {
        super.onLand(landingMonster, opponentMonster);
        Card drawnCard = Board.drawCard(); // your existing system
        drawnCard.performAction(landingMonster, opponentMonster);
    }
   
}

