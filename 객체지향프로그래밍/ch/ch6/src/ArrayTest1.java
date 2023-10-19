import java.util.Scanner;

public class ArrayTest1 {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        int i;

        double sum = 0.0, avg;
        double dnum[] = new double[5]; //1차원 배열 선언

        System.out.println(dnum.length);

        System.out.print("초기화 하지 않은 dnum[]의 값: ");
        for(i = 0; i < dnum.length; i++){
            System.out.println(dnum[i]);
        }

        for(i = 0; i < dnum.length; i++){
            System.out.print("dnum의 "+i+"번째 데이터 입력: ");
            dnum[i] = stdin.nextDouble();
        }

        for(i=0; i < dnum.length; i++){
            sum = sum + dnum[i];
        }

        System.out.println(sum);

        avg = sum / dnum.length;

        System.out.println(avg);
    }
}
