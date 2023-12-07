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

    /**
     * Constructor de System, verifica duplicados de la lista de chatbots y mantiene la primera instancia
     * @param name nombre del sistema
     * @param InitialChatbotCodeLink id del chatbot inicial
     * @param chatbots lista de chatbots
     */
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

    /**
     * Selector del initialChatbotId
     * @return identificador del chatbot inicial del sistema
     */
    @Override
    public int getInitialChatbotId() {
        return InitialChatbotCodeLink;
    }

    /**
     * Selector de chatbots
     * @return lista de chatbots del sistema
     */
    @Override
    public List<Chatbot_21498571_PaulRamirez> getChatbots() {
        return chatbots;
    }

    /**
     * Selector de users
     * @return lista de usuarios registrados en el sistema
     */
    @Override
    public List<IUsuario_21498571_PaulRamirez> getUsers() {
        return users;
    }

    /**
     * Selector de Loggeduser
     * @return username del usuario con la sesion abierta en el sistema
     */
    @Override
    public String getLoggedUser() {
        return loggedUser;
    }

    /**
     * Selector de Actual
     * @return lista de enteros que indican respectivamente, id del ultimo chatbot vinculado e id del ultimo flow vinculado
     */
    @Override
    public List<Integer> getActual() {
        return actual;
    }

    /**
     * Modificador de System, agrega un chatbot si es que su id no se encuentra en la lista de chatbots
     * @param chatbot chatbot a agregar
     * @return booleano que indica si se agrego el chatbot a la lista o no
     */
    @Override
    public boolean systemAddChatbot(Chatbot_21498571_PaulRamirez chatbot){
        if(!(this.getChatbots().contains(chatbot))) {
            this.chatbots.add(chatbot);
            return true;
        }
        return false;
    }

    /**
     * Modificador de System, agrega un usuario si es que su username no se encuentra en la lista de usuarios
     * @param user usuario a agregar
     * @return booleano que indica si se registro el usuario no
     */
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

    /**
     * Login del sistema, verifica que el loggeduser sea un string vacio, y si lo es, asigna el username del ususario recibido a ese atributo
     * @param user usuario que quiere inciar sesion
     */
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

    /**
     * Logout del sistema, asigna el loggeduser a un string vacio y reinicia actual asignandolo como una lista vacia
     */
    @Override
    public void systemLogout(){
        this.loggedUser = "";
        this.actual = new ArrayList<>();
    }

    /**
     * Busca en la lista de usuarios el username recibido
     * @param nickname nombre de usuario
     * @return usuario al que le corresponde el nombre
     */
    @Override
    public IUsuario_21498571_PaulRamirez searchUser(String nickname){
        for(IUsuario_21498571_PaulRamirez user : this.users){
            if(user.getUserName().equals(nickname)){
                return user;
            }
        }
        return null;
    }

    /**
     * Busca un chatbot en la lista de chatbots del sistema, verificando si el id recibido es el mismo que el de un chatbot de la lista
     * @param id identificador del chatbot que se quiere encontrar
     * @return chatbot cuyo id corresponde al del parametro de entrada
     */
    @Override
    public Chatbot_21498571_PaulRamirez searchChatbot(int id){
        for(Chatbot_21498571_PaulRamirez chatbot : chatbots){
            if(chatbot.getId() == id){
                return chatbot;
            }
        }
        return null;
    }

    /**
     * toString de System
     * @return mensaje formateado de los elementos del system para mostrarlos por pantalla
     */
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

    /**
     * Construye un string que corresponde a la fecha actual, el usuario logeado, el mensaje enviado, luego la fecha actual otra vez, el nombre del chatbot y su mensaje
     * @param message mensaje enviado por el usuario
     * @param chatbot chatbot vinculado
     * @param flow flow vinculado
     * @return String formateado del mensaje enviado por el usuario y del chatbot
     */
    @Override
    public String registerAppendString(String message,
                                       Chatbot_21498571_PaulRamirez chatbot,
                                       Flow_21498571_PaulRamirez flow){
        LocalDate date = LocalDate.now();
        return  ("\n" + date + "-" + this.getLoggedUser() + ": " + message +
                "\n" + date + "-" + chatbot.getName() + ": " + flow.getNameMsg()  +
                flow.flowGetOptionsMsg(flow.getOption()));
    }

    /**
     * Metodo para hablar con los chatbot, revisa si hay usuario logeado, y luego actualiza el historial del usuario y el actual dependiendo si es el primer mensaje enviado o no
     * @param message mensaje enviado por el usuario
     * @return String formateado del mensaje enviado por el usuario y del chatbot
     */
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

    /**
     * Metodo que busca el historial de un usuario en los usuarios registrados
     * @param nickname username del usuario
     * @return historial del usuario cuyo username corresponde al parametro de entrada
     */
    public String synthesis(String nickname){
        return this.searchUser(nickname).getChatHistory();
    }
}
