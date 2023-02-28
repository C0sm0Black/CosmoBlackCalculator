package pro.sky.cosmoblackcalculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Integer plus(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public Integer minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public Integer multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public Double divide(Double num1, Double num2) {

        if (num2 == 0) {
            throw new DivisionByZeroException();
        }

        return num1 / num2;
    }

}
