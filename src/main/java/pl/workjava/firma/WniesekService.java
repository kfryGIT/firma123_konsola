package pl.workjava.firma;

import dataEntity.Wniosek;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WniesekService {



    private WniosekRepository repository;//wstrzykiwanie zalerznosci
    public WniesekService(WniosekRepository repository) {//wstrzykiwanie zalerznosci c.d. parametr
        this.repository = repository;
    }

    //magazynier tworzy nowy wniosek wywołując met.createNew z klasy service
    // ->potem serwis komunikuje się z repo gdzie jest lista wnioskow

    public Wniosek createNewWniosek(String name, int dni, int cenaDay, int autoKM, int autoC, int sumaCenParagonow){
        return this.repository.createNew(name, dni, cenaDay, autoKM, autoC, sumaCenParagonow);
    }

    public void readAll() {
        try {
            this.repository.readAll();
        }catch (FileNotFoundException e){
            System.out.println("nie znaleziono pliku");
        }
        }

    public void saveAll() throws IOException {
        this.repository.saveAll();}

}
