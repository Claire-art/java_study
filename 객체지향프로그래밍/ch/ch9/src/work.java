import java.util.Arrays;

/**
 * Queue 인터페이스
 */
interface Queue {
    void enqueue(int item); // 아이템을 큐에 추가하는 메서드
    int dequeue(); // 큐에서 아이템을 제거하고 반환하는 메서드
    boolean isEmpty(); // 큐가 비어있는지 확인하는 메서드
}

class MyQueue implements Queue {
    private static int front, rear, capacity; // 큐의 프론트, 리어, 용량을 나타내는 변수
    private static int queue[]; // 큐를 저장하는 배열

    public MyQueue(int size){
        front = rear = 0; // 처음에는 프론트와 리어가 0으로 초기화됨
        capacity = size; // 용량 설정
        queue = new int[capacity]; // 큐 배열 생성
    }

    @Override
    public void enqueue(int item){
        if (rear == capacity) {
            System.out.println("큐가 가득 찼습니다. 아이템을 추가할 수 없습니다.");
            return;
        }
        queue[rear] = item; // 리어 위치에 아이템 추가
        rear++; // 리어 위치 증가
    }

    @Override
    public int dequeue() {
        if (front == rear) {
            System.out.println("큐가 비어있습니다. 아이템을 제거할 수 없습니다.");
            return -1;
        }
        int item = queue[front]; // 프론트 위치의 아이템을 가져옴
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1]; // 아이템들을 한 칸씩 앞으로 이동시킴
        }
        rear--; // 리어 위치 감소
        return item; // 제거한 아이템 반환
    }

    public void display(){
        if(front == rear){
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("[ ");
        for(int i = front; i < rear; i++){
            System.out.print(queue[i] + " "); // 프론트부터 리어까지의 아이템 출력
        }
        System.out.println("]");
    }

    @Override
    public boolean isEmpty(){
        return front == rear; // 프론트와 리어가 같으면 큐는 비어있는 상태
    }
}

public class work {
    public static void main(String[] args){
        MyQueue q = new MyQueue(10);

        q.display(); // 큐 출력

        q.enqueue(1212);
        q.display(); // 큐 출력
        q.enqueue(4);
        q.display(); // 큐 출력
        q.enqueue(1313);
        q.display(); // 큐 출력

        q.dequeue();
        q.display(); // 큐 출력
        q.dequeue();
        q.display(); // 큐 출력
        q.dequeue();
        q.display(); // 큐 출력
    }
}
