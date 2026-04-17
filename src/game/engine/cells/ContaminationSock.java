package game.engine.cells;

import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class ContaminationSock extends TransportCell implements CanisterModifier {

	public ContaminationSock(String name, int effect) {
		super(name, effect);
	}
	
	public  void modifyCanisterEnergy(Monster monster, int canisterValue){
		monster.alterEnergy(canisterValue);
		}
	public void onLand(Monster landingMonster, Monster opponentMonster) {
    	this.transport(landingMonster); 
    	this.modifyCanisterEnergy(landingMonster, -100); 
	}
}

