class Car{
    String color;
    int speed;
    int gear;

    public String toString(){
        return color + speed + gear ;
    }

    int changeGear(int numGear){
        gear = numGear;
        return gear;
    }

    int speedUp(){
        speed += 10;
        return speed;
    }

    int speedDown(){
        return speed;
    }
}


public class CarTest {
    public static void main(String args[]){
        Car myCar = new Car();
        myCar.changeGear(1);
        myCar.speedUp();
        System.out.println(myCar);
    }
}
