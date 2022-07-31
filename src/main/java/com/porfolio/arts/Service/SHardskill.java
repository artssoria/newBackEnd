/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.arts.Service;

import com.porfolio.arts.Entity.Hardskill;
import com.porfolio.arts.Repository.RHardskill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class SHardskill {
    @Autowired
    RHardskill rHardskill;
    
    public List<Hardskill> list(){
        return rHardskill.findAll();
    }
    
    public Optional<Hardskill> getOne(int id){
        return rHardskill.findById(id);
    }
    
    public Optional<Hardskill> getByNmbreE(String nombreE){
        return rHardskill.findByNombreE(nombreE);
    }
    
    public void save(Hardskill hardskill){
        rHardskill.save(hardskill);
    }
    
    public void delete(int id){
        rHardskill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHardskill.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rHardskill.existsByNombreE(nombreE);
    }
}