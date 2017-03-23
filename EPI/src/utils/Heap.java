package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** Created by pankaj on 3/7/16. */
public class Heap {
  private int[] _arr;
  private int _capacity;
  private int _idx;

  public Heap(int initialCapacity) {
    this._capacity = initialCapacity;
    _arr = new int[this._capacity];
    _idx = 0; // Oth is a dummy entry to simplify parent-child indexing
  }

  public Heap(int[] A) {
    _idx = A.length;
    this._capacity = A.length + 1; //better to be a power of 2
    _arr = new int[this._capacity];
    for (int i = 0; i < _idx; i++) _arr[i + 1] = A[i];
    heapify(1);
  }

  public void heapify(int id) {
    if (id >= _idx) return;
    heapify(id << 1);
    heapify((id << 1) + 1);
    shiftDown(id);
  }

  public boolean isHeap() {
    for (int i = 1; i <= _idx; i++) {
      if (i << 1 <= _idx && _arr[i] > _arr[i << 1]) return false;
      if ((i << 1) + 1 <= _idx && _arr[i] > _arr[(i << 1) + 1]) return false;
    }
    return true;
  }

  public boolean isEmpty() {
    return _idx == 0;
  }

  public int size() {
    return _idx;
  }

  public Integer findMin() {
    if (isEmpty()) return null;
    return _arr[1];
  }

  public List<Integer> kSmallest(int k) {
    PriorityQueue<ArrayData> q = new PriorityQueue<>();
    q.add(new ArrayData(_arr[1], 1));
    List<Integer> kSmallest = new ArrayList<>();
    int N = _idx;
    while (!q.isEmpty() && kSmallest.size() < k) {
      ArrayData data = q.remove();
      kSmallest.add(data.val);
      int idx = data.idx << 1;
      if (++idx < N) q.add(new ArrayData(_arr[idx], idx));
      if (++idx < N) q.add(new ArrayData(_arr[idx], idx));
    }
    return kSmallest;
  }

  public Integer extractMin() {
    if (isEmpty()) return null;
    Integer min = _arr[1];
    _arr[1] = _arr[_idx--];
    shiftDown(1);
    return min;
  }

  public void insert(int val) {
    if (++_idx >= _arr.length) resize();
    _arr[_idx] = val;
    shiftUp();
  }

  private void shiftDown(int id) {
    int i = id;
    while (i << 1 < _idx && _arr[i] > Math.min(_arr[i << 1], _arr[(i << 1) + 1])) {
      if (_arr[i << 1] < _arr[(i << 1) + 1]) {
        swap(i << 1, i);
        i <<= 1;
      } else {
        swap((i << 1) + 1, i);
        i <<= 1;
        i++;
      }
    }
    if (i << 1 == _idx && _arr[i << 1] < _arr[i]) swap(i << 1, i);
  }

  private void shiftUp() {
    int i = _idx;
    while (i >> 1 > 0 && _arr[i >> 1] > _arr[i]) {
      swap(i >> 1, i);
      i >>= 1;
    }
  }

  private void swap(int i, int j) {
    int temp = _arr[i];
    _arr[i] = _arr[j];
    _arr[j] = temp;
  }

  private void resize() {
    _capacity <<= 2;
    int[] copy = Arrays.copyOf(_arr, _capacity);
    _arr = copy;
  }

  private static class ArrayData {
    final int val;
    final int idx;

    ArrayData(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
  }
}
