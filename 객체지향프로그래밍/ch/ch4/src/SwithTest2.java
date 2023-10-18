import java.util.Scanner;

public class SwithTest2 {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.print("월을 입력하세요(영문자): ");

        String month = stdin.next();

        switch(month){

            case "January":
                System.out.print("겨울입니다.");
                break;

            default:
                System.out.println("1~12월을 벗어난 달입니다.");
        }
    }
}
