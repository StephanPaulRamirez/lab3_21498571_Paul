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
        for (Option_21498571_PaulRamirez opt : option) {
            if (!(this.getOption().contains(opt))) {
                this.option.add(opt);
            }
        }
    }

    @Override
    public String toString() {
        return "\nFlow{" +
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
    public boolean flowAddOption(Option_21498571_PaulRamirez op) {
        if(!(this.getOption().contains(op))){
            this.option.add(op);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object flow) {
        if (this == flow) return true;
        if (flow == null || getClass() != flow.getClass()) return false;
        Flow_21498571_PaulRamirez that = (Flow_21498571_PaulRamirez) flow;
        return this.getId() == that.id;
    }

    @Override
    public String flowGetOptionsMsg(List<Option_21498571_PaulRamirez> O){
        String optionMsg = "";
        for (Option_21498571_PaulRamirez o : O){
            optionMsg = optionMsg + "\n" + o.getMsg();
        }
        return  optionMsg;
    }
}
