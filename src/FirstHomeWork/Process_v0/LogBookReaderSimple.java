package FirstHomeWork.Process_v0;

public class LogBookReaderSimple {
    public static void read(Process process) {
        for (int i = 0; i < process.logBook.size(); i++) {
            System.out.println(process.logBook.get(i).getDate().withNano(0));
            System.out.println(process.logBook.get(i).getText());
        }
    }
}
