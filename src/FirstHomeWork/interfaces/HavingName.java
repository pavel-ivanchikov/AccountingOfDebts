package FirstHomeWork.interfaces;

public interface HavingName {

    String getName();

    default long getAnswer() {
        return 42;
    }
}

