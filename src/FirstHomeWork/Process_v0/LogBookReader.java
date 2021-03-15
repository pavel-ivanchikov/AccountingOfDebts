package FirstHomeWork.Process_v0;

public class LogBookReader {

    public LogBookReader(){
    }

    public void read(Process process) {
        for (int i = 0; i < process.logBook.size(); i++) {
            System.out.print(process.logBook.get(i).getDate() + " ");
            System.out.println(process.logBook.get(i).getText());
        }
    }
}
