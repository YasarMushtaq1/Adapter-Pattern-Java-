import java.util.Scanner;

// Step 1: Define an interface for the target (what the client expects)
interface DistanceConverter {
    double convert(double kilometers);
}

// Step 2: Create an Adaptee (what we have, but it's not compatible with the target)
class KilometerConverter {
    // Converts kilometers to miles
    double convertToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
}

// Step 3: Create an Adapter class that adapts the KilometerConverter to DistanceConverter
class KilometerToMileAdapter implements DistanceConverter {
    private KilometerConverter kilometerConverter;

    public KilometerToMileAdapter(KilometerConverter kilometerConverter) {
        this.kilometerConverter = kilometerConverter;
    }

    @Override
    public double convert(double kilometers) {
        return kilometerConverter.convertToMiles(kilometers);
    }
}

public class AddapterPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for distance in kilometers
        System.out.print("----------In here we would convert kilometers to miles------------ ");
        System.out.print("\nEnter distance in kilometers: ");
        double kilometers = scanner.nextDouble();

        // Step 4: Create an instance of KilometerConverter
        KilometerConverter kilometerConverter = new KilometerConverter();

        // Step 5: Create an instance of KilometerToMileAdapter
        DistanceConverter adapter = new KilometerToMileAdapter(kilometerConverter);

        // Use the adapter to convert kilometers to miles
        double miles = adapter.convert(kilometers);

        // Display the result
        System.out.println("Distance in miles: " + miles);

        scanner.close();
    }
}
