package codigofuente_21498571_PaulRamirez.TDAs_21498571_PaulRamirez;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_21498571_PaulRamirez {
    /**
     * Menu principal del sistema, espera el enter del comando del usuario para inicializar el mismo, se puede iniciar sesion, registrar usuarios y finalizar el programa
     */
    public static void start() {
        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 3;
        int choice1;
        System.out.println("### Sistema de Chatbots ###");
        System.out.println("Presione Enter para inicializar el sistema");
        input.nextLine();
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
                        System.out.println("INTRODUZCA NOMBRE DEL USUARIO NORMAL: ");
                        input.nextLine();
                        String nickUser = input.nextLine();
                        UsuarioComun_21498571_PaulRamirez newUser = new UsuarioComun_21498571_PaulRamirez(nickUser);
                        boolregister = system.systemAddUser(newUser);
                    }
                    else{
                        System.out.println("### Sistema de Chatbots - Registro Usuario Administrador ###");
                        System.out.println("INTRODUZCA NOMBRE DEL USUARIO ADMINISTRADOR: ");
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

    /**
     * Metodo para mostrar por pantalla las opciones del menu del inicio
     */
    public static void printMenuInicio() {
        System.out.println("### Sistema de Chatbots - Inicio ###");
        System.out.println("1. Login de Usuario ");
        System.out.println("2. Registro de Usuario ");
        System.out.println("3. Finalizar Programa ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las indicaciones para introducir el nombre de usuario para iniciar sesion
     */
    public static void printMenuLogin() {
        System.out.println("### Sistema de Chatbots - Login ###");
        System.out.println("INTRODUZCA NOMBRE DE USUARIO: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones de registro
     */
    public static void printMenuRegistro() {
        System.out.println("### Sistema de Chatbots - Registro ###");
        System.out.println("1. Registrar usuario normal ");
        System.out.println("2. Registrar usuario administrador ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones del usuario normal al iniciar sesion
     */
    public static void printMenuNormal() {
        System.out.println("### Sistema de Chatbots - Usuario Normal ###");
        System.out.println("1. Hablar ");
        System.out.println("2. Mostrar Sintesis ");
        System.out.println("3. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones del usuario administrador al iniciar sesion
     */
    public static void printMenuChatbots() {
        System.out.println("### Sistema de Chatbots - Usuario Administrador ###");
        System.out.println("1. Crear un Chatbot ");
        System.out.println("2. Modificar un Chatbot ");
        System.out.println("3. Hablar ");
        System.out.println("4. Mostrar Sintesis ");
        System.out.println("5. Visualizar todos los Chatbot con sus flujos y opciones creadas ");
        System.out.println("6. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones al crear flows
     */
    public static void printMenuFlows() {
        System.out.println("### Sistema de Chatbots - Crear Flows ###");
        System.out.println("1. Crear un Flow ");
        System.out.println("2. Visualizar los Flows con sus opciones creadas ");
        System.out.println("3. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones al crear options
     */
    public static void printMenuOptions() {
        System.out.println("### Sistema de Chatbots - Crear Options ###");
        System.out.println("1. Crear un Option ");
        System.out.println("2. Visualizar todos los Options con sus keywords ");
        System.out.println("3. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones al ingresar las keyword de un option
     */
    public static void printMenuKeywords() {
        System.out.println("### Sistema de Chatbots - Crear Keywords ###");
        System.out.println("1. Agregar una Keyword ");
        System.out.println("2. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Metodo para mostrar por pantalla las opciones al modificar chatbots, es decir, agregar un flow o modificar un flow
     */
    public static void printMenuModChatbots() {
        System.out.println("### Sistema de Chatbots - Modificar Chatbots ###");
        System.out.println("1. Agregar un Flow ");
        System.out.println("2. Modificar un Flow ");
        System.out.println("3. Visualizar los Flows del chatbot con sus opciones creadas ");
        System.out.println("4. Salir ");
        System.out.println("INTRODUZCA SU OPCION: ");
    }

    /**
     * Menu para modificar un chatbot, se ingresan por consola los datos del flow/option que se desea agregar
     * @param input escaner del menu, para recibir los datos que desea ingresar el admin
     * @param chatbot chatbot al cual se le desea agregar un flow/option
     */
    public static void menuModify(Scanner input, Chatbot_21498571_PaulRamirez chatbot){
        int MENU_EXIT_OPTION_MOD = 4;
        int choicemod;
        int idflow;
        do {
            printMenuModChatbots();
            choicemod = input.nextInt();
            switch (choicemod){
                case 1:
                    System.out.println("Ingrese a continuacion los datos del flow que se desea agregar");
                    System.out.println("ingrese el id del flow: ");
                    idflow = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el name msg del flow: ");
                    String namemsg = input.nextLine();
                    List<Option_21498571_PaulRamirez> O = getUserOptions(input);
                    Flow_21498571_PaulRamirez f = new Flow_21498571_PaulRamirez(idflow,
                            namemsg, O);
                    boolean boolflow = chatbot.chatbotAddFlow(f);
                    if (boolflow){
                        System.out.println("Y se agrego exitosamente el flow al chatbot!");
                    }
                    else {
                        System.out.println("Pero no se completo la agregacion del flow porque el chatbot ya contenia otro con el mismo id,\nporfavor cree otro con distinto id");
                    }
                    break;
                case 2:
                    System.out.println("ingrese el id del flow a modificar: ");
                    idflow = input.nextInt();
                    input.nextLine();
                    Flow_21498571_PaulRamirez flow = chatbot.searchFlow(idflow);
                    if(flow == null){
                        System.out.println("no se encontro un flow con el id ingresado");
                        break;
                    }
                    System.out.println("Ingrese a continuacion los datos del option que se desea agregar");
                    System.out.println("ingrese el id del option: ");
                    int idoption = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el mensaje del option: ");
                    String msg = input.nextLine();
                    System.out.println("ingrese el chatbotcodelink del option: ");
                    int CCL = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el initialFlowCodeLink del option: ");
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
                        System.out.println("Se creo la opcion, pero no se completo la agregacion del option porque el flow ya contenia otro con el mismo id,\nporfavor cree otro con distinto id");
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

    /**
     * Menu para crear una serie de flows, que luego se agregan en el constructor de un chatbot
     * @param input escaner del menu, para recibir los datos que desea ingresar el admin
     * @return Flows creados por el administrador
     */
    public static List<Flow_21498571_PaulRamirez> getUserFlows(Scanner input){
        List<Flow_21498571_PaulRamirez> F = new ArrayList<>();
        int MENU_EXIT_OPTION_CHATBOT = 3;
        int choiceChatbot;
        do {
            printMenuFlows();
            choiceChatbot = input.nextInt();
            switch (choiceChatbot){
                case 1:
                    System.out.println("ingrese el id del flow: ");
                    int idflow = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el name msg del flow: ");
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

    /**
     * Menu para crear una serie de options, que luego se agregan en el constructor de un flow
     * @param input escaner del menu, para recibir los datos que desea ingresar el admin
     * @return options creador por el administrador
     */
    public static List<Option_21498571_PaulRamirez> getUserOptions(Scanner input){
        int choiceFlow;
        int MENU_EXIT_OPTION_FLOW = 3;
        List<Option_21498571_PaulRamirez> O = new ArrayList<>();
        do{
            printMenuOptions();
            choiceFlow = input.nextInt();
            switch (choiceFlow){
                case 1:
                    System.out.println("ingrese el id del option: ");
                    int idoption = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el mensaje del option: ");
                    String msg = input.nextLine();
                    System.out.println("ingrese el chatbotcodelink del option: ");
                    int CCL = input.nextInt();
                    input.nextLine();
                    System.out.println("ingrese el initialFlowCodeLink del option: ");
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

    /**
     * Menu para recibir las keywords que desea incluir el administrador a la creacion de un option
     * @param input escaner del menu, para recibir los datos que desea ingresar el admin
     * @return lista de keywords ingresadas por el admin
     */
    public static List<String> getUserKeywords(Scanner input){
        List<String> K = new ArrayList<>();
        int choicekeyword;
        do{
            printMenuKeywords();
            choicekeyword = input.nextInt();
            input.nextLine();
            switch (choicekeyword){
                case 1:
                    System.out.println("ingrese la keyword: ");
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

    /**
     * usuario comun para iniciar un talk, crear o modificar chatbots, mostrar los chatbots creados o mostrar el historial del admin
     * @param input escaner del menu, para recibir los datos que desea ingresar el admin
     * @param system
     */
    public static void adminMenu(Scanner input, System_21498571_PaulRamirez system){
        int choice2;
        int MENU_EXIT_OPTION2 = 6;
        do {
            printMenuChatbots();
            choice2 = input.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println("Ingrese el id del chatbot: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Ingrese el nombre del chatbot: ");
                    String nombre = input.nextLine();
                    System.out.println("Ingrese el mensaje de bienvenida del chatbot: ");
                    String message = input.nextLine();
                    System.out.println("Ingrese el id del flow para el primer link del chatbot: ");
                    int initialFlowId = input.nextInt();
                    input.nextLine();
                    List<Flow_21498571_PaulRamirez> F1 = getUserFlows(input);
                    Chatbot_21498571_PaulRamirez c = new Chatbot_21498571_PaulRamirez(id, nombre,
                            message, initialFlowId, F1);
                    boolean boolchatbot = system.systemAddChatbot(c);
                    if (boolchatbot){
                        System.out.println("Y se ha agregado exitosamente al sistema!");
                    }
                    else {
                        System.out.println("pero no se agrego, debido a que ya existia uno con el mismo id en el sistema, porfavor cree otro con distinto id");
                    }
                    break;
                case 2:
                    System.out.println("ingrese el id del chatbot a modificar: ");
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
                    System.out.println("Se muestra a continuacion el historial del usuario "
                            + system.getLoggedUser());
                    System.out.println(system.synthesis(system.getLoggedUser()));
                    System.out.println("\n");
                    System.out.println("Fin del Historial");
                    break;
                case 5:
                    System.out.println(system.getChatbots().toString());
                    break;
                case 6:
                    system.systemLogout();
                    System.out.println("SESION CERRADA\n");
                    break;
                default:
                    System.out.println(choice2 + " is not a valid option! Please select correct option.");
            }
        } while (choice2 != MENU_EXIT_OPTION2);
    }

    /**
     * Menu de usuario comun para iniciar un talk o mostrar el historial del usuario por pantalla
     * @param input escaner del menu, para recibir los datos que desea ingresar el usuario comun
     * @param system sistema en donde se establecen las conversaciones y que contiene los chatbots e historial de los usuarios
     */
    public static void normalMenu(Scanner input, System_21498571_PaulRamirez system){
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
                    System.out.println("Se muestra a continuacion el historial del usuario "
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

    /**
     * Menu usado iniciar un talk con un usuario, primera imprime por consola las indicaciones y luego comienza el chat
     * @param input escaner del menu, para recibir el mensaje que del usuario
     * @param system el sistema en donde se establece la conversacion
     */
    public static void menuTalk(Scanner input, System_21498571_PaulRamirez system){
        System.out.println("### Sistema de Chatbots - Ejecucion del sistema de chatbots ### \n" +
                "Ingrese como opcion SALIR, para salir de la conversacion\n"+
                "porfavor comience la conversacion enviando el primer mensaje: ");
        input.nextLine();
        String mensaje = input.nextLine();
        if(mensaje.equals("SALIR")){
            return;
        }
        System.out.println(system.talk(mensaje));
        do{
            System.out.println("Seleccione una opcion: ");
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

    /**
     * Metodo que inicializa el sistema, crea usuarios, options, flows y chatbots para luego agregarlos a un sistema
     * @return sistema con chatbots creados y usuarios registrados
     */
    public static System_21498571_PaulRamirez initialSystem(){
        Option_21498571_PaulRamirez OP1 = new Option_21498571_PaulRamirez(1, "1) Viajar",
                1, 1, List.of("viajar", "turistear", "conocer"));
        Option_21498571_PaulRamirez OP2 = new Option_21498571_PaulRamirez(2, "2) Estudiar",
                2, 1, List.of("estudiar", "aprender", "perfeccionarme"));
        Flow_21498571_PaulRamirez F1 = new Flow_21498571_PaulRamirez(1, "Flujo Principal Chatbot0\nBienvenido\n¿Que te gustaria hacer?",
                List.of(OP1,OP2));
        Chatbot_21498571_PaulRamirez C0 = new Chatbot_21498571_PaulRamirez(0, "Inicial",
                "Bienvenido\n¿Que te gustaria hacer?", 1, List.of(F1));

        Option_21498571_PaulRamirez OP3 = new Option_21498571_PaulRamirez(1, "1) New York, USA",
                1, 2, List.of("USA", "Estados Unidos", "New York"));
        Option_21498571_PaulRamirez OP4 = new Option_21498571_PaulRamirez(2, "2) Paris, Francia",
                1, 1, List.of("Paris", "Eiffel"));
        Option_21498571_PaulRamirez OP5 = new Option_21498571_PaulRamirez(3, "3) Torres del Paine, Chile",
                1, 1, List.of("Chile", "Torres", "Paine", "Torres Paine", "Torres del Paine"));
        Option_21498571_PaulRamirez OP6 = new Option_21498571_PaulRamirez(4, "4) Volver",
                0, 1, List.of("Regresar", "Salir", "Volver"));
        Flow_21498571_PaulRamirez F2 = new Flow_21498571_PaulRamirez(1, "Flujo 1 Chatbot1\n¿Donde te Gustaria ir?",
                List.of(OP3, OP4, OP5, OP6));
        Option_21498571_PaulRamirez OP7 = new Option_21498571_PaulRamirez(1, "1) Central Park",
                1, 2, List.of("Central", "Park", "Central Park"));
        Option_21498571_PaulRamirez OP8 = new Option_21498571_PaulRamirez(2, "2) Museos",
                1, 2, List.of("Museo"));
        Option_21498571_PaulRamirez OP9 = new Option_21498571_PaulRamirez(3, "3) Ningun otro atractivo",
                1, 3, List.of("Ninguno", "Ningun otro", "Ningun otro atractivo"));
        Option_21498571_PaulRamirez OP10 = new Option_21498571_PaulRamirez(4, "4) Cambiar destino",
                1, 1, List.of("Cambiar", "Volver", "Salir"));
        Flow_21498571_PaulRamirez F3 = new Flow_21498571_PaulRamirez(2, "Flujo 2 Chatbot1\n¿Que atractivos te gustaria visitar?",
                List.of(OP7, OP8, OP9, OP10));
        Option_21498571_PaulRamirez OP11 = new Option_21498571_PaulRamirez(1, "1) Solo",
                1, 3, List.of("Solo"));
        Option_21498571_PaulRamirez OP12 = new Option_21498571_PaulRamirez(2, "2) En pareja",
                1, 3, List.of("Pareja"));
        Option_21498571_PaulRamirez OP13 = new Option_21498571_PaulRamirez(3, "3) En familia",
                1, 3, List.of("Familia"));
        Option_21498571_PaulRamirez OP14 = new Option_21498571_PaulRamirez(4, "4) Agregar mas atractivos",
                1, 2, List.of("Volver", "Atractivos"));
        Option_21498571_PaulRamirez OP15 = new Option_21498571_PaulRamirez(5, "5) En realidad quiero otro destino",
                1, 1, List.of("Cambiar destino"));
        Flow_21498571_PaulRamirez F4 = new Flow_21498571_PaulRamirez(3, "Flujo 3 Chatbot1\n¿Vas solo o acompanado?",
                List.of(OP11, OP12, OP13, OP14, OP15));
        Chatbot_21498571_PaulRamirez C1 = new Chatbot_21498571_PaulRamirez(1, "Agencia Viajes",
                "Bienvenido\n¿Donde quieres viajar?", 1, List.of(F2,F3,F4));

        Option_21498571_PaulRamirez OP16 = new Option_21498571_PaulRamirez(1, "1) Carrera Tecnica",
                2, 1, List.of("Tecnica"));
        Option_21498571_PaulRamirez OP17 = new Option_21498571_PaulRamirez(2, "2) Postgrado",
                2, 1, List.of("Doctorado", "Magister", "Postgrado"));
        Option_21498571_PaulRamirez OP18 = new Option_21498571_PaulRamirez(3, "3) Volver",
                0, 1, List.of("Volver", "Salir", "Regresar"));
        Flow_21498571_PaulRamirez F5 = new Flow_21498571_PaulRamirez(1, "Flujo 1 Chatbot2\n¿Que te gustaria estudiar?",
                List.of(OP16, OP17, OP18));
        Chatbot_21498571_PaulRamirez C2 = new Chatbot_21498571_PaulRamirez(2, "Orientador Academico",
                "Bienvenido\n¿Que te gustaria estudiar?", 1, List.of(F5));

        System_21498571_PaulRamirez S0 = new System_21498571_PaulRamirez("Chatbots Paradigmas",
                0, List.of(C0, C1, C2));
        UsuarioComun_21498571_PaulRamirez U1 = new UsuarioComun_21498571_PaulRamirez("normal");
        Administrador_21498571_PaulRamirez U2 = new Administrador_21498571_PaulRamirez("admin");
        S0.systemAddUser(U1);
        S0.systemAddUser(U2);
        return S0;
    }
}

