// File LinkedQueue.java
/**
 *  This class represents a Queue datatype implemented using a singly-linked
 *  list with appropriate operations.
 *
 * @author:	Henry Leitner
 * @version: Last modified on April 6, 2018
 * Implements a Queue as a linked-list
 */

public class LinkedDequeue
{
    private QueueNode rear;
    private QueueNode front;
    private int count;

    public static void main(String[] args) {

        //TODO: Maybe make a console-like interface here with a scanner to select operations to perform
        // Demonstrate the creation of a LinkedDequeue and the addition of a few nodes using headAdd
        System.out.println("Let's start by creating a new LinkedDequeue with strings " +
                "'alpha', 'beta', 'omega' at the head of the queue.");
        LinkedDequeue dequeue1 = new LinkedDequeue();
        dequeue1.headAdd("alpha");
        dequeue1.headAdd("beta");
        dequeue1.headAdd("omega");
        System.out.println("This is the current state of our queue:");
        System.out.println(dequeue1.toString());

        // Demonstrate tailAdd
        System.out.println("Now let's add ints 1, 2, and 3 to the tail of the queue");
        dequeue1.tailAdd(1);
        dequeue1.tailAdd(2);
        dequeue1.tailAdd(3);
        System.out.println("This is the state of our queue after adding the new int values:");
        System.out.println(dequeue1.toString());

        // Demonstrate headPeek and tailPeek
        System.out.println("Peeking at the head of the queue reveals the object " + dequeue1.headPeek());
        System.out.println("Peeking at the tail of the queue reveals the object " + dequeue1.tailPeek());
        System.out.println();

        // Demonstrate tailRemove and headRemove
        dequeue1.tailRemove();
        System.out.println("After executing tailRemove, if we peek at the tail again, we can " +
                "see the object at the tail has changed, and is now: " + dequeue1.tailPeek());
        dequeue1.headRemove();
        System.out.println("Similarly, after executing headRemove, if we peek at the head again " +
                "we can see the object at the head has changed, and is now: " + dequeue1.headPeek());

        // Demonstrate toString
        System.out.println("Examining the entire queue again shows us the objects still in the queue: ");
        System.out.println(dequeue1.toString());

        // Demonstrate size
        System.out.println("We can see after these two removals that only 4 nodes remain in the queue. " +
                "The size method can also reveal this information: " + dequeue1.size());

        // Demonstrate isEmpty
        System.out.print("The isEmpty method allows us to determine if there are any nodes in the queue: ");
        System.out.println(dequeue1.isEmpty());
    }

    /**
     *  The QueueNode class is an inner class implemented to model a queue node;
     *  it can contain an Object type of data, and also holds the link to the
     *  next node in the queue.  If there are no other nodes, the link will be null.
     */
     class QueueNode           // an inner class
     {
	    private Object item;
	    private QueueNode link;
     }

    /**
     *  This constructor for the class will set up the needed instance variables
     *  which begin with no nodes present and thus are set to null.
     */
    public LinkedDequeue()
    {
	   rear = front = null;
	   count = 0;
    }

    /**
     * This method will construct a new QueueNode and add it onto the head
     * of the queue. If it is the first node added into the queue, both the front
     * and the rear will reference it, otherwise it will be added using the front
     * variable. The node counter is also updated.
     * @param   x   The object to be added to the head of the queue as a new QueueNode
     */
    public void headAdd(Object x) {
        QueueNode temp = new QueueNode();
        temp.item = x;
        temp.link = null;

        if (front == null) front = rear = temp;
        else {
            temp.link = front;
            front = temp;
        }
        count++;
    }

    /**
     * This method returns the the Object pointed to by the QueueNode at the head
     * of the queue.
     */
    public Object headPeek() {
        if (isEmpty()) return null;
        else return front.item;
    }

    /**
     * This method deletes the QueueNode at the head of the queue and resets the
     * front to be the next node in the queue. The deleted Object is returned and the
     * counter is decremented.
     */
    public Object headRemove() {
        if (isEmpty()) return null;
        else {
            Object temp = front.item;
            front = front.link;
            if (front == null) rear = null;
            count--;
            return temp;
        }
    }

    /**
     *  This method will test for an empty queue and return a boolean result.
     *
     *  @return     true for an empty list; false if the queue contains QueueNodes.
     */
    public boolean isEmpty()
    {
	   return ( count == 0 );
    }

    /**
     * This method will construct a new QueueNode and add it to the tail of the queue.
     * If it is the first node added into the queue, both the front and the rear will
     * reference it, otherwise it will be added using the rear variable. The node counter
     * is also updated.
     */
    public void tailAdd(Object x) {
        QueueNode temp = new QueueNode();
        temp.item = x;
        temp.link = null;

        if (rear == null) front = rear = temp;
        else {
            rear.link = temp;
            rear = temp;
        }
        count++;
    }

    /**
     * This method returns the Object pointed to by the QueueNode at the tail
     * of the queue.
     */
    public Object tailPeek() {
        if (isEmpty()) return null;
        else return rear.item;
    }

    /**
     * This method deletes the QueueNode at the tail of the queue and resets the rear
     * to the now-last node in the queue. The deleted Object is returned and the counter
     * is decremented.
     */
    public Object tailRemove() {
        if (isEmpty()) return null;
        else {
            Object temp = rear.item;

            QueueNode newRear = front;
            while (newRear.link != rear) newRear = newRear.link;
            rear = newRear;
            count--;
            return temp;
        }
    }

    /**
     *  This method will evaluate and return the current size of the queue.
     *
     *  @return     An int describing the current number of nodes in the queue
     */
    public int size()
    {
	    return count;
    }

    /**
     * This method prints each of the objects held by the nodes in the Queue,
     * one on each line.
     *
     * @return  A string representing all objects held by the nodes in the queue
     */
    public String toString() {
        if (isEmpty()) return null;
        StringBuilder builder = new StringBuilder();
        QueueNode node = front;
        for (int i = 0; i < count; i++) {
            builder.append("Object at node ").append(i).append(": ").append(node.item).append("\n");
            if (node.link == null) break;
            else node = node.link;
        }
        return builder.toString();
    }
}