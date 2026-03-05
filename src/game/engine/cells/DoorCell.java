package game.engine.cells;
import game.engine.Role;

public class DoorCell extends Cell {
    private Role role;
    private int energy;
    private boolean activated;

    public DoorCell(String name, Role role, int energy) {
        super(name);
        this.energy = energy;
        this.role = role;
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

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    


}
