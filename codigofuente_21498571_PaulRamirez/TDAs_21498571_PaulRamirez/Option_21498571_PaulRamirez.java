package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;
import codigofuente_21498571_PaulRamirez.interfaces_21498571_PaulRamirez.interfazOption_21498571_PaulRamirez;

import java.util.List;

public class Option_21498571_PaulRamirez implements interfazOption_21498571_PaulRamirez{
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
    public int getId() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }

    @Override
    public int getChatbotcodelink() {
        return chatbotCodeLink;
    }

    @Override
    public int getInitialflowcodelink() {
        return initialFlowCodeLink;
    }

    @Override
    public List<String> getKeyword() {
        return Keyword;
    }
}
