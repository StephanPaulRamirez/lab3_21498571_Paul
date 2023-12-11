package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IUsuario_21498571_PaulRamirez;

import java.util.Objects;

public class Administrador_21498571_PaulRamirez implements IUsuario_21498571_PaulRamirez{
    private String username;
    private String chatHistory;

    /**
     * Constructor de Administrador
     * @param username string que corresponde al nombre de usuario
     */
    public Administrador_21498571_PaulRamirez(String username) {
        this.username = username;
        this.chatHistory = "";
    }

    /**
     * Selector del username
     * @return nombre de usuario
     */
    @Override
    public String getUserName() {
        return username;
    }

    /**
     * Selector del chatHistory
     * @return historial del usuario
     */
    @Override
    public String getChatHistory() {
        return chatHistory;
    }

    /**
     * Modificador de Administrador, cambia el chatHistory al string que se recibe como entrada (lo actualiza)
     * @param newChatHistory String que corresponde al historial actualizado
     */
    @Override
    public void setChatHistory(String newChatHistory){
        this.chatHistory = newChatHistory;
    }

    /**
     * equals de Administrador
     * @param u Objeto a comparar si es igual
     * @return booleano que indica si el objeto recibido es de tipo administrador y que ademas tenga el mismo username
     */
    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        Administrador_21498571_PaulRamirez that = (Administrador_21498571_PaulRamirez) u;
        return Objects.equals(username, that.username);
    }

    /**
     * toString de Administrador
     * @return String formateado de los elementos del usuario para mostrarlos por pantalla
     */
    @Override
    public String toString() {
        return "\nAdministrador{" +
                "username='" + username + '\'' +
                '}';
    }
}
