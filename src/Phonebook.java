import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Phonebook {

    void run() throws IOException{
        Map<String,String> book = new HashMap<>();

        SimpleConsole console = new SimpleConsole();
        while(true) {
            String[] split = console.readLine().split(" ");
            String command = split[0];

            if (command.equals("add")) book = add(book, split[1], split[2]);
            else if (command.equals("list")) list(book);
            else if (command.equals("find")) find(book, split[1]).ifPresent(number -> {
                System.out.println(split[1] + " : " + number);
            });
            else if (command.equals("remove")) book = remove(book,split[1]);
            else if(command.equals("exit"))break;
        }
    }

    Map<String,String> add(Map<String,String> oldBook,String name, String number){
        oldBook.put(name,number);
        return oldBook;
    }

    void list(Map<String,String> list){
        list.forEach( (name,number) -> {
            System.out.println(name + " " + number);
        });
    }

    Optional<String> find(Map<String,String> book,String name){
        if( book.containsKey(name) ) return Optional.of(book.get(name));
        else return Optional.empty();
    }

    Map<String,String> remove(Map<String,String> oldBook,String name){
        oldBook.remove(name);
        return oldBook;
    }
    public static void main(String[] args) throws IOException{
        new Phonebook().run();
    }
}
