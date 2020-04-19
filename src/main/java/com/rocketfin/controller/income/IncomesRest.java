package com.rocketfin.controller.income;

import com.rocketfin.controller.income.converter.IncomeDTOtoIncomeConverter;
import com.rocketfin.controller.income.dto.IncomeDTO;
import com.rocketfin.business.income.IncomesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "incomes")
public class IncomesRest {

    private final IncomesService incomesService;
    private final IncomeDTOtoIncomeConverter incomeConverter;

    public IncomesRest(IncomesService incomesService, IncomeDTOtoIncomeConverter incomeConverter) {
        this.incomesService = incomesService;
        this.incomeConverter = incomeConverter;
    }

    @PostMapping
    public ResponseEntity<?> saveIncome(@RequestBody IncomeDTO dto) {
        return new ResponseEntity<>(incomesService.saveIncome(incomeConverter.convert(dto)), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateIncome(@RequestBody IncomeDTO dto) {
        return new ResponseEntity<>(incomesService.updateIncome(incomeConverter.convert(dto)), HttpStatus.CREATED);
    }

    @GetMapping("/findAllById/{id}")
    public ResponseEntity<?> listIncomes(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(incomesService.findAllIncomes(userId), HttpStatus.FOUND);
    }

    @GetMapping("/findIncomeById/{id}")
    public ResponseEntity<?> findIncome(@PathVariable("id") Long id) {
        return new ResponseEntity<>(incomesService.findById(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
