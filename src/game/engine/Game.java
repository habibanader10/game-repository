package game.engine;

import game.engine.cells.Cell;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;
import java.io.IOException;
import java.util.ArrayList;
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
        Role opponentRole;

        if(playerRole == Role.LAUGHER){
            opponentRole = Role.SCARER;
        }
        else 
            opponentRole = Role.LAUGHER;
        player = selectRandomMonsterByRole(playerRole);
        opponent = selectRandomMonsterByRole(opponentRole);
        this.current = player;
        }

    
    private Monster selectRandomMonsterByRole(Role role){
        ArrayList<Monster> monstersByRole = new ArrayList<>();
        Monster m;
        for(int i =0 ; i<allMonsters.size(); i++){
            m = allMonsters.get(i);
            if(m.getRole() == role){
                monstersByRole.add(m);
            }
        }
        int randomIndex = (int) (Math.random() * monstersByRole.size());
        return monstersByRole.get(randomIndex);
    }


    public Board getBoard() {
        return board;
    }


    public ArrayList<Monster> getAllMonsters() {
        return allMonsters;
    }


    public Monster getPlayer() {
        return player;
    }


    public Monster getOpponent() {
        return opponent;
    }


    public Monster getCurrent() {
        return current;
    }


    public void setCurrent(Monster current) {
        this.current = current;
    }

}
