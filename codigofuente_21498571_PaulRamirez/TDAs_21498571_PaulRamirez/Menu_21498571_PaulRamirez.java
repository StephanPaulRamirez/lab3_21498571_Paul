package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_21498571_PaulRamirez {
    public static void start() {
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 3;
        int choice1;
        System_21498571_PaulRamirez system = initialSystem();
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
                        System.out.println("Bienvenido " + nickname + " usted es administrador.");
                        adminMenu(input, system);
                    }
                    else{
                        System.out.println("Bienvenido " + nickname + " usted es usuario comun.");
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
                    boolean boolregister;
                    if(choice3 == 1){
                        System.out.println("### Sistema de Chatbots - Registro Usuario Normal ###");
                        System.out.print("INTRODUZCA NOMBRE DEL USUARIO NORMAL: ");
                        input.nextLine();
                        String nickUser = input.nextLine();
                        UsuarioComun_21498571_PaulRamirez newUser = new UsuarioComun_21498571_PaulRamirez(nickUser);
                        boolregister = system.systemAddUser(newUser);
                    }
                    else{
                        System.out.println("### Sistema de Chatbots - Registro Usuario Administrador ###");
                        System.out.print("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR: ");
                        input.nextLine();
                        String nickAdmin = input.nextLine();
                        Administrador_21498571_PaulRamirez newAdmin = new Administrador_21498571_PaulRamirez(nickAdmin);
                        boolregister = system.systemAddUser(newAdmin);
                    }
                    if(boolregister){
                        System.out.println("Se ha completado exitosamente el registro de usuario!");
                    }
                    else {
                        System.out.println("El nombre de usuario ingresado ya esta registrado en el sistema");
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
                    boolean boolflow = chatbot.chatbotAddFlow(f);
                    if (boolflow){
                        System.out.println("Y se agrego exitosamente el flow al chatbot!");
                    }
                    else {
                        System.out.println("Pero no se completo la agregacion del flow porque el chatbot ya contenia otro con el mismo id,\n porfavor cree otro con distinto id");
                    }
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
                    boolean booloption = flow.flowAddOption(o);
                    if (booloption){
                        System.out.println("Se creo exitosamente el option y se agrego la opcion creada al flow!");
                    }
                    else{
                        System.out.println("Se creo la opcion, pero no se completo la agregacion del option porque el flow ya contenia otro con el mismo id,\n porfavor cree otro con distinto id");
                    }
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
                    System.out.println("Se creo el chatbot con los flows creados pero se mantuvieron solo las primeras ocurrencias para cada id");
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
                    System.out.println("Se ha creado exitosamente el option!");
                    break;
                case 2:
                    System.out.println(O);
                    break;
                case 3:
                    System.out.println("Se creo el flow con las opciones creadas pero se mantuvieron solo las primeras ocurrencias para cada id");
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
                    boolean boolchatbot = system.systemAddChatbot(c);
                    if (boolchatbot){
                        System.out.println("Y se ha añadido exitosamente al sistema!");
                    }
                    else {
                        System.out.println("pero no se agrego, debido a que ya existia uno con el mismo id en el sistema, porfavor cree otro con distinto id");
                    }
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
                    menuTalk(input, system);
                    break;
                case 4:
                    System.out.print("Se muestra a continuacion el historial del usuario "
                            + system.getLoggedUser() + "\n");
                    System.out.println(system.synthesis(system.getLoggedUser()));
                    System.out.println("\n");
                    System.out.println("Fin del Historial");
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
                    menuTalk(input, system);
                    break;
                case 2:
                    System.out.print("Se muestra a continuacion el historial del usuario "
                            + system.getLoggedUser() + "\n");
                    System.out.println(system.synthesis(system.getLoggedUser()));
                    System.out.println("\n");
                    System.out.println("Fin del Historial");
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

    private static void menuTalk(Scanner input, System_21498571_PaulRamirez system){
        System.out.print("### Sistema de Chatbots - Ejecucion del sistema de chatbots ### \n" +
                "Ingrese como opcion SALIR, para salir de la conversacion\n"+
                "porfavor comience la conversacion enviando el primer mensaje: ");
        input.nextLine();
        String mensaje = input.nextLine();
        if(mensaje.equals("SALIR")){
            return;
        }
        System.out.println(system.talk(mensaje));
        do{
            System.out.print("Seleccione una opcion: ");
            mensaje = input.nextLine();
            String response = system.talk(mensaje);
            if(mensaje.equals("SALIR")){
                response = "SALIR";
            }
            switch (response) {
                case "":
                    System.out.println(mensaje + " no es una opcion valida");
                    break;
                case "SALIR":
                    System.out.println("Conversacion Finalizada, historial guardado");
                    break;
                default:
                    System.out.println(response);
            }
        }while (!mensaje.equals("SALIR"));
        String username = system.getLoggedUser();
        system.systemLogout();
        system.systemLogin(username);
    }

    private static System_21498571_PaulRamirez initialSystem(){
        Option_21498571_PaulRamirez OP1 = new Option_21498571_PaulRamirez(1, "1) Viajar",
                1, 1, List.of("viajar", "turistear", "conocer"));
        Option_21498571_PaulRamirez OP2 = new Option_21498571_PaulRamirez(2, "2) Estudiar",
                2, 1, List.of("estudiar", "aprender", "perfeccionarme"));
        Flow_21498571_PaulRamirez F1 = new Flow_21498571_PaulRamirez(1, "Flujo Principal Chatbot0\nBienvenido\n¿Qué te gustaría hacer?",
                List.of(OP1,OP2));
        Chatbot_21498571_PaulRamirez C0 = new Chatbot_21498571_PaulRamirez(0, "Inicial",
                "Bienvenido\n¿Qué te gustaría hacer?", 1, List.of(F1));

        Option_21498571_PaulRamirez OP3 = new Option_21498571_PaulRamirez(1, "1) New York, USA",
                1, 2, List.of("USA", "Estados Unidos", "New York"));
        Option_21498571_PaulRamirez OP4 = new Option_21498571_PaulRamirez(2, "2) París, Francia",
                1, 1, List.of("Paris", "Eiffel"));
        Option_21498571_PaulRamirez OP5 = new Option_21498571_PaulRamirez(3, "3) Torres del Paine, Chile",
                1, 1, List.of("Chile", "Torres", "Paine", "Torres Paine", "Torres del Paine"));
        Option_21498571_PaulRamirez OP6 = new Option_21498571_PaulRamirez(4, "4) Volver",
                0, 1, List.of("Regresar", "Salir", "Volver"));
        Flow_21498571_PaulRamirez F2 = new Flow_21498571_PaulRamirez(1, "Flujo 1 Chatbot1\n¿Dónde te Gustaría ir?",
                List.of(OP3, OP4, OP5, OP6));
        Option_21498571_PaulRamirez OP7 = new Option_21498571_PaulRamirez(1, "1) Central Park",
                1, 2, List.of("Central", "Park", "Central Park"));
        Option_21498571_PaulRamirez OP8 = new Option_21498571_PaulRamirez(2, "2) Museos",
                1, 2, List.of("Museo"));
        Option_21498571_PaulRamirez OP9 = new Option_21498571_PaulRamirez(3, "3) Ningún otro atractivo",
                1, 3, List.of("Ninguno", "Ningun otro", "Ningun otro atractivo"));
        Option_21498571_PaulRamirez OP10 = new Option_21498571_PaulRamirez(4, "4) Cambiar destino",
                1, 1, List.of("Cambiar", "Volver", "Salir"));
        Flow_21498571_PaulRamirez F3 = new Flow_21498571_PaulRamirez(2, "Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?",
                List.of(OP7, OP8, OP9, OP10));
        Option_21498571_PaulRamirez OP11 = new Option_21498571_PaulRamirez(1, "1) Solo",
                1, 3, List.of("Solo"));
        Option_21498571_PaulRamirez OP12 = new Option_21498571_PaulRamirez(2, "2) En pareja",
                1, 3, List.of("Pareja"));
        Option_21498571_PaulRamirez OP13 = new Option_21498571_PaulRamirez(3, "3) En familia",
                1, 3, List.of("Familia"));
        Option_21498571_PaulRamirez OP14 = new Option_21498571_PaulRamirez(4, "4) Agregar más atractivos",
                1, 2, List.of("Volver", "Atractivos"));
        Option_21498571_PaulRamirez OP15 = new Option_21498571_PaulRamirez(5, "5) En realidad quiero otro destino",
                1, 1, List.of("Cambiar destino"));
        Flow_21498571_PaulRamirez F4 = new Flow_21498571_PaulRamirez(3, "Flujo 3 Chatbot1\n¿Vas solo o acompañado?",
                List.of(OP11, OP12, OP13, OP14, OP15));
        Chatbot_21498571_PaulRamirez C1 = new Chatbot_21498571_PaulRamirez(1, "Agencia Viajes",
                "Bienvenido\n¿Dónde quieres viajar?", 1, List.of(F2,F3,F4));

        Option_21498571_PaulRamirez OP16 = new Option_21498571_PaulRamirez(1, "1) Carrera Técnica",
                2, 1, List.of("Técnica"));
        Option_21498571_PaulRamirez OP17 = new Option_21498571_PaulRamirez(2, "2) Postgrado",
                2, 1, List.of("Doctorado", "Magister", "Postgrado"));
        Option_21498571_PaulRamirez OP18 = new Option_21498571_PaulRamirez(3, "3) Volver",
                0, 1, List.of("Volver", "Salir", "Regresar"));
        Flow_21498571_PaulRamirez F5 = new Flow_21498571_PaulRamirez(1, "Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?",
                List.of(OP16, OP17, OP18));
        Chatbot_21498571_PaulRamirez C2 = new Chatbot_21498571_PaulRamirez(2, "Orientador Académico",
                "Bienvenido\n¿Qué te gustaría estudiar?", 1, List.of(F5));

        System_21498571_PaulRamirez S0 = new System_21498571_PaulRamirez("Chatbots Paradigmas",
                0, List.of(C0, C1, C2));
        UsuarioComun_21498571_PaulRamirez U1 = new UsuarioComun_21498571_PaulRamirez("normal");
        Administrador_21498571_PaulRamirez U2 = new Administrador_21498571_PaulRamirez("admin");
        S0.systemAddUser(U1);
        S0.systemAddUser(U2);
        return S0;
    }
}

