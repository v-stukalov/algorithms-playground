import java.util.PriorityQueue;

class MedianOfAStream {
    private PriorityQueue<Integer> lesser = new PriorityQueue<>((a, b) -> b - a); // MaxPQ
    private PriorityQueue<Integer> greater = new PriorityQueue<>((a, b) -> a - b); // MinPQ

    public void insertNum(int num) {
        if (lesser.isEmpty() || lesser.peek() >= num) {
            lesser.add(num);
        } else {
            greater.add(num);
        }
        if (lesser.size() > greater.size() + 1) {
            greater.add(lesser.poll());
        } else if (lesser.size() < greater.size()) {
            lesser.add(greater.poll());
        }
    }

    public double findMedian() {
        if (lesser.size() == greater.size()) {
            return lesser.peek() / 2.0 + greater.peek() / 2.0;
        } else {
            return lesser.peek();
        }
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
