package codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez.Option_21498571_PaulRamirez;

import java.util.List;

public interface IFlow_21498571_PaulRamirez {
    int getId();
    String getNameMsg();
    List<Option_21498571_PaulRamirez> getOption();
    void flowAddOption(Option_21498571_PaulRamirez op);
    String toString();
}
