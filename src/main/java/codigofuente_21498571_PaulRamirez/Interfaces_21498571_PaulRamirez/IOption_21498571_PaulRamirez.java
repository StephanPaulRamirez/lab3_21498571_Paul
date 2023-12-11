package codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez;

import java.util.List;

public interface IOption_21498571_PaulRamirez {
    int getId();
    String getMsg();
    int getChatbotCodeLink();
    int getInitialFlowCodeLink();
    List<String> getKeyword();
    boolean equals(Object op);
    String toString();
}