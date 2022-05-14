public class Techmon {
    private String name;
    private int level;
    private int happiness;


    public static final String DEFAULTNAME = "Buzz";
    public static final int DEFAULTLEVEL = 100;
    public static final int DEFAULTHAPPINESS = 252;
    private static int techmonPopulation = 0;

    public static int getTechmonPopulation() {
        return (techmonPopulation);
    }


    public Techmon() {
      this(DEFAULTNAME, DEFAULTLEVEL, DEFAULTHAPPINESS);

    }
    public Techmon(String initName, int initLevel) {
      this(initName, initLevel, 30);
    }

    public Techmon(String initName, int initLevel, int initHappiness) {
        name = initName;
        if (initLevel < 0) {
            level = 0;
        } else if (initLevel > 100) {
            level = 100;
        } else {
            level = initLevel;
        }
        if (initHappiness < 0) {
            happiness = 0;
        } else if (initHappiness > 252) {
            happiness = 252;
        } else {
            this.happiness = initHappiness;
        }
        techmonPopulation++;
    }

    public String getName() {
        return (name);
    }
    public int getHappiness() {
        return (happiness);
    }
    public void setHappiness(int happiness) {
        if (happiness < 0) {
            this.happiness = 0;
        } else if (happiness > 252) {
            this.happiness = 252;
        } else {
            this.happiness = happiness;
        }

    }
    public int getLevel() {
        return (level);
    }
    public void setLevel(int initlevel) {
        if (level < 0) {
            level = 0;
        } else if (level > 100) {
            level = 100;
        } else {
            this.level = level;
        }
    }
    public void eatTechSnax() {
        happiness = (int) (1.25 * happiness);
        if (happiness > 252) {
            happiness = 252;
        }
        System.out.println("Yum Blue Donkey");
    }
    public void cry() {
        if (level < 50) {
            level = (int) (level / 2);
        } else {
            level = (int) (level * (3 / 4));
        }
        System.out.println("I'm tired.");
    }
    public static void assemble() {
        if (techmonPopulation > 5) {
            System.out.println("Stampede!");
        } else {
            System.out.println("These " + techmonPopulation + " are really cute!");
        }
    }
    public String toString() {
        return ("My name is " + name + " my level is " + level + " and my happiness is " + happiness + "!");
    }
    public static void main(String[] args) {

    }
}
