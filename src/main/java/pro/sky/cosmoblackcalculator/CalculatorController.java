package pro.sky.cosmoblackcalculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<?> handleDivisionByZero(DivisionByZeroException e) {
        return ResponseEntity.badRequest().body("Делить на 0 нельзя!");
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловатть в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer num1,
                       @RequestParam(name = "num2", required = false) Integer num2) {

        if (num1 == null || num2 == null) {
            return "Одно или два из чисел не введено";
        } else {

            Integer result = calculatorService.plus(num1, num2);
            return num1 + " + " + num2 + " = " + result;

        }

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1,
                        @RequestParam(name = "num2", required = false) Integer num2) {

        if (num1 == null || num2 == null) {
            return "Одно или два из чисел не введено";
        } else {

            Integer result = calculatorService.minus(num1, num2);
            return num1 + " - " + num2 + " = " + result;

        }

    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1,
                           @RequestParam(name = "num2", required = false) Integer num2) {

        if (num1 == null || num2 == null) {
            return "Одно или два из чисел не введено";
        } else {

            Integer result = calculatorService.multiply(num1, num2);
            return num1 + " * " + num2 + " = " + result;

        }

    }

    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Double num1,
                         @RequestParam(name = "num2", required = false) Double num2) {

        if (num1 == null || num2 == null) {
            return "Одно или два из чисел не введено";
        } else {

            Double result = calculatorService.divide(num1, num2);
            return num1 + " / " + num2 + " = " + result;
        }

    }

}
