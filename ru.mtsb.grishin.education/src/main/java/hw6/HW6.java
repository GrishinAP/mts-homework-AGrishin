package hw6;


import java.util.*;

public class HW6 {
    public static void main(String[] args) throws invalidAnimalBirthDateException {
        int animalNumber = 23;
        AnimalRepository ar = new AnimalsRepositoryImpl();
        CreateAnimalServiceImpl cAI = new CreateAnimalServiceImpl();
        Map<String, List<Animal>> animalMap = cAI.createAnimals(animalNumber);
        List<Animal> allLists = new ArrayList<>();
        for (String oneKey : animalMap.keySet()) {
            allLists.addAll(animalMap.get(oneKey));
        }
        Animal[] animalsArr = new Animal[animalNumber];
        for (int i = 0; i < animalNumber; i++) animalsArr[i] = allLists.get(i);

        System.out.println("\nКто рождён в высокосный год");
        System.out.println(ar.findLeapYearNames(animalsArr));

        int k = 17;
        System.out.println("\nЖивотные старше " + k + " лет");
        System.out.println(ar.findOlderAnimal(animalsArr, k));

        System.out.println("\nКоличество задублированных типов животных.");
        System.out.println(ar.findDuplicate(animalsArr));

    }
}