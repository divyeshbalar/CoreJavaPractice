package org.balar.coreJavaBasics.abstractClassImpl;

public abstract class ParentAbstractExtension1 extends ParentAbstract{
    public abstract void extension1();
    public void addedBehavior(){
        System.out.println("In abstract class you can have normal methods with the implementation and could be accessed by the concrete object of the child class");
    }
}
