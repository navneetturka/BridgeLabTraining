//Write a Java program to check if two strings are anagrams (same characters, different order) without using built-in sorting.

import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }
        int[] freq = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int f : freq) {
            if (f != 0) {
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("Anagram");
        sc.close();
    }
}