package hw6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnimalsRepositoryImpl implements AnimalRepository {
    public static final List<String> patAnimals = new ArrayList<>(Arrays.asList("Dog", "Cat"));
    public static final List<String> predatorAnimals = new ArrayList<>(Arrays.asList("Lion", "Wolf"));
    public static final List<String> animalNames = new ArrayList<>(Arrays.asList("Шарик", "Пушок", "Рекс", "Дружок", "Хасан", "Джульбарс"));
    public static final List<String> animalCharacters = new ArrayList<>(Arrays.asList("Predator", "Pat"));
    public static final List<Double> animalCosts = new ArrayList<>(Arrays.asList(22.30, 32.40, 45.80, 15.33, 18.95));

    @Override
    public HashMap<String, LocalDate> findLeapYearNames(Animal[] animals) throws invalidAnimalBirthDateException {
        SearchService ss = new SearchServiceImpl();
        HashMap<String, LocalDate> retMap = new HashMap<>();
        for (Animal animal : animals) {
            if (ss.searchService(animal)) {
                retMap.put(animal.getBreed() + animal.getName(), animal.getBirthday());
            }
        }
        return retMap;
    }

    @Override
    public HashMap<Animal, Integer> findOlderAnimal(Animal[] animals, Integer n) {
        HashMap<Animal, Integer> retMap = new HashMap<>();
        Animal defAnimal = null;
        int maxAge = 0;
        LocalDate now = LocalDate.now();
        for (Animal animal : animals) {
            if (now.getYear() - animal.getBirthday().getYear() >= n) {
                retMap.put(animal, now.getYear() - animal.getBirthday().getYear());
            } else {
                if (now.getYear() - animal.getBirthday().getYear() > maxAge) {
                    maxAge = now.getYear() - animal.getBirthday().getYear();
                    defAnimal = animal;
                }
            }
        }
        if (retMap.isEmpty()) {
            retMap.put(defAnimal, maxAge);
        }
        return retMap;
    }

    @Override
    public HashMap<String, Integer> findDuplicate(Animal[] animals) {
        HashMap<String, Integer> retMap = new HashMap<>();
        int count;
        for (Animal animal : animals) {
            if (retMap.containsKey(animal.getBreed()))
                count = retMap.get(animal.getBreed()) + 1;
            else count = 1;
            retMap.put(animal.getBreed(), count);
        }
        return retMap;
    }
}
