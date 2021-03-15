package FirstHomeWork.Process_v0;

import FirstHomeWork.interfaces.MeasurableInRubles;

import java.time.LocalDate;

/**
 * Class represents debt process from certain person, parent process.
 * В этот процесс попадают сообщения касающиеся конкретного долга.
 */

public class Debt extends Process implements MeasurableInRubles{

    float sum;
    LocalDate deadline;



    //primary constructor
    Debt(Person person) {
        this.parent = person;
        System.out.println("Debt created");
    }

    @Override
    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */
    @Override
    public LocalDate getStartDate() {
        System.out.println("owes me " + sum + " from " + startDate);
        return this.startDate;
    }

    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("Method of Debt");
    }

}
