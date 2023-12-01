package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IChatbot_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;


public class Chatbot_21498571_PaulRamirez implements IChatbot_21498571_PaulRamirez {
    private int chatbotID;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private List<Flow_21498571_PaulRamirez> flows;

    public Chatbot_21498571_PaulRamirez(int chatbotID, String name, String welcomeMessage,
                                        int startFlowId, List<Flow_21498571_PaulRamirez> flows) {
        this.chatbotID = chatbotID;
        this.name = name;
        this.welcomeMessage = welcomeMessage;
        this.startFlowId = startFlowId;
        this.flows = new ArrayList<>();
        int n = flows.size();
        for (Flow_21498571_PaulRamirez flow : flows) {
            if (!(this.flows.contains(flow))) {
                this.flows.add(flow);
            }
        }
    }

    @Override
    public int getId() {
        return chatbotID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMsg() {
        return welcomeMessage;
    }

    @Override
    public int getStartFlowId() {
        return startFlowId;
    }

    @Override
    public List<Flow_21498571_PaulRamirez> getFlows() {
        return flows;
    }

    @Override
    public void chatbotAddFlow(Flow_21498571_PaulRamirez flow) {
        if(!(this.flows.contains(flow))) {
            this.flows.add(flow);
        }
    }

    @Override
    public String toString() {
        return "\nChatbot_21498571_PaulRamirez{" +
                "chatbotID=" + chatbotID +
                ", name='" + name + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", startFlowId=" + startFlowId +
                ", flows=" + flows.toString() +
                '}';
    }
}
