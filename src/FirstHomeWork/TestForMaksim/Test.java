package FirstHomeWork.TestForMaksim;


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

        MyLife pro = new MyLife();
        System.out.println("создали первый и основной процесс, который породит все остальные процессы");

        Person pro1 = pro.getNewPerson("Alex");
        System.out.println("создали процесс Человек, теперь можем брать в долг у друг у друга");

        Debt pro2 = pro1.getNewDebt();
        System.out.println("создали процесс Долг у конкретного человека.");

        System.out.println(" ");
        pro.doSomething();
        pro1.doSomething();
        pro2.doSomething();

        System.out.println(" ");
        System.out.println(pro1.getName());
        System.out.println(pro2.getBalance());

    }
}
