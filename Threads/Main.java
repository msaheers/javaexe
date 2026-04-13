public class Main { 

    public static void main(String[] args) {

        MyThread t = new MyThread(); //Create an object of MyThread class
        t.start(); // Start the thread // This will call the run() method  of MyThread class)
    }
}

/* From the above code we can see that we have created a class MyThread 
which extends the Thread class and we have ovverridden the run() method of Thread class. 

In the main method we have created an object of MyThread class 
and called the start() method of Thread class which will call the run() method of MyThread class
and print "Thread is running bro!" on the console. */