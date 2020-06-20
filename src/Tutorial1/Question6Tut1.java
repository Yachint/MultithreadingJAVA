import java.util.Scanner;

public class Question6Tut1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String n = s.next();

        StringBuilder normal = new StringBuilder(n);
        String reverse = String.valueOf(normal.reverse());

        if(n.equals(reverse)){
            System.out.println("It is a palindrome!");
        }
        else{
            System.out.println("NOT a palindrome!");
        }



    }
}
