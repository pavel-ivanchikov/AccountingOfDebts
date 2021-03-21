package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;
import FirstHomeWork.interfaces.MeasurableInRubles;

import java.time.LocalDateTime;

/**
 * Class represents debt process from certain person, parent process.
 * В этот процесс попадают сообщения касающиеся конкретного долга.
 */

public class Debt extends Process implements MeasurableInRubles{

    float balance;
    LocalDateTime deadline;

    //primary constructor
    Debt(Process parent) {
        super(parent);
    }

    public void setDeadLine(LocalDateTime localDateTime) {
        this.deadline = localDateTime;
        addMessageToLogBook(ServiceMessages.SDL.toString() + " " + this.deadline.withNano(0));
    }
    public void iGive (float amount){
        addMessageToLogBook(ServiceMessages.IGV.toString() + " " + amount);
        balance = balance + amount;
    }

    public void iTake (float amount){
        addMessageToLogBook(ServiceMessages.ITK.toString() + " " + amount);
        balance = balance - amount;
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
    public long getStart() {
        System.out.println("owes me " + balance + " from " + start);
        return this.start;
    }

    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("Method of Debt");
    }

}
