import java.io.File;

public class FileDirTest2 {
    public static void main(String args[]){
        File f1 = new File("C:\\Users\\hanjua\\Documents\\GitHub\\java_study\\객체지향프로그래밍\\ch\\ch13\\a.txt");

        System.out.println("파일 이름: " + f1.getName());
        System.out.println("파일 경로: " + f1.getPath());
        System.out.println("파일 절대 경로: " + f1.getAbsolutePath());
        System.out.println(f1.exists());
        System.out.println(f1.canWrite());
        System.out.println(f1.canRead());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.isAbsolute());
        System.out.println(f1.lastModified());
        System.out.println(f1.length());


    }
}
