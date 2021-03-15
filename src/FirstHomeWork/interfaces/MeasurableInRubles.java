package FirstHomeWork.interfaces;

public interface MeasurableInRubles {

    float getSum();

    default long getAnswer() {
        return 42;
    }
}