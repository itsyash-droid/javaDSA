public class MaxPQ{

    private Integer[] heap;
    private int n;

    public MaxPQ(int capacity){
        heap = new Integer[capacity + 1];
        n=0;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    public void insert(int x){
        if(n==heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k){
        while(k>1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }
    private  void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0;i<heap.length;i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMaxHeap(){
        for(int i = 0;i<=n;i++){
            System.out.println(heap[i] + " ");
        }
    }
    public static void main(String[] args){
        MaxPQ p = new MaxPQ(10);
        System.out.println(p.isEmpty());
        p.insert(6);
        p.insert(8);
        p.insert(10);
        p.insert(7);
        p.insert(4);
        p.insert(3);
        p.printMaxHeap();
        System.out.println();
        System.out.println(p.size());
    }
}