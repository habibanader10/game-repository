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
	

	public void executePowerupEffect(Monster opponentMonster) {

    int stealAmount = 10; // or constant

    int actualSteal = Math.min(stealAmount, opponentMonster.getEnergy());

    opponentMonster.setEnergy(opponentMonster.getEnergy() - actualSteal);
    this.setEnergy(this.getEnergy() + actualSteal);
}

	}


