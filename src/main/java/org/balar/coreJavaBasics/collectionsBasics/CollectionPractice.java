package org.balar.coreJavaBasics.collectionsBasics;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionPractice {
    
    public void run() {
        
        //Using System.currentTimeMillis()
//        long startTime = System.currentTimeMillis();
        
        
        /*
        ArrayList vs LinkedList
        ArrayList is implemented using the concept of dynamic array
        LinkedList is implemented using the concept of double linkedlist where there is a node, previous and next pointer
        
        ArrayList is Faster in retrieval/search/fetch of a value at a specific index
        However; it is super slow in adding values to the middle of the arraylist
        because we need to move up or down depending on you add or remove a value and update all the index numbers
        ArrayList increases the capacity of the list by 50%
        
        Whereas LinkedList is slow in search as the iterator has to go through each node until it get to the right one
        However; LinkedList is super quick in adding the value in between nodes.
         */


//        List<Integer> listOfInt = new ArrayList<>(IntStream.generate(() -> (int) (Math.random() * 120)).limit(120).boxed().toList());

//        System.out.println("UnSorted Random List: " + listOfInt);
//
//        //Finding Unique set from list
//        listOfInt = new ArrayList<>(new TreeSet<>(listOfInt).stream().toList());
//        System.out.println("Unique List: " + listOfInt);
//
//        listOfInt.sort((o1, o2) -> o1 < o2 ? -1 : 1); // Sorting using Comparator interface but using Lambda
//        System.out.println("ASC Sorted List: " + listOfInt);
//
//        listOfInt.sort(new ComparatorImpl()); // Sorting using Comparator interface but using Lambda
//        System.out.println("DESC Sorted List: " + listOfInt);
        
        List<Integer> listOfInt = new LinkedList<>(IntStream.range(0, 100).limit(100).boxed().toList());
        System.out.println(listOfInt);
        System.out.println(listOfInt.stream().max(Comparator.naturalOrder()));
        //################-------------Sorting of custom object using Comparator-------------------#################

//        List<Student> listOfStudents = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            listOfStudents.add(new Student(i, UUID.randomUUID().toString()));
//        }
//        System.out.println("Initital List of ids");
//        for (Student s : listOfStudents) {
//            System.out.println(s.id);
//        }
//
//        //reverse ordering of student list based on id number
//        System.out.println("Reversing the List of ids using comparator functional interface");
//        Collections.sort(listOfStudents, (o1, o2) -> o1.getId() > o2.getId() ? -1 : o1.getId() < o2.getId() ? 1 : 0);
//        for (Student s : listOfStudents) {
//            System.out.println(s.id);
//        }
//        //Using comparable interface
//        System.out.println("Natural ordering the List of ids using comparable Interface and compareTo Method");
//        Collections.sort(listOfStudents);
//        for (Student s : listOfStudents) {
//            System.out.println(s.id);
//        }
        
        
        //################-------------Map Interface-------------------#################
        /*
        it is a key value pair, let you define the dictionary
        Map gets implemented by following classes:
        1. HashMap -> introduced in 1.2, faster, Not Synchronized,  works with single thread and allows one null key, insertion order is not fixed
        2. Hashtable -> exist since 1.0, slower, Synchronized, works with multiple threads and do not allow null key. insertion order is not fixed
        3. TreeHashMap -> Hashmap but in sorted format
        4. LinkedHashMap -> insertion order is fixed
        
        HashMap implements Map<K,V> and is not a threadsafe solution
        HashTable ThreadSafe
        Entry Api is internal interface of Map interface
        
         */
        System.out.println("\n\nTesting Map HashMap");
        Map<Integer, String> mapOfStudent = new HashMap<>();
        mapOfStudent.put(0, "Frank");
        mapOfStudent.put(1, "Nitin");
        mapOfStudent.put(2, "Neysa");
        mapOfStudent.put(2, "Divyesh"); //duplicate Override
        
        // How to remove the element while iterating/traversing over the hashmap in java?
        Iterator itr = mapOfStudent.entrySet().iterator();
        
        while (itr.hasNext()) {
            Map.Entry current = (Map.Entry) itr.next();
            if (current.getKey().equals(2)) {
                itr.remove();
            }
        }
        
        //retreving the names using id keys
        // map.keySet() is used to get the set of keys
        for (Integer key : mapOfStudent.keySet()) {
            System.out.println(mapOfStudent.get(key));
        }
        
        
        System.out.println("\n\n Map HashMap");
        //Map.Entry : Entery is a nested interface inside Map
        Set<Map.Entry<Integer, String>> values = mapOfStudent.entrySet();
        for (Map.Entry<Integer, String> e : values) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
//
//        //Find duplicate elements in a list
//        List<String> listOfNames = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter names: ");
//
//        for (int i = 0; i < 5; i++) {
//            listOfNames.add(sc.nextLine());
//        }
//
//        Set<String> setOfNames = new HashSet<>();
//        for (String s : listOfNames) {
//            if (!setOfNames.add(s)) {
//                System.out.println("Duplicate: " + s);
//            }
//        }
//
        
        //Testing System.currentTimeMillis()
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time it took to run till here: " + (endTime - startTime));
        
        
        //Random class usage
//        List<Integer> litOfitems = new ArrayList<>();
//        Random r = new Random();
//        for (int i = 0; i < 10; i++) {
//            litOfitems.add(r.nextInt(100));
//            System.out.println(litOfitems.get(i));
//        }
        
    }
}


class Student implements Comparable<Student> {
    int id;
    String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
    
    @Override
    public int compareTo(Student o) {
        return this.getId() - o.getId();
    }
}
