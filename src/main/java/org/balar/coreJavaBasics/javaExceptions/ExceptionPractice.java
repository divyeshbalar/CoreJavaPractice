package org.balar.coreJavaBasics.javaExceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionPractice {
    //Exception is the parent class of all runtime exceptions
    // Throwable is the parent class of Exception
    // Error class also derive the parent Throwable class
    //Exceptions can be handled but errors cant be handled
    
    //Exception get derived by Checked and Unchecked exceptions
    // in code, we have normal statements and critical statements
    //in case of critical statements, we have to handle the exception using try and catch
    
    //Checked exceptions can be handled and can continue to run the application

    /*
    - Throwable
        - Exception
                - Checked - when your compiler can see and predict the critical statement and force you to handle the potential exception
                    We use throws to handle or passover the responsibility of handling checked exceptions
                    - IOException // file not found
                    - SQLException
                - UnChecked - Runtime Exception -Compiler wont force you to handle the UnChecked exceptions
                    - RuntimeException
                        - ArithmenticException
                        - ArrayIndexOutofBound
                        - NullpointerException


     */
    
    
    public void run() throws IOException {
        
        try {
            int i = 1;
            int j = 12;
            int arr[] = new int[4];
            int res = j / i;
            for (i = 0; i <= 4; i++) {
                arr[i] = i + 23;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // Finally is used to free the resources to avoid memory leak.
            System.out.println("Finally gets executed in all the cases, wehter an exception is thrown or not");
        }
        System.out.println("After the exception is thrown program continues");
        
        
        //From java 1.7 onwards, Try with resources like i/o, DB connections, sockets, files etc..
        // you can create the resources inside try and no need to write catch or even finally to free up the resources
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            str = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
        // Throws keyword
        // Throws is used to suppress the error in case if  you are damn sure that the critical statements won't throw any checked exception
        // Throws is used beside method definition along with exception type
        // in the following example, i am sure that it wont throw anything
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            str = br.readLine();
        }
        
        // Throw Keyword with user defined exception
        // It is used to manually throw an exception
        int i = 0;
        int j = 1;
        try {
            if (i < j) {
                throw new UserDefinedException("I is smalled than J");
            }
        } catch (UserDefinedException e) {
            System.out.println(e.getMessage());
        }
        
        //Custom Exception
        
        
    }
}

//Writing a custom exception
class UserDefinedException extends Exception {
    
    public UserDefinedException(String message) {
        super(message);
    }
}
