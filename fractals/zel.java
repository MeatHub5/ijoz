import java.awt.Color;

public class zel {
    //pozicija
    double x;
    double y;
    //smer
    int fi;

public zel(double x1,double y1,int a) {
    super();
    x=x1;
    y=y1;
    fi=a;
}

public void levo(int kot){
    fi=fi+kot;
}

public void naprej(double korak){
 double stariX=x;
 double stariY=y;
 x+=korak*Math.cos(Math.toRadians(fi));
 y+=korak*Math.sin(Math.toRadians(fi));
 StdDraw.line(stariX, stariY, x, y);
 }


public static void tree(int n, double x, double y, double a, double branchRadius) {
    double bendAngle = Math.toRadians(0);
    double branchAngle = Math.toRadians(45);
    double branchRatio = .65;
    double cx = x + Math.cos(a) * branchRadius;
    double cy = y + Math.sin(a) * branchRadius;
    StdDraw.setPenRadius(.001 * Math.pow(n, 1.15));
    StdDraw.line(x, y, cx, cy);
    if (n == 0) return;
    tree(n-1, cx, cy, a + bendAngle - branchAngle, branchRadius * branchRatio);
    tree(n-1, cx, cy, a + bendAngle + branchAngle, branchRadius * branchRatio);
    tree(n-1, cx, cy, a + bendAngle, branchRadius * (1 - branchRatio));
}
 

public static void sierpinski(int n, double x, double y, double stranica) {
    if (n == 0) {
        double h = stranica * Math.sqrt(3) / 2;
        
        double[] vx = { x, x + stranica, x + stranica / 2 };
        double[] vy = { y, y, y + h };
        
        StdDraw.filledPolygon(vx, vy);
        return;
    }

    double h = stranica * Math.sqrt(3) / 2;

    sierpinski(n - 1, x, y, stranica / 2);                       // Spodnji levi
    sierpinski(n - 1, x + stranica / 2, y, stranica / 2);        // Spodnji desni
    sierpinski(n - 1, x + stranica / 4, y + h / 2, stranica / 2);  // Zgornji
}
/* 
public static void sierpinskiZelva(int n, double korak, zel m) {
    if (n == 0) {
        m.naprej(korak);
        return;
    }

    sierpinskiZelva(n - 1, korak, m);
    m.levo(120);
    sierpinskiZelva(n - 1, korak, m);
    m.levo(120);
    sierpinskiZelva(n - 1, korak, m);
    m.levo(120);
}
*/
/* 
public static void fraktalnaRoza(int n, double korak, zel m) {
    if (n == 0) {
        m.naprej(korak);
        return;
    }
    m.naprej(korak);
    m.levo(45);
    fraktalnaRoza(n - 1, korak * 0.5, m);
    m.levo(-45);
    m.levo(-45);
    fraktalnaRoza(n - 1, korak * 0.5, m);
    m.levo(45);
    fraktalnaRoza(n - 1, korak * 0.4, m);
}
*/
public static void fraktalnaRoza(int n, int maxN, double korak, zel m, int casovniKorak) {
    if (n == 0) {
        // Tudi na koncu nastavimo barvo za zadnji najmanjši korak
        nastaviMavricnoBarvo(n, maxN, casovniKorak);
        m.naprej(korak);
        return;
    }

    // Preden želva potegne črto, nastavimo barvo za trenutni nivo globine
    nastaviMavricnoBarvo(n, maxN, casovniKorak);
    m.naprej(korak);

    // Razcep v levo stran
    m.levo(45);
    fraktalnaRoza(n - 1, maxN, korak * 0.5, m, casovniKorak);
    m.levo(-45);

    // Razcep v desno stran
    m.levo(-45);
    fraktalnaRoza(n - 1, maxN, korak * 0.5, m, casovniKorak);
    m.levo(45);
    
    // Dodaten rekurzivni korak naravnost
    fraktalnaRoza(n - 1, maxN, korak * 0.4, m, casovniKorak);
}

// Rekurzivna metoda za risanje logaritemske spirale
public static void fraktalnaSpirala(int korak, int maxKorakov, double dolzinaKoraka, zel m) {
    // Bazni primer: ko dosežemo želeno število zavojev, se ustavimo
    if (korak >= maxKorakov) {
        return;
    }

    // 1. Dinamično nastavimo barvo za ta del spirale
    nastaviSpiralnoBarvo(korak, maxKorakov);
    
    // 2. Nastavimo debelino črte: v središču (začetek) je tanjša, zunaj postane debelejša
    StdDraw.setPenRadius(0.001 + ((double)korak / maxKorakov) * 0.005);

    // 3. Želva naredi premik naprej in zavoj
    m.naprej(dolzinaKoraka);
    m.levo(12); // Kot določa, kako tesno je spirala zvita (poskusi med 10 in 15)

    // 4. Rekurzivni klic: povečamo števec korakov in logaritemsko podaljšamo naslednji korak
    // Množenje z 1.012 poskrbi, da se spirala lepo odpira navzven
    fraktalnaSpirala(korak + 1, maxKorakov, dolzinaKoraka * 1.012, m);
}


public static void nastaviPeriodicnoBarvo(int korak) {
    float hue = (korak % 100) / 100.0f;
    java.awt.Color barva = java.awt.Color.getHSBColor(hue, 0.8f, 0.9f);
    StdDraw.setPenColor(barva);
}

public static void nastaviMavricnoBarvo(int n, int maxN, int casovniKorak) {
    float faktorRazdalje = (float) n / maxN;
    float hue = ((casovniKorak % 100) / 100.0f) + (faktorRazdalje * 0.4f);
    hue = hue % 1.0f;
    java.awt.Color barva = java.awt.Color.getHSBColor(hue, 0.85f, 0.95f);
    StdDraw.setPenColor(barva);
}

// Metoda nastavi barvo na spektru med zeleno in modro glede na oddaljenost (trenutni korak)
public static void nastaviSpiralnoBarvo(int trenKorak, int maxKorakov) {
    // Delež nam pove, kako daleč v spirali smo (od 0.0 do 1.0)
    float delež = (float) trenKorak / maxKorakov;
    
    // Zelena barva na HSB krogu je okoli 0.33, modro-turkizna pa okoli 0.55
    // Z linearno interpolacijo ustvariva prehod natančno med tema dvema odtenkoma
    float hue = 0.33f + (delež * 0.22f);
    
    // Ustvarimo barvo s polno nasičenostjo
    java.awt.Color barva = java.awt.Color.getHSBColor(hue, 0.85f, 0.8f);
    StdDraw.setPenColor(barva);
}




