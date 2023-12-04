package codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Flow_21498571_PaulRamirez;

import java.util.List;

public interface IChatbot_21498571_PaulRamirez {
    int getId();
    String getName();
    String getMsg();
    int getStartFlowId();
    List<Flow_21498571_PaulRamirez> getFlows();
    boolean chatbotAddFlow(Flow_21498571_PaulRamirez flow);
    String toString();
    boolean equals(Object c);
    Flow_21498571_PaulRamirez searchFlow(int id);
}
