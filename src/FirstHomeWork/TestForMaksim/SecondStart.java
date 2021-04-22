package FirstHomeWork.TestForMaksim;

import FirstHomeWork.Process_v0.*;
import FirstHomeWork.Process_v0.Process;

import java.io.*;
import java.util.*;

/**
 * Читаю из базы данных уже созданные раннее процессы и готовлю систему для продолжения ведения учёта.
 */

public class SecondStart {

    public static void main(String[] args) throws FileNotFoundException{
        // Инициализирую сначала процесс МояЖизнь.
        // Для этого создаю конструктор для процесса с текстовым аргументом

        //список процессов в хронологическом порядке.
        List<Process> list = new LinkedList<>();
        Long id = 1617390011183L;
        MyLife myLife = new MyLife(id);

        //метод run итеративный, внутри он вызывает сам себя когда доходит до сообщения о создании процесса.
        list = Initialization.run(list, myLife, id);

        for (Process process : list) {
            process.addMessage("сегодня 22 апреля, тестирую систему.");
            LogBookReaderSimple.read(process);
            System.out.println(" ");
            System.out.println("id: " + process.getMainInfo());
            System.out.println(" ");
        }
    }
}