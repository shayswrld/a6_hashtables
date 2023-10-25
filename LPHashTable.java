import java.util.List;
/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
      boolean found = false; // A boolean flag indicating if we have found the key passed to findIndex
      boolean f_empty = false;//A boolean flag indicating if we have found the first empty slot
      int empty = -1; //if no free slot found return -1

      /*
      perform the hash function on the given key to find the index that you expect the
      key to be found at without probing
      */
      incProbeCount();
      int expHV = hashFunction(key); 

      if (table[expHV] == null) 
      {return expHV;}

      else if (key.compareTo(table[expHV]) == 0 )
      { return expHV;}

      else {
      //Linear probing, if not in expected add 1 until you get to empty slot or element
      //resetProbeCount();
      //incProbeCount();
        for (int i = expHV+1; i < table.length; i++) {
          incProbeCount();

          if ((table[i] != null) && (key.compareTo(table[i]) == 0)) {
            found = true;
            return i;
          }

          else if ((table[i] == null) && (f_empty == false))
          {
            f_empty = true;
            return i;
          }

          }

        if (found == false) 
        //Wrapping back around the table
        {
          for (int k = 0; k < expHV; k++)
          {           
          incProbeCount();

          if (!(f_empty) & (table[k] == null))
          {
            f_empty = true;
            return k;
          }

          else if ((table[k] != null) && (key.compareTo(table[k]) == 0))//Key is found after wrapping around
            {
              found = true;
              return k;
            }
  
          }

          return empty;
        }

        } 
      //incProbeCount();
      return -1;
      }
      


    }
