package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

import java.io.*;
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
 * Следующий шаг: сделать загрузку по уже существующей базе текстовых сообщений.
 *
 * Мысли по поводу следующего шага:
 * - Сначала добавить возможность процессам пересекаться, например для перезачитывания.
 * - Добавить возможность процессам сливаться, чтобы перестать их воспринимать отдельно.
 * - Когда инициализация дойдёт до момента пересечения или слияния процессов надо подождать
 * пока второй процесс тоже дойдёт до этого места а уже потом продолжать инициализацию.
 *
 *  Только что пришла мысль! Может производить загрузку, так сказать, в одном потоке,
 *  хронологически, по дате сообщений, по одному сообщению добавлять и видя список
 *  состоящий из следующих сообщений в каждом процессе добавлять самое старое из них.
 *  Поэтому можно пока не торопиться с добавлением функций пересечения и слияния,
 *  вроде как той проблемы, где инициализация происходит по нескольким потокам и это как-то
 *  мешает инициализации, не возникает, проблемы не возникает.
 */

public abstract class Process {

    /** у каждого процесса есть причина, породивший его процесс */
    Process reason;

    /** Это дата первого сообщения в журнале процесса */
    Long id;

    /** Это главное свойство объекта процесс */
    List<Message<LocalDateTime, String>> logBook;

    public Process() throws FileNotFoundException {
        this.reason = null;
        logBook = new LinkedList<>();
        Message<LocalDateTime, String> message = new Message<>(LocalDateTime.now(), ServiceMessages.OPN.toString() + " " + 0);
        logBook.add(message);
        LocalDateTime localDateTime = logBook.get(0).getDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        id = zonedDateTime.toInstant().toEpochMilli();
        addMessageToDataBase(message);
    }

    public Process(Process process) throws FileNotFoundException {
        reason = process;
        logBook = new LinkedList<>();
        Message<LocalDateTime, String> message = new Message<>(LocalDateTime.now(), ServiceMessages.OPN.toString() + " " + process.id);
        logBook.add(message);
        LocalDateTime localDateTime = logBook.get(0).getDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        id = zonedDateTime.toInstant().toEpochMilli();
        addMessageToDataBase(message);
    }

    /**
     * Продвигает процесс на шаг, добавляя сообщение в журнал, служеное или обычное.
     * @param string любое текстовое сообщение
     */

    public void add(String string) throws FileNotFoundException {
        Message<LocalDateTime, String> message = new Message<>(LocalDateTime.now(), string);
        logBook.add(message);
        addMessageToDataBase(message);
    }

    /**
     * Медод добавляет сообщение в журнал, служеное или обычное.
     * @param message любое текстовое сообщение
     */

//============9 марта, 11 урок, 34:00 на записи
    private void addMessageToDataBase(Message message) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:/" +
                "DataBaseAccountingOfDebts/" + id.toString()+".txt",true);
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fileOutputStream)));
        printWriter.write(message.getDate().toString() + " ");
        printWriter.write(message.getText().toString() + "\n");
        printWriter.flush();
        printWriter.close();
    }

//======================================================
    /**
     * method for "Дефолтное поведение (заданное в абстрактном классе)
     * переопределить в наследниках (один наследник останется с дефолтным поведением)..."
     */
    public Long getMainInfo() {
        return this.id;
    }

    /**
     * method for "для чего-то из первой домашней работы"
     */
    public abstract void doSomething();

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
