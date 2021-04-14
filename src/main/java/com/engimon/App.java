package com.engimon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.entity.StaticSerializer;
import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.inventory.Inventory;

/**
 * Hello world!
 *
 */
public class App {

    public static void save() {

        Inventory<Integer> x = new Inventory<>(5);
        x.add(5);
        x.add(2);
        x.add(3);
        x.add(7);
        x.add(10);
        Skill sk = new Skill(Element.FIRE, 1, "Testing Fire", 1D);
        Skill sk2 = new Skill(Element.WATER, 2, "Testing Water", 3D);
        Skill sk3 = new Skill(Element.WATER, Element.GROUND, 3, "Gabungan", 999.23D);
        new Skill(Element.FIRE, 4, "a", 1D);

        try {
            FileOutputStream fout = new FileOutputStream("../file.txt");
            ObjectOutputStream oot = new ObjectOutputStream(fout);
            oot.writeObject(x);
            oot.writeObject(sk);
            oot.writeObject(sk2);
            oot.writeObject(sk3);
            oot.writeObject(StaticSerializer.save());
            oot.flush();
            oot.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void load() {
        try {
            FileInputStream fin = new FileInputStream("../file.txt");
            ObjectInputStream oit = new ObjectInputStream(fin);
            System.out.println(oit.readObject());
            System.out.println(oit.readObject());
            System.out.println(oit.readObject());
            System.out.println(oit.readObject());
            StaticSerializer.load(((StaticSerializer) oit.readObject()));
            System.out.println(Skill.getSkill(1));
            System.out.println(Skill.getSkill(2));
            System.out.println(Skill.getSkill(3));
            System.out.println(Skill.getSkill(4));
            oit.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        load();
        // JFrame jf = new JFrame();
        // jf.setSize(500, 500);
        // jf.setTitle("Test");
        // jf.setVisible(true);
        // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
