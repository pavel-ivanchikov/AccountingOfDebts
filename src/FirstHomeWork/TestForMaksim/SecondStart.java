package FirstHomeWork.TestForMaksim;

import FirstHomeWork.Process_v0.DataBaseReader;
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


        // Пока просто переписал сообщения из файла в логбук, дальше буду идти по логбуку и выполнять команды, служенбные сообщения.
        DataBaseReader dataBaseReader = new DataBaseReader();
        dataBaseReader.read(myLife,id);


        LogBookReaderSimple lbr = new LogBookReaderSimple();

        lbr.read(myLife);
        System.out.println(" ");

    }
}
