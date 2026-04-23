package game.engine.monsters;

import game.engine.Constants;
import game.engine.Role;



public class Schemer extends Monster {
	
	public Schemer(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
	}
	
	

	private int stealEnergyFrom(Monster target) {
    	int stolenEnergy = Constants.SCHEMER_STEAL;
    	if (target.getEnergy() < stolenEnergy) {
       		 stolenEnergy = target.getEnergy();
  		  }
 		// remove energy from target
   		 target.setEnergy(target.getEnergy() - stolenEnergy);
   		 return stolenEnergy;
}
	

	public void executePowerupEffect(Monster opponentMonster) {
		int totalStolen = 0;
		totalStolen += stealEnergyFrom(opponentMonster);
		this.setEnergy(this.getEnergy() + totalStolen);
	}

	public void setEnergy(int energy) {
        int current = getEnergy();
        int change = energy - current;
        change += 10;   // ALWAYS, even when raw change is 0
        super.setEnergy(current + change);
    }

	}


