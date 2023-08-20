package pl.workjava.firma;

import dataEntity.Wniosek;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WniosekRepository {
    private List<Wniosek> wnioski = new ArrayList<>();

    //tworzenie owocu który wpłynoł do magazyny
    Wniosek createNew(String name,int dni, int cenaDay, int autoKM, int autoC, int sumaCenParagonow) {
        Random r = new Random();

        //int cenaAll, int cenaDayAll, int autoAll, int cena delegacji
        Wniosek wniosek = new Wniosek(r.nextInt(), name, dni, cenaDay, autoKM, autoC, sumaCenParagonow);
        this.wnioski.add(wniosek);
        System.out.println("utworzono nowy wniosek");
        return wniosek;
    }

    //zapisywanie do pliku

    void readAll() throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fr = new FileReader("./wnioski.json");//("./fruits.json")
        List<Wniosek> loadedFruits = gson.fromJson(fr, new TypeToken<List<Wniosek>>() {
        }.getType());
        this.wnioski.addAll(loadedFruits);
        this.wnioski.forEach(wniosek -> {
            //int cena, int cenaL, int dni, int cenaDay, int autoKM, int autoC
            System.out.println("załadowano wniosek " + wniosek.getName());
            System.out.println("ID wniosku " + wniosek.getId());
            System.out.println("liczba dni w delegacji " + wniosek.getDni());
            System.out.println("dieta za jeden dzień w delegacji " + wniosek.getCenaDay());
            System.out.println("liczba przejechanych kilometrów samochodem pracownika " + wniosek.getAutoKM());
            System.out.println("cena zwrotu za przejechany km " + wniosek.getAutoC());
            System.out.println("suma cen paragonów " + wniosek.getSumaCenParagonow());

            System.out.println("*___*");
            System.out.println("Zwrot diety za wszystkie dni delegacji " + wniosek.getCenaDayAll());
            System.out.println("Zwrot kosztów zw z podróżowaniem samochodem pracownika " + wniosek.getAutoAll());
            System.out.println("cena Delegacji " + wniosek.getCenaDelegacji());
            System.out.println("*********************************");
        });
    }

    void saveAll() throws IOException {
        Gson gson = new Gson();
        FileWriter fw = new FileWriter("./wnioski.json");
        gson.toJson(this.wnioski, fw);
        fw.flush();
        fw.close();//zamykamy new FileWriter
    }


}
