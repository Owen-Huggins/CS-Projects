//I worked on the homework assignment alone, using only course materials//
public class Trainer {
    private String name;
    private int badges;
    private Techmon[] techmonTeam;
    private int teamCounter = 0;

    public static final String DEFAULTNAME = "George P. Burdell";
    public static final int DEFAULTBADGES = 0;

    public Trainer() {
      this(DEFAULTNAME, DEFAULTBADGES, new Techmon[6]);
    }
    public Trainer(String initName) {
      this(initName, DEFAULTBADGES, new Techmon[6]);
    }
    public Trainer(String initName, int initBadges, Techmon[] initTechmonTeam) {
        name = initName;
        if (initBadges < 0) {
            badges = 0;
        } else if (initBadges > 8) {
            badges = 8;
        } else {
            badges = initBadges;
        }
        techmonTeam = initTechmonTeam;
    }
    public void addTechmon(Techmon techie) {
        if (teamCounter > 5) {
            System.out.println("Cannot add " + techie.getName() + "," + name + "'" + "s" + " team is full!");
        } else {
            techmonTeam[teamCounter] = techie;
            teamCounter++;
        }
    }
    public int getTeamSize() {
        return (teamCounter + 2);
    }
    public void introduceTeam() {
        String[] techmonNames = new String[teamCounter];
        int notNullCounter = 0;
        for (Techmon techie : techmonTeam) {
            if (techie != null) {
                techmonNames[notNullCounter] = techie.getName();
                notNullCounter++;
            }
        }
        for (int i = 0; i < (teamCounter - 1); i++) {
            System.out.print(techmonNames[i] + ",");
        }
        System.out.print(techmonNames[teamCounter]);
    }
    public void playWithTechmon(Techmon techie) {
        if (techie != null) {
            techie.setHappiness((int) (techie.getHappiness() * 1.5));
        }
        if (badges * 10 > techie.getLevel()) {
            techie.setLevel(techie.getLevel() + 1);
        }
    }
    public void playWithTechmon(String techmonName) {
        int counter = 0;
        for (int i = 0; i < techmonTeam.length; i++) {
            if (techmonTeam[i].getName() == techmonName) {
                playWithTechmon(techmonTeam[i]);
            } else {
                counter++;
            }
        }
        if (counter == techmonTeam.length) {
            System.out.println(techmonName + " is not in " + name + "'" + "s" + " team!");
        }
    }
    public String toString() {
        if (badges == 8) {
            return ("My name is " + name + ", and I can now challenge the Techmon League with my team.");
        } else {
            return ("My name is " + name + ", and I still have to beat " + (8 - badges) + " gyms.");
        }
    }

}
