package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;
import FirstHomeWork.interfaces.HavingName;

/**
 * Это процесс, содержащий информацию об определенном человеке, и порождающие процессы долгов
 * В этот процесс попадают сообщения касающиеся личности человека берущего или дающего в долг,
 * и которые нельзя записать в один из существующих долгов.
 */
public class Person extends Process implements HavingName {

    String name;

    Person(Process parent) {
        super(parent);
    }

    public void setName(String string) {
        this.name = string;
        addMessageToLogBook(ServiceMessages.SNM.toString() + " " + this.name);
    }

    public Debt getNewDebt() {
        Debt debt = new Debt(this);
        addMessageToLogBook(ServiceMessages.NDB.toString() + " " + debt.start);
        return debt;
    }


    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */

    @Override
    public long getStart() {
        System.out.println(name + " appeared in my system in " + start);
        return this.start;
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
