public class StringSpeed {
    StringSpeed(){
        String str = "a";
        long sTime = 0, eTime = 0, rTime = 0, rTime2 = 0;

        sTime = System.currentTimeMillis();
        for(int i = 0; i<99999; i++){
            str += "a";
        }
        eTime = System.currentTimeMillis();
        rTime = eTime - sTime;

        System.out.println("고정문자열 String의 런타임: " + rTime/1000.0);

        StringBuilder sb = new StringBuilder();
        sTime = System.currentTimeMillis();
        for(int i = 0; i < 99999; i++){
            sb.append("a");
        }

        eTime = System.currentTimeMillis();
        rTime2 = eTime - sTime;

        System.out.println("가변 문자열 스트링 버퍼의 런타임 시간: "+rTime2/1000.0);
    }

    public static void main(String[] args){
        new StringSpeed();
    }
}
