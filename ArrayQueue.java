import java.util.EmptyStackException;

public class ArrayQueue<T> implements Queue<T>{

    protected T[] arr;
    protected int head=0;
    protected int tail=0;
    protected int size = 10;
    protected int n; //n is number of elements in queue

    public ArrayQueue(){
        head = tail = n = 0;
        arr = (T[]) new Object[size];
    }

    protected void grow_array(){
        //make temp that's double size
        T[] temp = (T[]) new Object[arr.length*2];

       	//copy elements of prev array to the temp
        for(int i=0; i < arr.length; i++){
            temp[i] = arr[(head +i) % arr.length];
        }

        //tail and head are adjusted 
        tail=arr.length;
        head = 0;

        //arr now equals to the new array
        arr=temp;


    }

    //remove element from the queue
    public T dequeue(){
    	//check to see if queue is empty
        if(empty()){
           throw new EmptyStackException();
        }

        //save the dequeued value
        T temp = arr[head];
        arr[head] = null;

        //update number of elements
        n--;
        head++;

        //wrap around if needed
        if(head == arr.length){
            head = 0;
        }

        //return what was dequeued
        return temp;
    }

    public void enqueue(T item){
    	//check to see if resizing is necessary
        if(n + 1 > arr.length){
            grow_array();
        }

        //add item to end of queue
        arr[tail++] = item;

        //wrap around to front if necessary
        if(tail == arr.length){
            tail = 0;
        }

        //update number of elements
        n++;
    }

    //check if queue is empty
    public boolean empty(){
    	//if head and tail value are the same, the queue is empty
        if(head == tail){
            return true;
        }
        return false;
    }

}
