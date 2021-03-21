package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Процесс - это сущность, порождаемая другим процессом
 * и хранящая журнал комметариев (пометок), о том что проиходит в рамках этого процесса.
 * Пока буду называть эти комментарии(пометки) - сообщениями, служебными или рукописными.
 * Прошлое процесса неизменно, можно добавлять сообщения о прошлом только в настоящем.
 *
 * Следующий шаг: сделать id процесса, а именно дату его первого сообщения буду считать id процесса.
 * Для каждого процесса надо завести текстовый документ который будет называться датой первого сообщения.
 */

public abstract class Process {

    Process parent;
    long start;

    /** Это главное свойство объекта процесс */
    List<Message<LocalDateTime, String>> logBook;

    public Process(){
        this.parent = null;
        logBook = new LinkedList<>();
        addMessageToLogBook(ServiceMessages.OPN.toString() + " " + 0);
        LocalDateTime localDateTime = logBook.get(0).getDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        start = zonedDateTime.toInstant().toEpochMilli();
    }

    public Process(Process parent){
        this.parent = parent;
        logBook = new LinkedList<>();
        addMessageToLogBook(ServiceMessages.OPN.toString() + " " + parent.start);
        LocalDateTime localDateTime = logBook.get(0).getDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        start = zonedDateTime.toInstant().toEpochMilli();
    }

    /**
     * Медод добавляет сообщение в журнал, служеное или обычное.
     * @param text любое текстовое сообщение
     */
    public void addMessageToLogBook(String text){
        Message<LocalDateTime, String> message = new Message<>(LocalDateTime.now(), text);
        logBook.add(message);
    }

//======================================================
    /**
     * method for "для чего-то из первой домашней работы"
     */
    public abstract void doSomething();
    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */
    public long getStart() {
        return this.start;
    }
//======================================================

    /**
     * класс сообщение, чтобы наполнять журнал.
     */
    static class Message<LocalDateTime, String> {
        private final LocalDateTime date;
        private final String text;
        public Message(LocalDateTime date, String text){
            this.date = date;
            this.text = text;
        }
        public LocalDateTime getDate(){ return date; }
        public String getText(){ return text; }
    }
}
