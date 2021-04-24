package FirstHomeWork.TestForMaksim;

import FirstHomeWork.Process_v0.*;
import FirstHomeWork.Process_v0.Process;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Читаю из базы данных уже созданные раннее процессы и готовлю систему для продолжения ведения учёта.
 */

public class SecondStart2 {

    public static void main(String[] args) throws FileNotFoundException {

        //список процессов в хронологическом порядке.
        List<Process> list = new LinkedList<>();

        // Инициализирую сначала процесс МояЖизнь.
        Long id = 1617390011183L;
        MyLife myLife = MyLife.getMyLife(id);
        //MyLife myLife = new MyLife(id);

        //метод run итеративный, внутри он вызывает сам себя когда доходит до сообщения о создании процесса.
        list = Initialization.run(list, myLife, id);

        System.out.println(list.get(1).toString());

        Person person = (Person) list.get(1);
        Debt debt = (Debt) list.get(2);


        System.out.println(myLife.toString());
        System.out.println(person.toString());
        System.out.println(debt.toString());

//        for (Process process : list) {
//            LogBookReaderSimple.read(process);
//            System.out.println(" ");
//            System.out.println("id: " + process.getMainInfo());
//            System.out.println(" ");
//        }
    }
}