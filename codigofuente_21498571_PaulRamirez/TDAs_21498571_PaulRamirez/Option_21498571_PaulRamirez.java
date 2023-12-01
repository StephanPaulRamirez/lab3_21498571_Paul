package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import codigofuente_21498571_PaulRamirez.Interfaces_21498571_PaulRamirez.IOption_21498571_PaulRamirez;

import java.util.List;

public class Option_21498571_PaulRamirez implements IOption_21498571_PaulRamirez {
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int initialFlowCodeLink;
    private List<String> Keyword;

    public Option_21498571_PaulRamirez(int code, String message, int chatbotCodeLink,
                                       int initialFlowCodeLink, List<String> Keyword){
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.initialFlowCodeLink = initialFlowCodeLink;
        this.Keyword = Keyword;
    }

    @Override
    public String toString() {
        return "\nOption_21498571_PaulRamirez{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", chatbotCodeLink=" + chatbotCodeLink +
                ", initialFlowCodeLink=" + initialFlowCodeLink +
                ", Keyword=" + Keyword +
                '}';
    }

    @Override
    public int getId() {
        return code;
    }

    @Override
    public boolean equals(Object opt) {
        if (this == opt) return true;
        if (opt == null || getClass() != opt.getClass()) return false;
        Option_21498571_PaulRamirez that = (Option_21498571_PaulRamirez) opt;
        return code == that.code;
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    @Override
    public int getInitialFlowCodeLink() {
        return initialFlowCodeLink;
    }

    @Override
    public List<String> getKeyword() {
        return Keyword;
    }
}
