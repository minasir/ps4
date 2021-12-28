/*
 * Student First Name: Misha 
 * Student Last Name: Nasir
 * Student BU Number: U53500755
 * Purpose: Class written for Set 
 */

public class Set  {
    private static final int SIZE = 10; // default size of initial set

    private int[] set;      // array referece to the set
    private int size;       // current size of the set
    private int next;       // index to next available slot in the set array

    public Set() { // no arg constructor 
        this.set =  new int[SIZE];
        this.size = SIZE;
        this.next = 0;
    }

    public Set(int[] arr) {
        if(arr == null){
            throw new IllegalArgumentException("Array is Nulll");
        }
        this.next = 0;
        this.size = SIZE;
        this.set = new int[SIZE];
        for(int i = 0; i < arr.length;i++){
            this.insert(arr[i]);
        }
    }

    public boolean member(int k){
        //  Return true if n is in the set else false 
        for (int i = 0; i < this.next; i++) { 
            if(this.set[i] == k){ 
                return true;
            }
        }
        return false;
    }

    public Set clone() { 
        // returns an exact copy of this se
        Set clone = new Set();
        for(int i = 0; i < this.next; i++){
            clone.insert(set[i]);
        }
        return clone; 
    }

    public  String toString()  {
        // Return a string representation of this set
        String str = "[";
        for (int i = 0; i < this.next; i++){
            str += this.set[i];
            if(i != this.next -1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }

    public int cardinality() {
        // return the number of elements in this set
        return this.next;
    }

    public boolean isEmpty() {
        // return true if this is the empty set has no members and false otherwise.
        if(this.next == 0){
            return true;
        }
        return false;
    }

    public boolean subset(Set S) {
        // Returns true if this set is a subset of S false otherwise
        for(int i = 0; i < this.next ;i++){
            if(!S.member(set[i])) {
                return false;
            }
        }
        return true;
    }


    public boolean equal(Set S){
        // Returns true if this set and S have
   // exactly the same members.
        if(this.next == 0){
            return true; 
        }
        for(int i = 0; i < this.next; i++){
            if (this.member(S.set[i]) && this.next == S.next){ 
                return true;
            }
        }
        return false; 
    }
  
   
    public void insert(int k){
        // If the integer k is a member of the set already, do nothing, otherwise, add to the set
    if(!this.member(k)) {
        if(this.next==SIZE){
            resize();
        }
        set[this.next]= k;
        this.next++;
        this.size++;
    }
}

    public void delete(int k){
        //  If the integer k is not a member, do nothing; else remove it from the set;
        if(this.member(k)){
            for(int i=0; i < this.next;i++){
                if(this.set[i]==k){
                    this.set[i] = this.set[i+1];
                }
                else{
                    this.set[i] = this.set[i+1];
                }
              }
            this.next--;
        }
    }


    public Set union(Set S) {
        //  Return a new set consisting of all of the elements 
        Set y = this.clone();
        for(int i = 0; i < S.next ; i++) {
            y.insert(S.set[i]);
        }
        return y;
    }

    public Set intersection(Set S) {
    // Return a new set consisting of the elements that are common 
        Set x = new Set();
        for(int i = 0 ; i < this.next; i++) {
            if(S.member(this.set[i])) {
                x.insert(this.set[i]);
            }
        }
    return x;
    }

    public Set setdifference(Set S) {
        // Return a new set consistng of all the elements of this set that are not present in S.
        Set x = new Set();
        for(int i = 0; i < this.next; i++){
            if(!S.member(set[i])){
                x.insert(set[i]);
            }
        }
        return x; 
    }
       
        

    /**
     * This method reallocates the array set to twice as
     * big and copies all the elements over.
     * This method is called only by the insert method
     * when it cannot insert another element to the set.
     *
     * Note that this is the reason that in this class
     * the member size is not a class variable (i.e. static)
     * and it is not final, because the set can grow and size
     * will be modified accordingly.
     */

    private void resize() {
        size *= 2;

	// Create a new array double the size
        int[] temp = new int[size];

	// Copy all the elements from the current set
	// to the new set
        for(int i = 0; i < set.length; ++i) {
            temp[i] = set[i];
        }

	// Assign to the set reference the newly
	// resized array that represents the set.
        set = temp;
    }

}
