package fr.jh.calculator.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    public void initCalculator(){
        calculator = new Calculator();
    }

    @AfterEach
    public void undefCalculator() {
        calculator = null;
    }

    @Nested
    @DisplayName("Addition")
    class Addition{
        @Test
        public void addTwoPositiveNumbers() {
            // GIVEN
            final int a = 4;
            final int b = 2;

            // WHEN
            final int sum = calculator.add(a, b);

            // THEN
            assertThat(sum).isEqualTo(6);
        }

        @Test
        public void addTwoNegativeNumbers() {
            // GIVEN
            final int a = -4;
            final int b = -2;

            // WHEN
            final int sum = calculator.add(a, b);

            // THEN
            assertThat(sum).isEqualTo(-6);
        }

        @Test
        public void addOnePositiveNumberAndOneNegativeNumber() {
            // GIVEN
            final int a = 4;
            final int b = -2;

            // WHEN
            final int sum = calculator.add(a, b);

            // THEN
            assertThat(sum).isEqualTo(2);
        }

    }

    @Nested
    @DisplayName("Subtraction")
    class Subtraction{
        @Test
        public void subTwoPositiveNumbers(){
            // GIVEN
            final int a = 3;
            final int b = 4;

            // WHEN
            final int sub = calculator.sub(a, b);

            // THEN
            assertThat(sub).isEqualTo(-1);
        }

        @Test
        public void subTwoNegativeNumbers(){
            // GIVEN
            final int a = -3;
            final int b = -4;

            // WHEN
            final int sub = calculator.sub(a, b);

            // THEN
            assertThat(sub).isEqualTo(1);
        }

        @Test
        public void subOnePositiveNumberAndOneNegativeNumber(){
            // GIVEN
            final int a = 3;
            final int b = -4;

            // WHEN
            final int sub = calculator.sub(a, b);

            // THEN
            assertThat(sub).isEqualTo(7);
        }
    }

    @Nested
    @DisplayName("Multiplication")
    class Multiplication{
        @Test
        public void multiplyTwoPositiveNumbers(){
            // GIVEN
            final int a = 2;
            final int b = 4;

            // WHEN
            final int multiply = calculator.multiply(a, b);

            // THEN
            assertThat(multiply).isEqualTo(8);
        }

        @Test
        public void multiplyTwoNegativeNumbers(){
            // GIVEN
            final int a = -2;
            final int b = -4;

            // WHEN
            final int multiply = calculator.multiply(a, b);

            // THEN
            assertThat(multiply).isEqualTo(8);
        }

        @Test
        public void multiplyOnePositiveNumberAndOneNEgativeNumber(){
            // GIVEN
            final int a = 2;
            final int b = -4;

            // WHEN
            final int multiply = calculator.multiply(a, b);

            // THEN
            assertThat(multiply).isEqualTo(-8);
        }

        @Test
        public void multiplyOnePositiveNumberAndZero(){
            // GIVEN
            final int a = 2;
            final int b = 0;

            // WHEN
            final int multiply = calculator.multiply(a, b);

            // THEN
            assertThat(multiply).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("Division")
    class Division{
        @Test
        public void divideTwoPositiveNumbers(){
            // GIVEN
            final int a = 4;
            final int b = 2;

            // WHEN
            final int divide = calculator.divide(a, b);

            // THEN
            assertThat(divide).isEqualTo(2);
        }

        @Test
        public void divideTwoNegativeNumbers(){
            // GIVEN
            final int a = -4;
            final int b = -2;

            // WHEN
            final int divide = calculator.divide(a, b);

            // THEN
            assertThat(divide).isEqualTo(2);
        }

        @Test
        public void divideOnePositiveNumberAndOneNegativeNumber(){
            // GIVEN
            final int a = 4;
            final int b = -2;

            // WHEN
            final int divide = calculator.divide(a, b);

            // THEN
            assertThat(divide).isEqualTo(-2);
        }

        @Test
        public void divideOnePositiveNumberAndZero(){
            // GIVEN
            final int a = 4;
            final int b = 0;

            // WHEN

            // THEN
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        }
    }
}
