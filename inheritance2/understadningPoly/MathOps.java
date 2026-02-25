// Compile- Time Polymorphism ( Method Overloading)

class MathOps { 
    int add( int a , int b) { 
        return a + b; 
    }

    int add( int a, int b, int c) { 
        return a + b + c;
    }
}

// Here what we can understand: 

//Add( int, int)
// add( int, int, int)
// Same method name
// Different parameter list.
// Java decided which one to call at compile time 