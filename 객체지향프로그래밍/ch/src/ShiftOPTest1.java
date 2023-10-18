import java.util.Scanner;

public class ShiftOPTest1 {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.print("한 개의 숫자를 입력: ");

        int a = stdin.nextInt();

        boolean flag;
        flag = (a % 2 == 0) ? true : false; //입력받은 숫자를 2로 나눈 나머지가 0이면 true, 아니면 false를 반환
        System.out.print(a+"이 짝수입니까? : ");
        System.out.println(flag);
    }
}
