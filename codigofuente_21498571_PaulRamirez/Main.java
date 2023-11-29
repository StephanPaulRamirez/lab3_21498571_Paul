package codigofuente_21498571_PaulRamirez;


import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Chatbot_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Flow_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Option_21498571_PaulRamirez;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Option_21498571_PaulRamirez OP1 = new Option_21498571_PaulRamirez(1, "op1",
                1, 1, List.of("hola", "prueba"));
        Option_21498571_PaulRamirez OP2 = new Option_21498571_PaulRamirez(2, "op2",
                2, 1, List.of("chao", "pase"));
        Flow_21498571_PaulRamirez F1 = new Flow_21498571_PaulRamirez(1, "flow1", List.of(OP1));
        F1.flowAddOption(OP2);
        Chatbot_21498571_PaulRamirez C1 = new Chatbot_21498571_PaulRamirez(1, "C1",
                "hola",1, List.of(F1));
    System.out.println(C1.toString());

    }
}
