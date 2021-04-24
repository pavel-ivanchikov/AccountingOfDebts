package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.io.*;

/**
 * Это Process, который описывает жизнь ведущего учёт долгов. Он может быть только один.
 */
public class MyLife extends Process {

    private static MyLife instance;

    private MyLife() throws FileNotFoundException {
        super();
    }
    private MyLife(Long id){
        super(id);
    }

    public static MyLife getMyLife() throws FileNotFoundException {
        MyLife localInstance = instance;
        if (localInstance == null) {
            synchronized (MyLife.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MyLife();
                }
            }
        }
        return localInstance;
    }

    public static MyLife getMyLife(Long id){
        MyLife localInstance = instance;
        if (localInstance == null) {
            synchronized (MyLife.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MyLife(id);
                }
            }
        }
        return localInstance;
    }

    /**
     * @return not necessarily new person in my life,
     * that i mention and it becomes separate entity since now
     */
    public Person getNewPerson() throws FileNotFoundException {
        Person person = new Person(this);
        addMessage(ServiceMessages.NPR.toString() + " " + person.id);
        return person;
    }

    @Override
    public String toString() {
        return "MyLife{" +
                "keep records since " + logBook.get(0).getDate().withNano(0) +
                '}';
    }
}
