package FirstHomeWork.Process_v0;

import FirstHomeWork.Process_v0.ServiceMessages.ServiceMessages;

//import java.io.FileNotFoundException;
import java.time.LocalDateTime;
//import java.util.Iterator;
//import java.util.LinkedList;
import java.util.List;

// этот класс должен проходится по журналу и выполнять все служеные сообщения.
public class Initialization {

   public static List<Process> run(List<Process> list, Process process, Long id) {

       // Переписал сообщения из файла в логбук, добавил процесс в список процессов.
       DataBaseReader dataBaseReader = new DataBaseReader();
       dataBaseReader.read(process,id);
       list.add(process);
       Long next_id;

       for (Process.Message<LocalDateTime, String> message : process.logBook) {
           String string = message.getText();
           String[] strings = string.split(" ");

           // Служебное сообщение OPN не обрабатываю, поле причинного процесса заполняю в другом месте.
           if (strings[0].equals(ServiceMessages.NPR.toString())) {
               next_id = Long.parseLong(strings[1]);
               Person person = new Person(next_id);
               person.reason = process;
               list = Initialization.run(list, person, next_id);
           } else if (strings[0].equals(ServiceMessages.NDB.toString())) {
               next_id = Long.parseLong(strings[1]);
               Debt debt = new Debt(next_id);
               debt.reason = process;
               list = Initialization.run(list, debt, next_id);
           } else if (strings[0].equals(ServiceMessages.SNM.toString())) {
               String name = strings[1];
               Person person = (Person) process;
               person.setNameInPast(name);
           } else if (strings[0].equals(ServiceMessages.IGV.toString())) {
               float amount = Float.parseFloat(strings[1]);
               Debt debt = (Debt) process;
               debt.iGiveInPast(amount);
           } else if (strings[0].equals(ServiceMessages.ITK.toString())) {
               float amount = Float.parseFloat(strings[1]);
               Debt debt = (Debt) process;
               debt.iTakeInPast(amount);
           } else if (strings[0].equals(ServiceMessages.SDL.toString())) {
               LocalDateTime deadLine = LocalDateTime.parse(strings[1]);
               Debt debt = (Debt) process;
               debt.setDeadLineInPast(deadLine);
           }
       }
       return list;
   }
}
