package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IChatHistory_21498571_PaulRamirez;
import java.util.Objects;

public class ChatHistory_21498571_PaulRamirez implements IChatHistory_21498571_PaulRamirez{
    private UsuarioComun user;
    private String register;

    public ChatHistory_21498571_PaulRamirez(UsuarioComun user, String register) {
        this.user = user;
        this.register = register;
    }
    @Override
    public UsuarioComun getUser() {
        return user;
    }

    @Override
    public String getRegister() {
        return register;
    }

    @Override
    public String toString() {
        return "ChatHistory_21498571_PaulRamirez{" +
                "user=" + user +
                ", register='" + register + '\'' +
                '}';
    }

    @Override
    public boolean equals(UsuarioComun u) {
        return (user.equals(u));
    }

}
