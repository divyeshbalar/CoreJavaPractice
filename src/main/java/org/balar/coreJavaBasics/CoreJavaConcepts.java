package org.balar.coreJavaBasics;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class CoreJavaConcepts {
    
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        return (int) (IntStream.range(i, j + 1).boxed().map(x ->
                {
                    int reversedNumber = Integer.parseInt(new StringBuilder(Integer.toString(x)).reverse().toString());
                    return Math.abs(x - reversedNumber);
                })
                .filter(x -> x % k == 0).count());
        
    }
    
    //    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
//        // Write your code here
//        int len = a.size();
//        List<Integer> op = new ArrayList<>(len);
//
//        List<Integer> retList = new ArrayList<>();
//
//        for (int i = 0; i < len; i++) {
//            op.add(0);
//        }
//
//        for (int i = 0; i < len; i++) {
////            System.out.println((i + k) % len);
//            op.add(((i + k) % len), a.get(i));
//        }
//        for (int i : queries) {
////            System.out.println("op.get(" + i + ") = " + op.get(i));
//            retList.add(op.get(i));
//        }
//        return retList;
//
//    }
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        
        // Step 1: Optimize the number of rotations
        k = k % n;  // Only the remainder matters (effective rotations)
        
        // Step 2: Calculate the new start index after k rotations
        int start = n - k;  // This is the starting index of the rotated array
        
        // Step 3: Prepare result list to store the query results
        List<Integer> result = new ArrayList<>();
        
        // Step 4: For each query, calculate the corresponding value
        for (int query : queries) {
            // Compute the index in the original array based on the rotated array's view
            int rotatedIndex = (start + query) % n;
            result.add(a.get(rotatedIndex));
        }
        
        return result;
    }
    
    public void run() {
        
        // Short hand operators
        int i = 5;
        i *= 2; // i = i * 2
        byte b = 8;
        //b=b*2.5; //will return a double value and give compile time error
        b *= 127; // However using shorthand oeprator wont throw any issue
        out.println("After multiplying with a number which produces out of range Value of byte b: " + b);
        /*
        Internally when you use short hand operator, the return type of the first element will be used

        for example: byte b=8;
        b*=127; // E= E(type)*127
        the first element is b which is Byte type and the result will be casted into byte.
         */
        
        // Post and Pre increment operators
        int j = 2;
        i = j++; // post increment means First Assignment to i and then Increment
        i = ++j; // pre increment means First Increment and then assign it to the recepeint, i in this case
        
        // Bitwise Or and And
        i = 2;
        j = 3;
        int ans = i & j;//bitwise and operator IMPORTANT: & can be use to check if two numbers are same i&j==i then i and j are same
        out.println("Result of Bitwise & Operation: " + ans);
        ans = i | j;//bitwise and operator
        out.println("Result of Bitwise | Operation: " + ans);
        ans = i ^ j;//bitwise XOR operator if both are same then 0 orElse 1
        //XOR: 1=0001
        //     2=0010
        //ans= 3=0011
        out.println("Result of Bitwise ^ Operation: " + ans);
        // 1=   0001
        // 2=   0010
        // ans= 0000 //value of the answer would be 0
        
        // Bitwise leftshift and rightshift >> <<
        // leftshift will shift the binary of the number to left or right for n time
        // and add n number of zero towards left or right
        i <<= 2; // i = 0b20, after << 2 = 0b2000
        j >>= 2; // j = 0b20, after >> 2 = 0b0000
        out.println("i and j after left shift and right shift respectively: " + i + ", " + j);
        
        // Boolean or boolean
        boolean bool = false;
        out.println(bool); //need to initialise default value orlese it will show  compile time error
        
        //if else statements
        i = 3;
        if (i % 2 == 0) {
            out.println("even");
        } else {
            out.println("odd");
        }
        // &&: if both are true result is true
        // ||: if atleast one is true, the result is true
        
        //Ternary operator
        i = 20;
        String strResult = i % 2 == 0 ? "even" : "odd";
        out.println(strResult);
        
        //Switch case in java
        String s = "monday";
        s = s.toLowerCase();
        switch (s) {
            case "monday":
                out.println("day 1");
                break;
            case "tuesday":
                out.println("day 2");
                break;
            case "wednesday":
                out.println("day 3");
                break;
            default:
                out.print("Some other day!");
        }
        
        
        //Loops: initialization; conditional check; increment/decrement
        
        // While Loops Entry controlled loop
        i = 0;
        while (i < 5) {
            out.print(i);
            i++;
        }
        out.println();
        
        //Do while loop: exit controlled loop
        i = 0;
        do {
            i++;
            out.print(i);
        } while (i < 5);
        
        out.println();
        //For loop
        for (int l = 0; l < 3; l++) {
            out.print(l);
        }
        
        
        // Break: Labeled and unlabeled
        // Switch statements by default uses unlabeled break;
        
        //Labeled break
        outer:
        for (int l = 0; l < 5; l++) {
            for (int m = 0; m < 3; m++) {
                if (l == 2) {
                    break outer;
                }
                out.println(m);
            }
        }
        
        // Patterns
//           *
//          ***
//         *****
//        *******
        int row = 4; // 4 level of triangle pyramid
        int cols = (row * 2) - 1;
        for (i = 0; i < row; i++) {
            int stars = (i * 2) + 1;
            int count = 0;
//            out.println("Number of stars: "+stars);
            for (j = 0; j < cols; j++) {
                if (j <= (cols / 2) - (i + 1)) {
                    out.print(" ");
                } else if (count < stars) {
                    count++;
                    out.print("*");
                } else {
                    out.print(" ");
                }
            }
            out.println();
        }
        
        
        // holo square
        int rows = 6;
        cols = 7;
        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    out.print("*");
                } else {
                    out.print(" ");
                }
            }
            out.println();
        }
        
        // pattern of numbers
        // 1 2 3 4
        // 2 3 4 1
        // 3 4 1 2
        // 4 1 2 3
        rows = 4;
        cols = 4;
        
        for (i = 1; i <= rows; i++) {
            int k = i;
            for (j = 1; j <= cols; j++) {
                k = k % cols == 0 ? 4 : k % cols;
                out.print(k);
                k++;
            }
            out.println();
        }
        
        // Print ASCIIs
        // ASCII is 7 bit serializable; 2^7 possible values = 128 = 0-127
        out.println("Printing all ASCII Values: ");
        for (i = 0; i < 128; i++) {
            out.print((char) i);
            //out.printf("%d : %c\n", i,i);
        }
        
        //Tricks of java
        if (out.printf("\nHello World") == null) {
            //this will let you print helloworld without semicolumn
        }
        
        
        //find nth Fibbonaci number call
        out.println("Fibbonacci: " + this.fibbonaci(9));
        
        //Is the entered number is Palindrome or not
        out.println("Palindrome: " + this.isPalindrome(12321));
        
        //Is perfect number or not
        out.println("Perfect number : " + this.isPerfectNumber(28));
        
        //Is Armstrong number or not
        out.println("Armstrong number : " + this.isArmstrong(153));
        
        //Is Prime number or not
        out.println("Is this number a prime number? " + this.isPrime(81));
        
        //Swapping logics
        i = 1;
        j = 3;
        int temp;
        temp = i;
        i = j;
        j = temp;
        
        //OR
        i = 1;
        j = 3;
        i = i + j; // i=4
        j = i - j; // j=4-3=1
        i = i - j; // i=4-1=3
        
        //OR
        i = 1;
        j = 3;
        i = i ^ j;//i=1^3=2
        j = i ^ j;//j=2^3=1
        i = i ^ j;//i=2^1=3
        
        //OR
        i = 1;
        j = 3;
        j = i + j - (i = j);
        
        
        //VarArgs: variable Arguments String... args
        // if you have two methods with same name and different args;
        // the method matching the exact signature will get the preference over the var args.
        out.println(this.sum(1, 2, 3, 4, 5));
        
        
        // Method reference ::Lambda Expression
        this.lambdaExperiment();
        
        
        //String Operations
        // String in java is immutable | it uses flywait design pattern which allow reuse of a same object across multiple reference
