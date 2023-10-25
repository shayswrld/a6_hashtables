/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable  extends HashTable {


  /**
   * Create an QPHashTable with DEFAULT_SIZE table.
   */
  public QPHashTable() { super(); }

  /**
   * Create an QPHashTable with the given default size table.
   */
  public QPHashTable(final int size) { super(size); }

  /**
   * Find the index for entry: if entry is in the table, then returns its position;
   * if it is not in the table then returns the index of the first free slot.
   * Returns -1 if a slot is not found (such as when the table is full under LP).
   *
   */
  protected int findIndex(String key) {
      // Implement using quadratic probing.

      int expHV = hashFunction(key); //Get hash value
      incProbeCount();
      
      int result = -1;
  
      //Quadratic probing, if not in expected add (h)^2 until you get to empty slot or element, where h increase at each step
         int p =1;
         int hIndex = expHV % tableSize(); 
         
        if ((key.equals(table[hIndex])) || (table[hIndex] == null))
          return hIndex;
         
        while ((p < tableSize()) && (table[hIndex] != null)) {
          hIndex = (expHV + p*p) % tableSize();
          p++;
          incProbeCount();
          if (key.equals(table[hIndex]))//If the key in the table has a value and it is the key we are searching for
            {return hIndex;}
          else if (table[hIndex] == null)
            result = hIndex;
          
  
        } 
  
      return result; //Otherwise return -1
  
      }
  }
    
    