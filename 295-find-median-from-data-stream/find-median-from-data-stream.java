class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()) maxHeap.offer(num);
        else {
            minHeap.offer(num);
        } 

        if(maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll()); 
        else if (minHeap.size() - maxHeap.size() >= 1) maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();

        return ((double)minHeap.peek() + maxHeap.peek()) /2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */