package com.erensayar.HrApp.Service.Implementation;

import com.erensayar.HrApp.Entitys.HrManager;
import com.erensayar.HrApp.Repo.HrManagerRepo;
import com.erensayar.HrApp.Service.IHrManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
@Service
public class HrManagerService implements IHrManagerService {

    //<=====================================================================>
    private final HrManagerRepo hrManagerRepo;

    @Autowired // Constructor Injection
    public HrManagerService(HrManagerRepo hrManagerRepo) {
        this.hrManagerRepo = hrManagerRepo;
    }
    //<=====================================================================>

    @Override
    public List<HrManager> getAll() {
        return hrManagerRepo.findAll();
    }

    @Override
    public Optional<HrManager> getHrManagerById(Integer id) {
        return hrManagerRepo.findById(id);
    }

    @Override
    public void addHrManager(HrManager hrManager) {
        hrManagerRepo.save(hrManager);
    }

    @Override
    public void deleteById(Integer id) {
        hrManagerRepo.deleteById(id);
    }
}
