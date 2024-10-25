package org.balar.coreJavaBasics.java8LambdaInterfaces;

import java.util.Arrays;
import java.util.List;

public class LambdaRunner {
    public void run() {
        List<Car> listOfCars = Arrays.asList(
                new Car("Honda", "Accord", "Silver", 20000),
                new Car("Honda", "Civic", "White", 20220),
                new Car("Honda", "Fit", "Red", 4200),
                new Car("Honda", "Amaze", "White", 12000),
                new Car("Honda", "Pilot", "Silver", 45000),
                new Car("Honda", "Passport", "Black", 70000),
                new Car("Subaru", "Outback", "Blue", 32000),
                new Car("Subaru", "Legacy", "Blue", 14000),
                new Car("Subaru", "Impreza", "Silver", 3000),
                new Car("Subaru", "WRX STI", "Blue", 32200)
        );
        
        printCarsByPriceRange(listOfCars, 10000, 32000);
        
        System.out.println();
        printCarByColor(listOfCars, "Silver");
        
    }
    
    public void printCarsByPriceRange(List<Car> cars, int low, int high) {
        cars.stream().filter(car -> car.getPrice() > low && car.getPrice() < high).forEach(Car::printCar);
    }
    
    public void printCarByColor(List<Car> cars, String color) {
        cars.stream().filter(car -> car.getColor().equals(color)).forEach(Car::printCar);
    }
}
