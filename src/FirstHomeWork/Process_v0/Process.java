package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Процесс - это сущность, порождаемая другим процессом
 * и хранящая журнал комметариев (пометок) о том что проиходит в рамках эго процесса.
 * Пока буду называть эти комментарии(пометки) - сообщениями, служебными или рукописными.
 * Прошлое процесса неизменно, можно добавлять сообщения о прошлом только в настоящем.
 *
 * Следующий шаг: сделать id процесса, а именно дату его первого сообщения буду считать id процесса.
 * Для каждого процесса надо завести текстовый документ который будет называться датой первого сообщения.
 */

public abstract class Process {

    Process parent;

    /**
     * Это главное свойство объекта процесс
     */

    List<Message<LocalDate, String>> logBook;

    /**
     * наверно временные поля
     */

    LocalDate startDate;

    /**
     * Этот конструктор сделал чтобы сформировать второе сообщение в журнале
     * не в каждом наследнике, а сделать это в одном месте в родительском классе.
     */

    public Process(Process parent){
        startDate = LocalDate.now();
        logBook = new LinkedList<>();
        this.parent = parent;
        addMessageToLogBook(ServiceMessages.OPN.toString() + " " + parent);
    }

    /**
     *
     * Медод добавляет сообщение в журнал, служеное или обычное.
     * @param text любое текстовое сообщение
     */
    public void addMessageToLogBook(String text){
        Message<LocalDate, String> message = new Message<>(LocalDate.now(), text);
        logBook.add(message);
    }

    /**
     * method for "для чего-то из первой домашней работы"
     */

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
