package game.engine;

import java.util.ArrayList;

import game.engine.cards.Card;
import game.engine.cells.*;
import game.engine.exceptions.InvalidMoveException;
import game.engine.monsters.Monster;

public class Board {
	private Cell[][] boardCells;
	private static ArrayList<Monster> stationedMonsters; 
	private static ArrayList<Card> originalCards;
	public static ArrayList<Card> cards;
	
	public Board(ArrayList<Card> readCards) {
		this.boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
		stationedMonsters = new ArrayList<Monster>();
		originalCards = readCards;
		cards = new ArrayList<Card>();
		setCardsByRarity();
		reloadCards();
	}
	
	public Cell[][] getBoardCells() {
		return boardCells;
	}
	
	public static ArrayList<Monster> getStationedMonsters() {
		return stationedMonsters;
	}
	
	public static void setStationedMonsters(ArrayList<Monster> stationedMonsters) {
		Board.stationedMonsters = stationedMonsters;
	}

	public static ArrayList<Card> getOriginalCards() {
		return originalCards;
	}
	
	public static ArrayList<Card> getCards() {
		return cards;
	}
	
	public static void setCards(ArrayList<Card> cards) {
		Board.cards = cards;
	}
	
	//returns the cell at the given index
	private int[] indexToRowCol(int index) {
		int cols = Constants.BOARD_COLS;
		int row = index / cols;
		int col = index % cols;
		//  reverse column for odd rows
		if (row % 2 != 0) {
			col = cols - 1 - col;
		}
		return new int[]{row, col};
	}

	private Cell getCell(int index){
		int[] rowCol = indexToRowCol(index);
		return boardCells[rowCol[0]][rowCol[1]];
	}

	private void setCell(int index, Cell cell){
		int[] rowCol = indexToRowCol(index);
		boardCells[rowCol[0]][rowCol[1]] = cell;
	}

	public void initializeBoard(ArrayList<Cell> specialCells){
		int totalCells = Constants.BOARD_SIZE;
   		 // default cells
		for (int i = 0; i < totalCells; i++) {
			if (i % 2 == 0) {
				setCell(i, new Cell("Rest"));
			} else {
				// take door cells from specialCells list
				setCell(i,specialCells.remove(0));
			}
		}
		//Card Cells
		for (int i = 0; i < Constants.CARD_CELL_INDICES.length; i++) {
			int idx = Constants.CARD_CELL_INDICES[i];
			setCell(idx, new CardCell("Card Cell"));
		}
		// Conveyor Belts
		for (int i = 0; i < Constants.CONVEYOR_CELL_INDICES.length; i++) {
			int idx = Constants.CONVEYOR_CELL_INDICES[i];
			Cell c = specialCells.remove(0);
			setCell(idx, c);
		}

		// Contamination Socks
		for (int i = 0; i < Constants.SOCK_CELL_INDICES.length; i++) {
			int idx = Constants.SOCK_CELL_INDICES[i];
			Cell c = specialCells.remove(0);
			setCell(idx, c);
		}
		// Monster Cells
		for (int i = 0; i < Constants.MONSTER_CELL_INDICES.length; i++) {
			int idx = Constants.MONSTER_CELL_INDICES[i];
			Monster m = stationedMonsters.remove(0);
			setCell(idx, new MonsterCell("Monster Cell", m));
		}

		// Place stationed monsters
		for (int i = 0; i < stationedMonsters.size(); i++) {
			Monster m = stationedMonsters.get(i);
			int pos = m.getPosition();
			Cell cell = getCell(pos);
			cell.setMonster(m);
		}
	}

	private  void setCardsByRarity(){
		ArrayList<Card> expanded = new ArrayList<>();
		for (int i = 0; i < originalCards.size(); i++) {
			Card c = originalCards.get(i);
			for (int j = 0; j < c.getRarity(); j++) {
				expanded.add(c);
			}
		}
		cards = expanded;
}
	public static void reloadCards() {
		//duplicated code, can be optimized by calling setCardsByRarity() instead
		ArrayList<Card> expanded = new ArrayList<>();
		for (int i = 0; i < originalCards.size(); i++) {
			Card c = originalCards.get(i);
			for (int j = 0; j < c.getRarity(); j++) {
				expanded.add(c);
			}
		}
		cards = expanded;
	//
		java.util.Random rand = new java.util.Random();
		for (int i = cards.size() - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			// swap cards[i] and cards[j]
			Card temp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}
}
	public static Card drawCard() {
		if (cards.isEmpty()) {
			reloadCards();
		}
		return cards.remove(0);
	}

	public void moveMonster(Monster currentMonster, int roll, Monster opponentMonster)
        throws InvalidMoveException {

    int oldPos = currentMonster.getPosition();
    currentMonster.move(roll);
    Cell cell = getCell(currentMonster.getPosition());
    cell.onLand(currentMonster, opponentMonster);
    if (currentMonster.getPosition() == opponentMonster.getPosition()) {
        currentMonster.setPosition(oldPos);
        throw new InvalidMoveException("Collision occurred");
    }
    currentMonster.decrementConfusion();
    opponentMonster.decrementConfusion();
    //  Sync board
    updateMonsterPositions(currentMonster, opponentMonster);
}

	private void updateMonsterPositions(Monster player, Monster opponent){
		for (int i = 0; i < Constants.BOARD_ROWS; i++) {
			for (int j = 0; j < Constants.BOARD_COLS; j++) {
				boardCells[i][j].setMonster(null);
			}
		}
		Cell playerCell = getCell(player.getPosition());
		playerCell.setMonster(player);
		Cell opponentCell = getCell(opponent.getPosition());
		opponentCell.setMonster(opponent);
	}
}










