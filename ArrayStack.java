import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    protected T[] arr;
    protected int top;
    protected int size = 10;

    public ArrayStack() {
        top = -1;
        arr = (T[]) new Object[size];
    }

    //create an array double of the previous and copy
    //all 
    protected void grow_array() {
        //make temp that's double size of old arr
        T[] temp = (T[]) new Object[arr.length * 2];

        //copy over elements
        for( int i = 0; i < arr.length; i++){
            temp[i]=arr[i];
        }

        arr = temp;
    }

    //add an item to the top of the stack
    public void push(T item) {
        if (top == arr.length - 1) {
            grow_array();
        }
        arr[++top] = item;
    }

    //remove item from the top of stack
    public T pop() {
    	//check for empty
        if (empty()) {
        	//throw exception
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    //return the iteam at the top of the stack
    public T peek() {
    	//check for empty stack
        if (empty()) {
        	//throw exception
            throw new EmptyStackException();
        }
        return arr[top];

    }

    //function to check if stack is empty
    public boolean empty() {
        if (top < 0) {
            return true;
        }
        return false;
    }
}
