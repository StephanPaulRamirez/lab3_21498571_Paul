package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IChatbot_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;


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
        for (Flow_21498571_PaulRamirez flow : flows) {
            if (!(this.getFlows().contains(flow))) {
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
    public boolean chatbotAddFlow(Flow_21498571_PaulRamirez flow) {
        if(!(this.getFlows().contains(flow))) {
            this.flows.add(flow);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nChatbot{" +
                "chatbotID=" + chatbotID +
                ", name='" + name + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", startFlowId=" + startFlowId +
                ", flows=" + flows.toString() +
                '}';
    }

    @Override
    public boolean equals(Object c) {
        if (this == c) return true;
        if (c == null || getClass() != c.getClass()) return false;
        Chatbot_21498571_PaulRamirez that = (Chatbot_21498571_PaulRamirez) c;
        return chatbotID == that.chatbotID;
    }

    @Override
    public Flow_21498571_PaulRamirez searchFlow(int id){
        for(Flow_21498571_PaulRamirez flow : flows){
            if(flow.getId() == id){
                return flow;
            }
        }
        return null;
    }
}
