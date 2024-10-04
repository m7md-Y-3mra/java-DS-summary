import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        /*
        !Data Structure
            1. collection of data {organized} in some (fashion as stack, queues, priority queue, ----)
            2. not only stores data but also {supports operations} for accessing and manipulating the data

        !Java collection framework hierarchy
            - container of all collection in data structure
            - container of object that holds a group of objects, often refferred to as elements
        
            ? supports types of collection
                * 1. collection => storing a collection (chapter20)
                * 1. map => storing key/value pairs (chapter 21)
            
            todoe => open the slides the look in the graph
                all of collection inhernt of collection interface, that means all collection have all function in collection interface etc.

        !the collection interface
            ?1.  have the function=> (not have implementaion)
                {add addAll, remove removeAll, contains containsAll, returnAll, clear, IsEmpty, size, toArray}

                + add(e: E): boolean                              => add new element 
                + addAll(c: collection <? extends E>): boolean    => add all element in the collection c in this collection

                + remove(o: object): boolean                      => remove element o //not remove from index
                + removeAll(c: collection<?>): boolean            => remove all the elements in c from this collection 

                + contains(o: object)                             => true -> if the collection contain (element [o = object])
                + containAll(c: collection<?>): boolean           => true -> if this collection contain all the element in c 

                + retainAll(c: collection<?>): boolean            => return the elements that are both in two collection

                + clear(): void                                   => remove all element
                + IsEmpty() :boolean                              => true -> no elements
                + size(): int
                + toArray(): object[]                             => when change to array you lost element, and the size be fixed

            ?2. extend iterable<E> interface => increse number of fun. in collection
                ?have funs
                1. iterator() : iterator<E> => return iterator<E> object
                    *Iterator<E>
                        classic {design pattern} for {walking through a data structure => tarversing the all element in DS} {without having to expose the detils of how data is stored in the data structure => any collection stack, queue ... have hasNext fun to know if element , next to element}

                        all collections in java has itertor because collection extend eterabel that make compsite relationship with [Iterator<E>]
                        1. have funs.
                            + hasNext() : true => if iterator has more elements to traverse
                            + next()    : E    =>  return the next element from this iterator
                            + remove    : void => remove the last element obtained using the next method<
                
                2. forEach(action: consumer<? super E>) 
                    java8 add a new forEach method in Iterable interface
                    loop + make وظيفة معينة

                    -------==========> Exercises OF Collection funs <==========------- */
                System.out.println("-------==========>  Exercises OF Collection funs <==========-------");

                // declare first collection
                ArrayList<String> collection1 = new ArrayList<>();

                //**** use collection funs ****
                // add fun
                collection1.add("New York");
                collection1.add("Atlanta");
                collection1.add("Dallas");
                collection1.add("Madison");

                //print the first collection
                System.out.println("A list of cities in collection1: ");
                System.out.println(collection1);

                
                // contain fun
                    System.out.println("\nIs Dallas in collection? " + collection1.contains("Dallas"));

                // remove fun
                    collection1.remove("Dallas");
                    System.out.println("\nsize collection after remove: " + collection1.size());

                // declare other collection
                    Collection<String> collection2 = new ArrayList<>();

                // add fun
                    collection2.add("Seattle");
                    collection2.add("Portland");
                    collection2.add("Los Angles");
                    collection2.add("Atlanta"); // the common between two collections
                
                // print second collection
                    System.out.println("\nA list of cities in collection2: ");
                    System.out.println(collection2);

                // make clone from collection1 => copy element in othe collection, not copy refernce
                    ArrayList<String>  collection3 = (ArrayList<String>)(collection1.clone()); //** foucs in this
                    // other way to element in other collection
                    //collection3 = new ArrayList<>(collection1);

                // add All fun
                    collection3.addAll(collection2); // elements in collection3 = elements in collection1 + elements in collection2

                // print collection3
                    System.out.println("\nCities in collection1 or collection2");
                    System.out.println(collection3); //observe the Atlanta repeate twice

                // to reset the element in collection3 to repeat .... make clone 
                    collection3 = (ArrayList<String>)(collection1.clone());
                
                //  retainAll fun
                    collection3.retainAll(collection2); // return the common between them (Atlanta)
                    System.out.println("\nCities in collection1 and collection2: ");
                    System.out.println(collection3);

                //remove All 
                    collection3 = (ArrayList<String>)(collection1.clone());
                    System.out.println("\ncollection2: " + collection2);
                    System.out.println("collection3: " + collection3);
                    collection3.removeAll(collection2); //remove the common between them (Atlanta)
                    System.out.println("Cities in collection1, but not in collection2");
                    System.out.println(collection3);

                    /*-------==========> Exercises OF Iterator<E> <==========------- */
                    //make iterator
                        Iterator<String> iterator = collection3.iterator(); //iterator() is fun in iterable interface return Iterator<E>, Iterator<E> => object can loop عليه  
                    
                    System.out.println("\n\niterator: ");
                    while(iterator.hasNext()) {
                        System.out.print(iterator.next().toUpperCase() + " ");
                    }

                    System.out.println();

                    /*-------==========> Exercises OF forEach() <==========------- */
                    // lambda expersion
                    System.out.println("\n\nforEach: ");
                    collection3.forEach(e -> System.out.print(e.toUpperCase() + " "));
                    System.out.println();

                    // you can use forEach loop but the best first
                    for(String e: collection3) {
                        System.out.print(e.toUpperCase() + " ");
                    }
                    
