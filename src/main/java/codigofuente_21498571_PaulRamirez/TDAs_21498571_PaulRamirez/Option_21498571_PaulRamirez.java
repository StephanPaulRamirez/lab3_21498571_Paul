package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IOption_21498571_PaulRamirez;

import java.util.List;

public class Option_21498571_PaulRamirez implements IOption_21498571_PaulRamirez {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> Keyword;

    /**
     * Constructor de option
     * @param code identificador del option
     * @param message el mensaje que muestra por pantalla la opcion
     * @param chatbotCodeLink id del chatbot que vincula
     * @param initialFlowCodeLink id del flow que vincula
     * @param Keyword Lista de palabras clave
     */
    public Option_21498571_PaulRamirez(int code, String message, int chatbotCodeLink,
                                       int initialFlowCodeLink, List<String> Keyword){
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.Keyword = Keyword;
    }

    /**
     * Selector del id de option
     * @return identificador del option
     */
    @Override
    public int getId() {
        return code;
    }

    /**
     * Selector del mensaje de option
     * @return mensaje del option
     */
    @Override
    public String getMsg() {
        return message;
    }

    /**
     * Selector del id del chatbot que vincula el option
     * @return id del chatbot que vincula el option
     */
    @Override
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    /**
     * Selector del id del flow que vincula el option
     * @return id del flow que vincula el option
     */
    @Override
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    /**
     * Selector de las palabras claves del option
     * @return lista de las palabras clave
     */
    @Override
    public List<String> getKeyword() {
        return Keyword;
    }

    /**
     * equals del option
     * @param opt objeto a comparar si es igual
     * @return booleano que indica si el objeto recibido es de tipo option y ademas tiene el mismo id que el option
     */
    @Override
    public boolean equals(Object opt) {
        if (this == opt) return true;
        if (opt == null || getClass() != opt.getClass()) return false;
        Option_21498571_PaulRamirez that = (Option_21498571_PaulRamirez) opt;
        return this.getId() == that.code;
    }

    /**
     * toString del option
     * @return mensaje formateado de los elementos del option para mostrarlos por pantalla
     */
    @Override
    public String toString() {
        return "\nOption{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", Keyword=" + Keyword +
                '}';
    }
}
