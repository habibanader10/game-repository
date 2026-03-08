package game.engine;

import game.engine.cards.Card;
import game.engine.cells.Cell;
import game.engine.monsters.Monster;
import java.util.ArrayList;

public class Board {
    private final Cell[][] boardCells;
    private static ArrayList<Monster> stationedMonsters;
    private  static ArrayList<Card> originalCards;
    public static ArrayList<Card> cards;


   public Board(ArrayList<Card> readCards) {
        boardCells = new Cell[10][10];
        stationedMonsters = new ArrayList<>();
        cards = new ArrayList<>();
        originalCards = readCards;
    }


   public Cell[][] getBoardCells() {
    return boardCells;
   }


   public static ArrayList<Monster> getStationedMonsters() {
    return stationedMonsters;
   }


   public static ArrayList<Card> getOriginalCards() {
    return originalCards;
   }


   public static ArrayList<Card> getCards() {
    return cards;
   }


   public static void setStationedMonsters(ArrayList<Monster> stationedMonsters) {
    Board.stationedMonsters = stationedMonsters;
   }


   public static void setCards(ArrayList<Card> cards) {
    Board.cards = cards;
   }

    


   }

    


