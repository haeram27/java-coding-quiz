class Palindrome {
    public static void main(String args[]) {
        // TODO Auto-generated method stub
        
        String original = "maddam";
/*
//Read Input String        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome");
        original = in.nextLine();
*/
        
        isPalindromePoor(original);
        isPalindromeGood(original);
    }
    
    private static boolean isPalindromePoor(final String original) {
        //WithReverseString
        String reverse = ""; // Objects of String class
        int length = original.length();

        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse)) {
            System.out.println("palindrome.");
            return true;
        }
            
        else {
            System.out.println("Not a palindrome.");
            return false;
        }
    }
    
    private static boolean isPalindromeGood(final String original) {
        //WithoutReverseString, half number of check round against ReverseString
        int length = original.length();
        int i, begin, end, middle;

        begin = 0;
        end = length - 1;
        middle = length / 2;

        for (i = begin; i<middle; i++) {
            //if (Character.toLowerCase(original.charAt(begin)) == Character.toLowerCase(original.charAt(end))) {
            if (original.charAt(begin) == original.charAt(end)) {
                begin++;
                end--;
            } else {
                break;
            }
        }

        if (i == middle) {
            System.out.println("Palindrome.");
            return true;
        } else {
            System.out.println("Not a palindrome.");
            return false;
        }
    }
}