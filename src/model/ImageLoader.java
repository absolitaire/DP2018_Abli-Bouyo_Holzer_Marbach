package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;

public class ImageLoader {

    /**
     * Les images utilis�es pour les cases
     */
    protected String dv = "img/dv.png";
    protected String mv = "img/mv.png";
    protected String fv = "img/fv.png";
    protected String dh = "img/dh.png";
    protected String mh = "img/mh.png";
    protected String fh = "img/fh.png";
    protected String fh2 = "img/fh2.png";
    protected Image[] tableauPng;

    /**
     * Permet de creer les images
     */
    public ImageLoader() {
        try {
            //final String dir = System.getProperty("user.dir");
            //System.out.println("current dir = " + dir);
            this.tableauPng = new Image[7];
            this.tableauPng[0] = ImageIO.read(new FileInputStream(dh));
            this.tableauPng[1] = ImageIO.read(new FileInputStream(mh));
            this.tableauPng[2] = ImageIO.read(new FileInputStream(fh));
            this.tableauPng[3] = ImageIO.read(new FileInputStream(dv));
            this.tableauPng[4] = ImageIO.read(new FileInputStream(mv));
            this.tableauPng[5] = ImageIO.read(new FileInputStream(fv));
            this.tableauPng[6] = ImageIO.read(new FileInputStream(fh2));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Image[] getTableauPng() {
        return tableauPng;
    }
}
