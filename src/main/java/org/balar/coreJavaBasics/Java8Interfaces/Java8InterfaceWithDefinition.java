package org.balar.coreJavaBasics.Java8Interfaces;

public interface Java8InterfaceWithDefinition {

    default void show(){
        System.out.println("Printing from the inside of an interface: Java8InterfaceWithDefinition ");
        // If the show method is defined in both the parent interfaces than its mandatory for child class to override the show method
        // otherwise it will throw an error
    }
}

