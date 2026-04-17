package game.engine.cells;

import game.engine.Role;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class DoorCell extends Cell implements CanisterModifier {
	private Role role;
	private int energy;
	private boolean activated;
	
	public DoorCell(String name, Role role, int energy) {
		super(name);
		this.role = role;
		this.energy = energy;
		this.activated = false;
	}
	
	public Role getRole() {
		return role;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean isActivated) {
		this.activated = isActivated;
	}
	
	public void modifyCanisterEnergy(Monster monster, int canisterValue){
			monster.alterEnergy(canisterValue);
		}

	
	public void onLand(Monster landingMonster, Monster opponentMonster){
		if(this.activated) {
			return;
		}
		boolean matchRole = landingMonster.getRole() == this.role;
		int Doorenergy = this.getEnergy();
		if(!matchRole) {
        	Doorenergy *= -1;	
		}
		int og = landingMonster.getEnergy();
    	landingMonster.alterEnergy(Doorenergy);
    	if (landingMonster.getEnergy() != og)
       		 this.activated = true;
	}

}
