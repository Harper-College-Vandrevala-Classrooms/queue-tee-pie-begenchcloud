package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueueTees {

  QueueTees queue;

  class Puppy implements Cutie {
    public String description() {
      return "A little puppy with big, sad eyes";
    }

    public Integer cutenessRating() {
      return 11;
    }
  }

  class Kitty implements Cutie {
    public String description() {
      return "A fluffy kitten with tiny whiskers";
    }

    public Integer cutenessRating() {
      return 10;
    }
  }

  @BeforeEach
  void setUp() {
    queue = new QueueTees(3);
  }

  @Test
  void testEnqueueAndSize() {
    Cutie puppy = new Puppy();
    Cutie kitty = new Kitty();

    queue.enqueue(puppy);
    queue.enqueue(kitty);

    assertEquals(2, queue.size());
  }

  @Test
  void testDequeue() {
    Cutie puppy = new Puppy();
    Cutie kitty = new Kitty();

    queue.enqueue(puppy);
    queue.enqueue(kitty);

    assertEquals(puppy, queue.dequeue());
    assertEquals(kitty, queue.dequeue());
  }

  @Test
  void testQueueFull() {
    Cutie puppy = new Puppy();
    Cutie kitty = new Kitty();

    queue.enqueue(puppy);
    queue.enqueue(kitty);
    queue.enqueue(puppy);

    queue.enqueue(kitty);

    assertEquals(3, queue.size());
  }

  @Test
  void testDequeueEmpty() {
    assertNull(queue.dequeue());
  }
}
