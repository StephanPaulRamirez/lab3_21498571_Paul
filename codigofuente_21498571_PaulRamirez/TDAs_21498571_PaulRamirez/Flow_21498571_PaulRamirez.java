package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.interfaces_21498571_PaulRamirez.interfazFlow_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.interfaces_21498571_PaulRamirez.interfazOption_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;

public class Flow_21498571_PaulRamirez implements interfazFlow_21498571_PaulRamirez {
    private int id;
    private String nameMsg;
    private List<Option_21498571_PaulRamirez> option = new ArrayList<>();

    public Flow_21498571_PaulRamirez(int id, String nameMsg, List<Option_21498571_PaulRamirez> option){
        this.id = id;
        this.nameMsg = nameMsg;
        this.option = option;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNameMsg() {
        return nameMsg;
    }

    @Override
    public List<Option_21498571_PaulRamirez> getOption() {
        return option;
    }

    @Override
    public void flowAddOption(Option_21498571_PaulRamirez opcion) {
        this.option.add(opcion);
    }
}
