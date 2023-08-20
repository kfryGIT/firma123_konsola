import pl.workjava.firma.WniesekService;

import java.util.*;

public class SkanerWniosekUser {
    private WniesekService wniosekService;

    public static void handleCreateNewWniosek(Scanner scanner, WniesekService wniosekService) {//met. tworzy wniosek przy pomocy skanera
        System.out.println("Podaj nazwe wniosku:");
        String name = scanner.nextLine();

        System.out.println("Podaj liczbe dni w delegacji:");
        int dni = scanner.nextInt();
        System.out.println("Podaj diete za dzien:");
        int cenaDay = scanner.nextInt();
        System.out.println("Podaj liczbe przejechanych kilometrow samochodem pracownika:");
        int autoKM = scanner.nextInt();
        System.out.println("Podaj stawke za przejechany km:");
        int autoC = scanner.nextInt();

        System.out.println("Utworzyles nowy wniosek.");


//PARAGONY!!!!!!!!!!!

        List<String> paragony = new ArrayList<>(); // Lista do przechowywania wybranych paragonów
        int sumaCenParagonow = 0; // suma cen paragonów

        Set<Integer> addedParagonTypes = new HashSet<>(); // Zbiór przechowujący typy paragonów, które zostały już dodane

        while (true) {
            System.out.println("Czy chcesz dodac paragon? Wybierz numer paragonu lub 0 aby zakonczyc:");
            System.out.println("1. Cena paragonu za hotel");
            System.out.println("2. Cena paragonu za pociag");
            System.out.println("3. Cena paragonu za samolot");
            System.out.println("4. Cena paragonu za kolacje");
            System.out.println("5. Cena paragonu za sniadania");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (addedParagonTypes.contains(choice)) {
                System.out.println("Paragon tego typu zostal juz dodany. Wybierz inny typ lub 0 aby zakonczyc.");
                continue;
            }

            int cenaParagonu = 0;

            switch (choice) {
                case 1:
                    paragony.add("paragon za hotel");
                    System.out.println("Podaj cene paragonu za hotel:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 2:
                    paragony.add("paragon za pociag");
                    System.out.println("Podaj cene paragonu za pociag:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 3:
                    paragony.add("paragon za samolot");
                    System.out.println("Podaj cene paragonu za samolot:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 4:
                    paragony.add("paragon za kolacje");
                    System.out.println("Podaj cene paragonu za kolacje:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 5:
                    paragony.add("paragon za sniadania");
                    System.out.println("Podaj cene paragonu za sniadania:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                default:
                    System.out.println("Nieprawidlowy wybor.");
                    break;
            }

            addedParagonTypes.add(choice);

            System.out.println("Czy chcesz dodac kolejny paragon? Wybierz numer paragonu lub 0 aby zakonczyc:");
        }

        System.out.println("Dodales paragony: " + paragony);

        wniosekService.createNewWniosek(name, dni, cenaDay, autoKM, autoC, sumaCenParagonow);
    }
}
