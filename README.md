# a6_hashtables
# Hashing Assignment README

This README provides an overview of the program developed to fulfill the requirements of the CSC2001F Assignment A6 on Hashing.

## Program Overview

The program consists of two major parts:

1. **Implementation of Hash Tables:**

    - LPHashTable: Linear Probing Hash Table implementation.
    - QPHashTable: Quadratic Probing Hash Table implementation.

    These hash tables are designed to store and manage simple String data items. They support operations like insertion, checking for item existence, and counting probes during these operations.

2. **Optimizing Hash Function:**

    The HashTable class provided in the program uses an array of weights to create a linear combination of characters in a student ID to generate a hash code. In this part of the assignment, we optimize the weights to achieve the minimum number of probes during insertion.

## Implementation Details

### Hash Table Classes

- **LPHashTable (Linear Probing):**
  - Implements linear probing for collision resolution.
  - Fails when the number of probes exceeds the table size (i>M).
  - Returns -1 if probing fails.
  
- **QPHashTable (Quadratic Probing):**
  - Implements quadratic probing for collision resolution.
  - Fails when the number of probes exceeds the table size (i>M).
  - Returns -1 if probing fails.

### Performance Evaluation

Both LPHashTable and QPHashTable classes utilize the Monitorable class for tracking probe counts during insertions and searches.

## Task One [50 marks]

For this task, you are required to complete the implementation of the LPHashTable and QPHashTable classes according to the linear probing and quadratic probing techniques, respectively. The primary goal is to ensure that these classes function correctly and efficiently for storing and searching for items.

### Sample Input/Output

For testing and evaluating your implementations, you can use the provided programs: LPAutoTest and QPAutoTest. These programs allow you to insert items, check if the table is empty, get the table's size, search for items, print table contents, count probes, reset probe count, load items from a file, and quit.

## Task Two [50 marks]

This task involves optimizing the weights used in the hash function to achieve the minimum number of probes during insertion. You will generate a custom list of usernames from 'students.txt' using the DataMaker program and then create a program called 'Optimize' to evaluate all possible combinations of weights and determine the optimal weights that minimize probe counts.

### DataMaker Program

1. Use the DataMaker program to generate a custom list, 𝐿, of 36 usernames from 'students.txt'.

```shell
java DataMaker <username> <list length>
```

2. Redirect the output to a file called 'mydata.txt'.

### Optimize Program

1. Develop an 'Optimize' program that evaluates various weight combinations to minimize probe counts.

2. The program will output the least number of probes required and the number of weight combinations that achieve this.

3. Submit the 'mydata.txt' file and the 'results.txt' file containing the probe count results and weight combinations.
