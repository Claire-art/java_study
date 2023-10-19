import java.util.Random;

public class MultiArrayTest1 {
    public static void main(String args[]){
        Random ran = new Random();
        int[][] score = new int[4][4];

        for(int i = 0; i<4; i++){
            for(int j = 0; j<4;j++){
                score[i][j] = ran.nextInt(10); //0-9사이의 정수 난수로 초기화
            }
        }

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }

        System.out.println();

        for(int k = 0; k < 4; k++){
            int sum = 0;
            for (int value:score[k]){ //1차원 배열의 배열 형식으로 할당하면 된다.
                System.out.print(value + " ");
                sum = sum + value; //각 행의 각 요소를 더한다.
            }
            System.out.println("의 합계는 "+sum);
        }
    }
}
