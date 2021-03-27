package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;
import FirstHomeWork.interfaces.MeasurableInRubles;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

/**
 * Class represents debt process from certain person, reason process.
 * В этот процесс попадают сообщения касающиеся конкретного долга.
 */

public class Debt extends Process implements MeasurableInRubles{

    float balance;
    LocalDateTime deadline;

    //primary constructor
    Debt(Process parent) throws FileNotFoundException {
        super(parent);
    }

    public void setDeadLine(LocalDateTime localDateTime) throws FileNotFoundException {
        this.deadline = localDateTime;
        addMessage(ServiceMessages.SDL.toString() + " " + this.deadline.withNano(0));
    }
    public void iGive (float amount) throws FileNotFoundException {
        balance = balance + amount;
        addMessage(ServiceMessages.IGV.toString() + " " + amount);
    }

    public void iTake (float amount) throws FileNotFoundException {
        balance = balance - amount;
        addMessage(ServiceMessages.ITK.toString() + " " + amount);
    }

    @Override
    public float getBalance() {
        return balance;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     * @return дату старта в миллисекундах
     */
    @Override
    public Long getMainInfo() {
        Person person = (Person) this.reason;
        System.out.println("id: " + id + " " + person.name +
                " owes me " + balance + " to " + deadline.withNano(0));
        return this.id;
    }

    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("Method of Debt");
    }

}
