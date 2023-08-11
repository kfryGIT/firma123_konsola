import pl.workjava.firma.WniesekService;

import java.util.*;

public class SkanerWniosekUser {
    private WniesekService wniosekService;

    public static void handleCreateNewWniosek(Scanner scanner, WniesekService wniosekService) {//met. tworzy wniosek przy pomocy skanera
        System.out.println("Podaj nazwę wniosku:");
        String name = scanner.nextLine();

        System.out.println("Podaj cenę z paragonu:");
        int cena = scanner.nextInt();
        System.out.println("Podaj limit ceny z paragonu:");
        int cenaL = scanner.nextInt();
        System.out.println("Podaj liczbę dni w delegacji:");
        int dni = scanner.nextInt();
        System.out.println("Podaj dietę za dzień:");
        int cenaDay = scanner.nextInt();
        System.out.println("Podaj liczbę przejechanych kilometrów samochodem pracownika:");
        int autoKM = scanner.nextInt();
        System.out.println("Podaj stawkę za każdy przejechany km:");
        int autoC = scanner.nextInt();

        System.out.println("Utworzyłeś nowy wniosek.");


//PARAGONY!!!!!!!!!!!

        List<String> paragony = new ArrayList<>(); // Lista do przechowywania wybranych paragonów
        int sumaCenParagonow = 0; // suma cen paragonów

        Set<Integer> addedParagonTypes = new HashSet<>(); // Zbiór przechowujący typy paragonów, które zostały już dodane

        while (true) {
            System.out.println("Czy chcesz dodać paragon? Wybierz numer paragonu lub 0 aby zakończyć:");
            System.out.println("1. Cena paragonu za hotel");
            System.out.println("2. Cena paragonu za pociąg");
            System.out.println("3. Cena paragonu za aaa");
            System.out.println("4. Cena paragonu za bbb");
            System.out.println("5. Cena paragonu za ccc");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (addedParagonTypes.contains(choice)) {
                System.out.println("Paragon tego typu został już dodany. Wybierz inny typ lub 0 aby zakończyć.");
                continue;
            }

            int cenaParagonu = 0;

            switch (choice) {
                case 1:
                    paragony.add("paragon za hotel");
                    System.out.println("Podaj cenę paragonu za hotel:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 2:
                    paragony.add("paragon za pociąg");
                    System.out.println("Podaj cenę paragonu za pociąg:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 3:
                    paragony.add("paragon za aaa");
                    System.out.println("Podaj cenę paragonu za aaa:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 4:
                    paragony.add("paragon za bbb");
                    System.out.println("Podaj cenę paragonu za bbb:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                case 5:
                    paragony.add("paragon za ccc");
                    System.out.println("Podaj cenę paragonu za ccc:");
                    cenaParagonu = scanner.nextInt();
                    sumaCenParagonow += cenaParagonu;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór.");
                    break;
            }

            addedParagonTypes.add(choice);

            System.out.println("Czy chcesz dodać kolejny paragon? Wybierz numer paragonu lub 0 aby zakończyć:");
        }

        System.out.println("Dodałeś paragony: " + paragony);

        wniosekService.createNewWniosek(name, cena, cenaL, dni, cenaDay, autoKM, autoC, sumaCenParagonow);
    }
}
