package dataEntity;

public class Wniosek {

    private long id;
    private String name;
    private int dni;
    private int cenaDay;
    private int autoKM;
    private int autoC;
    private int sumaCenParagonow;

    public Wniosek(long id, String name, int dni, int cenaDay,
                   int autoKM, int autoC, int sumaCenParagonow) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.cenaDay = cenaDay;
        this.autoKM = autoKM;
        this.autoC = autoC;
        this.sumaCenParagonow=sumaCenParagonow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCenaDay() {
        return cenaDay;
    }

    public void setCenaDay(int cenaDay) {
        this.cenaDay = cenaDay;
    }

    public int getAutoKM() {
        return autoKM;
    }

    public void setAutoKM(int autoKM) {
        this.autoKM = autoKM;
    }

    public int getAutoC() {
        return autoC;
    }

    public void setAutoC(int autoC) {
        this.autoC = autoC;
    }

    public int getSumaCenParagonow() {
        return sumaCenParagonow;
    }

    public void setSumaCenParagonow(int sumaCenParagonow) {
        this.sumaCenParagonow = sumaCenParagonow;
    }



    //______________________________
    // ... pozostałe gettery i settery ...

    public int getCenaDayAll() {
        return dni * cenaDay;
    }

    public int getAutoAll() {
        return autoKM * autoC;
    }

    public int getCenaDelegacji() {
        return getCenaDayAll() + getAutoAll()+getSumaCenParagonow();
    }
    //_________________________________


    @Override
    public String toString() {
        return "Wniosek{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni=" + dni +
                ", cenaDay=" + cenaDay +
                ", autoKM=" + autoKM +
                ", autoC=" + autoC +
                ", sumaCenParagonów=" + sumaCenParagonow +
                '}';
    }
}
