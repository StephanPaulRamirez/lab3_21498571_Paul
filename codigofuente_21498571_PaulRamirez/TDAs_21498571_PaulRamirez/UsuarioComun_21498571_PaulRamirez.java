package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IUsuario_21498571_PaulRamirez;

import java.util.Objects;

public class UsuarioComun_21498571_PaulRamirez implements IUsuario_21498571_PaulRamirez{
    private String username;
    private String chatHistory;
    public UsuarioComun_21498571_PaulRamirez(String username) {
        this.username = username;
        this.chatHistory = "";
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getChatHistory() {
        return chatHistory;
    }

    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        UsuarioComun_21498571_PaulRamirez that = (UsuarioComun_21498571_PaulRamirez) u;
        return Objects.equals(username, that.username);
    }

    @Override
    public String toString() {
        return "\nUsuarioComun{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public void setChatHistory(String newChatHistory){
        this.chatHistory = newChatHistory;
    }
}
