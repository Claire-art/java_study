public class CopyArrayTest {
    public static void main(String args[]){
        int num1[] = {10, 20, 30};
        int num2[] = {40, 50, 60};

        num2 = num1;
        num2[2] = 200;
        
        for(int i: num2)
            System.out.println(i);

        System.out.println();

        for(int i: num1){
            System.out.println(i);
            //num1의 3번째 값이 200으로 바뀌는 side effect가 발생한 것을 확인
        }


        int num3[] = {100, 200, 300};
        int num4[] = {400, 500, 600};

        for(int i = 0; i < num3.length; i++){
            num4[i] = num3[i];
        }

        num4[2] = 999;

        System.out.println();

        for(int i: num3)
        System.out.println(i);

        System.out.println();

        for(int i: num4)
        System.out.println(i);
    }
}
