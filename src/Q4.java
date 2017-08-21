import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//猫狗队列
public class Q4 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        DogCatQueue queue = new DogCatQueue();
        queue.add(dog1);
        queue.add(dog2);
        queue.add(dog3);
        queue.add(cat1);
        queue.add(cat2);
        queue.add(cat3);
        System.out.println(queue.pollAll());
        System.out.println(queue.pollCat());
        System.out.println(queue.pollDog());
        System.out.println(queue.pollDog());
        System.out.println(queue.pollDog());
        System.out.println(queue.isDogEmpty());
        System.out.println(queue.isCatEmpty());
        System.out.println(queue.isEmpty());
    }

    public static class DogCatQueue {
        private Queue<Pet> queue;

        public DogCatQueue() {
            queue = new LinkedList<>();
        }

        public void add(Pet pet) {
            queue.add(pet);
        }

        public Pet pollAll() {
            return queue.poll();
        }

        public Dog pollDog() {
            Iterator<Pet> iterator = queue.iterator();
            Pet pet;
            while (iterator.hasNext()) {
                pet = iterator.next();
                if (pet instanceof Dog) {
                    queue.remove(pet);
                    return (Dog) pet;
                }
            }
            return null;
        }

        public Cat pollCat() {
            Iterator<Pet> iterator = queue.iterator();
            Pet pet;
            while (iterator.hasNext()) {
                pet = iterator.next();
                if (pet instanceof Cat) {
                    queue.remove(pet);
                    return (Cat) pet;
                }
            }
            return null;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public boolean isDogEmpty() {
            int size = 0;
            Iterator<Pet> iterator = queue.iterator();
            Pet pet;
            while (iterator.hasNext()) {
                pet = iterator.next();
                if (pet instanceof Dog)
                    size++;
            }
            return size == 0;
        }

        public boolean isCatEmpty() {
            int size = 0;
            Iterator<Pet> iterator = queue.iterator();
            Pet pet;
            while (iterator.hasNext()) {
                pet = iterator.next();
                if (pet instanceof Cat)
                    size++;
            }
            return size == 0;
        }
    }


    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static class Dog extends Pet {

        public Dog() {
            super("Dog");
        }
    }

    public static class Cat extends Pet {

        public Cat() {
            super("Cat");
        }
    }
}
