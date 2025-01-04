

import java.io.*;
import java.util.*;
 class CompoundWordsFinder {

    // Helper function to determine if a word can be formed by other words in the set
    private static boolean canFormWord(String word, Set<String> wordSet, boolean isOriginal) {
        if (wordSet.contains(word) && !isOriginal) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && canFormWord(suffix, wordSet, false)) {
                return true;
            }
        }

        return false;
    }

    public static void findLongestCompoundedWords(String filePath) {
        long startTime = System.currentTimeMillis();

        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort words by length in descending order
        words.sort((a, b) -> b.length() - a.length());

        Set<String> wordSet = new HashSet<>(words);
        String longest = "";
        String secondLongest = "";

        for (String word : words) {
            if (canFormWord(word, wordSet, true)) {
                if (longest.isEmpty()) {
                    longest = word;
                } else if (secondLongest.isEmpty()) {
                    secondLongest = word;
                    break;
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Longest Compound Word: " + longest);
        System.out.println("Second Longest Compound Word: " + secondLongest);
        System.out.println("Time taken to process " + filePath + ": " + (endTime - startTime) + " milliseconds");
    }

    public static void main(String[] args) {
        // Replace "Input_01.txt" and "Input_02.txt" with your file paths
        findLongestCompoundedWords("D:/projct/Input_01.txt");
        findLongestCompoundedWords("D:/projct/Input_02.txt");
    }
}
