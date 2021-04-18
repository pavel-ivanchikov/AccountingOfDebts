package FirstHomeWork.TestForMaksim;

import FirstHomeWork.Process_v0.LogBookReaderSimple;
import FirstHomeWork.Process_v0.MyLife;
import FirstHomeWork.Process_v0.Process;
import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Читаю из базы данных уже созданные раннее процессы и готовлю систему для продолжения ведения учёта.
 */

public class SecondStart {

    public static void main(String[] args) throws FileNotFoundException{

        // Инициализирую сначала процесс МояЖизнь.
        // Для этого создаю конструктор для процесса с текстовым аргументом.
        // Пишу пока логику чтения процесса тут, потом вынесу это в одельный документ
        // Пока пишу инициализацию только для MyLife

        Long id = 1617390011183L;

        MyLife myLife = new MyLife(id);

        try (FileReader reader = new FileReader("C:/" +
                "DataBaseAccountingOfDebts/" + id + ".txt"))
        {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");

                LocalDateTime localDateTime = LocalDateTime.parse(strings[0]);
                String string = strings[1];
                if (string != ServiceMessages.NPR.toString()) {
                    for (int i = 2; i < strings.length; i++) {
                        string += " " + strings[i];
                    }
                }
                myLife.addExistingMessage(localDateTime,string);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        LogBookReaderSimple lbr = new LogBookReaderSimple();

        lbr.read(myLife);
        System.out.println(" ");

    }
}
