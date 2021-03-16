package FirstHomeWork.Process_v0;
import FirstHomeWork.Process_v0.ServiceMessages.ProcessServiceMessages;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Процесс - это сущность, порождаемая другим процессом
 * и хранящая журнал комметариев (пометок) о том что проиходит в рамках эго процесса.
 * Пока буду называть эти комментарии(пометки) - сообщениями, служебными или рукописными.
 * Прошлое процесса неизменно, можно добавлять сообщения о прошлом в настоящий момент.
 */

public abstract class Process {
    
    Process parent;
    List<Message<LocalDate, String>> logBook;

    LocalDate startDate;


    {
        startDate = LocalDate.now();
        logBook = new LinkedList<>();
        addMessageToLogBook(ProcessServiceMessages.OPEN.toString());
    }

    public Process(Process parent){
        this.parent = parent;
        addMessageToLogBook("the process has become separate from " + parent);
    }

    public void addMessageToLogBook(String text){
        Message<LocalDate, String> message = new Message<>(LocalDate.now(), text);
        logBook.add(message);
    }


    public abstract void doSomething();

    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */

    public java.time.LocalDate getStartDate() {
        return this.startDate;
    }

    static class Message<LocalDate, String> {
        private LocalDate date;
        private String text;
        public Message(LocalDate date, String text){
            this.date = date;
            this.text = text;
        }
        public LocalDate getDate(){ return date; }
        public String getText(){ return text; }
        public void setDate(LocalDate date){ this.date = date; }
        public void setText(String text){ this.text = text; }
    }


}
