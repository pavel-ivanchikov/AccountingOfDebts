package FirstHomeWork.Process_v0;

import java.time.LocalDate;
import java.util.List;
//import jav afx.util.Pair;

/**
 * Процесс - это сущность, порождаемая другим процессом
 * и хранящая журнал комметариев (пометок) о том что проиходит в рамках эго процесса.
 * Пока буду называть эти комментарии(пометки) - сообщениями, служебными или рукописными.
 * Прошлое процесса неизменно, можно добавлять сообщения о прошлом в настоящий момент.
 */
public abstract class Process {
    
    Process parent;

    LocalDate startDate;

    {
        System.out.println("init Process");
        startDate = LocalDate.now();
    }

    /**
     * Здесь нужно создать основное поле класса - список сообщений.
     */

   // List<Pair<LocalDate,String>> mainInfo = new List<>;


    public abstract void doSomething();

    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */

    public LocalDate getStartDate() {
        return this.startDate;
    }

}
