import java.awt.Color;

public class DrakeTurtleDrawing{

    public static void main(String[]args) {
        // Nastavitev platna (širina, višina)
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(-200, 200);
        StdDraw.setYscale(-200, 200);
        
        // Ozadje
        StdDraw.clear(new Color(240, 240, 240));

        // 1. OBLIKA OBRAZA (Osnovni ton kože)
        StdDraw.setPenColor(new Color(210, 161, 125));
        StdDraw.filledOval(0, 10, 85, 110);

        // 2. PRIČESKA (Značilna kratka linija las)
        StdDraw.setPenColor(new Color(40, 40, 42));
        // Zgornji del las
        StdDraw.filledOval(0, 70, 82, 50);
        // Popravek oblike čela
        StdDraw.setPenColor(new Color(210, 161, 125));
        StdDraw.filledRectangle(0, 60, 85, 15);

        // 3. BRADA (Gosta, oblikovana brada iz slike)
        StdDraw.setPenColor(new Color(30, 30, 30));
        // Spodnji del brade
        StdDraw.filledOval(0, -45, 65, 55);
        // Stranski deli brade (zalisci)
        StdDraw.filledPolygon(new double[]{-82, -50, -30, -75}, new double[]{20, -50, -80, -10});
        StdDraw.filledPolygon(new double[]{82, 50, 30, 75}, new double[]{20, -50, -80, -10});
        
        // Ponovni izris osrednjega dela obraza, da brada ostane le na robovih
        StdDraw.setPenColor(new Color(210, 161, 125));
        StdDraw.filledOval(0, -10, 55, 60);

        // 4. OČI IN OBRVI (Močne, izrazite obrvi)
        // Leva obrva
        StdDraw.setPenColor(new Color(20, 20, 20));
        StdDraw.setPenRadius(5.0 / 600.0);
        StdDraw.line(-55, 38, -15, 33);
        // Desna obrva
        StdDraw.line(15, 33, 55, 38);

        // Levo oko
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledOval(-35, 20, 15, 8);
        StdDraw.setPenColor(new Color(50, 30, 20)); // Šarenica
        StdDraw.filledCircle(-35, 20, 6);
        
        // Desno oko
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledOval(35, 20, 15, 8);
        StdDraw.setPenColor(new Color(50, 30, 20)); // Šarenica
        StdDraw.filledCircle(35, 20, 6);

        // 5. NOS
        StdDraw.setPenColor(new Color(185, 135, 100)); // Senca za nos
        StdDraw.setPenRadius(4.0 / 600.0);
        StdDraw.line(-10, 25, -10, -15);
        StdDraw.line(-10, -15, 10, -15);

        // 6. USTNICE (Značilna resna drža ustnic)
        StdDraw.setPenColor(new Color(170, 95, 95));
        StdDraw.filledOval(0, -35, 22, 10);
        StdDraw.setPenColor(new Color(30, 30, 30)); // Sredinska črta ust
        StdDraw.setPenRadius(2.0 / 600.0);
        StdDraw.line(-22, -35, 22, -35);
        
        // 7. BRKI (Povezani z brado)
        StdDraw.setPenColor(new Color(30, 30, 30));
        StdDraw.filledOval(0, -25, 25, 6);
        StdDraw.setPenColor(new Color(210, 161, 125)); // Popravek nad ustnico
        StdDraw.filledOval(0, -28, 20, 4);
    }
}
