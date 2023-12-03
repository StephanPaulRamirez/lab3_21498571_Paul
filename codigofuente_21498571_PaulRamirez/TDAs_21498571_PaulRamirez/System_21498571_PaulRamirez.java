package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IUsuario_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.ISystem_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;

public class System_21498571_PaulRamirez implements ISystem_21498571_PaulRamirez{
    private String name;
    private int InitialChatbotCodeLink;
    private List<Chatbot_21498571_PaulRamirez> chatbots;
    private List<IUsuario_21498571_PaulRamirez> users;
    private String loggedUser;
    private List<Integer> actual;

    public System_21498571_PaulRamirez(String name, int InitialChatbotCodeLink,
                                       List<Chatbot_21498571_PaulRamirez> chatbots) {
        this.name = name;
        this.InitialChatbotCodeLink = InitialChatbotCodeLink;
        this.chatbots = new ArrayList<>();
        for (Chatbot_21498571_PaulRamirez chatbot : chatbots) {
            if (!(this.chatbots.contains(chatbot))) {
                this.chatbots.add(chatbot);
            }
        }
        this.users = new ArrayList<>();
        this.loggedUser = "";
        this.actual = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getInitialChatbotId() {
        return InitialChatbotCodeLink;
    }
    @Override
    public List<Chatbot_21498571_PaulRamirez> getChatbots() {
        return chatbots;
    }
    @Override
    public List<IUsuario_21498571_PaulRamirez> getUsers() {
        return users;
    }
    @Override
    public String getLoggedUser() {
        return loggedUser;
    }
    @Override
    public List<Integer> getActual() {
        return actual;
    }
    @Override
    public void systemAddChatbot(Chatbot_21498571_PaulRamirez chatbot){
        if(!(this.chatbots.contains(chatbot))) {
            this.chatbots.add(chatbot);
        }
    }

    @Override
    public void systemAddUser(IUsuario_21498571_PaulRamirez user){
        if(!(this.users.contains(user))) {
            this.users.add(user);
        }
    }
    @Override
    public void systemLogin(String user){
        if(this.loggedUser.isEmpty()){
            for(IUsuario_21498571_PaulRamirez u: users){
                if(u.getUserName().equals(user)){
                    this.loggedUser = user;
                    return;
                }
            }
        }
    }
    @Override
    public void systemLogout(){
        this.loggedUser = "";
        this.actual = new ArrayList<>();
    }

    @Override
    public IUsuario_21498571_PaulRamirez searchUser(String nickname){
        for(IUsuario_21498571_PaulRamirez user : this.users){
            if(user.getUserName().equals(nickname)){
                return user;
            }
        }
        return null;
    }

    @Override
    public Chatbot_21498571_PaulRamirez searchChatbot(int id){
        for(Chatbot_21498571_PaulRamirez chatbot : chatbots){
            if(chatbot.getId() == id){
                return chatbot;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "\nSystem{" +
                "name='" + name + '\'' +
                ", InitialChatbotCodeLink=" + InitialChatbotCodeLink +
                ", chatbots=" + chatbots.toString() +
                ", users=" + users +
                ", loggedUser='" + loggedUser + '\'' +
                ", actual=" + actual +
                '}';
    }
}
