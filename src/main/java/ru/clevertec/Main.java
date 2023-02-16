package ru.clevertec;

import ru.clevertec.model.Animal;
import ru.clevertec.model.Car;
import ru.clevertec.model.Flower;
import ru.clevertec.model.House;
import ru.clevertec.model.Person;
import ru.clevertec.util.Util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
    }

    private static void task1() throws IOException {
        List<Animal> animals = Util.getAnimals();
               animals.stream().filter(animal -> animal.getAge()>=10 && animal.getAge()<=20)
                       .sorted(Comparator.comparing(Animal::getAge))
                       .skip(14).limit(7)
                       .forEach(System.out::println);
    }

    private static void task2() throws IOException {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .filter(animal -> animal.getGender().equalsIgnoreCase("Female"))
                .map(Animal::getBread)
                .forEach(System.out::println);
    }

    private static void task3() throws IOException {
        List<Animal> animals = Util.getAnimals();
                animals.stream().filter(animal -> animal.getAge()>30)
                        .map(Animal::getOrigin)
                        .distinct()
                        .filter(s -> s.contains("A"))
                        .forEach(System.out::println);
    }

    private static void task4() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long female = animals.stream().filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println("Task 4: " + female);

    }

    private static void task5() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean hungarian = animals.stream().filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> animal.getOrigin().equalsIgnoreCase("Hungarian"));
        System.out.println("Task 5: " + hungarian);
    }

    private static void task6() throws IOException {
        List<Animal> animals = Util.getAnimals();
        long countMale = animals.stream().filter(animal -> animal.getGender().equalsIgnoreCase("Male"))
                        .count();
        long countFemale = animals.stream().filter(animal -> animal.getGender().equalsIgnoreCase("Female"))
                .count();

        boolean isTrue;
        isTrue = animals.size() <= countFemale + countMale;

        System.out.println("Task 6: " + isTrue);
    }

    private static void task7() throws IOException {
        List<Animal> animals = Util.getAnimals();
        boolean oceania = animals.stream().noneMatch(animal -> animal.getOrigin().equalsIgnoreCase("Oceania"));
        System.out.println("Task 7: " + oceania);
    }

    private static void task8() throws IOException {
        List<Animal> animals = Util.getAnimals();
        Optional<Animal> animal = animals.stream().sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparing(Animal::getAge));
        System.out.println("Task 8: " + animal.get().getAge());
    }

    private static void task9() throws IOException {
        List<Animal> animals = Util.getAnimals();
        Optional<char[]> min = animals.stream().map(Animal::getBread)
                .map(String::toCharArray)
                .min(Comparator.comparing(chars -> chars.length));
        System.out.println("Task 9: " + min.get().length);
    }

    private static void task10() throws IOException {
        List<Animal> animals = Util.getAnimals();
        int sum = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println("Task 10: " + sum);
    }

    private static void task11() throws IOException {
        List<Animal> animals = Util.getAnimals();
        OptionalDouble indonesian = animals.stream().filter(animal -> animal.getOrigin().equalsIgnoreCase("Indonesian"))
                .mapToInt(Animal::getAge)
                .average();

        System.out.println("Task 11: " + indonesian.getAsDouble());
    }

    private static void task12() throws IOException {
        List<Person> people = Util.getPersons();
        people.stream().filter(p -> p.getGender().equalsIgnoreCase("male"))
                .filter(p->Math.abs(ChronoUnit.YEARS.between(LocalDate.now(),p.getDateOfBirth())) >=18 && Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), p.getDateOfBirth()))<=27)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);


    }

    private static void task13() throws IOException {
        List<House> houses = Util.getHouses();
        //        Продолжить...
    }

    private static void task14() throws IOException {
        List<Car> cars = Util.getCars();
        //        Продолжить...
    }

    private static void task15() throws IOException {
        List<Flower> flowers = Util.getFlowers();
        //        Продолжить...
    }
}