package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.io.*;

/**
 * Это Process, который описывает жизнь ведущего учёт долгов.
 * В этот процесс попадают сообщения касающиеся личности ведущего учёт долгов
 * и которые нельзя записать в оидн из уже существующих процессов Person.
 */

public class MyLife extends Process {

    public MyLife() throws FileNotFoundException {super();}
    /**
     * @return not necessarily new person in my life,
     * that i mention and it becomes separate entity since now
     */
    public Person getNewPerson() throws FileNotFoundException {
        Person person = new Person(this);
        add(ServiceMessages.NPR.toString() + " " + person.id);
        return person;
    }
//====================================================================================
    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("do something");
    }
//====================================================================================
}
