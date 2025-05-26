package com.telusko.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Stream API in Java

public class Demo {

    public static void main( String[] args )
    {
        List<Integer> nums = Arrays.asList(6,5,2,8,1,7);

        //Lesson 1:
        //Attempting to reuse the Stream raises a compile time exception:
        //"Stream has already been linked or consumed" and does not produce anything
        //data.forEach(n -> System.out.println(n));

        //So the take away here is: we can process the Stream only once. Which is good for avoiding issues like "Out of memory issues"

        //Lesson 2: count method
        //testing some Stream methods
        //System.out.println(data.count());
        //data.forEach(n -> System.out.println(n));

        //Lesson 3:
        //returns new Stream object AND our initial data object has been consumed
        //Stream<Integer> sortedData = data.sorted();
        //sortedData.forEach(n -> System.out.println(n));

        //we can process our type using the base class
        //nums.forEach(n -> System.out.println(n));

        // OR better

        //we can create a Stream object to manipulate the data
        //Stream<Integer> data = nums.stream();

        //Lesson 4:
        //This is an example of walking on the data to double the value
        //for(Integer n : nums){
        //    System.out.println(n*2);
        //}

        // Or better instantiate a Stream and a Map, pass the elements and what processing you'd like the  values to do

        //Stream<Integer> data = nums.stream();
        //final Stream<Integer> integerStream = data.map(n -> n * 2);

        // Or instantiate the Stream, Map and output in 2 line
        //Stream<Integer> data = nums.stream().map(n -> n * 2); //the maqp returns a Stream
        //data.forEach(n -> System.out.println(n));

        // Or instantiate the Stream, Map and output in 1 line by removing the Intermediate object
        //Note: forEach will not return a value, so the below won't work
        //Stream<Integer> data = nums.stream().map(n -> n * 2).forEach(n -> System.out.println(n));

        //Note: so just output the values
        //nums.stream().map(n -> n * 2).forEach(n -> System.out.println(n));

        /*
        //Using the Builder pattern increases the readability
        nums.stream()                                     //1 Stream
                .sorted()                                 //2 Stream : first Stream is gone now
                .map(n -> n * 2)                          //3 Stream : Second Stream is gone now
                .forEach(n -> System.out.println(n));
        */

        //Lesson 6: implementing the filter method using a Predicate
        //Version 1: anonymous Inner class
//        Predicate<Integer> predi = new Predicate<Integer>(){   //anonymous Inner class
//            @Override
//            public boolean test(Integer n) {
//                return n % 2 == 1;  //returns true or false
//            }
//        };

        //Version 2: remove the anonymous Inner class, remove {} for 1 line function
        //Predicate<Integer> predi = n -> n % 2 == 1;  //returns true or false

        //Lesson 6: implementing the filter method
//        nums.stream()
//            //.filter(predi)         //create Stream of Odd numbers, using a predicate
//            .filter(n -> n%2 == 1)   //create Stream of Odd numbers, thereby operating on only the Odd Integers
//            //.map(mapper)
//            .map(n -> n * 2)
//            .forEach(n -> System.out.println(n));

        //Lesson 7: implementing the mapping method using a Function
        //Map Version 1: public interface Function<T, R>
        // T:(input) and R (output) are both Integers
//        Function<Integer, Integer> mapper = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer n) {
//                return n * 2;
//            }
//        };

        //Map Version 2: remove the anonymous Inner class, replace with lamda
        //    Function<Integer, Integer> mapper = n-> n*2;

//        //Lesson 7: implementing the mapper method
//        nums.stream()
//                //.filter(predi)     //create Stream of Odd numbers, using a predicate
//                .filter(n -> n%2 == 1)     //create Stream of Odd numbers, thereby operating on only the Odd Integers
//                //.map(mapper)
//                .map(n -> n * 2)
//                .forEach(n -> System.out.println(n));


        //Lesson 8: implementing the reducer method
        Integer result = nums.stream()
                            //.filter(predi)
                            .filter(n -> n%2 == 1)
                            //.map(mapper)
                            .map(n -> n * 2)
                            .reduce(0, (c,e)->c+e);

        //this is how Reduce works by keeping a running total
        // therefore c is the output of the first summation, in this case 2 + 0, e == new element
        // Integer sum = integers.reduce(0, (c, e) -> a+b);
        //integers.reduce(starting value:0, apply(0,2) -> (0 + 2)
        //integers.reduce(starting value:2, apply(2,10) -> (2 + 10)
        //integers.reduce(starting value 12, apply(12,14) -> (12 + 14)
        // integers.reduce would return 26

        System.out.println(result);

    }
}
