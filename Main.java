public class Main {
    public static void main(String[] args) {
        String firstname = "data";
        String lastName = "value";

        System.out.println(firstname);

        String fullName = calculate(firstname);

        System.out.println(fullName);
    }

    public static String calculate(String name) {
        String temp = name + ".";
        return temp;
    }
}