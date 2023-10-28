package lk.ijse.carRent.service.impl;

import lk.ijse.carRent.dto.IncomeDTO;
import lk.ijse.carRent.repo.IncomeRepo;
import lk.ijse.carRent.service.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepo incomeRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public ArrayList<IncomeDTO> dailyIncome() {
        return new ArrayList<IncomeDTO>(incomeRepo.dailyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> monthlyIncome() {
        return new ArrayList<IncomeDTO>(incomeRepo.MonthlyIncome());
    }

    @Override
    public ArrayList<IncomeDTO> AnnuallyIncome() {
        return new ArrayList<IncomeDTO>(incomeRepo.AnnuallyIncome());
    }
}
