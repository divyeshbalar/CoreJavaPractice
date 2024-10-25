package org.balar.coreJavaBasics.Java8Interfaces;

public class Java8MutipleInterfaceExtender extends Java8ThirdRuleImplementation implements Java8InterfaceWithDefinition, Java8InterfaceWithDenition1{

    public void show() {
        Java8MutipleInterfaceExtender.super.show(); //even this will call the show of the Java8ThirdRuleImplementation because class has more precedence over default methods in interface
//        super.show();
        System.out.println("Showing from inside of Java8MutipleInterfaceExtender");
    }
}
