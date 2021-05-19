package fr.jh.calculator.service;

import fr.jh.calculator.domain.Calculator;
import fr.jh.calculator.domain.model.CalculationModel;
import fr.jh.calculator.domain.model.CalculationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTests {
    @Mock
    Calculator calculator;

    CalculatorService calculatorServiceUnderTest;

    @BeforeEach
    public void init(){
        calculatorServiceUnderTest = new CalculatorServiceImpl(calculator);
    }

    @Test
    public void calculateShouldUseCalculatorForAddition(){
        // GIVEN
        when(calculator.add(2, 3)).thenReturn(5);

        // WHEN
        final int result = calculatorServiceUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION,2,3)).getSolution();

        // THEN
        verify(calculator).add(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void calculateShouldUseCalculatorForSubtraction(){
        // GIVEN
        when(calculator.sub(2, 3)).thenReturn(-1);

        // WHEN
        final int result = calculatorServiceUnderTest.calculate(
                new CalculationModel(CalculationType.SUBTRACTION, 2, 3)).getSolution();

        // THEN
        verify(calculator).sub(2, 3);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void calculateShouldUseCalculatorForMultiplication(){
        // GIVEN
        when(calculator.multiply(2, 3)).thenReturn(6);

        // WHEN
        final int result = calculatorServiceUnderTest.calculate(
                new CalculationModel(CalculationType.MULTIPLICATION, 2, 3)).getSolution();

        // THEN
        verify(calculator).multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calculateShouldUseCalculatorForDivision(){
        // GIVEN
        when(calculator.divide(4, 2)).thenReturn(2);

        // WHEN
        final int result = calculatorServiceUnderTest.calculate(
                new CalculationModel(CalculationType.DIVISION, 4, 2)).getSolution();

        // THEN
        verify(calculator).divide(4,2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void calculateShouldUseCalculatorForDivisionByZero(){
        // GIVEN
        when(calculator.divide(4,0)).thenThrow(new ArithmeticException());

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> calculatorServiceUnderTest.calculate(
                new CalculationModel(CalculationType.DIVISION, 4, 0)));

        // THEN
        verify(calculator, times(1)).divide(4, 0);
    }


}
