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
    protected String dv = "/img/dv.png";
    protected String mv = "/img/mv.png";
    protected String fv = "/img/fv.png";
    protected String dh = "/img/dh.png";
    protected String mh = "/img/mh.png";
    protected String fh = "/img/fh.png";
    protected String fh2 = "/img/fh2.png";
    protected String smv1 = "/img/smv1.png";
    protected String smv2 = "/img/smv2.png";
    protected String smv3 = "/img/smv3.png";
    protected String smh1 = "/img/smh1.png";
    protected String smh2 = "/img/smh2.png";
    protected String smh3 = "/img/smh3.png";
    protected String crh1 = "/img/crh1.png";
    protected String crh2 = "/img/crh2.png";
    protected String crh3 = "/img/crh3.png";
    protected String crv1 = "/img/crv1.png";
    protected String crv2 = "/img/crv2.png";
    protected String crv3 = "/img/crv3.png";
    protected String tpv1 = "/img/tpv1.png";
    protected String tpv2 = "/img/tpv2.png";
    protected String tph1 = "/img/tph1.png";
    protected String tph2 = "/img/tph2.png";
    protected String spv1 = "/img/spv1.png";
    protected String spv2 = "/img/spv2.png";
    protected String spv3 = "/img/spv3.png";
    protected String sph1 = "/img/sph1.png";
    protected String sph2 = "/img/sph2.png";
    protected String sph3 = "/img/sph3.png";
    protected Image[] tableauPng;

    /**
     * Permet de creer les images
     */
    public ImageLoader() {
        try {
            //final String dir = System.getProperty("user.dir");
            //System.out.println("current dir = " + dir);
            this.tableauPng = new Image[29];
            this.tableauPng[0] = ImageIO.read(this.getClass().getResourceAsStream(dh));
            this.tableauPng[1] = ImageIO.read(this.getClass().getResourceAsStream(mh));
            this.tableauPng[2] = ImageIO.read(this.getClass().getResourceAsStream(fh));
            this.tableauPng[3] = ImageIO.read(this.getClass().getResourceAsStream(dv));
            this.tableauPng[4] = ImageIO.read(this.getClass().getResourceAsStream(mv));
            this.tableauPng[5] = ImageIO.read(this.getClass().getResourceAsStream(fv));
            this.tableauPng[6] = ImageIO.read(this.getClass().getResourceAsStream(fh2));
            this.tableauPng[7] = ImageIO.read(this.getClass().getResourceAsStream(smv1));
            this.tableauPng[8] = ImageIO.read(this.getClass().getResourceAsStream(smv2));
            this.tableauPng[9] = ImageIO.read(this.getClass().getResourceAsStream(smv3));
            this.tableauPng[10] = ImageIO.read(this.getClass().getResourceAsStream(smh1));
            this.tableauPng[11] = ImageIO.read(this.getClass().getResourceAsStream(smh2));
            this.tableauPng[12] = ImageIO.read(this.getClass().getResourceAsStream(smh3));
            this.tableauPng[13] = ImageIO.read(this.getClass().getResourceAsStream(crh1));
            this.tableauPng[14] = ImageIO.read(this.getClass().getResourceAsStream(crh2));
            this.tableauPng[15] = ImageIO.read(this.getClass().getResourceAsStream(crh3));
            this.tableauPng[16] = ImageIO.read(this.getClass().getResourceAsStream(crv1));
            this.tableauPng[17] = ImageIO.read(this.getClass().getResourceAsStream(crv2));
            this.tableauPng[18] = ImageIO.read(this.getClass().getResourceAsStream(crv3));
            this.tableauPng[19] = ImageIO.read(this.getClass().getResourceAsStream(tpv1));
            this.tableauPng[20] = ImageIO.read(this.getClass().getResourceAsStream(tpv2));
            this.tableauPng[21] = ImageIO.read(this.getClass().getResourceAsStream(tph1));
            this.tableauPng[22] = ImageIO.read(this.getClass().getResourceAsStream(tph2));
            this.tableauPng[23] = ImageIO.read(this.getClass().getResourceAsStream(spv1));
            this.tableauPng[24] = ImageIO.read(this.getClass().getResourceAsStream(spv2));
            this.tableauPng[25] = ImageIO.read(this.getClass().getResourceAsStream(spv3));
            this.tableauPng[26] = ImageIO.read(this.getClass().getResourceAsStream(sph1));
            this.tableauPng[27] = ImageIO.read(this.getClass().getResourceAsStream(sph2));
            this.tableauPng[28] = ImageIO.read(this.getClass().getResourceAsStream(sph3));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Image[] getTableauPng() {
        return tableauPng;
    }
}
