package FirstHomeWork.Process_v0;

import FirstHomeWork.interfaces.HavingName;

import java.time.LocalDate;

/**
 * Это процесс, содержащий информацию об определенном человеке, и порождающие процессы долгов
 * В этот процесс попадают сообщения касающиеся личности человека берущего или дающего в долг.
 */
public class Person extends Process implements HavingName {

    String name;

    Person(Process parent, String name) {
        this.parent = parent;
        System.out.println("The new Person is in the my system");
        this.name = name;
    }


    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */

    @Override
    public LocalDate getStartDate() {
        System.out.println(name + " appeared in my system in " + startDate);
        return this.startDate;
    }

    public Debt getNewDebt() {
        return new Debt(this);
    }

    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("Method of Person");
    }

    public String getName() {
        return this.name;
    }

}
