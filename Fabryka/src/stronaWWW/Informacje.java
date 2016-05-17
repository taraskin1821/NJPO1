package stronaWWW;

import org.rendersnake.HtmlCanvas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Informacje implements HTMLInterface {

    @Override
    public boolean generuj() {

        HtmlCanvas html = new HtmlCanvas();
        String informacja = "Powinny oddać zadania z NJPO dawno temu";
        File file = new File("Strona_info.html");

        try {

            html
                    .html()
                        .body()
                            .h1().content("Ważna informacja")
                            .h3().content(informacja)
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
