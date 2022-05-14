public class WreckFight {
    public static void main(String[] args) {
        Icemon mon1 = new Icemon("Edward Cullen", 101, 50, false, 0);
        Icemon mon2 = new Icemon("Edward Cullen", 101, 50, false, 0);
        Firemon mon3 = new Firemon("Stan Loona", 16, 12, 45, 0);
        Firemon mon4 = new Firemon("Stan Loona", 16, 12, 45, 0);

        System.out.println(mon1);
        System.out.println(mon2);
        System.out.println(mon3);
        System.out.println(mon4);

        mon1.duel(mon2);
        mon1.duel(mon3);



        System.out.println(mon1);
        System.out.println(mon2);
        System.out.println(mon3);
        System.out.println(mon4);


        System.out.println(mon1.equals(mon2));
        System.out.println(mon3.equals(mon4));



    }
}
