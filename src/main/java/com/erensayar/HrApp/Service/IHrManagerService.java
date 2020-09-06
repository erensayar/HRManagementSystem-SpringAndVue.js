package com.erensayar.HrApp.Service;

import com.erensayar.HrApp.Entitys.HrManager;

import java.util.List;
import java.util.Optional;

/**
 * @author erensayar
 */
public interface IHrManagerService {

    List<HrManager> getAll();

    Optional<HrManager> getHrManagerById(Integer id);

    void addHrManager(HrManager hrManager);

    void deleteById(Integer id);

}
