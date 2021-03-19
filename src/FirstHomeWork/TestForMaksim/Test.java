package FirstHomeWork.TestForMaksim;

import FirstHomeWork.Process_v0.LogBookReader;
import FirstHomeWork.Process_v0.MyLife;
import FirstHomeWork.Process_v0.Person;
import FirstHomeWork.Process_v0.Debt;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Цель проекта. Создать систему учёта долгов и должников и мыслей вокруг долгов.
 *
 * Функционал (use cases):
 * - сохранить инфу о текущей задолженности, изменения ее баланса, внесение комметариев у учтенного человека (моей или его)
 * - иметь доступ ко всем закрытым долгам (сумма, даты, комменты) учтенного человека
 * - напоминать мне о предстоящем возврате долга (или напомнить о том что надо дать вдолг в будущем)
 * - база данных принципиально неизменна.
 *
 * - в текстовом документе записи следущего вида:
 * sm
 *  LocalDate ServiceMessage some_parameter hashcode/n
 * m
 *  LocalDate text hashcode/n
 *
 * Система проектируется так чтобы быть максимально дружелюбной в процессе поиска чего-либо в прошлом.
 *
 * тестирую объекты походу их описания
 *
 * Создаю примитивную систему, где есть всего один должник и у этого человека всего один долг.
 *
 * В каждый процесс добавляю по одному сообщению
 *
 * Добавляю новое сообщение в MyLife вводя его с клавиатуры.
 */

public class Test {

    public static void main(String[] args){

        System.out.println("Тест начался");
        MyLife myLife = new MyLife();
        myLife.addMessageToLogBook("Жизнь продолжается");
        Person person = myLife.getNewPerson();
        person.addMessageToLogBook("Все мысли косающиеся этого человека буду писать сюда");
        myLife.addMessageToLogBook("Все мысли которые не касаются нового человека я буду писать сюда");
        person.setName("Alex");
        Debt debt = person.getNewDebt();
        debt.iGive(1800);
        debt.setDeadLine(LocalDate.now());
        //=======================================================================================
        System.out.println("создали первый процесс MyLife который породит все остальные процессы");
        System.out.println("MyLife породил процесс Person");
        System.out.println("Установил Имя у Пёрсона");
        System.out.println("Person породил процесс Debt");
        System.out.println("Определил сумму долга");
        System.out.println("Установил какой-то Дэдлайн");
        //=======================================================================================
        myLife.addMessageToLogBook("Жизнь продолжается");
        person.addMessageToLogBook("Жизнь человека то же продолжается");
        debt.addMessageToLogBook("Жизнь долга тяжела и неказиста.");
        //=======================================================================================
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите текс для добавления в журнал MyLife");
            String text = in.nextLine();

            myLife.addMessageToLogBook(text);

            in.close();
        }
        //=======================================================================================
        System.out.println(" ");
        System.out.println("Вывожу все 3 логбука которые есть");
        System.out.println(" ");
        LogBookReader lbr = new LogBookReader();
        lbr.read(myLife);
        System.out.println(" ");
        lbr.read(person);
        System.out.println(" ");
        lbr.read(debt);
    }
}
