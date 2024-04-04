import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gallows {

    // Массив русских букв
   private static final List<Character> ALF = List.of('а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

   // Чтение введенных символов
   private static Scanner scanner = new Scanner(System.in);

   // Массив слов
   private static final  String[] WORDS = {
           "яблоко", "банан", "кошка", "собака", "слон", "рыба", "виноград", "шапка", "лед", "куртка",
           "земляника", "лимон", "мышь", "гнездо", "апельсин", "груша", "королева", "кролик", "змея", "тигр",
           "зонтик", "скрипка", "кит", "ксилофон", "яхта", "зебра", "муравей", "птица", "машина", "утка",
           "яйцо", "лягушка", "коза", "лошадь", "чернило", "желе", "кенгуру", "лев", "обезьяна", "орех",
           "океан", "карандаш", "одеяло", "роза", "солнце", "дерево", "единорог", "ваза", "вода"
   };

   // Начало игры
   public static void start(){
       int action = -1;
       System.out.println("Игра \"Виселица\":");
       System.out.println("1. Начать новую игру");
       System.out.println("0. Выйти из игры");
        while(action != 0) {
            action = scanner.nextInt();
            if (action == 1) {
                newGame();
            } else if (action == 0) {
                break;
            } else {
                System.out.println("Ошибка ввода!");
            }
        }
    }


    // Новая игра
   private static void newGame(){
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        String[] subWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            subWord[i] = "*";
        }
       System.out.println();
        guessing(word,subWord);
    }


    // Отгадывание
   private static void guessing(String word, String[] subWord) {
       int countFalls = 0;
       boolean flagTrueResult = false;
       char letter = ' ';
       List<Character> tempAlf = new java.util.ArrayList<>(List.copyOf(ALF));

       while (!flagTrueResult && countFalls < 6) {
           boolean flatTrueLetter = false;
           System.out.println();
           System.out.println("Состояние:");
           System.out.println("Загаданное слово: " + Arrays.toString(subWord));
           System.out.printf("Количество ошибок: %d \n",countFalls);
           Falls.printFalls(countFalls);
           System.out.println();
           System.out.println("Доступные буквы:");
           tempAlf.forEach(character -> System.out.print(character + " "));
           System.out.println();
           System.out.println();
           String newStr = "";
           System.out.println("Введите букву");
           newStr = scanner.next().trim().toLowerCase();
           while(newStr.length() != 1 || !isValidRussianLetter(newStr.charAt(0)) || !tempAlf.contains(newStr.charAt(0))){
               System.out.println("Неправильный ввод!");
               System.out.println("Введите букву");
               newStr = scanner.next().trim().toLowerCase();
           }

           letter = newStr.charAt(0);

           for (int i = 0; i < word.length(); i++) {
               if (word.charAt(i) == letter) {
                   subWord[i] = String.valueOf(letter);
                   flatTrueLetter = true;
               }
           }
           int counter = 0;
           for (int j = 0; j < subWord.length; j++) {
               if (subWord[j].equals("*")) {
                   counter++;
               }
           }
           if (counter == 0) {
               flagTrueResult = true;
           } else if(flatTrueLetter) {
               System.out.println("Такая буква есть!");
               tempAlf.remove(tempAlf.indexOf(letter));
           } else {
               System.out.println("Такой буквы нет!");
               countFalls++;
               tempAlf.remove(tempAlf.indexOf(letter));
           }

       }
       if(!flagTrueResult){
           System.out.println();
           System.out.println("Ты проиграл!!!");
           System.out.println();
       } else {
           System.out.println();
           System.out.println("Ты выиграл!");
           System.out.println();
       }
       start();
   }


   // Проверка валидности данных
    public static boolean isValidRussianLetter(char c) {
        // Проверяем, находится ли символ в диапазоне русских букв (а-я, ё)
        return (c >= 'а' && c <= 'я') || c == 'ё' ;
    }
}