/*      
        !The List Interface (index)
        **** Properties & Methodes ****
            ? store elements in sequential order
            ? extend the collection interface => has all fun. in collection
            ? store element => index
                but the list make overLoad fun (add, addAll, remove)
                    add(index int, element Object): boolean                => add at specified index
                    addAll(index: int, c: collection<? extend E>): boolean => all all the element in c at specified index
                    remove(index: int): E                                  => remove element at specified index
                                                                                but the collectin remove(object)


            ? acess element => index
                get(index: int): E                       => return element at specified index
                set(index: int, element: Object): Object => set element at specified index  
                
            ? acess index => element
                indexOf(element: object): int   => search of the index  
                lastIndexOf(element: object): int => serrch of the last index of element

            ? other function
                listIterator(): listIterator<E> =>
                listIterator(startIndex: int): listIterator<E>
                subList(fromIndex: int, toIndex: int): list<E> => from included, to excluded last not be in list as  string

                    *list List Iterator
                    extend iterator interface => have the fun. in iterator (hasNext, next, remove) +
                    - add (element: E) :void
                    - hasPervious() :boolean
                    - nextIndex(): int
                    - Pervious(): E
                    - PerviousIndex(): int
                    - set(element: E): void

                    - iterator walk in front, List Iterator can walk front and back
                    - have iterator(front -> next, hasNext) + walk back(hasPervious, Pervious)
                    
                    list Iterator is [loop front iterator(next, hasNext)] + [loop back +(hasPervious, Pervious)]


                ? difference between ArrayList and LinkedList
                ArrayList => extend {AbstractList}
                    {AbstractList} => (implement List and extends AbstractCollection(implement Collection)

                linkedList => extend {AbstractSequentialList} and implement {Deque} 
                    AbstractSequentialList => (extend {AbstractList}) 
                        {AbstractList} => (implement List fun. and extends AbstractCollection(implement Collection)


                size list can grow or shrink dynamically 
                    if you need to support random access through an index without inseting or removing elements from any place => ArrayList
                    if you need to support random access through an index with inseting or removing elements from any place => LinkedList
                fixed 
                    does not require insertion or deletion of elements => array
                
                *ArrayList
                    implement list extend collection
                    ArrayList() => empty list with the default initial capacity
                    ArrayList(c: collection<? extends E>) => array list from an existing collection
                    ArrayList(initialCapacity: int) => create empty list with the specified initial capacity
                    trimToSize():void => trims the capacity of this ArrayList instance to be the lists current size

                *linkedList
                    LinkedList()
                    LinkedList(c: collection<? extends E>)
                    addFirst(o: E): void => add to the head
                    addLast(o: E): void  => add to the tail
                    getFirst(): E        => return head
                    getLast(): E         => return tail
                    removeFirst(): E     => remove head
                    removeLast(): E      => remove tail
                -------==========>  Exercises ArrayList & linkedList <==========------
 */
                System.out.println("-------==========>  Exercises ArrayList & linkedList <==========-------");
                List<Integer> ArrayList1 = new ArrayList<>();
                ArrayList1.add(1);
                ArrayList1.add(2);
                ArrayList1.add(3);
                ArrayList1.add(4);
                ArrayList1.add(5);
                ArrayList1.add(0, 10); // as addFirst but not have fun
                ArrayList1.add(3, 30);
                    //you work arryList as linkedList about add index = addFirst, addLast
                System.out.println(ArrayList1);

                LinkedList<Object> linkedList1 = new LinkedList<>(ArrayList1); //as clone, I make this way when diff. type
                linkedList1.add(1, "red"); 
                linkedList1.removeLast();
                linkedList1.addFirst("green"); // add(0, "green")

                System.out.println(linkedList1);

