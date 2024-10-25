package org.balar.coreJavaBasics.abstractClassImpl;

public class ChildAbstractionConcrete  extends ParentAbstractExtension1{

    @Override
    public void extension1() {
        System.out.println("Implementation of Extension 1 method");
    }

    @Override
    public void commonBehavior() {
        System.out.println("Implementation of common behavior from parent abstract class");
        this.addedBehavior();
    }
}
