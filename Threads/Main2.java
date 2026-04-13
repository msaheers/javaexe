public class Main2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();

        Thread t = new Thread(task); // Creating a Thread object and passing the MyTask object to it and why?
        // Because the Thread class has a constructor that takes a Runnable object 
        // as an argument and we have created a class MyTask which implements the Runnable interface
        // and we hae overridden the run() method of Runnable interface
        // and we want to run the run() method of MyTask class in a separate thread so we have to pass the Mytask object to the Thread class constructor.
        t.start();
    }
}