//        Scanner sc = new Scanner(System.in);
//        out.println("Enter the two inputs one after the other:");
//        String input1 = sc.nextLine();
//        String input2 = sc.nextLine();
//
//        out.println(input1+": lenght="+input1.length()+ " Upper case="+input1.toUpperCase()+"\n"+input2+": length="+input2.length()+" Upper case="+input1.toUpperCase());
        
        String str = "Hi, there, hello, how, are , you?";
        Arrays.stream(str.split(",")).map(x -> x.trim()).forEach(out::print);
        
        // StringBuffer and StringBuilder
        //StringBuffer is threadsafe and StringBuilder is not threadsafe[No synchronization]
        StringBuffer sbf = new StringBuffer("Divyesh Balar");
        sbf.append(" Java Geneius");
        sbf.replace(8, 13, "BALAR");
        sbf.delete(8, 13);
        out.println("\n String Buffer: " + sbf + " char at function " + sbf.charAt(8));
        
        
        //Wrapper classes
        // AutoBoxing and AutoUnboxing
        // premetive Data type: char int float doule byte
        // Wrapper: Integer, Float, Double, etc...
        i = 102;
        Integer ii = Integer.valueOf(i);//Boxing
        Integer jj = i; //Auto-Boxing
        
        j = jj; // Integer to int Auto-UnBoxing
        i = jj.intValue(); // Unboxing
        
        // this wrapper classes are used in collections and autoboxing and auto unboxing is used extensively there.
        
        
        //Copy/clone object | Object Cloning
        //1> Shallow Copy -> 1 object reffered by 2 reference
        Object a = new Object();
        Object aShallowCopy = a;
        //Object a and aShallowCopy both reffers to the same object in the heap memory; so if a change any internal of it, it will be reflected in the aShallowCopy
        
        //2> Deep Copy -> copying the source object and its values to the target object manually
        // two saperate stack entry of reference and reffering to two different object in heap.
        Parent pSource = new Parent();
        pSource.i = 12;
        Parent pTarget = new Parent();
        pTarget.i = pSource.i;
        
        //3> Cloning -> using clone method of Clonnable interface which needs to be overriden by the source class and must implement clone() method.
        Parent pSource1 = new Parent();
        pSource1.i = 123;
        Parent pTarget1 = pSource1.clone();
        System.out.println("Cloned object pTarget1 = i = " + pTarget1.i);
        
        
        //#################---------File Handling in java-----------------####################
        
        try {
            // Write in a file
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("test.txt"));
            dos.writeUTF("Hi Hello How Are you?");
            
            //Read from a file
            DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
            String strFile = dis.readUTF();
            
            System.out.println(strFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        Complex d1 = new Complex();
        
        // d2 is reference variable of class Demo that
        // points to object of class Sample
        Complex d2 = new Sample();
        
        // But here method will be call using type of
        // reference
        // for static methods with same signature in both base and sub class; the method of a reference type will be called as mentioned below
        d1.f1();
        d2.f1();
        
        // for overriding of a normal method, the method of an object will be called
        d1.f2();
        d2.f2();
        
        // conclusion is, in class method, method will be called for whatever is the class type mentioned and NOT the actual instance type
        // for method overriding, the actual onject instace will call its own method implementation
        
        System.out.println("TESTSSSS: " + beautifulDays(20, 23, 6));
        System.out.println(CoreJavaConcepts.circularArrayRotation(Arrays.asList(1, 2, 3), 2, Arrays.asList(0, 1, 2)));
        
    }
    
    @Override
    public String toString() {
        //By default if we dont override the toString method, it uses the one from the Object class and returns the Integer.toHexString(hashCode())
        return "Printing the toString from CoreJavaConcepts class" + this.isPalindrome(12321);
        
    }
    
    private void lambdaExperiment() {
        List<String> names = Arrays.asList("Divyesh", "frank", "Yash", "Nitin");
        //calling enhanced for loop
        out.println("Iterating through names list using enhanced for loop: ");
        for (String name : names) {
            out.print(name + " ");
        }
        
        //Using forEach
        out.println("Iterating through names list using forEach method and assigning the consumer object: ");
        Consumer<String> cons = new Consumer<>() {
            @Override
            public void accept(String s) {
                out.print(s + " ");
            }
        };
        names.forEach(cons);
        
        //now the consumer is a functional interface, it can be written using labda
        out.println("Iterating through names list using forEach method and assigning the consumer's accept(String s) implementation using Lambda : ");
        names.forEach(name -> out.println(name));
        
        //passing a function to a function is called higher order function i.e forEach(println)
        // "::" is use to refer the method as a method and not a variable
        // for ex: this.sum(i); where compiler will by default consider the i as a variable and '::' is use to inform the compiler that its a method.
        out.println("Iterating through names list using forEach method and using the method reference:  ");
        names.forEach(out::println);
        
        names.forEach(this::printTheString);
        
    }
    
    private void printTheString(String s) {
        if (s.length() > 4) {
            out.println(s.toUpperCase());
        } else {
            out.println(s.toLowerCase());
        }
    }
    
    private int sum(int... args) {
        return Arrays.stream(args).reduce(0, Integer::sum);
    }
    
    private boolean isPrime(int num) {
        
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isArmstrong(int n) {
        //A number is an armstrong number if the sum of the qube of each digit in that number equals the number
        int sum = 0;
        while (n > 0) { //153
            int remainder = n % 10;// 3
            n = n / 10;// 15
            out.println(remainder);
            out.println(n);
            sum = sum + (remainder * remainder * remainder); // 3^3 = 27,
            out.println("sum = " + sum);
        }
        return sum == n;
    }
    
    
    public int fibbonaci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibbonaci(n - 1) + fibbonaci(n - 2);
    }
    
    public boolean isPalindrome(int n) {
        
        int temp = n;//123
        int remainder = 0;
        int res = 0;
        while (n > 0) {
            remainder = n % 10; // 3, 2, 1
            n = n / 10;//12, 1, 0
            res = (res * 10) + remainder;//3, 30+2=32, 320+1=321
        }
        return res == temp;
        
    }
    
    public boolean isPerfectNumber(Integer n) {
        //perfect number are the numbers whos sum of the all factors EXCLUDING itself is same as the number itself;
        if (n <= 0) {
            return false;
        }
        int factor = 1;
        int sum = 0;
        while (factor <= n / 2) {
            if (n % factor == 0) {
                sum += factor;
            }
            factor++;
        }
        out.println("Sum of all the factor of given number is: " + sum);
        return sum == n;
    }
    
    
}

// Java program to demonstrate
// method Hiding in java

class Complex {
    public static void f1() {
        System.out.println(
                "f1 method of the Complex class is executed.");
    }
    
    public void f2() {
        System.out.println(
                "f2 method of the Complex class is executed.");
    }
}

// class child extend Demo class
class Sample extends Complex {
    public static void f1() {
        System.out.println(
                "f1 of the Sample class is executed.");
    }
    
    public void f2() {
        System.out.println(
                "f2 method of the Sample class is executed.");
    }
}

