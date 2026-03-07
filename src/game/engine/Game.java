package game.engine;

import java.io.IOException;
import java.util.ArrayList;

import game.engine.cells.Cell;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;
import game.engine.cards.Card;

public class Game {
    private Board board;
    private ArrayList<Monster> allMonsters;
    private Monster player;
    private Monster opponent;
    private Monster current;

    public Game(Role playerRole) throws IOException{
        board = new Board(DataLoader.readCards());
        ArrayList<Cell> readCells = DataLoader.readCells();
        ArrayList<Monster> readMonsters = DataLoader.readMonsters();
        allMonsters = readMonsters;

        ArrayList<Monster> playerMonsters = new ArrayList<>();
        ArrayList<Monster> opponentMonsters = new ArrayList<>();

        Role opponentRole;

        if(playerRole == Role.LAUGHER){
            opponentRole = Role.SCARER;
        }
        else 
            opponentRole = Role.LAUGHER;

        for(int i =0 ; i<allMonsters.size(); i++){
            Monster m = allMonsters.get(i);
            if(m.getRole() == playerRole){
                playerMonsters.add(m);
            }
            else if(m.getRole() == opponentRole){
                opponentMonsters.add(m);
            }
        }

    }

}
