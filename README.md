# Problem Statement

## Write a program that:
1. Reads provided files (Input_01.txt and Input_02.txt) containing alphabetically sorted words list (one
word per line, no spaces, all lower case)
2. Identifies & display below given data in logs/console/output file
	-  longest compounded word
	-  second longest compounded word
	-  time taken to process the input file

Note: A compounded word is one that can be constructed by combining (concatenating) shorter words
also found in the same file 


# Solution

## intution
- we need to check for each string in the file
- if it is compounded or not
- and keep track for the second longest subsequence

## Approach
 - first we have used an arrayList for reading all the strings from file
 - now we will create 2 empty string which will keep track of first longest compounded word and second longest compounded word
 - for each word in the arrayList we will check if the word is compounded or not
	 - to check it we have created an arrayList which will keeptrack of the words that can possibly be a unit of compounded words i.e trackCompounded
	 - we have a StringBuilder to check if the current word is a unit or compounded word itself
	 - now at last we will check if the word is compounded or not using trackCompounded



# Execution
- The Code is in JAVA language
- download the Source code and the test files
- install Java Development Kit
- just run the code using
	- javac WordCompositionProblem.java
	- java WordCompositionProblem```
