package watki.ZipBomba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ZipBombThread implements Runnable {

    int numer;

    public ZipBombThread(int nr) {
        this.numer = nr;
    }

    @Override
    public void run() {

        FileOutputStream out = null;

        try{
            File f = new File("Plik_numer_" + numer);

            out = new FileOutputStream(f);

            for(int j = 0; j < 111111; j++)
                out.write(j);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
