package com.csc;

public class QueueTees {

  private Cutie[] queue;
  private int front;
  private int rear;
  private int size;
  private final int capacity;

  public QueueTees(int capacity) {
    this.capacity = capacity;
    this.queue = new Cutie[capacity];
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  public QueueTees() {
    this(5);
  }

  public void enqueue(Cutie cutie) {
    if (size == capacity) {
      System.out.println("The queue is full. Cannot add more cuties!");
      return;
    }
    rear = (rear + 1) % capacity;
    queue[rear] = cutie;
    size++;
  }

  public Cutie dequeue() {
    if (size == 0) {
      System.out.println("The queue is empty. No cuties to remove!");
      return null;
    }
    Cutie removed = queue[front];
    front = (front + 1) % capacity;
    size--;
    return removed;
  }

  public int size() {
    return size;
  }
}
