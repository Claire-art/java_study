public class ArrayTest2 {
    public static void main(String args[]){
        int score[] = {88,97, 53, 62, 92, 68, 82};
        int max = score[0];

        for(int i: score) //확장된 for문 사용, 변수 x는 인덱스가 아닌 배열 요소의 값이 순차적으로 배정된다.
        // 기존 for문 => for(int i = 1; i < score.length; i = i+1)
        {
            if (i > max){ //=> if(score[i] > max)
                max = i; // => max = score[i]
            }

            System.out.println("배열 요소의 최대값은: " + max);
        }
    }
}
