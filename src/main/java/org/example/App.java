package org.example;

import javax.smartcardio.*;
import java.util.List;

/**
 * <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.smartcardio/javax/smartcardio/package-summary.html">Java™ Smart Card I/O API</a>
 */
public class App {
    public static void main(String[] args) throws CardException {
        // show the list of available terminals
        TerminalFactory factory = TerminalFactory.getDefault();
        List<CardTerminal> terminals = factory.terminals().list();
        System.out.println("Terminals: " + terminals);

// get the first terminal
        CardTerminal terminal = terminals.get(0);
        // establish a connection with the card
        Card card = terminal.connect("T=0");
        System.out.println("card: " + card);
//        CardChannel channel = card.getBasicChannel();
//        ResponseAPDU r = channel.transmit(new CommandAPDU(c1));
//        System.out.println("response: " + toString(r.getBytes()));
        // disconnect
        card.disconnect(false);
    }
}
