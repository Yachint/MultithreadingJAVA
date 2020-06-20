import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();

        String k  = String.valueOf(num);

        System.out.println(k.charAt(k.length()-1));
    }
}
