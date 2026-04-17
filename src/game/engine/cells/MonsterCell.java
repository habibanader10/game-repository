package game.engine.cells;

import game.engine.monsters.*;

public class MonsterCell extends Cell {
	private Monster cellMonster;

	public MonsterCell(String name, Monster cellMonster) {
		super(name);
		this.cellMonster = cellMonster;
	}

	public Monster getCellMonster() {
		return cellMonster;
	}
	
	public void onLand(Monster landingMonster, Monster opponentMonster) {
		Monster cellMonster = this.cellMonster;
		// CASE 1: same role → free powerup
		if (landingMonster.getRole() == cellMonster.getRole()) {
			landingMonster.executePowerupEffect(opponentMonster);
			return;
		}
		// CASE 2: different roles
		if (landingMonster.getEnergy() > cellMonster.getEnergy()) {
			int landingEnergy = landingMonster.getEnergy();
			int cellEnergy = cellMonster.getEnergy();
			landingMonster.alterEnergy(cellEnergy - landingEnergy);
			cellMonster.setEnergy(landingEnergy);
		}
	}
}
