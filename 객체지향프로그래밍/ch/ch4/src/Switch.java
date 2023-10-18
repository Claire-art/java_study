import java.util.Scanner;

public class Switch {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.println("월을 입력하세요: ");
        int month = stdin.nextInt();

        String MtoS;

        switch (month)
        {
            case 12:
            case 1:
            case 2:
                MtoS = "겨울입니다.";
                break;
            case 3:
            case 4:
            case 5:
                MtoS = "봄입니다.";
                break;
            case 9:
                System.out.print("멋진 9월과 "); // break문이 안달려있어서 아래로 넘어감
            case 10:
                System.out.print("낙엽의 11월은 ");
                MtoS = "가을입니다.";
                break;
            default:
                MtoS = "1~12월을 벗어난 달입니다.";
                break;
        }
        System.out.println(MtoS);
    }
}
