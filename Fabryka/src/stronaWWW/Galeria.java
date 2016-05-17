package stronaWWW;

import org.rendersnake.HtmlAttributes;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Galeria implements HTMLInterface  {

    @Override
    public boolean generuj() {

        HtmlCanvas html = new HtmlCanvas();

        File file = new File("Galeria.html");

        try {
            html
                    .html()
                    .body()
                    .h1().content("GALERIA")
                    .render(new IconImage("Foto #1").alt("Foto#1"))
                    .render(new IconImage("Foto #2").alt("Foto#2"))
                    .render(new IconImage("Foto #3").alt("Foto#3"))
                    .render(new IconImage("Foto #4").alt("Foto#4"))
                    .render(new IconImage("Foto #5").alt("Foto#5"))
                    .render(new IconImage("Foto #6").alt("Foto#6"))
                    .render(new IconImage("Foto #7").alt("Foto#7"))
                    .render(new IconImage("Foto #8").alt("Foto#8"))
                    .render(new IconImage("Foto #9").alt("Foto#9"))
                    .render(new IconImage("Foto #10").alt("Foto#10"))
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



    public class IconImage implements Renderable {

        public HtmlAttributes attributes = new HtmlAttributes();

        public IconImage(String name) {
            super();
            this.attributes
                    .src("/static/images/icons/" + name)
                    .width("256")
                    .height("256");
        }
        public void renderOn(HtmlCanvas html) throws IOException {
            html.img(attributes);
        }
        public IconImage alt(String alt) {
            this.attributes.alt(alt);
            return this;
        }
    }
}
