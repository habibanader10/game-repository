package game.engine.cells;

import game.engine.monsters.Monster;


import java.util.ArrayList;
import java.util.Random;
import game.engine.dataloader.DataLoader;
import game.engine.cards.Card;
import java.io.IOException;

public class CardCell extends Cell {
    private static ArrayList<Card> cards;

	
	public CardCell(String name) {
        super(name);
    }

    // Method to get the list of cards from the data loader
    private ArrayList<Card> getCards() {
    try {
        return DataLoader.readCards();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


    public void onLand(Monster landingMonster, Monster opponentMonster)  {
        super.onLand(landingMonster, opponentMonster);
        if (cards == null || cards.isEmpty()) {
                cards = getCards();
            }
        int index = new Random().nextInt(cards.size());
        Card Drawn = cards.remove(index);
        Drawn.performAction(landingMonster, opponentMonster);
    }
    
   
}
