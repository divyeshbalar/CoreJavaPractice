package org.balar.coreJavaBasics.streamPractice;

import java.util.List;

import static java.util.Arrays.asList;

public class StreamPractice {
    //Stream Concept
    /*
    1. Method Referenc
    2. forEach : internal iteration
    3. parallelStream() to achieve multithreading and parallellism in stream
    
    !IMPORTANT
    Stream has lots of methods, most of the intermediate ones are having lazy evaluation
    When terminal method are executing, they ask the intermediate methods for the result one by one.
    
    i.e.
    Intermidiate methods
    1. filter() accept Predicate object and returned filtered stream
    2. map() accept Function object and return stream
    
    Terminal Methods
    .toList() converts the result to immutable list
    .forEach accepts Consumer object and return nothing
    .findFirst() is a terminal method which return the first element found.
    .ifPresent() accepts consumer object
    .orElse(0) used to assign default value
    
    If you do not provide a terminal method in the stream statement, it will not get executed and also it wont give any error.
    The reason being the lazy evaluation
     */
    
    public void run() {
        
        List<Integer> list = asList(1, 2, 2, 4, 4, 5, 6, 6, 7, 7, 7, 87, 50, 8, 8, 98, 9);
        
        //This statement wont be executed as it does not have a terminal method
        // stream implements lazy evaluation
        list.stream().filter(i -> i % 2 == 0);
        
        //Reverse the order of the list and then Find First odd
        list.stream().sorted((o1, o2) -> o2.compareTo(o1)).filter(i -> i % 2 != 0).findFirst().ifPresent(System.out::println);
        
        //Reverse the order of the list and then Find First even number if any otherwise print 0
        list.stream().sorted((o1, o2) -> o2.compareTo(o1)).filter(i -> i % 2 == 0).findFirst().ifPresentOrElse(System.out::println, () -> System.out.println(0));
        
        
        //Map Reduce in stream
        System.out.println(list.parallelStream()
                .filter(i -> i % 5 == 0)
                .map(x -> x * 12)
                .max((o1, o2) -> o1.compareTo(o2)).toString());
//                .reduce(0, (integer, integer2) -> integer + integer2));
        
    }
}
