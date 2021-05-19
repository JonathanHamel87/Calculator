package fr.jh.calculator.domain.model;

public enum CalculationType {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static CalculationType fromSymbol(String operation) {
        switch (operation) {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "/":
                return DIVISION;
            case "*":
                return MULTIPLICATION;
            case "x":
                return MULTIPLICATION;
            default:
                throw new UnsupportedOperationException("Not implemented yet");
        }
    }
}
