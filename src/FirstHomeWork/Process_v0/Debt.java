package FirstHomeWork.Process_v0;

import FirstHomeWork.interfaces.MeasurableInRubles;

import java.time.LocalDate;
import java.util.Date;

/**
 * Class represents debt process from certain person, parent process.
 * В этот процесс попадают сообщения касающиеся конкретного долга.
 */

public class Debt extends Process implements MeasurableInRubles{

    float sum;

    Debt(Person person, float sum) {
        this.parent = person;
        this.sum = sum;
        System.out.println("Debt created");
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

    @Override
    public float getSum() {
        return this.sum;
    }

}
