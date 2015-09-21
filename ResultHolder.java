/**
 * Created by Alenor on 20.09.2015.
 */
public class ResultHolder {
    private double result;

    public ResultHolder() {
        this.result = 0;
    }

    public double getResult() {
        return this.result;
    }

    public synchronized void increaseResult(double value) {
        result += value;
    }
}
