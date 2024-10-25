package org.balar.coreJavaBasics.innerClasses;

//Annonymous class
@FunctionalInterface
interface E {
    public void show();
}

public class DifferentInnerClasses {
    public void run() {
        /*
         Types of Inner classes:
         1. Member Class -> just like Member var and member method, we have member class
         2. Nested Class
         3. Anonymous
         4. Lambda
         */
        
        //How to access member inner class
        A a = new A();
        A.B b = a.new B(); // new B can be accessed using object of A and B can be reffered as A.B
        b.show();
        
        //How to access nested static inner class
        C.D d = new C.D();
        d.show();
        
        //How to create and access annonymous class of Functional interface and using lambda
        // Doing following implementation add an annonymous class whihc can override or extend the behavior depending on the usage of super
        E e = () -> System.out.println("How are you!");
        e.show();
        
        
        //
        
    }
}

//Member inner class
class A {
    class B { //This is a member class which is inner class
        public void show() {
            System.out.println("Call inside the Inner Class B");
        }
    }
}

//Nested Inner class | static inner class
class C {
    static class D {
        public void show() {
            System.out.println("From inside of a nested static inner class");
        }
    }
}