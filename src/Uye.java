import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uye implements IUye{

    private String ad;
    private String kullaniciAdi;
    private String password;
    private String telefon;
    private Gender gender;
    private ERole eRole = ERole.UYE;
    private List<Kitap> uyeKitaplar;

    public Uye(String ad, String kullaniciAdi, String password, String telefon, Gender gender) {
        this.ad = ad;
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;
        this.telefon = telefon;
        this.gender = gender;
    }
    public Uye(String ad, String kullaniciAdi, String password, String telefon, Gender gender, List<Kitap> uyeKitaplar) {
        this.ad = ad;
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;
        this.telefon = telefon;
        this.gender = gender;
        this.uyeKitaplar = uyeKitaplar;
    }

    public Uye(String ad, String kullaniciAdi, String password, String telefon, Gender gender, ERole eRole) {
        this.ad = ad;
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;
        this.telefon = telefon;
        this.gender = gender;
        this.eRole = eRole;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Kitap> getUyeKitaplar() {
        if (uyeKitaplar == null) {
            uyeKitaplar = new ArrayList<>();
        }
        return uyeKitaplar;
    }

    public void setUyeKitaplar(List<Kitap> uyeKitaplar) {
        this.uyeKitaplar = uyeKitaplar;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }

    @Override
    public String toString() {
        return "Uye{" +
                "ad='" + ad + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", password='" + password + '\'' +
                ", telefon='" + telefon + '\'' +
                ", gender=" + gender +
                ", uyeKitaplar=" + uyeKitaplar +
                '}';
    }

    @Override
    public void kitapAl(Kitap kitap) {
        getUyeKitaplar().add(kitap);
    }

    @Override
    public void kitapIadeEt(Kitap kitap) {
        getUyeKitaplar().remove(kitap);
    }
}
