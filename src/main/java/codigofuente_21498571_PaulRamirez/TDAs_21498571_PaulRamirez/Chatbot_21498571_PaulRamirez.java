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

    /**
     * Constructor de chatbot, verifica duplicados de la lista de flows y mantiene la primera instancia
     * @param chatbotID identificador del chatbot
     * @param name nombre del chatbot
     * @param welcomeMessage mensaje de bienvenida del chatbot
     * @param startFlowId id del flow inicial del chatbot
     * @param flows lista de flows
     */
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

    /**
     * Selector del id del chatbot
     * @return identificador del chatbot
     */
    @Override
    public int getId() {
        return chatbotID;
    }

    /**
     * Selector del nombre del chatbot
     * @return nombre del chatbot
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * Selector del id del flow inicial del chatbot
     * @return identificador del flow inicial del chatbot
     */
    @Override
    public int getStartFlowId() {
        return startFlowId;
    }

    /**
     * Selector de la lista de flows del chatbot
     * @return lista de flows del chatbot
     */
    @Override
    public List<Flow_21498571_PaulRamirez> getFlows() {
        return flows;
    }

    /**
     * Modificador de chatbot, agrega un flow si su id no se encuentra en la lista de chatbots
     * @param flow flow a agregar
     * @return booleano que indica si se agrego el flow a la lista o no
     */
    @Override
    public boolean chatbotAddFlow(Flow_21498571_PaulRamirez flow) {
        if(!(this.getFlows().contains(flow))) {
            this.flows.add(flow);
            return true;
        }
        return false;
    }

    /**
     * Busca un flow en la lista de flows del chatbot, verificando si el id recibido es el mismo que el de un flow de la lista
     * @param id id del flow que se quiere encontrar
     * @return flow cuyo id corresponde al del parametro de entrada
     */
    @Override
    public Flow_21498571_PaulRamirez searchFlow(int id){
        for(Flow_21498571_PaulRamirez flow : flows){
            if(flow.getId() == id){
                return flow;
            }
        }
        return null;
    }

    /**
     * equals de chatbot
     * @param c objeto a comparar si es igual
     * @return booleano que indica si el objeto recibido es de tipo chatbot y ademas tiene el mismo id que el chatbot
     */
    @Override
    public boolean equals(Object c) {
        if (this == c) return true;
        if (c == null || getClass() != c.getClass()) return false;
        Chatbot_21498571_PaulRamirez that = (Chatbot_21498571_PaulRamirez) c;
        return chatbotID == that.chatbotID;
    }

    /**
     * toString de chatbot
     * @return string formateado de los elementos de chatbot para mostrarlos por pantalla
     */
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

}
