package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IFlow_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;

public class Flow_21498571_PaulRamirez implements IFlow_21498571_PaulRamirez {
    private int id;
    private String nameMsg;
    private List<Option_21498571_PaulRamirez> option;

    public Flow_21498571_PaulRamirez(int id, String nameMsg, List<Option_21498571_PaulRamirez> option){
        this.id = id;
        this.nameMsg = nameMsg;
        this.option = new ArrayList<>();
        int n = option.size();
        for (Option_21498571_PaulRamirez opt : option) {
            if (!(this.option.contains(opt))) {
                this.option.add(opt);
            }
        }
    }

    @Override
    public String toString() {
        return "Flow_21498571_PaulRamirez{" +
                "id=" + id +
                ", nameMsg='" + nameMsg + '\'' +
                ", option=" + option.toString() +
                '}';
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
    public void flowAddOption(Option_21498571_PaulRamirez op) {
        if(!(this.option.contains(op))){
            this.option.add(op);
        }
    }
}
