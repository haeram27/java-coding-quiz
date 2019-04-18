public class GcdTest {
    // 최소 공약수: 루프 이용하는  방법 (유클리드 호제법)
    public static int gcd_modulus(int a, int b) {
        int big, small;
        int rest;
        
        // 인자 값이 모두 0보다 작거나 같으면 0 출력
        if ((a <= 0) && (b <= 0)) {
            return 0;
        }
        // 나눗셈을 위해 입력값을 큰 수와 작은 수로 나눔
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }
        
        // 제수(나누는 값)이 0이면 피제수(나눌값) 최대공약수 
        if (small == 0) {
            return big;
        }
        
        // 나머지가 0이 될 때 까지 small과 rest를 계속 나눈다.
        // 나머지가 0이면 small(제수)가 최대공약수 이다. 
         do {
            rest = big%small;
            if(rest > 0) {
                big = small;
                small = rest;
            }
        } while (rest > 0);
        
        return small;
    }
    
    // 최소 공약수: 재귀 호출을 이용하는  방법 : (BEST)최선의 방법
    public static int gcd_recursion(int a, int b) {
        int big, small;
        
        // 인자 값이 모두 0보다 작거나 같으면 0 출력
        if ((a <= 0) && (b <= 0)) {
            return 0;
        }
        
       // 나눗셈을 위해 입력값을 큰 수와 작은 수로 나눔
       if (a > b) { big = a; small = b; } 
       else { big = b; small = a; }
        
        // 나머지(small)가 0이면 제수(big)가 최대공약수 이다.
        // 여기가 GCD의 핵심이다. 
        if (small == 0) {
            return big;
        } else {
            return gcd_recursion(small, big%small);
        }
    }
    
    // 최대 공배수: 
    public static int lcm(int a, int b, int gcd) {
        // 인자 값이 모두 0보다 작으면 0 출력
        if ((a <= 0) || (b <= 0) || (gcd <= 0)) {
            return 0;
        }
        
        // 여기가 LCM의 핵심이다. 
        return (a*b)/gcd;
        
    }
    
    public static void main(String args[]) {
        
        int a = 12, b = 8;
        int gcd_loop, gcd_recur;
        int lcm;

        // 최대공약수(GCD: greatest common divisor) 공식
        // gcd(big, small) = gcd(small, r)
        gcd_loop = gcd_modulus(a, b);
        gcd_recur = gcd_recursion(a, b);
        
        System.out.println(
                String.format("POOR::GCD_MODULUS of %d and %d is %d.", 
                        a, b, gcd_loop));
        System.out.println(
                String.format("BEST::GCD_RECURSION of %d and %d is %d.", 
                        a, b, gcd_recur));

        // 최소공배수(LCM: leat common multiple) 공식
        // gcd(big, small) = gcd(small, r)
        lcm = lcm(a, b, gcd_recur);
        System.out.println(
                String.format("LCM of %d and %d is %d.", 
                        a, b, lcm));
    }
}