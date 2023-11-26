package codigofuente_21498571_PaulRamirez;


import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Flow_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Option_21498571_PaulRamirez;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Option_21498571_PaulRamirez OP = new Option_21498571_PaulRamirez(1, "op1",
                1, 1, List.of("hola", "prueba"));
        Flow_21498571_PaulRamirez F1 = new Flow_21498571_PaulRamirez(1, "flow1", List.of(OP));
    System.out.println(F1.toString());

    }
}
