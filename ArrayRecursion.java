/* 
* Nmae: Misha Nasir
* BU ID: U53500755
* Problem 4 
* Recursion and Arrays 
*/

public class ArrayRecursion {
    public static boolean search(Object item, Object[] arr, int start){
        if(arr == null){
            throw new IllegalArgumentException("Error! Array cannot be null");
        }
        if(arr[start]==item){
            return true;
        }
        else if(arr[start] != item && start >= arr.length-1){
            return false;
        }
        return search(item, arr, start+1);
    }

    public static String reverseArrayToString(Object[] arr, int index){
        // uses recursion to create a string of all the elements in an array, but in reverse order
        String str = "";
        if (arr == null){ // if null value is passed to the array return empty string 
            return str;
        }
        if (index == 0) {
            str = "[" + reverseArrayToString(arr, index + 1) + arr[index] + "]";
        }
        else if (index < arr.length) {
            str = reverseArrayToString(arr, index + 1) + arr[index] + ", ";
        }
        return str;
    }

    public static void main(String[] args){
        System.out.println("\n");
        Object[]arr= {"hello", "misha", "boston"};
        System.out.println(search("university", arr, 0));
        System.out.println(search("misha", arr, 0));
        String a[] = { "abc", "def", "ghi", "klm", "nop", "qrs" };
        String b[] = {"hello", "my", "name", "is", "misha"};
        String c[]={" "};
        System.out.println(reverseArrayToString(a, 0));
        System.out.println(reverseArrayToString(b, 0));
        System.out.println(reverseArrayToString(c,0));
        System.out.println("\n");
    }
}
