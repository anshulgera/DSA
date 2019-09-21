public class PriorityQueue {
    // max queue
    int size;
    int[] heap;

    public PriorityQueue(int maxSize) {
        heap = new int[maxSize];
        size = 0;
    }

    public void swapElements(int parent, int pos) {
        int temp = heap[position];
        heap[position] = heap[pos];
        heap[pos] = temp;
        return;
    }

    public void push(int value) {
        if (size == heap.length) {
            System.out.println("Heap overflow");
            return;
        }
        // Insert the new element at the back of queue initially
        // Then check if the position is correct of not 
        // w.r.t its parent
        // index of parent = (curr_index+1)/2 - 1
        int pos = size;
        heap[pos] = value;
        while (pos>0) {
            int parent = (pos+1)/2 - 1;
            if (heap[parent] >= heap[pos]) {
                break;
            }
            swapElements(parent, pos);
            pos = parent;
        }
        size++;
    }

    public void pop() {
        if (size == 0) {
            System.out.println("Empty queue");
            return;
        }
        int toReturn = heap[0];
        heap[0] = heap[size-1];
        size--;
        int pos = 0;
        while (pos < size/2) {
            int leftChild = pos*2 + 1;
            int rightChild = leftChild + 1;
            // check if right child exists and if yes, then if it is greater than left child 
            if (rightChild < size && heap[leftChild] < heap[rightChild]) {
                if (heap[pos] >= heap[rightChild]) break;
                swapElements(pos, rightChild);
                pos = rightChild;
            } else {
                if (heap[pos] >= heap[leftChild]) break;
                swapElements(pos, leftChild);
                pos = leftChild;
            }
        }
        
        return toReturn;
    }
}