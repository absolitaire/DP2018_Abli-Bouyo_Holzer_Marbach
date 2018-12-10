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
    protected String smv1 = "img/smv1.png";
    protected String smv2 = "img/smv2.png";
    protected String smv3 = "img/smv3.png";
    protected String smh1 = "img/smh1.png";
    protected String smh2 = "img/smh2.png";
    protected String smh3 = "img/smh3.png";
    protected String crh1 = "img/crh1.png";
    protected String crh2 = "img/crh2.png";
    protected String crh3 = "img/crh3.png";
    protected String crv1 = "img/crv1.png";
    protected String crv2 = "img/crv2.png";
    protected String crv3 = "img/crv3.png";
    protected String tpv1 = "img/tpv1.png";
    protected String tpv2 = "img/tpv2.png";
    protected String tph1 = "img/tph1.png";
    protected String tph2 = "img/tph2.png";
    protected String sp3v1 = "img/sp3v1.png";
    protected Image[] tableauPng;

    /**
     * Permet de creer les images
     */
    public ImageLoader() {
        try {
            //final String dir = System.getProperty("user.dir");
            //System.out.println("current dir = " + dir);
            this.tableauPng = new Image[24];
            this.tableauPng[0] = ImageIO.read(new FileInputStream(dh));
            this.tableauPng[1] = ImageIO.read(new FileInputStream(mh));
            this.tableauPng[2] = ImageIO.read(new FileInputStream(fh));
            this.tableauPng[3] = ImageIO.read(new FileInputStream(dv));
            this.tableauPng[4] = ImageIO.read(new FileInputStream(mv));
            this.tableauPng[5] = ImageIO.read(new FileInputStream(fv));
            this.tableauPng[6] = ImageIO.read(new FileInputStream(fh2));
            this.tableauPng[7] = ImageIO.read(new FileInputStream(smv1));
            this.tableauPng[8] = ImageIO.read(new FileInputStream(smv2));
            this.tableauPng[9] = ImageIO.read(new FileInputStream(smv3));
            this.tableauPng[10] = ImageIO.read(new FileInputStream(smh1));
            this.tableauPng[11] = ImageIO.read(new FileInputStream(smh2));
            this.tableauPng[12] = ImageIO.read(new FileInputStream(smh3));
            this.tableauPng[13] = ImageIO.read(new FileInputStream(crh1));
            this.tableauPng[14] = ImageIO.read(new FileInputStream(crh2));
            this.tableauPng[15] = ImageIO.read(new FileInputStream(crh3));
            this.tableauPng[16] = ImageIO.read(new FileInputStream(crv1));
            this.tableauPng[17] = ImageIO.read(new FileInputStream(crv2));
            this.tableauPng[18] = ImageIO.read(new FileInputStream(crv3));
            this.tableauPng[19] = ImageIO.read(new FileInputStream(tpv1));
            this.tableauPng[20] = ImageIO.read(new FileInputStream(tpv2));
            this.tableauPng[21] = ImageIO.read(new FileInputStream(tph1));
            this.tableauPng[22] = ImageIO.read(new FileInputStream(tph2));
            this.tableauPng[23] = ImageIO.read(new FileInputStream(sp3v1));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Image[] getTableauPng() {
        return tableauPng;
    }
}
