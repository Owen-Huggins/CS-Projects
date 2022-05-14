public class Gym {
    public static void main(String[] args) {
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer("Bobby Dodd");

        Techmon cmon = new Techmon("Cmon", 21, 10);
        Trainer trainer3 = new Trainer("Ash", 8, new Techmon[]{cmon});

        Techmon pythmon = new Techmon("Pythmon", 13, 1);
        Techmon rubymon = new Techmon();
        Techmon rustmon = new Techmon();
        Trainer trainer4 = new Trainer("Gary", 8, new Techmon[]{pythmon, rubymon, rustmon});

        Techmon mon1 = new Techmon();
        Techmon dataStruct = new Techmon("DataStruct", 13, 32);
        Techmon assembly = new Techmon("Assembly", 21);
        Techmon javamon = new Techmon("Javamon", 13, 31);

        System.out.println(trainer1.toString());
        System.out.println(trainer2.toString());
        System.out.println(trainer3.toString());
        System.out.println(trainer4.toString());
        System.out.println(Techmon.getTechmonPopulation());

    }
}
