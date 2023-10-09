import java.util.Scanner;

interface Clothing {
    String getDescription();
}

class TShirt implements Clothing {
    @Override
    public String getDescription() {
        return "T-shirt";
    }
}

class Jeans implements Clothing {
    @Override
    public String getDescription() {
        return "Jeans";
    }
}

interface ClothingDecorator extends Clothing {
    String getAdditionalDescription();
}

class SweaterDecorator implements ClothingDecorator {
    private final Clothing clothing;

    public SweaterDecorator(Clothing clothing) {
        this.clothing = clothing;
    }

    @Override
    public String getDescription() {
        return clothing.getDescription() + " with Sweater";
    }

    @Override
    public String getAdditionalDescription() {
        return "Sweater";
    }
}

class ShortsDecorator implements ClothingDecorator {
    private final Clothing clothing;

    public ShortsDecorator(Clothing clothing) {
        this.clothing = clothing;
    }

    @Override
    public String getDescription() {
        return clothing.getDescription() + " with Shorts";
    }

    @Override
    public String getAdditionalDescription() {
        return "Shorts";
    }
}

class ClothingMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Clothing Menu:");
        System.out.println("Select a base clothing item:");

        Clothing clothing = null;

        while (clothing == null) {
            System.out.println("1. T-shirt");
            System.out.println("2. Jeans");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clothing = new TShirt();
                    break;
                case 2:
                    clothing = new Jeans();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        System.out.println("Do you want to add any extras?");
        System.out.println("1. Sweater");
        System.out.println("2. Shorts");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                clothing = new SweaterDecorator(clothing);
                break;
            case 2:
                clothing = new ShortsDecorator(clothing);
                break;
            default:
                System.out.println("No extras selected.");
        }

        System.out.println("You've selected: " + clothing.getDescription());

        scanner.close();
    }
}
