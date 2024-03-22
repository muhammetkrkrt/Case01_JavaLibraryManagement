import java.time.LocalDate;

public abstract class Kitap {
    private String ISBN;
    private String baslik;
    private String yazar;
    private LocalDate yayinYili;
    private Durum durum;
    public Kitap(String ISBN, String baslik, String yazar, LocalDate yayinYili) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
    }

    public Kitap(String ISBN, String baslik, String yazar, LocalDate yayinYili, Durum durum) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.durum = durum;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public LocalDate getYayinYili() {
        return yayinYili;
    }

    public void setYayinYili(LocalDate yayinYili) {
        this.yayinYili = yayinYili;
    }

    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "ISBN='" + ISBN + '\'' +
                ", baslik='" + baslik + '\'' +
                ", yazar='" + yazar + '\'' +
                ", yayinYili=" + yayinYili +
                '}';
    }
}
