package game.engine.cells;

import game.engine.Constants;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class ContaminationSock extends TransportCell implements CanisterModifier {

	public ContaminationSock(String name, int effect) {
		super(name, effect);
	}
	
	 public void modifyCanisterEnergy(Monster monster, int canisterValue) {
        monster.alterEnergy(canisterValue);
    }
    public void transport(Monster monster) {
       //backward movement (shield cannot block this)
        super.transport(monster);
        //slip penalty (shield-aware via alterEnergy)
        modifyCanisterEnergy(monster, -Constants.SLIP_PENALTY);
    }

    public void onLand(Monster landingMonster, Monster opponentMonster) {
        setMonster(landingMonster);
        transport(landingMonster);   // now handles movement + penalty together
    }
}

