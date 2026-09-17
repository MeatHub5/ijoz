package dat;

import java.io.*;

public class r6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("C:\\ijoz\\dat\\clanek.txt"));
        String vrsica=br.readLine();
        int st=0;
        while (vrsica!=null) {
            int zac=0;
            int p=vrsica.indexOf(' ');
            while (p!=-1) {
                String beseda = vrsica.substring(zac,p);
                if (beseda.equalsIgnoreCase("danes")) {
                    st++;
                }
                zac=p+1;
                p=vrsica.indexOf(' ',zac);
                
            }
            vrsica=br.readLine();
            
        }
        System.out.println("Beseda danes se pojavi "+st+" krat.");
        br.close();
    }
}
