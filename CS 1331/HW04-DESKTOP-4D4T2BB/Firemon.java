public class Firemon extends Tekemon {
    private int knowledgeLevel;
    private int firePoints;


    private static final int DEFAULTLEVEL = 30;
    private static final int DEFAULTSTAMINA = 20;
    private static final int DEFAULTKNOWLEDGELEVEL = 30;
    private static final int DEFAULTFIREPOINTS = 0;

    public int getKnowledgeLevel() {
        return (knowledgeLevel);
    }
    public int getFirePoitns() {
        return (firePoints);
    }


    public void setKnowledgeLevel(int knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public void setFirePoints(int firePoints) {
        this.firePoints = firePoints;
    }


    public Firemon(String intName) {
        this(intName, DEFAULTLEVEL, DEFAULTSTAMINA, DEFAULTKNOWLEDGELEVEL, DEFAULTFIREPOINTS);
    }

    public Firemon(String name, int level, int stamina, int knowledgeLevel, int firePoints) {
        super(name, level, stamina);
        this.knowledgeLevel = knowledgeLevel;
        this.firePoints = firePoints;

    }

    public void duel(Tekemon t) {
        if (this.equals(t)) {
            System.out.println("Cannot duel an ally!");
        } else if (this.getStamina() == 0 || t.getStamina() == 0) {
            System.out.println("Cannot duel");
        } else {
            if (this.getKnowledgeLevel() > 13) {
                if ((((Math.random() * 10) + 1) % 2) == 1) {
                    this.fireFight();
                }
            }
            t.setStamina(t.getStamina() - (15 + ((int) (this.getLevel() / 2))));
            if (t.getStamina() < 0) {
                t.setStamina(0);
            } else if (t.getStamina() == 0) {
                this.setFirePoints((int) ((this.getFirePoitns() + (.5 * t.getLevel()))));
                this.levelUp();
            }
        }
    }

    public void fireFight() {
        if (this.getStamina() > 25) {
            if (this.getKnowledgeLevel() >= 30) {
                this.setFirePoints(this.firePoints + 20);
            } else {
                this.setFirePoints(this.firePoints + 10);
            }
            System.out.println("We won the fight, yay!");
            this.levelUp();
        }
    }

    public void levelUp() {
        if (this.getLevel() >= 30) {
            while (firePoints >= 40) {
                this.setLevel(this.getLevel() + 1);
                firePoints = firePoints - 40;
                System.out.println("Yay, I am now " + this.getLevel() + "!");
            }
        } else if (this.getLevel() < 30) {
            while (firePoints >= 20) {
                this.setLevel(this.getLevel() + 1);
                firePoints = firePoints - 20;
                System.out.println("Yay, I am now " + this.getLevel() + "!");
            }
        }

    }

    public boolean equals(Object o) {
        return (super.equals(o) &&  ((Firemon) o).getKnowledgeLevel() == knowledgeLevel);
    }

    public String toString() {
        return (super.toString() + " I am a Firemon, and I have " + knowledgeLevel + " knowledge.");
    }


}
