package fr.jh.calculator.controller;

import fr.jh.calculator.domain.model.Calculation;
import fr.jh.calculator.domain.model.CalculationType;
import fr.jh.calculator.domain.model.CalculationModel;
import fr.jh.calculator.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class CalculatorController {
    public static final String CALCULATOR_TEMPLATE = "calculator";

    @Inject
    CalculatorService calculatorService;

    @GetMapping("/")
    public String index(Calculation calculation){
        return "redirect:calculator";
    }

    @GetMapping("/calculator")
    public String root(Calculation calculation){
        return CALCULATOR_TEMPLATE;
    }

    @PostMapping("/calculator")
    public String calculate(@Valid Calculation calculation, BindingResult bindingResult, Model model){
        final CalculationType type = CalculationType.valueOf(calculation.getCalculationType());
        final CalculationModel calculationModel = new CalculationModel(
                type,
                calculation.getFirstNumber(),
                calculation.getSecondNumber());

        final CalculationModel response = calculatorService.calculate(calculationModel);

        model.addAttribute("response", response);
        return CALCULATOR_TEMPLATE;
    }
}
