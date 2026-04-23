package game.engine.monsters;

import game.engine.Board;
import game.engine.Constants;
import game.engine.Role;



public class Schemer extends Monster {
	
	public Schemer(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
	}
	
	

	private int stealEnergyFrom(Monster target) {
        int stolen = Math.min(Constants.SCHEMER_STEAL, target.getEnergy());
        target.setEnergy(target.getEnergy() - stolen);
        return stolen;
    }

    
    public void executePowerupEffect(Monster opponentMonster) {
        int totalStolen = 0;
        totalStolen += stealEnergyFrom(opponentMonster);
        for (Monster stationed : Board.getStationedMonsters()) {
            totalStolen += stealEnergyFrom(stationed);
        }
        this.setEnergy(this.getEnergy() + totalStolen);   // one setEnergy  +10 passive applied once
    }

	public void setEnergy(int energy) {
        int current = getEnergy();
        int change = energy - current;
        change += 10;   // ALWAYS, even when raw change is 0
        super.setEnergy(current + change);
    }

	}


