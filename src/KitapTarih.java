import java.time.LocalDate;

public class KitapTarih extends Kitap{

    private String aciklama;


    public KitapTarih(String ISBN, String baslik, String yazar, LocalDate yayinYili, String aciklama) {
        super(ISBN, baslik, yazar, yayinYili);
        this.aciklama = aciklama;
    }

    public KitapTarih(String ISBN, String baslik, String yazar, LocalDate yayinYili, Durum durum, String aciklama) {
        super(ISBN, baslik, yazar, yayinYili, durum);
        this.aciklama = aciklama;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
