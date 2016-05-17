package stronaWWW;

import org.rendersnake.HtmlCanvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;


public class Kontakty implements HTMLInterface  {

    String names[] = {"Andrzej", "Janusz", "Andżelika", "Dżesika", "Konstanty Ildefons"};
    String adresses[] = {"ul. ABC 1/2 34-567 Potato", "ul. CoJaRobie 3/4 56-789 Tu", "ul. MoglemTeraz 5/6 78-901 GraćWGry", "ul. NieSpie 7/8 90-123 BoProgramuje", "ul. Adres 9/0 12-345 Widmo"};
    String phonenumbers[] = {"123-456-789", "234-567-890", "345-678-901", "456-789-012", "567-890-123"};

    public boolean generuj() {

        HtmlCanvas html = new HtmlCanvas();

        File file = new File("POTATO.html");

        try {

            html
                    .html()
                    .body()
                    .h1().content("KONTAKTY")
                    .br()
                    .h2().content(names[new Random().nextInt(5)])
                    .h3().content(adresses[new Random().nextInt(5)])
                    .h3().content(phonenumbers[new Random().nextInt(5)])
                    .br()
                    .br()
                    .h2().content(names[new Random().nextInt(5)])
                    .h3().content(adresses[new Random().nextInt(5)])
                    .h3().content(phonenumbers[new Random().nextInt(5)])
                    .br()
                    .br()
                    .h2().content(names[new Random().nextInt(5)])
                    .h3().content(adresses[new Random().nextInt(5)])
                    .h3().content(phonenumbers[new Random().nextInt(5)])
                    .br()
                    .br()
                    .h2().content(names[new Random().nextInt(5)])
                    .h3().content(adresses[new Random().nextInt(5)])
                    .h3().content(phonenumbers[new Random().nextInt(5)])
                    .br()
                    .br()
                    .h2().content(names[new Random().nextInt(5)])
                    .h3().content(adresses[new Random().nextInt(5)])
                    .h3().content(phonenumbers[new Random().nextInt(5)])
                    ._body()
                    ._html();



            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(html.toHtml());
            bw.flush();
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

}
