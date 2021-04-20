package FirstHomeWork.Process_v0;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

// этот класс имеет один метод, который переписывает из текстового документа в Журнал все сообщения без разбора
public class DataBaseReader {

    public static void read(Process process, long id) {

        try (FileReader reader = new FileReader("C:/" +
                "DataBaseAccountingOfDebts/" + id + ".txt"))
        {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");

                LocalDateTime localDateTime = LocalDateTime.parse(strings[0]);
                StringBuilder string = new StringBuilder(strings[1]);
                for (int i = 2; i < strings.length; i++) {
                    string.append(" ").append(strings[i]);
                }
                process.addExistingMessage(localDateTime, string.toString());
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


}