import car.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        InBrand c1 = new InBrand("Mercedes", 2000, 4, "Automatic", 10, 1);
        InBrand c2 = new InBrand("BMW", 1996, 3, "Automatic", 5, 2);

        if (c1 == c2) {
            System.out.println("c1 is identical c2");
        }
        else {
            System.out.println("c1 is not identical c2");
        }

        if (c1.equals(c2)) {
            System.out.println("c1 is equals c2");
        }
        else {
            System.out.println("c1 is not equals c2");
        }

        System.out.println("Set c2 to c1");

        c2 = c1;
        if (c1 == c2) {
            System.out.println("c1 is identical c2");
        }
        else {
            System.out.println("c1 is not identical c2");
        }

        System.out.println("Array testing");
        String[] brands = new String[] {
                "Mercedes", "BMW", "Chevrolet",
                "Cadillac", "Porsche", "Tesla",
                "Aston Martin", "Jaguar", "Pontiac",
                "Fiat"
        };

        String[] transmissionTypes = new String[] {
                "Automatic", "Manual"
        };

        ArrayList<Car> cars = new ArrayList<Car>();
        for(int i = 0; i < 10; i++) {
            InBrand newCar = new InBrand(brands[i],
                                         rand.nextInt(2010, 2023),
                                         rand.nextInt(3, 6),
                                         transmissionTypes[rand.nextInt(0, 2)],
                                         rand.nextDouble(10, 20),
                                         rand.nextInt(1, 4));
            if(cars.contains(newCar)) {
                i--;
            }
            else {
                cars.add(newCar);
            }
        }

        for(Car car : cars) {
            System.out.println(car);
        }
    }
}
