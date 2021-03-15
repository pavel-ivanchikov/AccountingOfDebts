package FirstHomeWork.interfaces;

public interface MeasurableInRubles {

    float getBalance();

    default long getAnswer() {
        return 42;
    }
}