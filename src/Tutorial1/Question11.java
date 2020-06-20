import java.util.Scanner;

public class Question11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String first = s.next();
        String last = s.next();

        System.out.println(String.valueOf(first.charAt(0)).toUpperCase()+" "+String.valueOf(last.charAt(0)).toUpperCase());
    }
}
