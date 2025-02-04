package imp.hashing.hashmap;

import java.util.HashMap;

public class Itenary {

    public static String getStart( HashMap<String,String> ticket){
        HashMap<String,String> rev=new HashMap<>();
             for (String s:ticket.keySet()) {
                rev.put(ticket.get(s), s);
             }
             for (String s : ticket.keySet()) {
                if (!rev.containsKey(s)) {
                    return s;
                }
             }
             return null;
    }

    public static void main(String[] args) {
        HashMap<String,String> ticket=new HashMap<>();
        ticket.put("ch", "b");
        ticket.put("m", "d");
        ticket.put("g", "ch");
        ticket.put("d", "g");

        String start=getStart(ticket);

        System.out.print(start);
        for (String s : ticket.keySet()) {
            start=ticket.get(start);
            System.out.print("--->"+start);
        }

    }
}
