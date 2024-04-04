public class Falls {

    // Начальное состояние
    static void noFalls(){
        System.out.println("   ___   ");
        System.out.println("      |   ");
        System.out.println("      |   ");
        System.out.println("      |   ");
        System.out.println("   ___|   ");
    }


    // 1 ошибка
    static void oneFalls(){
        System.out.println("   ___   ");
        System.out.println("   *  |   ");
        System.out.println("      |   ");
        System.out.println("      |   ");
        System.out.println("   ___|   ");
    }

    // 2 ошибки
    static void twoFalls(){
        System.out.println("   ___   ");
        System.out.println("   *  |   ");
        System.out.println("   |  |   ");
        System.out.println("      |   ");
        System.out.println("   ___|   ");
    }

    // 3 ошибки
    static void threeFalls(){
        System.out.println("   ___   ");
        System.out.println("  _*  |   ");
        System.out.println("   |  |   ");
        System.out.println("      |   ");
        System.out.println("   ___|   ");
    }

    // 4 ошибки
    static void fourFalls(){
        System.out.println("   ___   ");
        System.out.println("  _*_ |   ");
        System.out.println("   |  |   ");
        System.out.println("      |   ");
        System.out.println("   ___|   ");
    }

    // 5 ошибок
    static void fiveFalls(){
        System.out.println("   ___   ");
        System.out.println("  _*_ |   ");
        System.out.println("   |  |   ");
        System.out.println("  /   |   ");
        System.out.println("   ___|   ");
    }

    // 6 ошибок
    static void sixFalls(){
        System.out.println("   ___   ");
        System.out.println("  _*_ |   ");
        System.out.println("   |  |   ");
        System.out.println("  / \\ |   ");
        System.out.println("   ___|   ");
    }

    // Вывод состояния
    static void printFalls(int countOfFalls){
        if(countOfFalls == 0){
            noFalls();
        } else if (countOfFalls == 1) {
            oneFalls();
        } else if (countOfFalls == 2) {
            twoFalls();
        } else if (countOfFalls == 3) {
            threeFalls();
        } else if (countOfFalls == 4) {
            fourFalls();
        } else if (countOfFalls == 5) {
            fiveFalls();
        } else sixFalls();
    }
}
