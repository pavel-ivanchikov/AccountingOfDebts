package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.io.*;

/**
 * Это Process, который описывает жизнь ведущего учёт долгов.
 */

public class MyLife extends Process {

    public MyLife() throws FileNotFoundException {super();}

    /**
     * @return not necessarily new person in my life,
     * that i mention and it becomes separate entity since now
     */
    public Person getNewPerson() throws FileNotFoundException {
        Person person = new Person(this);
        addMessage(ServiceMessages.NPR.toString() + " " + person.id);
        return person;
    }
}
