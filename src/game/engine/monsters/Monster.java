package game.engine.monsters;
import game.engine.Role;

public abstract class Monster implements Comparable {
    private String name;
    private String description;
    private Role role;
    private Role originalRole;
    private int energy;
    private int position;
    private boolean frozen;
    private boolean shielded;
    private int confusionTurns;
    public Monster(String name, String description, Role originalRole, int energy) {
        this.name = name;
        this.description = description;
        this.role = originalRole;
        this.originalRole = originalRole;
        this.energy = energy;
    }

    //Getters:
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Role getOriginalRole() {
        return originalRole;
    }

      public Role getRole() {
        return role;
    }

    public int getEnergy() {
        return energy;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public boolean isShielded() {
        return shielded;
    }

    public int getConfusionTurns() {
        return confusionTurns;
    }

    //Setters:
    public void setRole(Role role) {
        this.role = role;
    }

    public void setEnergy(int energy) {
        if(energy>=0)
            this.energy = energy;
    }

    public void setPosition(int position) {
        if(position >=0 && position<=99 )
            this.position = position;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public void setShielded(boolean shielded) {
        this.shielded = shielded;
    }

    public void setConfusionTurns(int confusionTurns) {
        this.confusionTurns = confusionTurns;
    }
    public int compareTo(Object o) {
        Monster other = (Monster) o;
        return this.position - other.position;
    }
    




  

    

    

}
