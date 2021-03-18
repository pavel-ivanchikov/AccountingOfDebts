package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.MyLifeServiceMessages;
import FirstHomeWork.Process_v0.ServiceMessages.PersonServiceMessages;
import FirstHomeWork.Process_v0.ServiceMessages.ProcessServiceMessages;

/**
 * Это Process, который описывает жизнь ведущего учёт долгов.
 * В этот процесс попадают сообщения касающиеся личности ведущего учёт долгов
 * и которые нельзя записать в оидн из уже существующих процессов Person.
 */

public class MyLife extends Process {

    public MyLife() {
        super(null);
    }

    /**
     * @param name of person
     * @return not necessarily new person in my life,
     * that i mention and it becomes separate entity since now
     */
    public Person getNewPerson(String name) {
        addMessageToLogBook(MyLifeServiceMessages.NEW_PERSON.toString() + "_" + name + " . появился в моей системе новый человек");
        return new Person(this, name);
    }

    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("do something");
    }

}
