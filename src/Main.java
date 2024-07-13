import java.util.*;

public class Main {
    public static void main(String[] args) {                // MAIN METHOD
        System.out.println();
        yerlestir();
    }
    public static int indexBul(double[][] dizi,double sayi,int a) {         //2 boyutlu listeler için aranan index bulan metod
        int index = -1;
        for (int j = 0; j < 40; j++) {
            if (dizi[a][j] == sayi && dizi[a][j] != 0) {
                index = j;
            }
        }
        return index;
    }
    public static int tekindexBul(double[] dizi,double sayi) {                  //tek boyutlu listeler için aranan index bulan metod
        int index = -1;
        for (int j = 0; j < 40; j++) {
            if (dizi[j] == sayi && dizi[j] != 0) {
                index = j;
            }
        }
        return index;
    }
    public static double kucuksayiBul(double[][] yataysira,int index){             // çift boyutlu listelerde en küçük sayıyı bulan metod
        double kucukSayi = 999;
        for (int j = 0; j < 40; j++) {
            if (yataysira[index][j] < kucukSayi && yataysira[index][j] != 0){
                kucukSayi = yataysira[index][j];
            }
        }
        return kucukSayi;
    }
    public static double[][] matrisOlustur(){                                       // uzaklık matrisini oluşturan ve döndüren metod
        Random random = new Random();
        System.out.print("    0    ");
        double[][] uzaklik_matrisi = new double[40][40];
        for (int i = 1; i < 10; i++) {
            System.out.print(i+"    ");
        }
        for (int i = 10; i < 40; i++) {
            System.out.print(i+"   ");
        }
        System.out.println();
        for (int i = 0; i < 40; i++) {
            System.out.print(i+"| ");
            for (int j = 0; j < 40; j++) {
                if (uzaklik_matrisi[i][j] == 0){
                    double rastgele = random.nextDouble(10);
                    uzaklik_matrisi[i][j] = rastgele;
                    uzaklik_matrisi[j][i] = rastgele;
                    if (i == j){
                        uzaklik_matrisi[i][j] = 0;
                    }
                }
                System.out.print(String.format("%.2f",uzaklik_matrisi[i][j]) + " ");
            }
            System.out.println();
        }
        return uzaklik_matrisi;
    }
    public static void yerlestir(){                             // asıl yerleştirme işleminin yapıldığı metod.
        double[][] uzaklikMatrisi = matrisOlustur();
        System.out.println();
        System.out.print("                 1                     ");
        for (int i = 1; i < 4; i++) {
            System.out.print(i+1+ "                         ");
        }
        System.out.println();
        String[] isimler = {"Duane Mcfarland","Ayana Villalobos","Cecilia Ali","Damon Mcarthur","Dilan Cleveland",
                "Mattie Mccoy","Gareth Bellamy","Ryker Sutherland", "Leona Vincent","Tiah Todd", "Cali Watts",
                "Prince Sharples", "Ishmael Cooley", "Liya Nichols","Ines Newton","Aaryan Meadows","Matt Lu",
                "Tamzin Molloy","Abdul Nolan","Kaelan Dyer","Emilija Shields","Korben Magana","Mariah Dillard",
                "Stanley Mac","Krystian Kirkland","Leticia Knox","Braden Poole","Hester Villa","Keenan Henderson",
                "Dominick Lin","Kay Trevino","Howard Mccartney","Josef Kaufman","Roberto Pollard","Najma Valentine",
                "Homer Dorsey","Umaima Patrick","Sumayya Dennis","Patrick Morin","Kamil Davey"};
        yolcular [] yolcu = new yolcular [40];
        double[][] en_kucukler = new double[10][4];
        for (int i = 1; i < 40; i++)
        {
            yolcu[i] = new yolcular("0",0);
        }
        double [][] uzaklikMatrisi2 = new double[uzaklikMatrisi.length][];
        for(int i = 0; i < uzaklikMatrisi.length; i++)
            uzaklikMatrisi2[i] = uzaklikMatrisi[i].clone();
        Random random = new Random();
        int rastgele_2 = random.nextInt(40);
        Object[][] koltuk_matrisi = new Object[10][4];
        String ilk_yolcu = isimler[rastgele_2];
        yolcular yolcu1 = new yolcular(ilk_yolcu,rastgele_2);       //ilk yolcunun oluşturulduğu yer.
        koltuk_matrisi[0][0] = yolcu1;                      // ilk yolcunun ilk koltuğa koyulduğu yer.
        yolcu[0] = yolcu1;
        en_kucukler[0][0] = 0;
        ArrayList<Integer> yolcu_indexleri = new ArrayList<>();
        yolcu_indexleri.add(0, yolcu[0].getIndex());
        for (int i = 0; i < 10; i++) {                      // yerleştirme işleminin başladığı yer.
            System.out.print(i+1+"| ");
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    System.out.print("  ");
                }
                if (i == 0 && j != 0) {                             //  ilk 4 yolcunun yerleştirildiği kod parçası.
                    double kucuk_Sayi = kucuksayiBul(uzaklikMatrisi2, rastgele_2);
                    double kucuk_Sayi2 = kucuksayiBul(uzaklikMatrisi2, rastgele_2);
                    double kucuk_Sayi3 = kucuksayiBul(uzaklikMatrisi2, rastgele_2);
                    if (j == 1) {
                        koltuk_matrisi[i][j] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2)); // YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                        yolcu[1] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2));
                        rastgele_2 = indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2);
                        uzaklikMatrisi2[rastgele_2][indexBul(uzaklikMatrisi2, kucuk_Sayi, rastgele_2)] = 0;
                        yolcu_indexleri.add(1, yolcu[1].getIndex());
                        en_kucukler[0][1] = kucuk_Sayi;
                    }
                    if (j == 2) {
                        koltuk_matrisi[i][j] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2));// YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                        yolcu[2] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2));
                        rastgele_2 = indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2);
                        uzaklikMatrisi2[rastgele_2][indexBul(uzaklikMatrisi2, kucuk_Sayi2, rastgele_2)] = 0;
                        yolcu_indexleri.add(2, yolcu[2].getIndex());
                        en_kucukler[0][2] = kucuk_Sayi2;
                    }
                    if (j == 3) {
                        koltuk_matrisi[i][j] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi3, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi3, rastgele_2));// YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                        yolcu[3] = new yolcular(isimler[indexBul(uzaklikMatrisi2, kucuk_Sayi3, rastgele_2)], indexBul(uzaklikMatrisi2, kucuk_Sayi3, rastgele_2));
                        uzaklikMatrisi2[rastgele_2][indexBul(uzaklikMatrisi2, kucuk_Sayi3, rastgele_2)] = 0;
                        yolcu_indexleri.add(3, yolcu[3].getIndex());
                        en_kucukler[0][3] = kucuk_Sayi3;
                    }
                }
                if (j == 0 && i != 0) {                             // ilk sütundaki koltuklara yerleştirilecek yolcular için yazılan kod parçası.
                    int a = yolcu[4*(i-1) + j].getIndex();
                    int b = yolcu[4*(i-1) + j + 1].getIndex();
                    double[] toplam = new double[40];
                    for (int k = 0; k < 40; k++) {
                        if((k != a && k != b) && (uzaklikMatrisi[a][k] != 0 && uzaklikMatrisi[b][k] != 0) && uzaklikMatrisi[k][a] != 0 && uzaklikMatrisi[k][b] != 0){
                            toplam[k] = uzaklikMatrisi[a][k] + uzaklikMatrisi[b][k];
                        }
                    }
                    double enKucuk;
                    int sira;
                    int l;
                    for (int k = 0; k < 40; k++) {                      // UZAKLIK MATRİSİNDEKİ DEĞERLERİ DÖNEREK EN KÜÇÜK DEĞERİ BULAN DÖNGÜ
                        for (int m = 0; m < 40; m++) {
                            enKucuk = 999;
                            if (enKucuk > toplam[m] && toplam[m] != 0){
                                enKucuk = toplam[m];
                                sira= tekindexBul(toplam,enKucuk);
                                l = sira;
                                if (yolcu_indexleri.contains(sira)){
                                    toplam[l] = 0;                      // EĞER YOLCU ÖNCEDEN YERLEŞTİRİLDİYSE ONU ES GEÇMEYİ SAĞLAYAN KOD.
                                }
                            }
                            en_kucukler[i][j] = enKucuk;
                        }
                    }
                    enKucuk = 999;
                    for (int m = 0; m < 40; m++) {
                        if (enKucuk > toplam[m] && toplam[m] != 0) {
                            enKucuk = toplam[m];
                        }}
                    en_kucukler[i][j] = enKucuk;
                    sira = tekindexBul(toplam,enKucuk);
                    koltuk_matrisi[i][j] = new yolcular(isimler[sira], sira);               // YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                    yolcu[4*i+j] = new yolcular(isimler[sira], sira);
                    yolcu_indexleri.add(4 * i + j, yolcu[4 * i + j].getIndex());
                }
                if((j == 1 || j == 2) && i != 0){                // 2. ve 3. sütunlardaki koltuklara yerleştirilecek yolcular için yazılan kod parçası.
                    int a = yolcu[4*i+j-1].getIndex();
                    int b = yolcu[4 * i - 4 + j - 1].getIndex();
                    int c = yolcu[4*i-4+j].getIndex();
                    int d = yolcu[4 * i - 4 + j + 1].getIndex();
                    double[] toplam2 = new double[40];
                    for (int k = 0; k < 40; k++) {
                        if((k != a && k != b && k!= c && k!= d) && (uzaklikMatrisi[a][k] != 0 && uzaklikMatrisi[b][k] != 0 &&
                                uzaklikMatrisi[c][k] != 0 && uzaklikMatrisi2[d][k]!= 0)&& uzaklikMatrisi[k][a] != 0 && uzaklikMatrisi[k][b] != 0 &&
                                uzaklikMatrisi[k][c] != 0 && uzaklikMatrisi2[k][d]!= 0) {
                            toplam2[k] = uzaklikMatrisi[a][k] + uzaklikMatrisi[b][k]+uzaklikMatrisi[c][k] + uzaklikMatrisi[d][k] ;
                        }
                    }
                    double enKucuk2;
                    int sira2;
                    int l;
                    for (int k = 0; k < 40; k++) {
                        enKucuk2 = 999;
                        for (int m = 0; m < 40; m++) {                      // UZAKLIK MATRİSİNDEKİ DEĞERLERİ DÖNEREK EN KÜÇÜK DEĞERİ BULAN DÖNGÜ
                            if (enKucuk2 > toplam2[m] && toplam2[m] != 0){
                                enKucuk2 = toplam2[m];
                                sira2= tekindexBul(toplam2,enKucuk2);
                                l = sira2;
                                if (yolcu_indexleri.contains(sira2)){
                                    toplam2[l] = 0;                         // EĞER YOLCU ÖNCEDEN YERLEŞTİRİLDİYSE ONU ES GEÇMEYİ SAĞLAYAN KOD.
                                }
                            }
                            en_kucukler[i][j] = enKucuk2;
                        }
                    }
                    enKucuk2 = 999;
                    for (int m = 0; m < 40; m++) {
                        if (enKucuk2 > toplam2[m] && toplam2[m] != 0) {
                            enKucuk2 = toplam2[m];
                        }}
                    en_kucukler[i][j] = enKucuk2;
                    sira2 = tekindexBul(toplam2,enKucuk2);
                    koltuk_matrisi[i][j] = new yolcular(isimler[sira2], sira2);             // YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                    yolcu[4*i+j] = new yolcular(isimler[sira2], sira2);
                    yolcu_indexleri.add(4 * i + j, yolcu[4 * i + j].getIndex());
                }
                if(j == 3 && i != 0){                               // son sütundaki koltuklara yerleştirilecek yolcular için yazılan kod parçası.
                    int a = yolcu[4*i+j-1].getIndex();
                    int b = yolcu[4*(i-1) + j - 1].getIndex();
                    int c = yolcu[4*(i-1)+j].getIndex();
                    double[] toplam2 = new double[40];
                    for (int k = 0; k < 40; k++) {
                        if((k != a && k != b && k!= c) && (uzaklikMatrisi[a][k] != 0 && uzaklikMatrisi[b][k] != 0 && uzaklikMatrisi[c][k] != 0) &&
                                uzaklikMatrisi[k][a] != 0 && uzaklikMatrisi[k][b] != 0 && uzaklikMatrisi[k][c] != 0){
                            toplam2[k] = uzaklikMatrisi[a][k] + uzaklikMatrisi[b][k]+uzaklikMatrisi[c][k];
                        }
                    }
                    double enKucuk3;
                    int sira3;
                    int l;
                    for (int k = 0; k < 40; k++) {                      // UZAKLIK MATRİSİNDEKİ DEĞERLERİ DÖNEREK EN KÜÇÜK DEĞERİ BULAN DÖNGÜ
                        enKucuk3 = 999;
                        for (int m = 0; m < 40; m++) {
                            if (enKucuk3 > toplam2[m] && toplam2[m] != 0){
                                enKucuk3 = toplam2[m];
                                sira3= tekindexBul(toplam2,enKucuk3);
                                l = sira3;
                                if (yolcu_indexleri.contains(sira3)) {
                                    toplam2[l] = 0;                  // EĞER YOLCU ÖNCEDEN YERLEŞTİRİLDİYSE ONU ES GEÇMEYİ SAĞLAYAN KOD.
                                }
                            }
                            en_kucukler[i][j] = enKucuk3;
                        }
                    }
                    enKucuk3 = 999;
                    for (int m = 0; m < 40; m++) {
                        if (enKucuk3 > toplam2[m] && toplam2[m] != 0) {
                            enKucuk3 = toplam2[m];
                        }}
                    en_kucukler[i][j] = enKucuk3;
                    sira3 = tekindexBul(toplam2,enKucuk3);
                    koltuk_matrisi[i][j] = new yolcular(isimler[sira3], sira3);   // YOLCU SINIFINDAN NESNE ÜRETİLEREK KOLTUK MATRİSİNE EKLENEN YER.
                    yolcu[4*i+j] = new yolcular(isimler[sira3], sira3);
                    yolcu_indexleri.add(4 * i + j, yolcu[4 * i + j].getIndex());
                }
                System.out.print(koltuk_matrisi[i][j] + " ");                   // KOLTUK MATRİSİNİN for döngüsü yardımıyla yazdırıldığı yer.
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("     1     ");
        for (int i = 1; i < 4; i++) {
            System.out.print(i+1+"     ");
        }
        System.out.println();
        double tdtoplam = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print(i+1+"| ");
            for (int j = 0; j < 4; j++) {
                tdtoplam += en_kucukler[i][j];
                System.out.print(String.format("%5.2f",en_kucukler[i][j]) + " ");                   // yerleştirilen yolcuların birbirine olan uzaklıklarının yazdırıldığı kod.
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("YERLESTIRILEN YOLCULARIN UZAKLIKLAR TOPLAMI = "+String.format("%.2f",tdtoplam));       // e maddesinde istenen toplam değerini yazdırıldığı kod.
    }
}