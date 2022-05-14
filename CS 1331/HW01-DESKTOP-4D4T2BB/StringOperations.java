public class StringOperations{
    public static void main(String[] args){
      String name = "Owen Huggins";
      System.out.println(name);
      String new_name = "A" + name.substring(1,11) + "Z";
      System.out.println(new_name);
      String address = "www.gatech.edu";
      System.out.println(address);
      String new_address = address.substring(4,10) + "1331";
      System.out.println(new_address);
    }
}
