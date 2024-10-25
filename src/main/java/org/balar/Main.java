package org.balar;

import org.balar.coreJavaBasics.CoreJavaConcepts;
import org.balar.coreJavaBasics.multiThreading.MultiThreadingPractice;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException { //String... args is a variable argument
        System.out.println("Hello world!");
        
        CoreJavaConcepts cjc = new CoreJavaConcepts();
        cjc.run();
//
//        OopsConcepts opsObj = new OopsConcepts();
//        opsObj.run();

//        ExceptionPractice ep = new ExceptionPractice();
//        ep.run();
        
        MultiThreadingPractice mtp = new MultiThreadingPractice();
        mtp.main();

//        RunnerClass rc = new RunnerClass();
//        rc.start();

//        InterThreadComm itc = new InterThreadComm();
//        itc.start();


//        SumOfMultipleOf3And5 sumOfMultipleOf3And5 = new SumOfMultipleOf3And5();
//        sumOfMultipleOf3And5.run();

//        CollectionPractice cp = new CollectionPractice();
//        cp.run();
//
//        DifferentInnerClasses dic = new DifferentInnerClasses();
//        dic.run();

//        StreamPractice sp = new StreamPractice();
//        sp.run();

//        EulerRunner er = new EulerRunner();
//        er.run();


//        DsaRunner dr = new DsaRunner();
//        dr.run();


//        LambdaRunner lr = new LambdaRunner();
//        lr.run();
    }
}