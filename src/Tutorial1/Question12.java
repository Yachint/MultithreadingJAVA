import java.util.Scanner;
import java.util.regex.Pattern;

public class Question12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String text = s.next();

        if(Pattern.matches("[0-9]+",text) == true){
            System.out.println("It contains only Numbers!");
        }
        else{
            System.out.println("It also contains Letters!");
        }
    }
}
