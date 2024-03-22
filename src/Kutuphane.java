import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kutuphane {
    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public void kutuphaneOlustur(){
        List<Kitap> kitapList = new ArrayList<>();
        kitapList.add(new KitapBilim("1000","Beyin","David Eagleman", LocalDate.of(2015, Month.OCTOBER,06),Durum.ODUNC_ALINABILIR," Büyük ilgi gören kitabı Incognito ile nörobilimi geniş kitlelerle buluşturan David Eagleman, bizi içimizdeki kozmosa doğru hızlı ve nefes kesici bir yolculuğa çıkarıyor"));
        kitapList.add(new KitapBilim("1001","Türlerin Kökeni","Charles Darwin", LocalDate.of(1859, Month.NOVEMBER,24),Durum.ODUNC_ALINABILIR," Türlerin Kökeni, İngiliz doğa tarihçisi Charles Darwin'in 24 Kasım 1859'da yayımlanan kitabı. Orijinal adı Doğal Seçilim Yoluyla Türlerin Kökeni ya da Yaşam Mücadelesinde Avantajlı Irkların Korunumu Üzerine idi, ancak 1872'de çıkan 6. baskısında Türlerin Kökeni olarak kısaltıldı."));
        kitapList.add(new KitapBilim("1002","Büyük Tasarım","Stephen Hawking", LocalDate.of(2010, Month.OCTOBER,2),Durum.ODUNC_ALINABILIR," Büyük Tasarım 2010 yılında fizikçiler Stephen Hawking ve Leonard Mlodinow tarafından yazılıp Bantam Books yayınevi tarafından yayımlanan popüler bilim kitabıdır."));
        kitapList.add(new KitapRoman("2000","Kürk Mantolu Madonna","Sabahattin Ali", LocalDate.of(1960, Month.JULY,11),Durum.ODUNC_ALINABILIR," Kürk Mantolu Madonna, Sabahattin Ali'nin 1943 yılında yayımladığı bir romanıdır."));
        kitapList.add(new KitapRoman("2001","Bülbülü Öldürmek","Harper Lee", LocalDate.of(2010, Month.OCTOBER,2),Durum.ODUNC_ALINABILIR,"Bülbülü Öldürmek, ABD'li yazar Harper Lee'nin 1960'ta yayınlanan ve Pulitzer Ödülü kazanan romanıdır."));
        kitapList.add(new KitapRoman("2002","Simyacı","Paulo Coelho", LocalDate.of(1998, Month.DECEMBER,22),Durum.ODUNC_ALINABILIR," Simyacı, Brezilyalı yazar Paulo Coelho'nun yazdığı ve yayımlandığı yıl olan 1988'den bu yana dünyayı birbirine katan, eleştirmenler tarafından bir fenomen olarak değerlendirilen fantastik ve nasihat romanıdır."));
        kitapList.add(new KitapRoman("2003","Yabancı","Albert Camus", LocalDate.of(1942, Month.APRIL,12),Durum.ODUNC_ALINABILIR," Yabancı, Albert Camus'nün 1942 yılında yayımlanan romanı. Eser Camus'nün edebiyat alanında verdiği en önemli yapıt olarak kabul edilir."));
        kitapList.add(new KitapTarih("3000","Suyu Arayan Adam","Şevket Süreyya Aydemir", LocalDate.of(1959, Month.SEPTEMBER,19),Durum.ODUNC_ALINABILIR,"Suyu Arayan Adam, Şevket Süreyya Aydemir'in kendi yaşamını anlattığı 1959 yılında tamamladığı kitap"));
        kitapList.add(new KitapTarih("3001","Fidel Castro","Fidel Castro", LocalDate.of(2006, Month.MAY,9),Durum.ODUNC_ALINABILIR,"fidel Castro ve Ignacio Ramonet'nin yazdığı My Life: A Spoken Autobiography 2006'da İspanyolca, 2008'de İngilizce yayınlandı."));
        kitapList.add(new KitapTarih("3002","Tarih","Herodot", LocalDate.of(1903, Month.OCTOBER,2),Durum.MEVCUT_DEGIL,"Bilinmiyor."));
        kitapList.add(new KitapTarih("3003","Devlet Ana","Kemal Tahir", LocalDate.of(1967, Month.APRIL,14),Durum.ODUNC_ALINABILIR,"Devlet Ana, Türk edebiyatının önemli yazarlarından Kemal Tahir'in, 1967 yılında yayımladığı en önemli eserlerinden olan, bir tarihi romandır."));
        setKitaplar(kitapList);
        List<Uye> uyeler = new ArrayList<>();
        uyeler.add(new Uye("Akif","akif12","12345","5556667788",Gender.MALE,ERole.ADMIN));
        uyeler.add(new Uye("elif","elif2","123456","5326669911",Gender.FEMALE));
        setUyeler(uyeler);
    }

    public Kutuphane() {
        kutuphaneOlustur();
    }

    public List<Kitap> getKitaplar() {
        return kitaplar;
    }

    public void setKitaplar(List<Kitap> kitaplar) {
        this.kitaplar = kitaplar;
    }

    public List<Uye> getUyeler() {
        return uyeler;
    }

    public void setUyeler(List<Uye> uyeler) {
        this.uyeler = uyeler;
    }

    public void uyeEkle(Uye uye){
        getUyeler().add(uye);
    }


    public void kitapListele(Uye uye) {
        if (uye.getUyeKitaplar().isEmpty()){
            System.out.println("Odunc aldiginiz kitap bulunmamaktadir");
        }else {
            uye.getUyeKitaplar().forEach(System.out::println);
        }
    }

    public void kitapOduncAl(Uye uye) {
        System.out.println("Mevcut kitaplar:");
        getKitaplar().stream()
                .filter(kitap -> kitap.getDurum() == Durum.ODUNC_ALINABILIR)
                .forEach(System.out::println);
        System.out.println("Ödünç almak istediğiniz kitabın ISBN numarasını giriniz:");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();

        Optional<Kitap> oduncAlinanKitap = getKitaplar().stream()
                .filter(kitap -> kitap.getISBN().equals(isbn))
                .findFirst();
        if (oduncAlinanKitap.isPresent()) {
            Kitap kitap = oduncAlinanKitap.get();
            uye.kitapAl(kitap);
            kitap.setDurum(Durum.ODUNC_VERILDI);
            System.out.println("Kitap başarıyla ödünç alındı.");
        } else {
            System.out.println("Belirtilen ISBN numarasına sahip bir kitap bulunamadı.");
        }
    }

    public void kitapDurumDegistir() {
        System.out.println("Durumunu degistirmek istediğiniz kitabın ISBN numarasını giriniz:");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        Optional<Kitap> durumKitap = getKitaplar().stream()
                .filter(kitap -> kitap.getISBN().equals(isbn))
                .findFirst();
        if (durumKitap.isPresent()) {
            Kitap kitap = durumKitap.get();
            System.out.println("Guncel durumunu seciniz");
            System.out.println("1-ODUNC_VERILDI   2-ODUNC_ALINABILIR  3-MEVCUT_DEGIL");
            String secim = scanner.nextLine();
            switch (Integer.valueOf(secim)){
                case 1:
                    kitap.setDurum(Durum.ODUNC_VERILDI);
                    break;
                case 2:
                    kitap.setDurum(Durum.ODUNC_ALINABILIR);
                    break;
                case 3:
                    kitap.setDurum(Durum.MEVCUT_DEGIL);
                    break;
                default:
                    System.out.println("Lutfen gecerli bir sayi giriniz");
                    kitapDurumDegistir();
            }

            System.out.println("Kitabin durumu başarıyla  degistirildi.");
        } else {
            System.out.println("Belirtilen ISBN numarasına sahip bir kitap bulunamadı.");
        }
    }

    public void kitapTeslimEt(Uye uye) {
        System.out.println("Teslim edilebilir kitaplar:");
        uye.getUyeKitaplar().forEach(System.out::println);
        System.out.println("Teslim etmek istediğiniz kitabın ISBN numarasını giriniz:");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();

        Optional<Kitap> teslimEdilecekKitap = getKitaplar().stream()
                .filter(kitap -> kitap.getISBN().equals(isbn))
                .findFirst();
        if (teslimEdilecekKitap.isPresent()) {
            Kitap kitap = teslimEdilecekKitap.get();
            uye.kitapIadeEt(kitap);
            kitap.setDurum(Durum.ODUNC_ALINABILIR);
            System.out.println("Kitap başarıyla teslim edildi.");
        } else {
            System.out.println("Belirtilen ISBN numarasına sahip bir kitap bulunamadı.");
        }
    }

    public void uyeKitaplariListele() {
        System.out.println("Listelemek istediginiz uye kullanici adini giriniz");
        Scanner scanner = new Scanner(System.in);
        String kullaniciAd = scanner.nextLine();

        Optional<Uye> uyeler = getUyeler().stream()
                .filter(uye -> uye.getKullaniciAdi().equals(kullaniciAd))
                .findFirst();
        if (uyeler.isPresent()) {
            if(uyeler.get().getUyeKitaplar().isEmpty()){
                System.out.println("Uyenin kitabi bulunmamaktadir");
            }else{
                uyeler.get().getUyeKitaplar().forEach(System.out::println);
            }
        } else {
            System.out.println("Belirtilen kullanici adina sahip bir kullanici bulunamadı.");
        }
    }

    public void mevcutKitaplar() {
        System.out.println("-----Mevcut Kitaplar-----");
        getKitaplar().forEach(kitap -> System.out.println(kitap + "       Durumu -> " + kitap.getDurum().toString()));
    }

    public void kitapEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eklemek istediginiz kitabin ISBN numarasini giriniz");
        String isbn = scanner.nextLine();
        System.out.println("Kitabin adini giriniz");
        String ad = scanner.nextLine();
        System.out.println("Yazari giriniz");
        String yazarAdi= scanner.nextLine();
        System.out.println("Yayin Yilini giriniz (yyyy-aa-gg");
        String yayinYili = scanner.nextLine();
        System.out.println("Kitabin aciklamasini giriniz");
        String aciklama = scanner.nextLine();
        System.out.println("Kitabin turunu giriniz (ROMAN - TARIH - BILIM )");
        String tur = scanner.nextLine();
        LocalDate yayinYiliDate = LocalDate.parse(yayinYili);
        if (tur.equals("ROMAN")){
            Kitap kitap = new KitapRoman(isbn,ad,yazarAdi,yayinYiliDate,Durum.ODUNC_ALINABILIR,aciklama);
            getKitaplar().add(kitap);
            System.out.println("Basarili sekilde eklendi");
        } else if (tur.equals("TARIH")) {
            Kitap kitap = new KitapTarih(isbn,ad,yazarAdi,yayinYiliDate,Durum.ODUNC_ALINABILIR,aciklama);
            getKitaplar().add(kitap);
            System.out.println("Basarili sekilde eklendi");
        }else if (tur.equals("BILIM")){
            Kitap kitap = new KitapBilim(isbn,ad,yazarAdi,yayinYiliDate,Durum.ODUNC_ALINABILIR,aciklama);
            getKitaplar().add(kitap);
            System.out.println("Basarili sekilde eklendi");
        }else{
            System.out.println("Yanlis Tur girdiniz");
            kitapEkle();
        }
    }

    public void uyeleriListele() {
        System.out.println("-----Mevcut Uyeler-----");
        getUyeler().forEach(System.out::println);
    }
}
