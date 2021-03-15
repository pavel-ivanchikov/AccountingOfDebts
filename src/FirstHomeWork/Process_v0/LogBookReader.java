package FirstHomeWork.Process_v0;

public class LogBookReader {

    public LogBookReader(){
    }

    public void read(Process process) {
        String text;
        for (int i = 0; i < process.logBook.size(); i++) {
            System.out.print(process.logBook.get(i).getDate() + " ");
            text = process.logBook.get(i).getText();
//            System.out.println(makeStandardResponse(text, getNameOfClass(process)));
            makeStandardResponse(text, getNameOfClass(process));
        }
    }


    /**
     *
     * метод который будет комментировать стандартные действия из жизни процесса, все ENUMs
     *
     */
    public void makeStandardResponse(String message, String processName) {
        String firstWord = getFirstWordOfText(message);
        if (firstWord.equals("OPEN")){
            System.out.println("new object of " + processName + " class was created");
        }
        else System.out.println(processName + " was closed!");
    }

    /**
     *
     * @param text some text
     * @return first word of text
     */
    public String getFirstWordOfText(String text){
        String[] strings;
        strings = text.split(" ");
        return strings[0];
    }

    public String getNameOfClass(Object obj){
        return obj.getClass().getSimpleName();
    }
}
