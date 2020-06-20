import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int month = s.nextInt();
        int day = s.nextInt();

        if(month==12 || month==1 || month==2 || month==3){
            if(month==12 && day>=16){
                System.out.println("Winter!");
            }
            else if(month==3 && day<=15){
                System.out.println("Winter!");
            }
            else if(month==1 || month==2){
                System.out.println("Winter!");
            }
        }
        if(month==3 || month==4 || month==5 || month==6){
            if(month==3 && day>=16){
                System.out.println("Spring!");
            }
            else if(month==6 && day<=15){
                System.out.println("Spring!");
            }
            else if(month==4 || month==5){
                System.out.println("Spring!");
            }
        }

        if(month==6 || month==7 || month==8 || month==9){
            if(month==6 && day>=16){
                System.out.println("Summer!");
            }
            else if(month==9 && day<=15){
                System.out.println("Summer!");
            }
            else if(month==7 || month==8){
                System.out.println("Summer!");
            }
        }

        if(month==9 || month==10 || month==11 || month==12){
            if(month==9 && day>=16){
                System.out.println("Fall!");
            }
            else if(month==12 && day<=15){
                System.out.println("Fall!");
            }
            else if(month==10 || month==11){
                System.out.println("Fall!");
            }
        }

    }
}
