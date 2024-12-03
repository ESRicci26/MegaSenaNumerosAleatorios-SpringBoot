package com.javaricci.MegaSena.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MegaSenaController {

    @GetMapping("/")
    public String showHomePage(Model model) {
        // Adiciona as opções do combobox
        model.addAttribute("options", Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        model.addAttribute("randomNumbers", "");
        return "index";
    }

    /*
    @PostMapping("/generate")
    public String generateNumbers(int numberOfDigits, Model model) {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            availableNumbers.add(i);
        }
        Collections.shuffle(availableNumbers);
        List<Integer> randomNumbers = availableNumbers.stream().limit(numberOfDigits).sorted().collect(Collectors.toList());

        model.addAttribute("options", Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        model.addAttribute("randomNumbers", randomNumbers);
        return "index";
    }
    */
    @PostMapping("/generate")
    public String generateNumbers(int numberOfDigits, Model model) {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
            availableNumbers.add(i);
        }
        Collections.shuffle(availableNumbers);
        List<Integer> randomNumbers = availableNumbers.stream().limit(numberOfDigits).sorted().collect(Collectors.toList());

        // Converte a lista em uma string formatada sem colchetes
        String formattedNumbers = randomNumbers.stream()
                                               .map(String::valueOf)
                                               .collect(Collectors.joining(", "));

        model.addAttribute("options", Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
        model.addAttribute("randomNumbers", formattedNumbers);
        return "index";
    }

    
}
