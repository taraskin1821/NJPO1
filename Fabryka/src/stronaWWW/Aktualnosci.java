package stronaWWW;

import org.rendersnake.HtmlCanvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Aktualnosci implements HTMLInterface {

    @Override
    public boolean generuj() {

        HtmlCanvas html = new HtmlCanvas();

        File file = new File("Aktualnosci.html");

        try {

            html
                    .html()
                    .body()
                    .h1().content("News nr #1")
                    .h4().content("Znana gwiazda umarła!")
                    .br()
                    .br()
                    .h1().content("News nr #2")
                    .h4().content("Jeszcze bardziej znana gwiazda ma HIV!")
                    .br()
                    .br()
                    .h1().content("News nr #3")
                    .h4().content("Jak schudnąć 5min w 10 kilo?!")
                    .br()
                    .br()
                    .h1().content("News nr #4")
                    .h4().content("Jak schudnąć 5min w 10 kilo?!")
                    .br()
                    .br()
                    .h1().content("News nr #5")
                    .h4().content("Jak schudnąć 5min w 10 kilo?!")
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
