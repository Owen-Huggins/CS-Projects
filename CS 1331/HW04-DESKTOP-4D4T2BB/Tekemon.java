//I worked on the homework assignment alone, using only course materials
/**
* @author Owen Huggins
* @version 1.0
*/
public abstract class Tekemon {
    private String name;
    private int level;
    private int stamina;
    /**
    *
    */

    public Tekemon(String name, int level, int stamina) {
        this.name = name;
        this.level = level;
        if (stamina < 0) {
            this.stamina = 0;
        } else {
            this.stamina = stamina;
        }
    }

    public String getName() {
        return (name);
    }
    public int getLevel() {
        return (level);
    }
    public int getStamina() {
        return (stamina);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public abstract void duel(Tekemon t);

    public void potion() {
        stamina = (stamina + 15);
    }

    public abstract void levelUp();

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Tekemon)) {
            return false;
        }
        return ((((Tekemon) o).getName().equals(name)) && (((Tekemon) o).getLevel() == level)
            && (((Tekemon) o).getStamina() == this.stamina));
    }

    public String toString() {
        return ("My name is " + name + ", and I am a Tekemon. My level is " + level
            + " and my current stamina is " + stamina + ".");
    }
}
