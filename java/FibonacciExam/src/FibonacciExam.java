public class FibonacciExam {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
// Fibonacci using Recurssion

        int pos = 10;
        for (int i = 1; i <= pos; i++) {
            System.out.println(fiboRecur(i));
        }

// Fibonacci using Recurssion
/*
        fiboLoop(10);
*/
        
// Fibonacci using array
/*
        int[] arr = new int[10];
        FiboArray f = new FiboArray(arr);
        f.print();    // 배열 출력하기
*/
    }
    
    /**
     * Recurssion을 이용한 피보나치 출력
     * 
     * F(0) = 0, F(1) = 1, F(N) = F(N - 1) + F(N - 2), for N > 0 
     * 
     * (n)번째 Fibonacci 수열까지 구한다.
     * F(1):1 F(2):1 F(3):2 F(4):3 F(5):5 F(6):8 F(7):13 F(8):21 F(9):34 ...
     * 
     * Recurssion 이용 시 Performance는 엄청나게 떨어지며      * 93번째 즈음 overflow 발생할 수 있다
     * 
     * @param n
     * @return 
     */
    public static int fiboRecur(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fiboRecur(n-2) + fiboRecur(n-1);
        }
    }
    
    /**
     * Loop를 이용한 피보나치 출력
     * 
     * @param n
     * @return 
     */
    public static void fiboLoop(int n) {
        int t1 = 0, t2 = 1;
        System.out.print("First " + n + " terms: ");

        for (int i = 1; i <= n; ++i)
        {
            System.out.print(t1 + " + ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}

/**
 * array를 이용한 피보나치
 */
class FiboArray {
     
    int[] arr;
 
    public FiboArray() {
 
    }
 
    public FiboArray(int[] arr) {
        this.arr = arr;
    }
 
    public void execute() {
        arr[0] = 1;                           // 초기값
        arr[1] = 1;
        int result = 0;                       // 더한 결과 값
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 2) {
                result = arr[i] + arr[i + 1]; // 배열 첫번째와 그 다음 배열을 더한다.
                arr[i + 2] = result;          // 그 값을 첫번째 값 다다음 값에 입력한다.
            } else {                          // 배열의 (마지막 배열-1)번째 일 때
                break;
            }
 
        }
    }
 
    public void print() {
        execute();            // 피보나치 수열 배열에 입력하기
        for (int i : arr) {   // 배열의 값을 출력하기
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

