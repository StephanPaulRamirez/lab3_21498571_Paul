package codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Chatbot_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Flow_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.System_21498571_PaulRamirez;

import java.util.List;

public interface ISystem_21498571_PaulRamirez {
    int getInitialChatbotId();
    List<Chatbot_21498571_PaulRamirez> getChatbots();
    List<IUsuario_21498571_PaulRamirez> getUsers();
    String getLoggedUser();
    List<Integer> getActual();
    boolean systemAddChatbot(Chatbot_21498571_PaulRamirez c);
    boolean systemAddUser(IUsuario_21498571_PaulRamirez u);
    void systemLogin(String u);
    void systemLogout();
    IUsuario_21498571_PaulRamirez searchUser(String n);
    Chatbot_21498571_PaulRamirez searchChatbot(int i);
    String toString();
    String registerAppendString(String message,
                                Chatbot_21498571_PaulRamirez chatbot,
                                Flow_21498571_PaulRamirez flow);
}
