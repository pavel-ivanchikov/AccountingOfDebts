package FirstHomeWork.TestForMaksim;


import FirstHomeWork.Process_v0.LogBookReader;
import FirstHomeWork.Process_v0.MyLife;
import FirstHomeWork.Process_v0.Person;
import FirstHomeWork.Process_v0.Debt;

/**
 *
 тестирую объекты походу их описания
 */
public class Test {

    public static void main(String[] args){

        System.out.println("Тест начался");

        MyLife myLife = new MyLife();
        System.out.println("создали первый и основной процесс, который породит все остальные процессы");

        Person person = myLife.getNewPerson("Alex");
        System.out.println("создали процесс Человек, теперь можем брать в долг у друг у друга");

        Debt debt = person.getNewDebt();
        System.out.println("создали процесс Долг у конкретного человека.");

        LogBookReader lbr = new LogBookReader();
        lbr.read(person);
        lbr.read(debt);

        System.out.println(" ");
        myLife.doSomething();
        person.doSomething();
        debt.doSomething();

        System.out.println(" ");
        System.out.println(person.getName());
        System.out.println(debt.getBalance());

    }
}
