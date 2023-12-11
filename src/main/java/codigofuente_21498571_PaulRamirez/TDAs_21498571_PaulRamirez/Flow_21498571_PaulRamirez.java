package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IFlow_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;

public class Flow_21498571_PaulRamirez implements IFlow_21498571_PaulRamirez {
    private int id;
    private String nameMsg;
    private List<Option_21498571_PaulRamirez> option;

    /**
     * Constructor de flow, verifica duplicados de la lista de options y mantiene la primera instancia
     * @param id identificador del flow
     * @param nameMsg mensaje del nombre de un flow
     * @param option lista de opciones
     */
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

    /**
     * Selector del id del flow
     * @return identificador del flow
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Selector del nombre del flow
     * @return nombre del flow
     */
    @Override
    public String getNameMsg() {
        return nameMsg;
    }

    /**
     * Selector de las opciones del flow
     * @return lista de opciones
     */
    @Override
    public List<Option_21498571_PaulRamirez> getOption() {
        return option;
    }

    /**
     * Modificador de flow, agrega una opcion si es que su id no se encuentra en la lista de opciones
     * @param op opcion a agregar
     * @return booleano que indica si se agrego el option a la lista o no
     */
    @Override
    public boolean flowAddOption(Option_21498571_PaulRamirez op) {
        if(!(this.getOption().contains(op))){
            this.option.add(op);
            return true;
        }
        return false;
    }

    /**
     * Recorre los option y concatena el mensaje de estos en un string
     * @param O lista de option que le pertenece a un flow
     * @return string formateado de los mensajes de los option para mostrar por pantalla
     */
    @Override
    public String flowGetOptionsMsg(List<Option_21498571_PaulRamirez> O){
        String optionMsg = "";
        for (Option_21498571_PaulRamirez o : O){
            optionMsg = optionMsg + "\n" + o.getMsg();
        }
        return  optionMsg;
    }

    /**
     * equals de flow
     * @param flow objeto a comparar si es igual o no
     * @return booleano que indica si el objeto recibido es de tipo flow y ademas tiene el mismo id que el flow
     */
    @Override
    public boolean equals(Object flow) {
        if (this == flow) return true;
        if (flow == null || getClass() != flow.getClass()) return false;
        Flow_21498571_PaulRamirez that = (Flow_21498571_PaulRamirez) flow;
        return this.getId() == that.id;
    }

    /**
     * toString de flow
     * @return string formateado de los elementos del flow para mostrarlos por pantalla
     */
    @Override
    public String toString() {
        return "\nFlow{" +
                "id=" + id +
                ", nameMsg='" + nameMsg + '\'' +
                ", option=" + option.toString() +
                '}';
    }
}
