package Test;

import java.awt.*;
import java.net.URI;

public class OpenVideo {

    public static void main(String args[]) throws Exception{
        for(int i=0;i<10;i++){
            load();
        }
    }

    public static void load() throws Exception{
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("https://www.youtube.com/watch?v=JejRiJADLqo&feature=youtu.be"));
    }
}
