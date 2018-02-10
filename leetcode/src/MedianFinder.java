import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() + 1 < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        assert Math.abs(maxHeap.size() - minHeap.size()) <= 1;
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            throw new IllegalArgumentException("Empty!");
        } else if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) >>> 1;
        } else if (maxHeap.size() == minHeap.size() + 1) {
            return maxHeap.peek();
        } else if (maxHeap.size() + 1 == minHeap.size()) {
            return minHeap.peek();
        } else {
            throw new IllegalStateException("BUG!");
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such: MedianFinder obj = new
 * MedianFinder(); obj.addNum(num); double param_2 = obj.findMedian();
 */