 public static void main(String[] args) {
    /*zel z=new zel(0.5, 0.5, 180/3);
    for(int k=0;k<30000;k++){
        z.naprej(0.03);
        z.levo(180/15);
    }*/

    /*zel z=new zel(0.5, 0.5, 0);
    for(int k=0;k<10000;k++){
        z.naprej(0.01);
        int kot=(int)(Math.random()*360);
        z.levo(kot);
    }*/
/* 
    zel z=new zel(0, 0, 0);
        int n=5;
        double korak=1/Math.pow(3, n);
        koch(n,korak,z);
        z.levo(120);
        koch(n,korak, z);
        z.levo(120);
        koch(n,korak, z);
    */
/* 
        int n =10;
        StdDraw.show(0);
        tree(n, .5, 0, Math.PI/2, 0.3);
        StdDraw.show(0);
*/
/* 
        int n = 10; 
        StdDraw.show(0);
        Color barva=new Color(n*10,0,0);
        StdDraw.setPenColor(barva);
        sierpinski(n, 0.1, 0.1, 0.8);
        StdDraw.show(0);

        int casovniKorak = 0;
    
    while (true) {
        StdDraw.clear(); 
        nastaviPeriodicnoBarvo(casovniKorak);
        sierpinski(n, 0.1, 0.1, 0.8);
        tree(n, 0.5, Math.PI/2, 0.3,0.1);
        StdDraw.show(50); 
        casovniKorak++;
    }
        *//* 
    int n = 8;
    int casovniKorak = 0;

    while (true) {
        StdDraw.clear();
        nastaviPeriodicnoBarvo(casovniKorak);
        for (int i = 0; i < 8; i++) {
            zel z = new zel(0.5, 0.5, i * 45);
            fraktalnaRoza(n, 0.05, z);
        }
        StdDraw.show(100);
        
        casovniKorak++;
    }
    *
    int n = 8; 
    int casovniKorak = 0;

    while (true) {
        StdDraw.clear(); 
        for (int i = 0; i < 8; i++) {
            zel z = new zel(0.5, 0.5, i * 45);
            fraktalnaRoza(n, n, 0.05, z, casovniKorak);
        }
        
        StdDraw.show(80); 
        casovniKorak++;
    }
*/
    int maxKorakov = 500; 
    
    // Izklopimo sprotno osveževanje za takojšen gladek prikaz
    StdDraw.show(0);
    StdDraw.clear(new java.awt.Color(10, 25, 20)); // Temno ozadje kot na sliki

    // Narišemo 3 prepletene spirale, zamaknjene za 120 stopinj, da dobimo bogat volumen
    for (int i = 0; i < 6; i++) {
        // Želvo postavimo v središče (0.5, 0.5) z začetnim kotom (0, 120, 240)
        zel z = new zel(0.5, 0.5, i * 120);
        
        // Zaženemo rekurzijo: začnemo pri koraku 0, z zelo majhnim začetnim korakom (0.002)
        fraktalnaSpirala(0, maxKorakov, 0.002, z);
    }

    // Končni prikaz na zaslonu
    StdDraw.show(0);

 }

public static void koch(int n,double korak,zel m){
    if (n==0){
        m.naprej(korak);
        return;
    }
    koch(n-1,korak,m);
    m.levo(60);
    koch(n-1,korak,m);
    m.levo(-120);
    koch(n-1,korak,m);
    m.levo(60);
    koch(n-1,korak,m);
    }
}
