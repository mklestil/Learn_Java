package at.klestilmartin;

import at.klestilmartin.controller.MyController;

public class Main {
    /*
    An example of Network in Java with sockets, the client send a file
    to the server.
     */
    public static void main(String[] args) {
        System.out.println("Hello world! This is my FileServer Example");
        MyController controller = new MyController();
    }
}