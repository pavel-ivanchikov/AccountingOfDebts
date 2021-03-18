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

        System.out.println(" ");

        MyLife myLife = new MyLife();
        System.out.println("создали первый и основной процесс, который породит все остальные процессы");

        System.out.println(" ");

        Person person = myLife.getNewPerson("Alex");
        Debt debt = person.getNewDebt();

        myLife.addMessageToLogBook("Жизнь продолжается");
        person.addMessageToLogBook("Жизнь человека то же продолжается");
        debt.addMessageToLogBook("Жизнь долга тяжела и неказиста.");


        LogBookReader lbr = new LogBookReader();
        lbr.read(myLife);
        System.out.println(" ");
        lbr.read(person);
        System.out.println(" ");
        lbr.read(debt);

/*        System.out.println(" ");
        myLife.doSomething();
        person.doSomething();
        debt.doSomething();

        System.out.println(" ");
        System.out.println(person.getName());
        System.out.println(debt.getBalance());*/

    }
}
