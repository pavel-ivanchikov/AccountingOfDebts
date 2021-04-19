package FirstHomeWork.Process_v0;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DataBaseReader {

    public DataBaseReader() {

    }

    public void read(Process process, long id) {

        try (FileReader reader = new FileReader("C:/" +
                "DataBaseAccountingOfDebts/" + id + ".txt"))
        {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");

                LocalDateTime localDateTime = LocalDateTime.parse(strings[0]);
                String string = strings[1];
                for (int i = 2; i < strings.length; i++) {
                    string += " " + strings[i];
                }
                process.addExistingMessage(localDateTime,string);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


}