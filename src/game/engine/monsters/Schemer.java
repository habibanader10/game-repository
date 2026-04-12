package game.engine.monsters;

import game.engine.Constants;
import game.engine.Role;



public class Schemer extends Monster {
	
	public Schemer(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
	}
	
	 private int stealEnergyFrom(Monster target){
		int stolenEnergy = Constants.SCHEMER_STEAL;
		if(target.getEnergy() < stolenEnergy) {
			stolenEnergy = target.getEnergy();
		}
		return stolenEnergy;
	 }
	 //byzaaaa
	 public void executePowerupEffect(Monster opponentMonster){
		int stolenEnergy = stealEnergyFrom(opponentMonster);
		opponentMonster.setEnergy(opponentMonster.getEnergy() - stolenEnergy);
		this.setEnergy(this.getEnergy() + stolenEnergy);
		
    }

	}


