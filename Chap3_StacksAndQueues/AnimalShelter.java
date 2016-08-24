import java.util.ArrayList;
import java.util.LinkedList;

public class AnimalShelter
{
    private LinkedList<LinkedList<Animal>> queues;
    private int                            timestamp;
    private int                            size;

    public AnimalShelter()
    {
        queues = new LinkedList<LinkedList<Animal>>();
        for (int i=0; i<2; i++)
        {
            queues.add(new LinkedList<Animal>());
        }
        timestamp = 0;
        size = 0;
    }

    public enum AnimalType {dog, cat};

    public class Animal
    {
        public AnimalType type;
        public int animalName;
        public int timestamp;

        public Animal(AnimalType type, int animalName, int timestamp)
        {
            this.type = type;
            this.animalName = animalName;
            this.timestamp = timestamp;
        }
    }

    public void enqueue(AnimalType type, int animalName)
    {
        int index = (type == AnimalType.dog) ? 0 : 1;
        queues.get(index).add(new Animal(type, animalName, timestamp));
        timestamp++;
        size++;
    }

    public int dequeueDog()
    {
        int index = 0;
        if (queues.get(index).isEmpty()) throw new IndexOutOfBoundsException("dog queue underflow");
        Animal ani = queues.get(index).pollFirst();
        size--;
        return ani.animalName;
    }

    public int dequeueCat()
    {
        int index = 1;
        if (queues.get(index).isEmpty()) throw new IndexOutOfBoundsException("cat queue underflow");
        Animal ani = queues.get(index).pollFirst();
        size--;
        return ani.animalName;
    }

    public int dequeueAny()
    {
        if (queues.get(0).isEmpty() && queues.get(1).isEmpty()) throw new IndexOutOfBoundsException("queue underflow");
        int dogTimestamp = Integer.MAX_VALUE;
        int catTImestamp = Integer.MAX_VALUE;
        if (!queues.get(0).isEmpty())
            dogTimestamp = queues.get(0).peekFirst().timestamp;
        if (!queues.get(1).isEmpty())
            catTImestamp = queues.get(1).peekFirst().timestamp;
        int index = (dogTimestamp > catTImestamp) ? 0 : 1;
        Animal ani = queues.get(index).pollFirst();
        size--;
        return ani.animalName;
    }

    public static void main(String[] args)
    {
        try
        {
            AnimalShelter as = new AnimalShelter();
            // enqueue dogs (odd)
            as.enqueue(AnimalType.dog, 1);
            as.enqueue(AnimalType.dog, 3);
            as.enqueue(AnimalType.dog, 5);

            // enqueue cats (even)
            as.enqueue(AnimalType.cat, 2);
            as.enqueue(AnimalType.cat, 4);
            as.enqueue(AnimalType.cat, 6);

            System.out.format("dequeue cat: %d\n", as.dequeueCat());
            System.out.format("dequeue dog: %d\n", as.dequeueDog());
            System.out.format("dequeue oldest: %d\n", as.dequeueAny());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}