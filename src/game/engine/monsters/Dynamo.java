package game.engine.monsters;

import game.engine.Role;

public class Dynamo extends Monster {
	
	public Dynamo(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
	}

	public void setEnergy(int energy) {
    int current = getEnergy();
    int change = energy - current;
	 change *= 2; // double the change
    super.setEnergy(current + change);
}
	public void executePowerupEffect(Monster opponentMonster){
		 opponentMonster.setFrozen(true);
	}
}