/*
        !Comparator Interface

            ? ************************************************************************
            ?           |                               |
            ?           |        Comparable             |       Comparator
            ?           |                               |
            ? *************************************************************************
            Package     |java.lang                      | java.util
            --------------------------------------------------------------------------
            mean        |قابل للمقارنة                  | j المقارن 
            --------------------------------------------------------------------------
            type        | interface                     | interface
            --------------------------------------------------------------------------
            method      | compareTo(object o)           | compare(object o1, object o2)    
            ---------------------------------------------------------------------------
            method      | داخل الكلاس                    | j كلاس خارجي    
            ---------------------------------------------------------------------------
            
            
            ?Sort
            in any sort operation, I need thing Accordingly compare to make sort
                1. make algorithm sort by self  
                    EX: bubble sort, .....
                
                2. sort by java sort methodes
                    how to tell java sort Accordingly?
                        by compartor interface, I implement part of algorthim(compareTo) not all algorithm

                -------==========>  Exercises Compartor <==========------
*/  
                System.out.println("-------==========>  Exercises Compartor <==========------");
                //java has many way to make sort
                    //1. Collections.sort
                    ////2. Array.sort في نفسي منها شئ
                    //3. collection(arraylist, linkedlist).sort

                // I have many to way to make Compartor
                    // 1. create class implement Compartor interface
                    ArrayList<Student> arrayList2 = new ArrayList<>();
                    arrayList2.add(new Student(101,"Vijay",23));  
                    arrayList2.add(new Student(106,"Ajay",27));  
                    arrayList2.add(new Student(105,"Jai",21)); 

                    //sorting by Age
                    AgeComparator ageComparator1 =  new AgeComparator();
                    Collections.sort(arrayList2, ageComparator1);
                    System.out.println("\n\nSorting By Age");
                    System.err.println(arrayList2 + "\n");

                    //sorting by Name
                    NameComparator nameComparator1 =  new NameComparator();
                    arrayList2.sort(nameComparator1);
                    arrayList2.sort(nameComparator1);
                    System.out.println("\n\nSorting By Name");
                    System.err.println(arrayList2 + "\n");

                // 2. lambda expersion
                    //A. 
                        //sorting by Age
                        Comparator<Student> ageComparator2 =  (Student o1, Student o2) -> {Student s1=(Student)o1;  
                            Student s2=(Student)o2;  
                            
                            if(s1.getAge() == s2.getAge())  
                                return 0; 
                    
                            else if(s1.getAge() > s2.getAge())  
                                return 1; 
                    
                            else  
                                return -1;};
                        Collections.sort(arrayList2, ageComparator2);
                        System.out.println("\n\nSorting By Age");
                        System.err.println(arrayList2 + "\n");

                     //B.
                        //sorting by Age
                        Collections.sort(arrayList2, (Student o1, Student o2) -> {Student s1=(Student)o1;  
                            Student s2=(Student)o2;  
                            
                            if(s1.getAge() == s2.getAge())  
                                return 0; 
                    
                            else if(s1.getAge() > s2.getAge())  
                                return 1; 
                    
                            else  
                                return -1;});
                        
                        System.out.println("\n\nSorting By Age");
                        System.err.println(arrayList2 + "\n");
                        
                // 3. Method Referance
                    // sorting by Name
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    arrayList3.add("moahmmed");
                    arrayList3.add("ali");
                    arrayList3.add("ahmed");
                    arrayList3.add("yasser");
                    Collections.sort(arrayList3, String::compareToIgnoreCase);
                    System.out.println("\n\nSorting By Name");
                    System.err.println(arrayList2 + "\n");

        /*
            !Vector & Stack 
            !Vector
                + in java2
                + Not recommended to use, is replaced by the ArrayList
                + the array list and vector in the same level in the graph(brother)
                + Not effieient for most of the application
                + we study vector because
                    - the old java code
                    - stack extend vector
            
            !Stack
                + LIFO (last-in-first-out)
                + has fun.
                    - stack()
                        - empty(): boolean      => true: if stack empty
                        - peek(): E             => return the top element is stack
                        *- pop(): E              => removes the top element is this stack
                        *- push(o: E): E         => adds a new element to the top of this stack
                    - search(o: Object): int    => returns the position of the specified element is this stack
                
            !Queues & Priority Queues 
            !Queues
                + interface
                *+ have only two concrete classes (LinkedList, Priority Queues)
                + FIFO (first in first out)
                + appended to the end of the queue and are removed from the beginning
                + has funs. (all funs. return the E element)

                    *- offer(element: E): boolean => insert the element

                    *- poll(): E => remove the head of queue
                            throw exception if this queue is empty
                    - romove(): E => remove the head of queue
                            throw exception if this queue is empty

                    *- peek(): E => retrieves but does not remove
                                    returing null if this queue is empty
                    - element(): E => retrieves but does not remove
                                    throw exception if this queue is empty

                    Stack: push, pop, peek    || Queue: offer, poll, peek           Priority Queues
                        : remove and all last ||        : remove first add last  || remove priority element, add last
            !Priority Queues
                + extend Queues
                + elemetns are assigned priorities
                + the element with the highest priority is removed first
                + hava funs.
                    - PriorityQueue()
                    - PriorityQueue(initialCapcity: int)
                    - priorityQueue(c: collection<? extends E>)
                    *- priorityQueue(initialCapacity: int, comparator: Comparator<? super E>)
                        |_ by comparator parameter can determine the way of Peiority
                            you can use collections.reverseOrdres to make Periority letter reverse
                            but the defualt is comparTo
                
                todo Note: if you make Priority Queues from class you created you must in class implement compareTo method or compartor
                -------==========>  Exercises Queues & Priority Queues <==========------
                
         */

        System.out.println("-------==========> Exercises Queues & Priority Queues <==========------");
        Queue<Integer> queue1 = new LinkedList<Integer>();// must declare linkedlist or priority queues becuase have only two concrete classes (LinkedList, Priority Queues)
        queue1.add(1); //because queue extend collection
        queue1.add(6);
        queue1.add(3);
        queue1.offer(4); //fun in queue interface
        System.out.println(queue1);   // 1 6 3 4
        int first = queue1.poll();    // retrieve and remove the first element
        System.out.println(first); // 1
        System.out.println(queue1);   // 6 3 4   
                
        
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>(); //stirng aleady have compareTo method 
        priorityQueue1.offer("mohammed");
        priorityQueue1.offer("ali");
        priorityQueue1.offer("yasser");  

        System.out.println("\n\nPriorityQueue using Comparable: ");
        System.out.println(priorityQueue1);
        System.out.println();

        // if you want to arrange element by other way use othe construcer by using compartor
        PriorityQueue<String> priorityQueue2 = new PriorityQueue<>(3, Collections.reverseOrder());
        priorityQueue2.offer("mohammed");
        priorityQueue2.offer("ali");
        priorityQueue2.offer("yasser");
        
        System.out.println("\n\nPriorityQueue using Compartor: ");
        System.out.println(priorityQueue2);

        // if you want to print priorityQueue by for or while  by peek
        for(int i = 0; i < priorityQueue1.size(); i++ ) {
            System.out.print(priorityQueue1.peek() + " ");
        }
        System.out.println();
        // this is wrong because peek is fixed in priorityQueue1 henc
        //if you want to print priorityQueue by for or while by remove because move the after element
        for(int i = 0; i < priorityQueue1.size(); i++ ) {
            System.out.print(priorityQueue1.remove() + " ");
        }
        //i < priorityQueue1.size() => this condtion is wrong because the size in every loop change
        // the correct priorityQueue1.size() > 0 
        for(int i = 0; priorityQueue1.size() > 0; i++ ) {
            System.out.print(priorityQueue1.remove() + " ");
        }

        //**make PriorityQueue of object -> the class of object must implement comparable interface or use compartor in constructor

        PriorityQueue<Student> priorityQueue3 = new PriorityQueue<>(3, new NameComparator());
        priorityQueue3.offer(new Student(5, "ali", 25));
        priorityQueue3.offer(new Student(6, "ahmad", 28));
        priorityQueue3.offer(new Student(7, "omer", 15));
        System.out.println("\n\n PriorityQueue of objects");
        System.out.println(priorityQueue3);

        // ستاك يرث من لست فهو مش طبيعي فكل خصائص لست فيه من إضافة بواسطة الندكس وزيادة فانتبه له رعاك الله 
        Stack<String> stack1 = new Stack<>();
        stack1.add("mohammed");
        stack1.add("ali");
        stack1.add("yassser");
        for(int i = 0; i < stack1.size(); i++) {
            System.out.println(stack1.get(i));
        }

        stack1.add(0, "alaa");
        System.out.println(stack1);


        /*
            !Evaluating Expressions case stduy
        
        
         */

        /*
        !The Set Interface(Unique)
            - extend collection interface
            - does not introduce new mehtods or constants
            - the concrete classes that implement Set must ensure that no duplicate elements can be added to the set
            - open slides in Set interface hierarchy
            *- has three concrete classes (HashSet, LinkedHashSet, TreeSet)

            ?AbstractSet class
            + is an abstract class
            + all concrete classes (HashSet, LinkedHashSet, TreeSet) implement this class
            + extend AbstractCollection and implement Set (open the slide and look in graph)
            + provides concrete implementaions  
                - equals mehtod
                - hashCode mehtod
                    الخاص بهhashcode يدخل الرقم في معادلة نتاجها يكون رقم صغير والهدف من ذلك فحص أي ملف كبير لم يجدث عليه تغيرات من خلال مقارنته ب 
            + methodes not implemented
                - size methode => from collection
                - iterator     => from collection
            
            !HashSet Class
            + It does not maintain the order of the data
            + concrete class that implements set
            + used to store duplicate-free elements
            + has funs.
                - HashSet()
                - HashSet(c: collection<? extends E>)
                - HashSet(initialCapacity: int)
                *- HashSet(initialCapacity: int, loadFactor: float)

            !LinkedHashSet
            + maintain the order of the data
            + has funs.
                - LinkedHashSet()
                - LinkedHashSet(c: collection<? extends E>)
                - LinkedHashSet(initialCapacity: int)
                *- LinkedHashSet(initialCapacity: int, loadFactor: float)
            
            !SortedSet interface and TreeSet class
            !SortedSet
            + subinterface of set
            + guarantees that the elements in the set are sorted
            !TreeSet
            + data sorted by ......
            + concrete class that implements the sortedSet interface
            + if you create TreeSet of object you must implement comparable interface or compartor if dont like sorted
            + has funs.
                - TreeSet()
                - TreeSet(c: collection<? extends E>)
                ?- TreeSet(comparator: comparator<? super E>)
                *- TreeSet(s: sortedSet<E>)
            
            لو مش حاب ترتيب أي كلاس أو ليس له ترتيب استخدم compartor
         */
        //HashSet
        Set<String> hashSet1 = new HashSet<>();
        // Add strings to the set
        hashSet1.add("London");
        hashSet1.add("Parise");
        hashSet1.add("New York");
        hashSet1.add("San Francisco");
        hashSet1.add("New York"); // add twice

        System.out.println("\n\n HashSet: ");
        System.out.println(hashSet1);

        //print by forEach function
        hashSet1.forEach(e -> System.out.print(e.toLowerCase() + ""));
        System.out.println();

        //print by enhanc forEach function
        for(String n: hashSet1) {
            System.out.print(n + " ");
        }

        //print by iterator() forEach function
        Iterator itr = hashSet1.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        //LinkedHashSet
        LinkedHashSet<String> linkedHashSet1 = new LinkedHashSet<>();
        linkedHashSet1.add("London");
        linkedHashSet1.add("Parise");
        linkedHashSet1.add("New York");
        linkedHashSet1.add("San Francisco");
        linkedHashSet1.add("New York");
        //print
        linkedHashSet1.forEach(e -> System.out.print(e.toLowerCase() + " "));
        System.out.println();

        // TreeSet
        TreeSet<String> treeSet1 = new TreeSet<>(hashSet1);
        System.out.println("Storted tree set: " + treeSet1);

        //use method in sortedSet interface 
        System.out.println("first: " + treeSet1.first()); //the first element
        System.out.println("last: " + treeSet1.last()); //the last element
        System.out.println("headSet (\"New York\"): " + treeSet1.headSet("New York")); //firstSet to New York, newyork not included 
        System.out.println("tailSet (\"New York\"): " + treeSet1.tailSet("New York")); //firstSet to New York

        //use the methodes in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet1.lower("P")); // أصغر منها
        System.out.println("higher(\"P\"): " + treeSet1.higher("P")); // أكبر منها
        System.out.println("floor(\"P\"): " + treeSet1.floor("P")); // أصغر منها
        System.out.println("ceiling(\"P\"): " + treeSet1.ceiling("P")); // أكبر منها
        System.out.println("pollFirst(): " + treeSet1.pollFirst()); //remove first
        System.out.println("pllLast(): " + treeSet1.pollLast()); //remove last
        System.out.println("\n\n TreeSet: " + treeSet1);

        //TreeSet with compartor
        TreeSet<String> treeSet2 = new TreeSet<>(Collections.reverseOrder());
        treeSet2.addAll(treeSet1);
        System.out.println("treeSet with compartor: " + treeSet2);

        //TreeSet in colloge
        TreeSet<MyCar> treeSet3 = new TreeSet<>();
        treeSet3.add(new MyCar("ali", 1998));
        treeSet3.add(new MyCar("mohammed", 2000));
        treeSet3.add(new MyCar("yasser", 2002));
        System.out.println("\n\n TreeSet3: " );
        System.out.println(treeSet3);

        LinkedHashSet<MyCar> linkedHashSet2 = new LinkedHashSet<>(treeSet3);
        linkedHashSet2.add(new MyCar("ali", 1998));
        linkedHashSet2.add(new MyCar("mohammed", 2000));
        System.out.println("\n\n linkedHashSet2: " );
        System.out.println(linkedHashSet2);
            //we have a problem when add two same object the set add two but because it is set has not same object only in hash set and hashlinkedset not in treeset
            // I solve the problem by select name class and select create hash code only 😁
            //deep understing this point later

        
        //todo note: add in treeSet depend in compartor, EX: GeometricObjectCompator in video   

        //Set List Performance Test
        // LinkedList > ArrayList > treeSet > hasSet, linkedHashSet  
        /*
        !Map Interface (key, value + unique or reset)
            مثل ست ولكن بدل كل عنصر فيها عبارة قيمة فقط ، كل عنصر عبارة عن قيمة وكي
            + not deplicated entry 
            + maps keys to the elements
            + keys like indexes
            + in list the indexes are integer, in Map the keys can by any objects
            + Entry = key + value
            + the hierarchy of Map same the set but name set => map
            + instance of Map represents a group of objects, each of which is associated with a key
            + concrete classes {TeeMap, HashMap, linkedHashMap}

            + has funs.
                {put  putAll, remove, containsKey containsValue, keyset values entrySet, get, clear, IsEmpty, size, toArray}

                - put(key: K, value: V): V                      => puts an entry, if you put same key to reset the value
                - putAll(m: Map<? extends k, ? extends V): void => adds all the entries from m to this map

                - remove(key: object): V                        => removes the entries for the specified key

                - containsKey(key: object): boolean             => ture -> if the map contains entry for specified key
                - containsValue(value: Object): boolean         => true -> if this map maps one or more keys to the specified value

                - keySet(): Set<K>                              => return a set consisting of the keys in this map
                - vlaues(): collection<V>                       => returns a collection consisting of the values in this map
                - entrySet(): set<Map.Entry<K, V>>              =>return set consisting of the entries in this map ترجع في صورة ست        
                
                - get(key: Object): V                           => returns the [value] for the specified [key] in this map
                
                - clear(): void                                 => removes all entries
                - isEmpty(): boolean                            => true -> if this map contains no entries
                - size(): int                                   => nubmer of entries in this map

                !HashMap<K, V>
                - is efficient for locating a value, inserting a mapping, deleting a mapping
                - constructor
                    - HashMap()
                    - HashMap(m:Map <? extends K, ? extends V)
                    - HashMap(initialCapacity: int, loadFactor: float)
                
                !LinkedHashMap(K, V)
                - introduced in JDK 1.4
                - extend HashMap
                - supports an ordering of the entries in the map
                - has two types of ordering
                    + insertion order
                        retrieved in the order in which they were inserted into the map
                    + access order
                        from least recently accessed to most recently
                - LinkedHashMap() => insertion order
                - LinkedHashMap(m: Map<? extends K, ? extends V>)
                - linkedHashMap(initialCapacity: int, loadFactor: float, accessOrder: boolean) => access order   

                loadFactor%:  increse capacity when element fill (loadfactor * initialCapacity)
                accessOrder: false => insertion order, true: access order

                EX: LinkedHashMap<>(16, 0.75f, true)
                if(fillElement = 16*0.75) 
                    increase space auto. -> لعند 12 سيبدأ يملئ من جديد

                    
                    !TreeMap
                    - implement Sorted map
                    - is efficient for traversing the key in sorted order 
                    - TreeMap()
                    - TreeMap(m: Map<? extends K, ? extends V>)
                    - TreeMap(c: comparator<? super K>)
                    
                todo Note: HashMap, linkedHashMap(), TreeMap have constracotr => [(), (m: Map<? extends K, ? extends V>)] 
                todo       HashMap, linkedHashMap() only (initialCapacity: int, loadFactor: float, accessOrder: boolean)
                todo       TreeMap  TreeMap(c: comparator<? super K>)
                todo نفس الكلام السابق ينطبق على ست بالملي، وهم فيهم تشابه كبير جدا جدا جدا حتى من حيث أسماء الكلاسس

         */  
        //****** HashMap: ******
        Map<String, Integer> HashMap1 = new HashMap<>();
        HashMap1.put("Smith", 30);
        HashMap1.put("Anderson", 31);
        HashMap1.put("Lewis", 29);
        HashMap1.put("Cook", 29);

        System.out.println("\n\n Display entries in HashMap");
        System.out.println(HashMap1 + "\n");

        //****** TreeMap: ******
         //creating a TreeMap from preceding HashMap
        Map<String, Integer> treeMap = new TreeMap<>(HashMap1);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap );

        //****** linkedHashMap: ******
        Map<String, Integer> linkedHashMap1 = new LinkedHashMap<>(16, 0.75f, true);
        //true: acess order(use get method in last), flase: insertion order
        linkedHashMap1.put("smith", 30);
        linkedHashMap1.put("Anderson", 31);
        linkedHashMap1.put("Lewis", 29);
        linkedHashMap1.put("Cook", 29  );

        //display linkedHashMap
        System.out.println("\n\nlinkedHashMap: " + linkedHashMap1);//{smith=30, Anderson=31, Lewis=29, Cook=29}

        //display the age for Lewis
        System.out.println("\n\nage for lewis: " + linkedHashMap1.get("Lewis"));


        System.out.println("\n\nlinkedHashMap: " + linkedHashMap1); //{smith=30, Anderson=31, Cook=29, Lewis=29}

        //todo Note: differantce between two display because accessOrder

        //display by for Each, this is only way to print any map in line line
        System.out.println("\n\nNames and ages are ");
        treeMap.forEach(
            (name, age) -> System.out.println(name + " : " + age + " ")
        );

        /*System.out.println("\n\nNames and ages are ");
        for(int i = 0; i < treeMap.size(); i++) {
            System.out.println(treeMap.get(i));
        }*/ //this is wrong 

        //TreeMap in colloge
        TreeMap<Integer, staff> treeMap4 = new TreeMap<>();
        treeMap4.put(1, new staff("moahmmed", 1000, "khaled"));
        treeMap4.put(2, new staff("yasser", 2000, "yousef"));
        treeMap4.put(3, new staff("omer", 3000, "khaled"));

        //remove method
        treeMap4.remove(1);
        //replace method
        treeMap4.replace(2, new staff("omer", 100, "ahmed")); // same get in the same key
        treeMap4.replace(3, new staff("omer", 3000, "khaled"),new staff("yasser", 500, "yousef") );
        //if condition if key3 = new staff("omer", "ahmed", "khaled") replace new staff("yasser", "alaa", "yousef")
        System.out.println("\n\ntreeMap4: " );
        System.out.println(treeMap4);
        //make key is class
        //you must make hashCode equal mehtod in Staff
        //deep understing this point later
        TreeMap<staff, Integer> treeMap5 = new TreeMap<>((staff1, staff2) -> staff1.getStaffName().compareTo(staff2.getStaffName()));
        treeMap5.put(new staff("omer", 100, "ahmed"), 1);
        treeMap5.put(new staff("omer", 100, "ahmed"), 2);
        treeMap5.put(new staff("omer", 100, "ahmed"), 3);

        System.out.println("\n\ntreeMap5: " );
        System.out.println(treeMap5);





        //Case Study
        // set text in string
        String text = "Good morning Have a good class. Have a good visit. Have fun";


        //create a treeMap to hold words as key and count as values
        Map<String, Integer> treeMap2 = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");

        for(int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if(key.length() > 0) {
                if(!treeMap2.containsKey(key)) {
                    treeMap2.put(key, 1);
                }
                else {
                    int value = treeMap2.get(key);
                    value++;
                    treeMap2.put(key,value);
                }
            }
        }

        //display key and value for each entry
        treeMap2.forEach((k, v) -> {
            System.out.println(k + "\t" + v);
        });

        /*
         * Before Exam:
            * read book and write note
            * answer this question !important
                * https://liveexample-ppe.pearsoncmg.com/selftest/selftest9e?chapter=22&username=liang9e
                * https://liveexample-ppe.pearsoncmg.com/selftest/selftest9e?chapter=23&username=liang9e
         */

    }
}
