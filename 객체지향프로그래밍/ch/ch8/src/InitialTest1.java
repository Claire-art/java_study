class Initial{
    // 객체 변수들은 변수를 초기화 하지 않아도 값이 묵시적으로 할당된다.
    int number;
    double rate;
    String name;
    int[] score;

    public void aMethod(){
        int count; // 매소드 지역 변수는 변수의 값을 명시적으로 초기화하지 않으면 구문 오류 발생
        System.out.println(number);
        // System.out.println(count); => 초기화 되지 않은 지역 변숫값 출력 불가, 오류 발생
    }
}

public class InitialTest1{
    public static void main(String args[]){
        int var1;
        double var2;

        Initial ob1 = new Initial();

        // System.out.println(var1);
        ob1.aMethod();
    }
}