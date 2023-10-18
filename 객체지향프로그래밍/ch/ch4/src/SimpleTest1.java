import java.util.Scanner;

public class SimpleTest1 {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.print("한개의 숫자를 입력: ");
        int count = stdin.nextInt();

        if(count < 0){
            System.out.println("-22는 음수입니다.");
        }
    }
}
