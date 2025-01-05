Overview

The CompositionWord program is designed to find the longest and second-longest compound words from a given list of words in a text file. A compound word is defined as a word that can be formed by concatenating two or more smaller words from the same list. The program processes the words efficiently by leveraging sorting and a recursive algorithm to check if a word can be constructed using smaller words.

Design Decisions and Approach

Data Handling:

Words are read from the input file and stored in a HashSet for fast lookups.
Sorting the words by length ensures that the program processes the longest words first.

Algorithm:

A helper function, formComposition, recursively checks if a word can be formed by splitting it into prefixes and suffixes and validating them against the set of words.

The isOriginal flag prevents false positives by distinguishing the original word from its components.

Efficiency:

Sorting once and using a HashSet ensures efficient processing.

Recursion checks are straightforward but could be optimized further using memoization for larger datasets.

Steps to Execute

1.Compile the Program: Run the following command in your terminal:

javac CompositionWord.java

2.Prepare Input Files: Create text files (e.g., Input_01.txt, Input_02.txt) with one word per line.

3.Run the Program: Execute the program by running:

java CompositionWord

Ensure the file paths in the main method match the location of your input files.

4.View Results: The program will output:

The longest compound word.

The second-longest compound word.

The time taken to process each file.


Example Output

For an input file containing:

cat


dog

cats

catsdog

rat

catsdograt

The program will output:

Longest Compound Word: catsdograt

Second Longest Compound Word: catsdog

Time take to process D:/projct/Input_01.txt: [time] milliseconds
