class BankAccountTest{
    int accountNumber; //께좌 번호
    String owner; //예금주
    int balance; // 잔액을 표시하는 변수

    int deposit(int Money){
        balance = balance + Money;
        return balance;
    }

    int withdraw(int outMoney){
        balance = balance - outMoney;
        return balance;
    }

    public String toString(){
        return "현재 잔액은 " + balance + "입니다.";
    }
}

public class BankAccount {
    public static void main(String args[]){
        BankAccountTest myAccount = new BankAccountTest();
        myAccount.deposit(10000);
        System.out.println(myAccount);
        myAccount.withdraw(8000);
        System.out.println(myAccount);
    }

    /*
    toString() 메소드는 Java의 Object 클래스에 정의된 메소드입니다. 
    모든 클래스는 Object 클래스를 상속받기 때문에, 따로 정의하지 않아도 기본적으로 이 메소드를 사용할 수 있습니다.
    이 toString() 메소드는 객체를 문자열 형태로 나타내기 위해 사용되며, 객체를 출력하거나 문자열과 연결할 때 자동으로 호출됩니다. 
    따라서 System.out.println(myAccount); 구문에서 myAccount 객체가 문자열로 변환되어 출력되는데, 
    이때 BankAccountTest 클래스에 오버라이딩된 toString() 메소드가 호출됩니다.
    즉, 직접적으로 호출하지 않았더라도 특정 상황에서 자동으로 호출되기 때문에 실행이 되었다고 볼 수 있습니다.
     */
    
}
