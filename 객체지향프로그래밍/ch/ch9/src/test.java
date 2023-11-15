import java.util.Arrays;

/**
 * Queue
 */
interface Queue {
    void enqueue(int item);
    int dequeue();
    boolean isEmpty();
}

class MyQueue implements Queue {
    private static int front, rear, capacity;
    private static int queue[];

    public MyQueue(int size){
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    @Override
    public void enqueue(int item){
        if (rear == capacity) {
            System.out.println("Queue is full. Cannot enqueue item.");
            return;
        }
        queue[rear] = item;
        rear++;
    }

    @Override
    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty. Cannot dequeue item.");
            return -1;
        }
        int item = queue[front];
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        return item;
    }

    public void display(){
        if(front == rear){
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("[ ");
        for(int i = front; i < rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty(){
        return front == rear;
    }
}

public class test {
    public static void main(String[] args){
        MyQueue q = new MyQueue(10);

        q.display();

        q.enqueue(10);
        q.display();
        q.enqueue(20);
        q.display();
        q.enqueue(30);
        q.display();

        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
    }
}
