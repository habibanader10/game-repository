package game.engine.cells;

import game.engine.monsters.Monster;

public class MonsterCell extends Cell  {
    private Monster cellMonster;

    public MonsterCell(Monster cellMonster, String name) {
        super(name);
        this.cellMonster = cellMonster;
    }

    public Monster getCellMonster() {
        return cellMonster;
    }
    



}
