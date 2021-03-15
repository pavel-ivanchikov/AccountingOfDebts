package FirstHomeWork.Process_v0;

/**
 * Это Process, который описывает жизнь ведущего учёт долгов.
 * В этот процесс попадают сообщения касающиеся только личности ведущего учёт долгов.
 */

public class MyLife extends Process {

    public MyLife() {
        parent = null;
        System.out.println("MyLife created");
    }

    /**
     *
     * @param name of person
     * @return not necessarily new person in my life, that i mention and it becomes separate entity since now
     */
    public Person getNewPerson(String name) {
        return new Person(this, name);
    }


    /**
     * method for "Создать иерархию классов с абстрактным классом на вершине."
     */
    public void doSomething() {
        System.out.println("do something");
    }

}
