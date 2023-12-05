package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IUsuario_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.ISystem_21498571_PaulRamirez;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class System_21498571_PaulRamirez implements ISystem_21498571_PaulRamirez{
    private String name;
    private int InitialChatbotCodeLink;
    private List<Chatbot_21498571_PaulRamirez> chatbots;
    private List<IUsuario_21498571_PaulRamirez> users;
    private String loggedUser;
    private List<Integer> actual;
    private LocalDate creationDate = LocalDate.now();


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
    public boolean systemAddChatbot(Chatbot_21498571_PaulRamirez chatbot){
        if(!(this.getChatbots().contains(chatbot))) {
            this.chatbots.add(chatbot);
            return true;
        }
        return false;
    }

    @Override
    public boolean systemAddUser(IUsuario_21498571_PaulRamirez user){
        for(IUsuario_21498571_PaulRamirez u : this.getUsers()){
            if(u.getUserName().equals(user.getUserName())){
                return false;
            }
        }
        this.users.add(user);
        return true;
    }
    @Override
    public void systemLogin(String user){
        if(this.getLoggedUser().isEmpty()){
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
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public String registerAppendString(String message,
                                       Chatbot_21498571_PaulRamirez chatbot,
                                       Flow_21498571_PaulRamirez flow){
        LocalDate date = LocalDate.now();
        return  ("\n" + date + "-" + this.getLoggedUser() + ": " + message +
                "\n" + date + "-" + chatbot.getName() + ": " + flow.getNameMsg()  +
                flow.flowGetOptionsMsg(flow.getOption()));
    }

    public String talk(String message){
        if(this.getLoggedUser().isEmpty()){
            return "";
        }
        Chatbot_21498571_PaulRamirez c;
        Flow_21498571_PaulRamirez f;
        if(this.getActual().isEmpty()){
            c = this.searchChatbot(this.getInitialChatbotId());
            f = c.searchFlow(c.getStartFlowId());
            actual = List.of(this.getInitialChatbotId(), c.getStartFlowId());
        }
        else {
            c = this.searchChatbot(actual.get(0));
            f = c.searchFlow(actual.get(1));
            boolean encontrado = false;
            for(Option_21498571_PaulRamirez o : f.getOption()){
                if(Integer.toString(o.getId()).equals(message) || o.getKeyword().contains(message)){
                    actual = List.of(o.getChatbotCodeLink(), o.getInitialFlowCodeLink());
                    encontrado = true;
                }
            }
            if (!encontrado){
                return "";
            }
            c = this.searchChatbot(actual.get(0));
            f = c.searchFlow(actual.get(1));
        }
        StringBuilder chatHistory = new StringBuilder(this.searchUser(this.getLoggedUser()).getChatHistory());
        String registerAppend = this.registerAppendString(message, c, f);
        chatHistory.append(registerAppend);
        this.searchUser(this.getLoggedUser()).setChatHistory(chatHistory.toString());
        return registerAppend;
    }

    public String synthesis(String nickname){
        return this.searchUser(nickname).getChatHistory();
    }
}
