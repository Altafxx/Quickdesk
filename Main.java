import java.util.*;

interface IQueuable {
    public void enqueue(String s);
    public String dequeue();
    public String[] getQueue();
    public int size();
}


class QUEUE implements IQueuable {
    private int capacity, front, back;
    private String arr[];

    public QUEUE(int c) {
        capacity = c;
        front = 0;
        back = 0;
        arr = new String[capacity];
    }

    public void enqueue(String s) {
        arr[back] = s;
        back++;
    }

    public String dequeue() {
        String s = arr[front];
        for (int i = 0; i < back - 1; i++) arr[i] = arr[i + 1];
        back--;
        return s;
    }

    public String[] getQueue() {
        return arr;
    }

    public int size() {
        return back;
    }
}

class STACK implements IQueuable {
    private int capacity, front, back;
    private String arr[];

    public STACK(int c) {
        capacity = c;
        front = 0;
        back = 0;
        arr = new String[capacity];
    }

    public void enqueue(String s) {
        arr[back] = s;
        back++;
    }

    public String dequeue() {
        String s = arr[back - 1];
        String temp[] = new String[arr.length];
        for (int i = 0; i < arr.length - 1; i++) temp[i] = arr[i];
        back--;
        return s;
    }

    public String[] getQueue() {
        String temp[] = new String[back];
        int tempSize = back;
        for (int i = 0; i < back; i++) {
            temp[tempSize - 1] = arr[i];
            tempSize = tempSize - 1;
        }
        return temp;
    }

    public int size() {
        return back;
    }
}

class Main {
    public static void main(String[] args) {
        String strArr[] = new String[5], remove;
        int option;
        // STACK stack = new STACK(strArr.length);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Input 5 Word =");
        for(int i = 0; i < 5; i++) {
            System.out.print((i+1) + " - ");
            strArr[i] = input.nextLine(); 
        }

        System.out.print("\n(1)FIFO or (2)LIFO? ");
        option = input.nextInt();

        if (option == 1) {
            QUEUE queue = new QUEUE(strArr.length);

            for (int i = 0; i < strArr.length; i++) queue.enqueue(strArr[i]);
            System.out.print("\n\nYour current queue is = ");
            for (int i = 0; i < queue.size(); i++) System.out.print(queue.getQueue()[i] + " ");

            System.out.print("\n\nFirst element will be removed");
            remove = queue.dequeue();
            System.out.print("\n" + remove + " has been remove");
            System.out.print("\n\nYour current queue is = ");
            for (int i = 0; i < queue.size(); i++) System.out.print(queue.getQueue()[i] + " ");
            System.out.print("\nAnd you current queue size is " + queue.size());
        }

        if (option == 2) {
            STACK stack = new STACK(strArr.length);
            
            for (int i = 0; i < strArr.length; i++) stack.enqueue(strArr[i]);
            System.out.print("\n\nYour current queue is = ");
            for (int i = 0; i < stack.size(); i++) System.out.print(stack.getQueue()[i] + " ");

            System.out.print("\n\nFirst element will be removed");
            remove = stack.dequeue();
            System.out.print("\n" + remove + " has been remove");
            System.out.print("\n\nYour current queue is = ");
            for (int i = 0; i < stack.size(); i++) System.out.print(stack.getQueue()[i] + " ");
            System.out.print("\nAnd you current queue size is " + stack.size());
        }

        input.close();
    }   
}