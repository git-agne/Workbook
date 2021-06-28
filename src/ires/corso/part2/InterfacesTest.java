package ires.corso.part2;

import ires.corso.part2.firstclasses.*;
import ires.corso.part2.interfaces.Personaggio;

public class InterfacesTest {
    public static void main(String[] args) {
        Eroe hero1 = new Eroe();
        Licantropo were1 = new Licantropo(true);
        Vampiro vamp1 = new Vampiro();

        for(int i = 0; i < 3; i++) {
            hero1.combatti();
        }
        vamp1.azzanna();
        were1.azzanna();
        were1.azzanna();

        Personaggio[] pers = new Personaggio[3];
        pers[0] = hero1;
        pers[1] = were1;
        pers[2] = vamp1;

        for(int j = 0; j < pers.length; j++) {
            System.out.println(pers[j].getForza());
        }
    }
}
