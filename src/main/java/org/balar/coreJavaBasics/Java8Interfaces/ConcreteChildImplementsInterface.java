package org.balar.coreJavaBasics.Java8Interfaces;

public class ConcreteChildImplementsInterface implements ChildExtendingMultipleInterface {
    @Override
    public void display() {
        System.out.println("Testing multiple to one and one to one inheritance");
    }
}
