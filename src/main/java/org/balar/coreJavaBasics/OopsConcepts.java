package org.balar.coreJavaBasics;

import org.balar.coreJavaBasics.Java8Interfaces.*;
import org.balar.coreJavaBasics.abstractClassImpl.ChildAbstractionConcrete;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Integer.valueOf;
import static java.lang.System.out;

public class OopsConcepts {

    static{
        //Static blocks execute when the class is being loaded, even before main method
        //Static block is used to initialize the static variables.
        out.println("Inside Static, which gets executed when the class is being loaded");
    }


    //Static variable is shared amongst all the instances and it resides in a common space where its accessible as a global var
    // thus its called a class variable.
    private static int temp;

    public void run(){

        // Class and objects and Constructor

        TestClass tsObject = new TestClass();
        //TestClass is the calss blueprint to create nultiple instances
        //tsObject is the reference which will be stored in the stack and pointing to the heap memory using hashcode where the instance body is present
        tsObject.show(); // calling the instance method using instance
        out.println(tsObject.count);
        // !IMPORTANT
        TestClass ts= new TestClass(5);//here "new" keyword will allocate the memory to the reference inside the heap memory
        //the TestClass() is the constructor of the class will figure out exactly how much memory to assign
        out.println(ts.count);

        // !IMPORTANT
        //In java, everything is call by value and not call by reference.
        // to achieve the call by reference, we pass the object in the method parameter; however the reference holds the hashcode only
        // so if you assign the object reference from main to customMethod(Object obj),
        // the main method stack and print stack both are having the exact same hashcode reffering to the same object in heap memory

        //###########################################------Access Modifiers------########################################
        // default public private protected final abstract

        // With class definition, you can only use default, public, abstract and final with class. however if you have a inner class then you can use private.
        // Default class can only be accessible inside the package and not outside of it.

        // With variable, you can use public private protected default and final
        // However with the methods, you can use private, public, protected, default, abstract and final

        // Anything Private is only accessible from within the class
        // Anything default can only be accessible from within the package
        // Anything protected can only be accessible by the subclass/child class
        // Anything public is accessible by all and anywhere.


        //###########################################------Static Keyword------########################################
        // static let you define a method, variable and a block which is accessible by class name or without invoking it explicitely!
        // Static methods and vars belongs to the class and not the instance; so they are called class methods/variable and not instance variable
        // Static methods are accessible using class name rather than an object of that class. and same applies to class variables
        // Static variable are considered to be a global variable.
        // !IMPORTANT Static method can only modify or work upon a static variables

        OopsConcepts.testStaticMethod();

        //Static block is on top of the class

        //###########################################------ Classloader-------#############################################
        // Classloader is the subsystem of JVM
        // JVM loads the classloader as one of the first program while compiling
        // Classloader loads the classfiles into the jvm at runtime.
        // There are multiple class loaders and they load the classes in hiearchical manner
        // Root/parent classloader is Bootstrap classloader, it loads all the classes under jre library/core classes i.e system libs or jdk libs
        // Ext  ension classloader: it loads all the extension or thirdparty jars/libs which are required for the application.
        // System classloader: this loads all the classes from the classpath i.e jdbc jar, hibernate jar, spring classes jar
        // One can create a custom classloader by using the hooks provided by the JVM, it is not common but Application Server developers,
        //          web logic,web sphere, jboss are the one who write their own custom classloaders
        // If a classloader can not find a class, it will throw class not found exception


        // How to dynamically load a class? using reflection api!
        try {
            out.println("#--------------------------------Just Messing Around with reflection API!--------------------------------#");
            Class coreJavaConceptClass = Class.forName("org.balar.coreJavaBasics.CoreJavaConcepts");
            //instanciate the object and invoke a method
            Object obj= coreJavaConceptClass.newInstance();
            Method m = org.balar.coreJavaBasics.CoreJavaConcepts.class.getMethod("isPerfectNumber",Integer.class);
            m.invoke(obj, Integer.valueOf(28));
            out.println("#--------------------------------Just Messing Around!--------------------------------#");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

 /*
        //##############################################-------Annotation--------------##############################
        // Annotations are used to annotate the intention of the method or a class or a variable/field
        // i.e @Override will let the java knows while compiling that the intention of
        // the annotated method is to override the corresponding method in the super class.
        // It also increases readability of the code by showing the intention.
        // i.e @SuppressWarnings("unchecked") used to suppress any warnings by IDE.
        // i.e @Deprecated used to indicate the intention of deprecating the method
        // i.e @FunctionalInterface which will allow only one method inside an interface: JAVA 8
        // How to create annotations?


        !IMPORTANT Annotation needs meta annotation as follows
        @Inherited // which enforces the annotation property to the child class of already annotated class
        @Target(ElementType.TYPE) // Decide the scope/level of the annotation, if its only for class or method or variable i.e: type(class and interface), method, field, constructor etc
        @Retention(RetentionPolicy.RUNTIME) // decide till when you want the new annotation to reatain. i.e source, class and runtime

        @interface AnnotationName{
            //marker annotation
        }
        //then @AnnotationName // Annotation with no variable is called a marker annotation
        @interface AnnotationSingle{
            String OS() default "windows";//OS is the variable of the annotation
            //single Value Annotation
        }
        // then @AnnotationSingle(OS="Android") // annotation with single variable Annotation is single value annotation

        @interface AnnotationMulti{
            String os(); //os is the variable of the annotation
            int version() default 1; //version is also an int type variable
            //Multi Value Annotation
        }
        // then @AnnotationMulti(os="Android", version="2") // annotation with single variable Annotation is single value annotation
 */
        //###################################---------Encapsulation----------#######################
        //Encapsulation is nothing but encapsulating your instance vars which are suppose to be private, using methods/setter/getter

        //###################################---------Inheritance----------#######################
        // Inheritance can be achieved using extends and implements keywords
        // Java does not support multiple inheritance as it can result in the diamond problem
        // However; java 8 does allow deafult method implementation in the interface which can cause the same issue
        // A->B->C is multi level inheritance
        // A->B C->B multiple inheritance is not supported
        // A->B is simple inheritance

        // In case of object creation, if the child class object is created, it will by default will call the super class constructor
        // Even if you initiate the parameterized constructor of a child class,
        //          it will still initiates the default constructor of the parent class using default super() key word.
        // If you wants to explicitely initiate the parameterized constructor, you need to explicitely write super(i,j);

        //###################################---------Polymorphism----------#######################
        // more than one behavior of a class is polymorphism
        // Types of polymorphism is overloading and overriding
        // Method Overloading: Multiple methods with the same name but different signature is called method overloading; the same applies to constructor overloading.
        // Method Overriding: same method name with same signature in a parent and child class, where child class behavior overrides the parent class behavior.

        //###################################---------Dynamic Method Dispatch----------#######################
        // Dynamic Method Dispatch helps you decide which method to invoke at the run time, helps you achieve run time polymorphism
         Parent pt = new Child();
         Child ct = new Child();
         pt.show();
         ct.show();
        // show() method is overridden.
        // dynamic method dispatch get to know which show() to call at runtime and the concept used is method overriding NOT OVERLOADING.

        //###################################-----------SUPER keyword as a constructor and as an object------------#######################
        // Super() can be use to instanciate the super class constructor.
        // all child constructor calls super() by default and it calls the default constructor of parent class.
        // you can also user super(parameters) to call a parameterized constructor of the parent class but it needs to be explicitly called.

        // Super keyword as an object
        // if parent and child class both have a same name variable,
        // and if one wants to access the variable of the super class instead of sub-class, one can use super.var;

        Parent cObj = new Child();
        cObj.show();

        //###################################-----------Final Keyword------------#######################
        // Final can be use with class method and variable

        //Final var
        final int finalVar;
        finalVar=0; // final var can only be defined only once
        //finalVar=123;// final var can not be changed once assigned.

        //Final Method
        // Final methods can not be overridden

        //Final class
        // Final class can not be inherited

        //###################################-----------This Keyword------------#######################

        //This keyword can be use to access the current instance of the object
        // Types of variables: 1> instance variable 2> local variable 3> class variable
        // 1> primitive var int float etc and 2> reference var object type


        //###################################------------Annonymous object-----------#######################
        new Parent().display();
        //If the idea of creating an object is to use only once,
        // just use the annonymous object so it does not consume any of the stack memory and only use the heap memory.
        // Other perspective is use the annonymous object: the annonymous object will be eligible for garbage collection as soon as we are done with it
        // because there is no reference linked to it.

        //###################################------------Abstraction-----------#######################
        ChildAbstractionConcrete cac = new ChildAbstractionConcrete();
        cac.commonBehavior();
        cac.extension1();

        //###################################------------Interface-----------#######################
        ParentInterface1 pInt1 = new ConcreteChildImplementsInterface();
        ParentInterface2 pInt2 = new ConcreteChildImplementsInterface();
        pInt2.display();
        pInt1.display();

        //Every method in an interface is a public abstract by default so no need to mention it.


        // Types of Interface
        // 1> Marker interface: interface with no declaration of any method
        // Why do i need marker interface?
        // to check if the class is an instanceOf a marker interace. i.e runnable, serializable, Remote etc
        if(pInt2 instanceof TestMarkerInterface){
            pInt2.display();
        } else {
          System.out.println("Its not an instace of required interface");
        }

        // 2> SAM: Single Abstract Method OR functional interface
        // 3> regular interface

        //###################################------------Anonymous Class-----------#######################

        // Invention vs Discovery
        // Invention: is when you create a concrete class and create an object to use its behavior and values
        // Discovery: is when you create an object directly from the use of interface and provide implementation on the go

        ParentInterface1 anonymousObject = new ParentInterface1(){

            @Override
            public void display() {
                System.out.println("Dynamically created Annonymous class");
            }
        };

        ParentInterface2 annonymousObj2 = () -> System.out.println("Inside annonymous object of which is using lamda to implement SAM interface");

        annonymousObj2.display();
        anonymousObject.display();

        //###################################-----------Default and static methods in JAVA 8------------#######################
        // defining a method in an interface is allowed in java 8
        Java8MutipleInterfaceExtender jmie = new Java8MutipleInterfaceExtender();
        jmie.show(); // Show is a static method inside two interfaces and one of the parent class
        // with java 8 interface can decare and define the method in interface using default command.

        // in java8, one can define a static method inside of an interface
        StaticMethodTestInJava8Interface.show();




        //###################################-----------------------#######################



        //###################################-----------------------#######################




        //###################################-----------------------#######################


        //###################################-----------------------#######################







    }

    private static void testStaticMethod() {
        //only static class variables can be modified in a static method.
        temp=10;
    }
}

class TestClass{

    //Constructor is a member method and has a same name as class name and it will never return anything, and it will be used to allocate the memory
    public TestClass(){
        //Default Constructor provided by JVM
        i = 0;
        count++;
    }

    //Parameterized constructor
    public TestClass(int i){
        this.i = i;
        count++;
    }

    //having more than one constructors with different signature is called constructor overloading just like method overloading

    int i;
    public void show(){
        out.println("Test");
        out.println(count);
    }

    static int count=0;

}

class Parent implements Cloneable{
    protected int i=0;
    public void show(){
        System.out.println(this.i);
    }
    public void display(){
        System.out.println("Inside Display");
    }

    @Override
    public Parent clone() {
        try {
            Parent clone = (Parent) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.i = this.i;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
class Child extends Parent{
    private int i=11;
    public void show(){
        super.display();
        System.out.println(super.i+this.i);
    }
}

