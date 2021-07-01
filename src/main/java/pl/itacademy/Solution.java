package pl.itacademy;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int secondMaxNumber(Collection<Integer> numbers) {
        return numbers.stream()
                .distinct() //remove duplicates
                .sorted(Comparator.reverseOrder()) //sort collection, so maximum will be on 1 place
                .skip(1) //skip 1 element of the stream, our first maximum
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }

    public List<String> findPalindromes(Collection<String> words) {
        return words.stream()
                .filter(i -> palindrome(i))
                .collect(Collectors.toList());
    }

    public static boolean palindrome(String word){
        String reverse = "";
        for(int i = word.length()-1; i>=0; i--){
            reverse = reverse + word.charAt(i); //create reverse word
        }

        return reverse.equals(word); //check if reversed word is the same as original word
    }

}
