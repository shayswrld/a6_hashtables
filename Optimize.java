/*Program to optimize the probeCount for a hashtable given different weights
for the hash function*/
//Shaylin Velen
//09/05/2023
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Arrays;
//import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.stream.Collectors;

public class Optimize {
        /*
         * A class to generate 5^9 combinations of weights to optimize probes for a LPHashTable
         */
        private static int combCount;//Number of sets of weights with the least number of probes
        private static int leastProbes =1369787878;//Least number of probes for a set of weights - counter
        //private int pCount =0;
        final static HashTable hashTable = new LPHashTable(37);
        private static List<String> data = new ArrayList<String>();


            public static void main(String[] args) {
                //int[] start = {0,0,0,0,0,0,0,0,0};
                readFile();
                generateCode();//start at index 0
                
                try {
                FileWriter writer = new FileWriter("results.txt");
                writer.write(leastProbes + " " + combCount);
                writer.close();

                }
                catch (IOException io) {
                    System.out.println("File not found.");
                }
            }

            public static int[] convert(String base_5)
            /*converts a decimal number into base 5
             *if the length is not 9 fills all the previous values with 0
             */
            {
                while (base_5.length() < 9) {
                    base_5 = "0" + base_5;

                }
                String[] strWeights = base_5.split("");
                int[] newWeights = new int[strWeights.length];
                

                for (int n =0; n < strWeights.length; n++) {
                    newWeights[n] = Integer.parseInt(strWeights[n]);

                }
                //System.out.println(Arrays.toString(newWeights));
                return newWeights;

                
            }

        
            public static void generateCode() {
                for (int i = 1953125; i >= 0 ; i--)//1953347 in base 10 is 444444444 in base 5
                {
                    String base_5 = Integer.toString(i, 5);
                    int[] weights = convert(base_5);//convert to base5 fill with 0s
                    assignWeight(weights);

                }
            }

            public static void readFile() 
            //Read a textfile into an arraylist to optimize speed 
            {
                try {
                    Scanner fileIn = new Scanner(new File("mydata.txt"));
                    while (fileIn.hasNextLine()) {
                        data.add(fileIn.nextLine());       
                    }
                    fileIn.close();
                    

                }
                catch (FileNotFoundException fnfExep) {
                    System.out.println("File not found.");
                }
                catch (IllegalStateException illExcep) {
                    System.out.println("Insert failure. Table full?");
                }

            }

            public static void assignWeight(int[] weights) {
                hashTable.setWeights(weights);
                hashTable.empty();
                for (String element : data) {
                    hashTable.insert(element);
                    
                }
                
                testPCount(hashTable.getProbeCount());
                hashTable.resetProbeCount();

            }

            public static void testPCount(int probeCount) {
                if (leastProbes >= probeCount) {
                    leastProbes = probeCount;
                    combCount++;
                }


            }

        }
        /* 
                for (int i = 0; i <= 4; i++) {
                    weight[index] = i;//value we are assigning to each digit
                    if (index == weight.length - 1) {
                        assignWeight(weight);//Generate a code with the base case and test that set of weights
                        //System.out.println(Arrays.toString(weight));
                    } else {
                        generateCode(weight, index + 1);//recurse to the next index until we are at the end
                        assignWeight(weight);
                        //System.out.println(Arrays.toString(weight));
                    }
                    weight[index] = 0;//Assign 0 before moving onto index +1
                }
                */
        




    
