package FirstHomeWork.TestForMaksim;

//import FirstHomeWork.Process_v0.LogBookReader;
import FirstHomeWork.Process_v0.LogBookReaderSimple;
import FirstHomeWork.Process_v0.MyLife;
import FirstHomeWork.Process_v0.Person;
import FirstHomeWork.Process_v0.Debt;


import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

import java.util.concurrent.TimeUnit;

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
 * Добавляю новое сообщение в MyLife вводя его с клавиатуры(пока закоментил, мешает тестировать)
 */

public class Test {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        System.out.println("Тест начался");
        MyLife myLife = new MyLife();
        TimeUnit.SECONDS.sleep(1);
        myLife.add("Это уже второе сообщение в журнале MyLife");
        Person person = myLife.getNewPerson();
        TimeUnit.SECONDS.sleep(1);
        person.add("Всё касается этого человека буду писать сюда");
        myLife.add("В жунал Persona я буду записывать всё что его касается, " +
                "а сюда я буду записывать все остальные мысли");
        person.setName("Alex");
        person.add("Ой, случайно не то имя набрал...");
        person.setName("Paul");
        Debt debt = person.getNewDebt();
        debt.add("Он скоро собирается взять в долг, " +
                "создам процесс заранее");
        TimeUnit.SECONDS.sleep(1);
        debt.iGive(1800);
        debt.setDeadLine(LocalDateTime.now());
        debt.add("Я дал ему деньги наликом, " +
                "на остановке около метро площадь Мужества");
        //=======================================================================================
        System.out.println("создали первый процесс MyLife который породит все остальные процессы");
        System.out.println("MyLife породил процесс Person");
        System.out.println("Установил Имя у Пёрсона");
        System.out.println("Person породил процесс Debt");
        System.out.println("Определил сумму долга");
        System.out.println("Установил какой-то Дэдлайн");
        //=======================================================================================
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите текс для добавления в журнал MyLife");
            String text = in.nextLine();

            myLife.add(text);

            in.close();
        }
        //=======================================================================================
        System.out.println(" ");
        System.out.println("Вывожу все 3 логбука которые есть");
        System.out.println(" ");

//        LogBookReader lbr = new LogBookReader();
        LogBookReaderSimple lbr = new LogBookReaderSimple();

        lbr.read(myLife);
        System.out.println(" ");
        lbr.read(person);
        System.out.println(" ");
        lbr.read(debt);

        System.out.println(" ");
        System.out.println("MainInfo обо всех трёх процессах");
        System.out.println("id: " + myLife.getMainInfo());
        person.getMainInfo();
        debt.getMainInfo();

        System.out.println(" ");
        System.out.println("Имя человека: " + person.getName());
    }
}