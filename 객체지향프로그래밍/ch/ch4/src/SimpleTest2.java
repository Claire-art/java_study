import java.util.Scanner;

public class SimpleTest2 {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.print("한 개의 숫자를 입력: ");

        int count = stdin.nextInt();

        if(count < 0); //조건문 뒤에 ;을 붙이면 문장이 종료된다.
            System.out.println(count + "은 음수입니다.");
        

    }
}
