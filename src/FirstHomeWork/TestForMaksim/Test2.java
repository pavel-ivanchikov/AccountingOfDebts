package FirstHomeWork.TestForMaksim;


import FirstHomeWork.Process_v0.Process;
import FirstHomeWork.Process_v0.MyLife;
import FirstHomeWork.Process_v0.Person;
import FirstHomeWork.Process_v0.Debt;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 Создать иерархию классов с абстрактным классом на вершине.
 Продумать какие поля должны быть у объектов данного типа и какое должно быть поведение.
 Дефолтное поведение (заданное в абстрактном классе) переопределить в наследниках
 (один наследник останется с дефолтным поведением)

 Создать для этой иерархии два интерфейса с одним абстрактным методом, одним дефолтным.
 Расширить эти интерфейсы в своих классах.

 Заполнить два ArrayList объектами вашего типа.
 Отсортировать одну коллекцию по natural ordering, другую по другим признакам (на ваш выбор).

 Задание выполнять в отдельной ветке. Ветку назвать NameSurname_HW1.

 Запушить в репозиторий, создать new pull request

 */
public class Test2 {

    public static void main(String[] args) throws NullPointerException {
        // Создаём перевый процесс, которые пораждает все остальные
        MyLife myLife = new MyLife();


        // Создаю первый список
        // Создам 5 человек и у каждого по 2 долга.
/*
        try {

            ArrayList<Process> arrayList1 = new ArrayList<>(15);

            for (int i = 0; i < 5; i++) {
                Person somePerson = myLife.getNewPerson("Имя" + i);
                arrayList1.add(somePerson);
                //Debt debt1 = somePerson.getNewDebt((i + 1) * 100);
                Debt debt1 = somePerson.getNewDebt();
                arrayList1.add(debt1);
//                Debt debt2 = somePerson.getNewDebt((i + 1) * 200);
                Debt debt2 = somePerson.getNewDebt();
                arrayList1.add(debt2);
            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        // Создаю второй список
        // Создам 3 человек и у каждого по 3 долга.
        try {

            ArrayList<Process> arrayList2 = new ArrayList<>(12);

            for (int i = 0; i < 3; i++) {
                Person somePerson = myLife.getNewPerson("Имя" + i);
                arrayList2.add(somePerson);
                //Debt debt1 = somePerson.getNewDebt((i + 1) * 100);
                Debt debt1 = somePerson.getNewDebt();
                arrayList2.add(debt1);
//                Debt debt2 = somePerson.getNewDebt((i + 1) * 200);
                Debt debt2 = somePerson.getNewDebt();
                arrayList2.add(debt2);
//                Debt debt3 = somePerson.getNewDebt((i + 1) * 300);
                Debt debt3 = somePerson.getNewDebt();
                arrayList2.add(debt3);
            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }



*/
    }

}