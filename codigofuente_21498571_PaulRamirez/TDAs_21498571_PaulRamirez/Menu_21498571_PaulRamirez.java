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
                    int choice2;
                    int MENU_EXIT_OPTION2 = 6;
                    if(system.getLoggedUser().isEmpty()){
                        System.out.println("ESE NOMBRE DE USUARIO NO ESTRA REGISTRADO");
                        break;
                    }
                    List<Chatbot_21498571_PaulRamirez> L = new ArrayList<>();
                    do {
                        printMenuChatbots();
                        choice2 = input.nextInt();
                        switch (choice2){
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
                                int choiceChatbot;
                                int MENU_EXIT_OPTION_CHATBOT = 3;
                                List<Flow_21498571_PaulRamirez> F = new ArrayList<>();
                                do {
                                    printMenuFlows();
                                    choiceChatbot = input.nextInt();
                                    switch (choiceChatbot){
                                        case 1:
                                            System.out.print("ingrese el id del flow: ");
                                            int idflow = input.nextInt();;
                                            input.nextLine();
                                            System.out.print("ingrese el name msg del flow: ");
                                            String namemsg = input.nextLine();;
                                            int choiceFlow;
                                            int MENU_EXIT_OPTION_FLOW = 3;
                                            List<Option_21498571_PaulRamirez> O = new ArrayList<>();
                                            do{
                                                printMenuOptions();
                                                choiceFlow = input.nextInt();
                                                switch (choiceFlow){
                                                    case 1:
                                                        System.out.print("ingrese el id del option: ");
                                                        int idoption = input.nextInt();;
                                                        input.nextLine();
                                                        System.out.print("ingrese el mensaje del option: ");
                                                        String msg = input.nextLine();
                                                        System.out.print("ingrese el chatbotcodelink del option: ");
                                                        int CCL = input.nextInt();;
                                                        input.nextLine();
                                                        System.out.print("ingrese el initialFlowCodeLink del option: ");
                                                        int IFCL = input.nextInt();;
                                                        input.nextLine();
                                                        List<String> K = new ArrayList<>();
                                                        int choicekeyword;
                                                        do{
                                                            printMenuKeywords();
                                                            choicekeyword = input.nextInt();
                                                            input.nextLine();
                                                            switch (choicekeyword){
                                                                case 1:
                                                                    System.out.print(" ingrese la keyword: ");
                                                                    K.add(input.nextLine());
                                                                    break;
                                                                case 2:
                                                                    break;
                                                                default:
                                                                    System.out.println(choicekeyword + " is not a valid option! Please select correct option.");
                                                            }
                                                        }while(choicekeyword != 2);
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
                                Chatbot_21498571_PaulRamirez c = new Chatbot_21498571_PaulRamirez(id,nombre,
                                        message, initialFlowId, F);
                                if(L.contains(c)){
                                    System.out.println("no se completo la creacion del chatbot porque ya se habia creado uno con el mismo id");
                                    break;
                                }
                                L.add(c);
                                break;
                            case 2:
                                System.out.println("ingrese el id del chatbot a modificar: ");

                                break;
                            case 3:
                                System.out.print("ingrese el id del chatbot a ejecutar en el sistema: ");
                                int idEjecucionChatbot = input.nextInt();
                                input.nextLine();
                                for(Chatbot_21498571_PaulRamirez chatbot : L){
                                    if(chatbot.getId() == idEjecucionChatbot){
                                        system.systemAddChatbot(chatbot);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println(system.getChatbots().toString());
                                break;
                            case 5:
                                System.out.println(L);
                                break;
                            case 6:
                                system.systemLogout();
                                System.out.print("SESION CERRADA\n");
                                break;
                            default:
                                System.out.println(choice2 + " is not a valid option! Please select correct option.");
                        }
                    } while (choice2 != MENU_EXIT_OPTION2);
                    break;

                case 2:
                    printMenuRegistro();
                    int choice3 = input.nextInt();
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
        System.out.println("### Sistema de Chatbots - Crear flows ###");
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
}

