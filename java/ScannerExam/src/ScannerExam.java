import java.io.File;
import java.util.Scanner;

public class ScannerExam {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc;
        try {
            sc = new Scanner(new File("res\\input.txt"));
            //sc = new Scanner(System.in);

            int T = sc.nextInt();
            for (int test_case = 0; test_case < T; ++test_case) {
                System.out.println(sc.next());
            }
            
            if (sc != null) {
                sc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
