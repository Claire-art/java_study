/**
 * Queue
 */
interface Queue {
    void enqueue(int item);
    int dequeue();
    boolean isEmpty();
}

class MyQueue {
    private static int front, rear, capacity;
    private static int queue[];

    public MyQueue(int size){
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }

    public void enqueue(int item){
        // 큐가 가득 차 있지 않다면, item 넣기
    }

    public int dequeue() {
        //큐가 비어있지 않다면, item 빼기
    }

    public void display(){
        int i;
        if(front == rear){
            System.out.printf("Queue is Empty\n");
            return;
        }

        System.out.print("[");
        for(i = front; i < rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("]");
        return;
    }

    public boolean isEmpty(){
        // front와 rear를 비교하여 큐가 비어있는지를 확인하기
    }
}

public class work {
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
