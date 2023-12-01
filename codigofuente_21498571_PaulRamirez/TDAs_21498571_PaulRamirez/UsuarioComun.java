package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IUsuario_21498571_PaulRamirez;

import java.util.Objects;
public class UsuarioComun implements IUsuario_21498571_PaulRamirez{
    private String username;

    public UsuarioComun(String username) {
        this.username = username;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        UsuarioComun that = (UsuarioComun) u;
        return (username.equals(that.username));
    }

    @Override
    public String toString() {
        return "\nUsuarioComun{" +
                "username='" + username + '\'' +
                '}';
    }
}
