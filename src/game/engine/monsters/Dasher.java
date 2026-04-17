package game.engine.monsters;

import game.engine.Role;

public class Dasher extends Monster {
	private int momentumTurns;

	public Dasher(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
		this.momentumTurns = 0;
	}
	
	public int getMomentumTurns() {
		return momentumTurns;
	}
	
	public void setMomentumTurns(int momentumTurns) {
		this.momentumTurns = momentumTurns;
	}
	
	public void move(int distance) {
   		 int multiplier = 2; // normal movement multiplier
   		 if (momentumTurns > 0) {
       		 multiplier = 3; // powerup multiplier
       		 momentumTurns--;
   		 }
   		 int newPosition = getPosition() + (distance * multiplier);
   		 setPosition(newPosition);
}

	
	public void executePowerupEffect(Monster opponentMonster){
		this.momentumTurns = 3; // Dasher gains momentum for the next 3 turns
	}


}