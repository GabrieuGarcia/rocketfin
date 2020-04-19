package com.rocketfin.business.income;

import com.rocketfin.entity.Income;
import com.rocketfin.exception.BusinessException;
import com.rocketfin.exception.ResourceNotFoundException;
import com.rocketfin.respository.IncomesRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomesService {

    private final IncomesRespository incomesRespository;

    public IncomesService(IncomesRespository incomesRespository) {
        this.incomesRespository = incomesRespository;
    }

    public Income saveIncome(Income income) {
        try {
            return incomesRespository.save(income);
        } catch (Exception e) {
            throw new BusinessException("Não foi possível salvar a receita!");
        }
    }

    public List<Income> findAllIncomes(Long userId) {

        try {
            return incomesRespository.findAllById(userId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Não foi possível encontrar as receitas!");
        }
    }

    public Income updateIncome(Income income) {
        try {
            return incomesRespository.save(income);
        } catch (Exception e){
            throw new BusinessException("Não foi possível salvar a receita!");
        }
    }

    public Income findById(Long id) {
        try {
            return incomesRespository.findById(id).get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Não foi possível encontrar esta receita!");
        }
    }

    public void deleteIncome(Long id) {
        try {
            incomesRespository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException("Não foi possível encontrar esta receita!");
        }
    }
}
