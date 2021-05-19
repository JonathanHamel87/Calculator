package fr.jh.calculator.service;

import fr.jh.calculator.domain.Calculator;
import fr.jh.calculator.domain.model.CalculationModel;
import fr.jh.calculator.domain.model.CalculationType;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }


    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = null;

        switch (type){
            case ADDITION:
                response = calculator.add(calculationModel.getFirstNumber(), calculationModel.getSecondNumber());
                break;
            case SUBTRACTION:
                response = calculator.sub(calculationModel.getFirstNumber(), calculationModel.getSecondNumber());
                break;
            case MULTIPLICATION:
                response = calculator.multiply(calculationModel.getFirstNumber(), calculationModel.getSecondNumber());
                break;
            case DIVISION:
                try{
                    response = calculator.divide(calculationModel.getFirstNumber(), calculationModel.getSecondNumber());
                }catch (final ArithmeticException e){
                    throw new IllegalArgumentException();
                }
                break;
            default:
                throw new UnsupportedOperationException("Unsupported calculations");
        }
        calculationModel.setSolution(response);

        return calculationModel;
    }
}
