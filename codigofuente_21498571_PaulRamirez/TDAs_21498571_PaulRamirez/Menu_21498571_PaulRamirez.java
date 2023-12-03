package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_21498571_PaulRamirez {
    public static void start() {
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 3;
        int choice1;
        System_21498571_PaulRamirez system = new System_21498571_PaulRamirez("sistema", 1,
                List.of());
        do {
            printMenuInicio();
            choice1 = input.nextInt();

            switch (choice1) {

                case 1:
                    printMenuLogin();
                    input.nextLine();
                    String nickname = input.nextLine();
                    system.systemLogin(nickname);
                    if(system.getLoggedUser().isEmpty()){
                        System.out.println("ESE NOMBRE DE USUARIO NO ESTRA REGISTRADO");
                        break;
                    }
                    Administrador_21498571_PaulRamirez admin = new Administrador_21498571_PaulRamirez("condition");
                    if(system.searchUser(nickname).getClass() == admin.getClass()) {
                        adminMenu(input, system);
                    }
                    else{
                        normalMenu(input, system);
                    }
                    break;

                case 2:
                    printMenuRegistro();
                    int choice3 = input.nextInt();
                    while (choice3 > 2 || choice3 < 1){
                        System.out.println(choice3 + " is not a valid option! Please select correct option.");
                        printMenuRegistro();
                        choice3 = input.nextInt();
                    }
                    if(choice3 == 1){
                        System.out.println("### Sistema de Chatbots - Registro Usuario Normal ###");
                        System.out.print("INTRODUZCA NOMBRE DEL USUARIO NORMAL: ");
                        input.nextLine();
                        String nickUser = input.nextLine();
                        UsuarioComun_21498571_PaulRamirez newUser = new UsuarioComun_21498571_PaulRamirez(nickUser);
                        system.systemAddUser(newUser);
                    }
                    else{
                        System.out.println("### Sistema de Chatbots - Registro Usuario Administrador ###");
                        System.out.print("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR: ");
                        input.nextLine();
                        String nickAdmin = input.nextLine();
                        Administrador_21498571_PaulRamirez newAdmin = new Administrador_21498571_PaulRamirez(nickAdmin);
                        system.systemAddUser(newAdmin);
                    }
                    break;
                case 3:
                    System.out.println("Fin del programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println(choice1 + " is not a valid option! Please select correct option.");

            }
        } while (choice1 != MENU_EXIT_OPTION);
    }

    private static void printMenuInicio() {
        System.out.println("### Sistema de Chatbots - Inicio ###");
        System.out.println("1. Login de Usuario ");
        System.out.println("2. Registro de Usuario ");
        System.out.println("3. Finalizar Programa ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuLogin() {
        System.out.println("### Sistema de Chatbots - Login ###");
        System.out.print("INTRODUZCA NOMBRE DE USUARIO: ");
    }
    private static void printMenuRegistro() {
        System.out.println("### Sistema de Chatbots - Registro ###");
        System.out.println("1. Registrar usuario normal ");
        System.out.println("2. Registrar usuario administrador ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuNormal() {
        System.out.println("### Sistema de Chatbots - Usuario Normal ###");
        System.out.println("1. Hablar ");
        System.out.println("2. Sintestis ");
        System.out.println("3. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuChatbots() {
        System.out.println("### Sistema de Chatbots - Usuario Administrador ###");
        System.out.println("1. Crear un Chatbot ");
        System.out.println("2. Modificar un Chatbot ");
        System.out.println("3. Ejecutar un Chatbot ");
        System.out.println("4. Visualizar todos los chatbot existentes en el sistema ");
        System.out.println("5. Visualizar todos los Chatbot con sus flujos y opciones creadas ");
        System.out.println("6. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuFlows() {
        System.out.println("### Sistema de Chatbots - Crear Flows ###");
        System.out.println("1. Crear un Flow ");
        System.out.println("2. Visualizar los Flows con sus opciones creadas ");
        System.out.println("3. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuOptions() {
        System.out.println("### Sistema de Chatbots - Crear Options ###");
        System.out.println("1. Crear un Option ");
        System.out.println("2. Visualizar todos los Options con sus keywords ");
        System.out.println("3. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }
    private static void printMenuKeywords() {
        System.out.println("### Sistema de Chatbots - Crear Keywords ###");
        System.out.println("1. Agregar una Keyword ");
        System.out.println("2. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }

    private static void printMenuModChatbots() {
        System.out.println("### Sistema de Chatbots - Modificar Chatbots ###");
        System.out.println("1. Agregar un Flow ");
        System.out.println("2. Modificar un Flow ");
        System.out.println("3. Visualizar los Flows del chatbot con sus opciones creadas ");
        System.out.println("4. Salir ");
        System.out.print("INTRODUZCA SU OPCIÓN: ");
    }

    private static void menuModify(Scanner input, Chatbot_21498571_PaulRamirez chatbot){
        int MENU_EXIT_OPTION_MOD = 4;
        int choicemod;
        int idflow;
        do {
            printMenuModChatbots();
            choicemod = input.nextInt();
            switch (choicemod){
                case 1:
                    System.out.println("Ingrese a continuacion los datos del flow que se desea agregar");
                    System.out.print("ingrese el id del flow: ");
                    idflow = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el name msg del flow: ");
                    String namemsg = input.nextLine();
                    List<Option_21498571_PaulRamirez> O = getUserOptions(input);
                    Flow_21498571_PaulRamirez f = new Flow_21498571_PaulRamirez(idflow,
                            namemsg, O);
                    chatbot.chatbotAddFlow(f);
                    break;
                case 2:
                    System.out.print("ingrese el id del flow a modificar: ");
                    idflow = input.nextInt();
                    input.nextLine();
                    Flow_21498571_PaulRamirez flow = chatbot.searchFlow(idflow);
                    if(flow == null){
                        System.out.println("no se encontro un flow con el id ingresado");
                        break;
                    }
                    System.out.println("Ingrese a continuacion los datos del option que se desea agregar");
                    System.out.print("ingrese el id del option: ");
                    int idoption = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el mensaje del option: ");
                    String msg = input.nextLine();
                    System.out.print("ingrese el chatbotcodelink del option: ");
                    int CCL = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el initialFlowCodeLink del option: ");
                    int IFCL = input.nextInt();
                    input.nextLine();
                    List<String> K = getUserKeywords(input);
                    Option_21498571_PaulRamirez o = new Option_21498571_PaulRamirez(idoption,
                            msg, CCL, IFCL, K);
                    flow.flowAddOption(o);
                    break;
                case 3:
                    System.out.println(chatbot.getFlows().toString());
                    break;
                case 4:
                    break;
                default:
                    System.out.println(choicemod + " is not a valid option! Please select correct option.");
            }
        }while (choicemod != MENU_EXIT_OPTION_MOD);
    }
    private static List<Flow_21498571_PaulRamirez> getUserFlows(Scanner input){
        List<Flow_21498571_PaulRamirez> F = new ArrayList<>();
        int MENU_EXIT_OPTION_CHATBOT = 3;
        int choiceChatbot;
        do {
            printMenuFlows();
            choiceChatbot = input.nextInt();
            switch (choiceChatbot){
                case 1:
                    System.out.print("ingrese el id del flow: ");
                    int idflow = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el name msg del flow: ");
                    String namemsg = input.nextLine();
                    List<Option_21498571_PaulRamirez> O = getUserOptions(input);
                    Flow_21498571_PaulRamirez f = new Flow_21498571_PaulRamirez(idflow,
                            namemsg, O);
                    F.add(f);
                    break;
                case 2:
                    System.out.println(F);
                    break;
                case 3:
                    System.out.println("fin de la creacion de flows");
                    break;
                default:
                    System.out.println(choiceChatbot + " is not a valid option! Please select correct option.");

            }
        }while(choiceChatbot != MENU_EXIT_OPTION_CHATBOT);
        return F;
    }
    private static List<Option_21498571_PaulRamirez> getUserOptions(Scanner input){
        int choiceFlow;
        int MENU_EXIT_OPTION_FLOW = 3;
        List<Option_21498571_PaulRamirez> O = new ArrayList<>();
        do{
            printMenuOptions();
            choiceFlow = input.nextInt();
            switch (choiceFlow){
                case 1:
                    System.out.print("ingrese el id del option: ");
                    int idoption = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el mensaje del option: ");
                    String msg = input.nextLine();
                    System.out.print("ingrese el chatbotcodelink del option: ");
                    int CCL = input.nextInt();
                    input.nextLine();
                    System.out.print("ingrese el initialFlowCodeLink del option: ");
                    int IFCL = input.nextInt();
                    input.nextLine();
                    List<String> K = getUserKeywords(input);
                    Option_21498571_PaulRamirez o = new Option_21498571_PaulRamirez(idoption,
                            msg, CCL, IFCL, K);
                    O.add(o);
                    break;
                case 2:
                    System.out.println(O);
                    break;
                case 3:
                    System.out.println("fin de la creacion de options");
                    break;
                default:
                    System.out.println(choiceFlow + " is not a valid option! Please select correct option.");
            }
        }while(choiceFlow != MENU_EXIT_OPTION_FLOW);
        return O;
    }
    private static List<String> getUserKeywords(Scanner input){
        List<String> K = new ArrayList<>();
        int choicekeyword;
        do{
            printMenuKeywords();
            choicekeyword = input.nextInt();
            input.nextLine();
            switch (choicekeyword){
                case 1:
                    System.out.print("ingrese la keyword: ");
                    K.add(input.nextLine());
                    break;
                case 2:
                    break;
                default:
                    System.out.println(choicekeyword + " is not a valid option! Please select correct option.");
            }
        }while(choicekeyword != 2);
        return K;
    }

    private static void adminMenu(Scanner input, System_21498571_PaulRamirez system){
        int choice2;
        int MENU_EXIT_OPTION2 = 6;
        do {
            printMenuChatbots();
            choice2 = input.nextInt();
            switch (choice2) {
                case 1:
                    System.out.print("Ingrese el id del chatbot: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Ingrese el nombre del chatbot: ");
                    String nombre = input.nextLine();
                    System.out.print("Ingrese el mensaje de bienvenida del chatbot: ");
                    String message = input.nextLine();
                    System.out.print("Ingrese el id del flow para el primer link del chatbot: ");
                    int initialFlowId = input.nextInt();
                    input.nextLine();
                    List<Flow_21498571_PaulRamirez> F1 = getUserFlows(input);
                    Chatbot_21498571_PaulRamirez c = new Chatbot_21498571_PaulRamirez(id, nombre,
                            message, initialFlowId, F1);
                    system.systemAddChatbot(c);
                    break;
                case 2:
                    System.out.print("ingrese el id del chatbot a modificar: ");
                    int modId = input.nextInt();
                    input.nextLine();
                    Chatbot_21498571_PaulRamirez modC = system.searchChatbot(modId);
                    if(modC == null){
                        System.out.println("no se encontro un chatbot con el id ingresado");
                        break;
                    }
                    menuModify(input, modC);
                    break;
                case 3:
                    System.out.print("ingrese el id del chatbot a ejecutar en el sistema: ");
                    int idEjecucionChatbot = input.nextInt();
                    input.nextLine();
                    break;
                case 4:
                    System.out.println(system.getChatbots().toString());
                    break;
                case 5:
                    System.out.println(system.getChatbots().toString());
                    break;
                case 6:
                    system.systemLogout();
                    System.out.print("SESION CERRADA\n");
                    break;
                default:
                    System.out.println(choice2 + " is not a valid option! Please select correct option.");
            }
        } while (choice2 != MENU_EXIT_OPTION2);
    }

    private static void normalMenu(Scanner input, System_21498571_PaulRamirez system){
        int choice3;
        int MENU_EXIT_OPTION2 = 3;
        do {
            printMenuNormal();
            choice3 = input.nextInt();
            switch (choice3) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    system.systemLogout();
                    System.out.print("SESION CERRADA\n");
                    break;
                default:
                    System.out.println(choice3 + " is not a valid option! Please select correct option.");
            }
        } while (choice3 != MENU_EXIT_OPTION2);
    }
}

