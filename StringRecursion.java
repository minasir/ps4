/* 
* Nmae: Misha Nasir
* BU ID: U53500755
* Problem 3 
* This problem implements different methods to manipulate strings via recursion 
*/

public class StringRecursion {
    // problem 1
    public static void printReverse(String str){
        // recursion to print the individual characters in the string str in reverse orde
        if(str.length() <= 1){
            System.out.print(str); 
            return;
        }
        else{
            System.out.print(str.charAt(str.length()-1));
            printReverse(str.substring(0, str.length()-1 ));
        }
        //System.out.print(str.charAt(0));
    }

    // problem 2
    public static String trim(String str) {
        // takes string and removes trailing spaces  
        if(str == " "){ // base case 
            return " ";
        }
        if(str.charAt(0) == ' ' && str.length() > 1){
            return trim(str.substring(1));
        }
        return str;
    }

    // problem 3
    public static int find(char ch, String str){
        // find and return the index of the first occurrence of the character ch in the string str
        // if(str == " "|| str == null){ // base case
        //     return -1; 
        // }
        if(str==null || str.equals("")){
            return -1;
        }
        if(str.charAt(0)==ch){
            return 0;
        }
        int result = find(ch, str.substring(1));
        if(result == -1){
            return -1;
        }
        return result + 1;
    }

    // problem 4
    public static String weave(String str1, String str2){
        // return the string that is formed by “weaving” together 
        //the characters in the strings str1 and str2 to create a single string
        String s = str1 + str2;
        if(str1 == null || str2 == null){
            throw new IllegalArgumentException("Strings cannot be null!");
        }
        if(str1.length() < 1 || str2.length() < 1){ // using  " " is giving error 
            return s; // return str1 or str2
        }
        String str =  str1.substring(0, 1) + str2.substring(0, 1) + weave(str1.substring(1), str2.substring(1));
        return str;
    }

    // problem 5
    public static int indexOf(char ch, String s){
        int methodCall = find(ch, s);
        return methodCall;
    }

    public static void main(String[] args){
        /* test for print reverse  */
        System.out.println("-------------------------");
        System.out.println("The output of printReverse is: ");
        String str = "Terriers"; 
        printReverse(str);
        System.out.print("\n");

        /* test for trim */
        System.out.println("-------------------------");
        System.out.println("The output of trim is: ");
        System.out.println(trim("recursion  "));
        System.out.println(trim(" hello world    "));
       // System.out.println("\n");

        /* test for find */
        System.out.println("-------------------------");
        System.out.println("The output of find is: ");
        System.out.println(find('b', "Rabbit"));
        System.out.println(find('P', "Rabbit"));

        /* test for weave */
        System.out.println("-------------------------");
        System.out.println("The output of weave is: ");
        System.out.println(weave("aaaa", "bbbb"));
        System.out.println(weave("hello", "world"));
        System.out.println(weave("recurse", "NOW"));
        System.out.println(weave("hello", ""));
        System.out.println(weave("", ""));

        /* test for indexOf*/
        System.out.println("-------------------------");
        System.out.println("The output of indexOf is: ");
        System.out.println(indexOf('b', "Rabbit"));
        System.out.println( indexOf('P', "Rabbit"));
        System.out.println("-------------------------");
    }
}

