import java.util.*;

public class Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int vowelCount = 0;
        int consonantsCount = 0;
        int digitsCount = 0;
        int specialCount = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) { 
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantsCount++;
                }
            } 
            else if (Character.isDigit(ch)) {
                digitsCount++;
            } 
            else {
                specialCount++;
            }
        }
        System.out.println("Vowels = " + vowelCount);
        System.out.println("Consonants = " + consonantsCount);
        System.out.println("Digits = " + digitsCount);
        System.out.println("Special characters = " + specialCount);
        sc.close();
    }
}