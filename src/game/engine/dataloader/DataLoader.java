package game.engine.dataloader;

import game.engine.Role;
import game.engine.cards.Card;
import game.engine.cards.ConfusionCard;
import game.engine.cards.EnergyStealCard;
import game.engine.cards.StartOverCard;
import game.engine.cells.Cell;
import game.engine.cells.ContaminationSock;
import game.engine.cells.ConveyorBelt;
import game.engine.cells.DoorCell;
import game.engine.monsters.Dasher;
import game.engine.monsters.Dynamo;
import game.engine.monsters.Monster;
import game.engine.monsters.MultiTasker;
import game.engine.monsters.Schemer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DataLoader {
   private String cards;
   private String cells;
   private String monsters;

    public static ArrayList<Card> readCards() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("csvfiles/cards.csv"));
        ArrayList<Card> cards = new ArrayList<>();
        String line;
        Card card = null;
        while((line=br.readLine())!= null) {
            String [] values = line.split(",");
            String cardType = values[0];
            String name = values[1];
            String description = values[2];
            int rarity = Integer.parseInt(values[3]);
            switch (cardType) {
                case "ENERGYSTEAL":
                    int energy = Integer.parseInt(values[4]);
                    card = new EnergyStealCard(name, description, rarity,energy);
                    break;
                case "STARTOVER":
                    boolean lucky = Boolean.parseBoolean(values[4]);
                    card = new StartOverCard(name, description, rarity,lucky);
                    break;
                case "CONFUSION":
                    int duration = Integer.parseInt(values[4]);
                    card = new ConfusionCard(name, description, rarity,duration);
                    break;


               
            }
             if (card != null) 
                cards.add(card);
                
           
        }
         br.close();
        return cards;

    }
    public static ArrayList<Cell> readCells() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("csvfiles/cells.csv"));
        ArrayList<Cell> cells = new ArrayList<>();
        String line;
        while((line=br.readLine())!= null) {
            String [] values = line.split(",");
            String name = values[0];
            Cell cell = null;
            if(values.length == 3){
                Role role = Role.valueOf(values[1]);
                int energy = Integer.parseInt(values[2]);
                cell = new DoorCell(name,role,energy);
            } 
            else if(values.length == 2){
                int effect = Integer.parseInt(values[1]);

                if(effect > 0){
                    cell = new ConveyorBelt(name, effect);
                }
                 else {
                    cell = new ContaminationSock(name,effect);
                }
            }
            if (cell != null) 
                cells.add(cell);
            
        }
        br.close();
        return cells;
        
            
    }

     public static ArrayList<Monster> readMonsters() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("csvfiles/monsters.csv"));
        ArrayList<Monster> monsters = new ArrayList<>();
        String line;
        while((line=br.readLine())!= null) {
            String [] values = line.split(",");
            String monsterType = values[0];
            String name = values[1];
            String description = values[2];
            Role role = Role.valueOf(values[3]);
            int energy = Integer.parseInt(values[4]);
            Monster monster = null;
            switch (monsterType) {
                case "DASHER":
                    monster = new Dasher(name, description, role, energy);
                    break;
                case "DYNAMO":
                    monster = new Dynamo(name, description, role, energy);
                    break;
                case "MULTITASKER":
                    monster = new MultiTasker(name, description, role, energy);
                    break;
                case "SCHEMER":
                    monster = new Schemer(name, description, role, energy);
                    break;
            }
             if (monster != null) 
                monsters.add(monster);         
        }
        br.close();
        return monsters;
     }
}
