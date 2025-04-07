package StacksAndQueues;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis.
People must adopt either the"oldest" (based on arrival time) of all animals at the shelter, or they can select whether
they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific
animal they would like. Create the data structures to maintain this system and implement operations such as enqueue,
dequeueAny, dequeueDog, and dequeueCat. You may use the built-in Linked list data structure.
Hints:#22, #56, #63
* */
public class AnimalShelter {

    enum AnimalType {
        DOG, CAT
    }
    class Animal {
        private AnimalType type;

        private int consecutive;

        public Animal(AnimalType type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return type == animal.type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }

    LinkedList<Animal> dogs = new LinkedList<>();
    LinkedList<Animal> cats = new LinkedList<>();

    private void enqueue(Animal animal) {
        Integer lastConsecutiveOfCats = cats.peekLast().consecutive;
        Integer lastConsecutiveOfDogs = dogs.peekLast().consecutive;

        int newConsecutive = Math.max(lastConsecutiveOfCats, lastConsecutiveOfDogs) + 1;
        animal.consecutive = newConsecutive;

        if(animal.type.equals(AnimalType.DOG)) {
            dogs.addLast(animal);
        } else {
            cats.addLast(animal);
        }

    }

    private Animal dequeueAny() {
        if(cats.isEmpty() && dogs.isEmpty())
            throw new NoSuchElementException();

        if(cats.isEmpty()) {
            return dogs.removeFirst();
        }

        if(dogs.isEmpty()) {
            return cats.removeFirst();
        }

        Integer lastConsecutiveOfCats = cats.peekLast().consecutive;
        Integer lastConsecutiveOfDogs = dogs.peekLast().consecutive;

        if(lastConsecutiveOfCats < lastConsecutiveOfDogs) {
            return cats.removeFirst();
        }

        return dogs.removeFirst();
    }

    private Animal dequeueDog() {
        if(dogs.isEmpty())
        throw new NoSuchElementException();
        return dogs.removeLast();
    }

    private Animal dequeueCat() {
        if(cats.isEmpty())
            throw new NoSuchElementException();
        return cats.removeLast();
    }
}
