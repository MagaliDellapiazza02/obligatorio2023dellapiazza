import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import entities.*;
import uy.edu.um.prog2.adt.linkedlist.*;
import uy.edu.um.prog2.adt.hashtable.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Long.parseLong;

public class Main {
    public MyHashTable<Long, User> users;

//  public MyHashTable<Long, Tweet> tweets;
    public MyLinkedList<Tweet> tweets;
    public MyHashTable<Long, Hashtag> hashtags; // me sirve de algo ??
    double tweetsCounter = 0;

    static MyLinkedList<Long> usersKeys = new LinkedList<>();
    static MyLinkedList<Long> tweetsKeys = new LinkedList<>();
    static MyLinkedList<Long> hashtagsKeys = new LinkedList<>();

    static MyLinkedList<Driver> driversList = new LinkedList<>();

    private static String input = "-1";
    private static final Scanner myObj = new Scanner(System.in);

    public Main(){
        users = new HashTable<>(80000);
//        tweets = new HashTable<>(2100000);
        hashtags = new HashTable<>(10000);

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.displayMenu(main);

    }

    public void uploadData() {
        String csvFile = "src/f1_dataset_test.csv";
        File file = new File(csvFile);

        try {
            CSVParser csvParser = CSVParser.parse(file, StandardCharsets.UTF_8, CSVFormat.DEFAULT);

            for (CSVRecord record : csvParser) {
                try {
                    long id = Long.parseLong(record.get(0));
                    String name = record.get(1);
                    double userFavourites = Double.parseDouble(record.get(7));
                    boolean userVerified = Boolean.parseBoolean(record.get(8));
                    String date = record.get(9);
                    String content = record.get(10);
                    String hastagsString = record.get(11); // ej: "['F1', 'FORMULA1', 'MexicoGP']"

                    String source = record.get(12);
                    boolean isRetweet = Boolean.parseBoolean(record.get(13));


                    //busco el hashtag en el hash de hashtags y sino esta en el hash ==> lo agrego como instancia de hashtag al hash
//                    for (int i = 0; i < hashtags.length; i++) {
//                          Hashtag hashtag = new Hashtag();
//                          hashtag.setId((long) hashtagHashSize);
//
//                    } no me sirve de nada el hash de hastags, ya tengo mi linkedlist de hashtags en cada tweet


                // CREO  INSTANCIAS DE LAS CLASES USER, TWEET Y HASHTAG //
                    User user = new User();
                    Hashtag hashTag = new Hashtag();

                    // CARGO VALORES DE LOS ATRIBUTOS DEL USER //
                    user.setName(name);
                    user.setUserFavourites(userFavourites);
                    user.setUserVerified(userVerified);

                    // CARGO VALORES DE LOS ATRIBUTOS DEL TWEET //
                        // PASO EL STRING-ARRAY A UNO DE TIPO DE DATO ARRAY
                        // Eliminar los caracteres especiales del inicio y final del string
                    hastagsString = hastagsString.substring(1, input.length() - 1);
                    String[] hashtags = hastagsString.split(",\\s*"); //divido el string en elementos individuales
                    for (int i = 0; i < hashtags.length; i++) {  // Eliminar las comillas y espacios en blanco alrededor de cada elemento
                        hashtags[i] = hashtags[i].trim().replaceAll("^'|'$", "");
                    }


                    Tweet tweet = new Tweet(id,content,date);
                    tweet.setSource(source);
                    tweet.setHashtags(hashtags); // le paso el String[] hashtags y los pasa por el método de la clase Tweet
                    tweet.setRetweet(isRetweet);
                    tweets.add(tweet); // agrego el tweet a la linkedlist de tweets
                    tweet.setId((long) tweetsCounter); //SUPONIENDO QUE EL ID DEL TWEET ES DIFERENTE AL ID DEL USUARIO
                    tweetsCounter++;


                    //AGREGO AL HASH USER DEPENDIENDO DE LA CANTIDAD DE TWEETS //

                    if (users.contains(user.getId())) {
                        user = users.get(user.getId());
                        user.incrementAmountOfTweets();
                        tweet.setUser(user);
                        users.put(user.getId(), user);
                    } else {
                        user.setAmountOfTweets(1);
                        tweet.setUser(user);
                        users.put(user.getId(), user);
                    }

                    //System.out.println(tweet.getUser().getName() + "tiene likes:" + tweet.getUser().getFavourites());

                } catch (Exception ignored) {}
            }

            csvParser.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    // CARGA PILOTOS //
    private static final String NOMBRE_ARCHIVO = "src/drivers.txt";
    public void cargaDrivers() {

        try {
            File archivo = new File(NOMBRE_ARCHIVO);
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                Driver driver = new Driver(scanner.nextLine());
                driversList.add(driver);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo: " + NOMBRE_ARCHIVO);
        }
    }


    public void displayMenu(Main main) {
        while (!(input.equals("1"))){
            System.out.println("Bienvenido. Ingrese el número correspondiente a lo que desea realizar: ");
            System.out.println("1- Cargar datos y menú de consultas. ");
            System.out.println();
            input = myObj.next();
            switch (input){
                case "1":
                    main.uploadData();
                    System.out.println("Carga completa.");
                    main.submenu(main,input);
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        }
    }

    public void submenu(Main main,String input){
        while(!input.equals("7")){
            System.out.println("Ingrese el número de consulta que desea realizar:");
            System.out.println("1- Listar los 10 pilotos activos en la temporada 2023 más mencionados en los tweets en un mes determinado.");
            System.out.println("2- Top 15 usuarios con más tweets. ");
            System.out.println("3- Cantidad de hashtags distintos para un día dado. ");
            System.out.println("4- Hashtag más usado para un día dado, sin tener en cuenta #f1.");
            System.out.println("5- Top 7 cuentas con más favoritos.");
            System.out.println("6- Cantidad de tweets con una palabra o frase específicos.");
            System.out.println("7- Finalizar.");
            input = myObj.next();

            switch(input){
                case "1":
                    try{
                        System.out.println("Ingrese un mes: ");
                        String newInput = myObj.next();
                        Integer mes = Integer.parseInt(newInput);
                        System.out.println("Ingrese un año(2021/2022): ");
                        String newInput2 = myObj.next();
                        Integer year = Integer.parseInt(newInput2);
                        //top10Pilots(main.tweets,main.driversList,month, year);
                    }catch (NumberFormatException e){
                        System.out.println("Mes erróneo, consulte de nuevo");
                    }
                    break;

                case "2":
                    //top15Users(main.users);
                    break;

                case "3":
                    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
                    formatDate.setLenient(false);

                    System.out.println("Ingrese una fecha inicio: dd-MM-yyyy");
                    String date = myObj.next();
                        //cantidadHashtags(main.tweets,date);

                    break;

                case "4":
//                    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
//                    formatDate.setLenient(false);
//
//                    System.out.println("Ingrese una fecha inicio: dd-MM-yyyy");
//                    String date = myObj.next();

                    //top7Cuentas(main.tweets,date);
                    break;

                case "5":
                    //top7Cuentas(main.tweets);
                    break;

                case "6":
                    //cantidadTweets(main.tweets, inputText);
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
                    break;

            }
        }
        input = "1";
    }
}

