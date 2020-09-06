package com.erensayar.HrApp.Repo;

import com.erensayar.HrApp.Entitys.HrManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author erensayar
 */
@Repository
public interface HrManagerRepo extends JpaRepository <HrManager,Integer>{
}
