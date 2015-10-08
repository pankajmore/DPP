package puzzles;

/**
 * Created by Pankaj on 10/8/15.
 */
public class CircularQueue {
    private Integer[] _q;
    private int _front, _back, _capacity, _size;

    public CircularQueue(int initialCapacity) {
        _capacity = initialCapacity;
        _q = new Integer[_capacity];
        _front = _back = 0;
        _size = 0;
    }

    public int capacity() {
        return _capacity;
    }

    public int size() {
        return _size;
    }

    public void enqueue(int x) {
        if (_size == _capacity) resize();
        _q[_front] = x;
        _front = (_front + 1) % _capacity;
        _size++;
    }

    public Integer dequeue() {
        if (_size == 0) return null;
        Integer d = _q[_back];
        _back = (_back + 1) % _capacity;
        _size--;
        return d;
    }

    private void resize() {
        Integer[] temp = new Integer[2 * _capacity];
        for (int i = 0, j = _back; i < _size; i++, j = (j + 1) % _capacity)
            temp[i] = _q[j];
        _q = temp;
        _back = 0;
        _front = _capacity;
        _capacity *= 2;
    }
}
