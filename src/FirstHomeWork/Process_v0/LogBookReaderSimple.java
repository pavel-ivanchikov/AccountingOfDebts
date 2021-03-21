package FirstHomeWork.Process_v0;

public class LogBookReaderSimple {
    public LogBookReaderSimple() {}

    public void read(Process process) {
        String text;
        for (int i = 0; i < process.logBook.size(); i++) {
            System.out.println(process.logBook.get(i).getDate().withNano(0));
            System.out.println(process.logBook.get(i).getText());
        }
    }
}
