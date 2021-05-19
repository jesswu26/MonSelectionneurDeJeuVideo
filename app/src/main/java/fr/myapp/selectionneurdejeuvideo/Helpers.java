package fr.myapp.selectionneurdejeuvideo;


public class Helpers extends Thread {
    public static  int randomGenerator(int min, int max){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
}
