public class Icemon extends Tekemon {
    private boolean pet;
    private static int icemonSize;
    private int icePoints;



    private static final int DEFAULTLEVEL = 15;
    private static final int DEFAULTSTAMINA = 100;
    private static final boolean DEFAULTPET = true;
    private static final int DEFAULTICEPOINTS = 0;


    public boolean getPet() {
        return (pet);
    }
    public int getIcemonSize() {
        return (icemonSize);
    }
    public int getIcePoints() {
        return (icePoints);
    }
    public void setPet(boolean pet) {
        this.pet = pet;
    }
    public void setIcemonSize(int icemonSize) {
        this.icemonSize = icemonSize;
    }
    public void setIcePoints(int icePoints) {
        this.icePoints = icePoints;
    }




    public Icemon(String intName) {
        this(intName, DEFAULTLEVEL, DEFAULTSTAMINA, DEFAULTPET, DEFAULTICEPOINTS);
    }

    public Icemon(String name, int level, int stamina, boolean pet, int icePoints) {
        super(name, level, stamina);
        this.pet = pet;
        this.icemonSize = icemonSize;
        this.icePoints = icePoints;
        icemonSize++;
    }

    public void duel(Tekemon t) {
        if (t instanceof Icemon) {
            System.out.println("Cannot duel an ally!");
        } else if (this.getStamina() == 0 || t.getStamina() == 0) {
            System.out.println("Cannot duel");
        } else {
            t.setStamina(t.getStamina() - (2 * this.getLevel()));
            if (t.getStamina() < 0) {
                t.setStamina(0);
            }
            if (t.getStamina() == 0) {
                this.setIcePoints((int) ((this.getIcePoints() + (.5 * t.getLevel()))));
                this.levelUp();
            }
        }
    }
    public void levelUp() {
        if (this.getLevel() >= 20) {
            while (icePoints >= 30) {
                this.setLevel(this.getLevel() + 1);
                icePoints = icePoints - 30;
                System.out.println("Yay, I am now " + this.getLevel() + "!");
            }
        } else if (this.getLevel() < 20) {
            while (icePoints >= 20) {
                this.setLevel(this.getLevel() + 1);
                icePoints = icePoints - 20;
                System.out.println("Yay, I am now " + this.getLevel() + "!");
            }
        }

    }

    public void iceWreck() {
        icePoints = ((int) (icePoints * (1 + (icemonSize * .1))));
    }

    public void brainFreeze() {
        if (icePoints >= 5) {
            this.setStamina(this.getStamina() + (int) (0.5 * this.icePoints));
            this.icePoints = this.icePoints - 5;
            if (this.icePoints < 0) {
                this.icePoints = 0;
            }
        }

    }

    public boolean equals(Object o) {
        return (super.equals(o) && this.getPet() == pet);
    }

    public String toString() {
        if (pet) {
            return (super.toString() + " I am a Icemon, and I have a pet.");
        } else {
            return (super.toString() + " I am a Icemon, and I do not have a pet.");
        }

    }




}
