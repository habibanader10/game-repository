package game.engine.monsters;

import game.engine.Role;

public class MultiTasker extends Monster {
	private int normalSpeedTurns;
	
	public MultiTasker(String name, String description, Role role, int energy) {
		super(name, description, role, energy);
		this.normalSpeedTurns = 0;
	}

	public int getNormalSpeedTurns() {
		return normalSpeedTurns;
	}

	public void setNormalSpeedTurns(int normalSpeedTurns) {
		this.normalSpeedTurns = normalSpeedTurns;
	}

	public void move(int distance) {
    int actualDistance;
    if (normalSpeedTurns > 0) {
        actualDistance = distance; // normal speed
        normalSpeedTurns--;
    } else {
        actualDistance = distance / 2; // half speed
    }
    int newPosition = getPosition() + actualDistance;
    setPosition(newPosition);
}

public void setEnergy(int energy) {
    int current = getEnergy();
    int change = energy - current;
 //mashkook f mawdoo3 -200 or +200
    if (change != 0) {
        if (change > 0)
            change += 200;
        else
            change -= 200;
    }
    super.setEnergy(current + change);
}

	public void executePowerupEffect(Monster opponentMonster) {
		 this.normalSpeedTurns = 2;
}

}