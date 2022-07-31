/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.arts.Controller;

import com.porfolio.arts.Dto.dtoHardskill;
import com.porfolio.arts.Entity.Hardskill;
import com.porfolio.arts.Security.Controller.Mensaje;
import com.porfolio.arts.Service.SHardskill;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hardskill")
@CrossOrigin(origins = "http://localhost:4200")
public class CHardskill {
    @Autowired
    SHardskill sHardskill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Hardskill>> list(){
        List<Hardskill> list = sHardskill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hardskill> getById(@PathVariable("id")int id){
        if(!sHardskill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Hardskill hardskill = sHardskill.getOne(id).get();
        return new ResponseEntity(hardskill, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHardskill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHardskill.delete(id);
        return new ResponseEntity(new Mensaje("Hardskill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardskill dtohardskill){
        if(StringUtils.isBlank(dtohardskill.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHardskill.existsByNombreE(dtohardskill.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Hardskill hardskill = new Hardskill(
                dtohardskill.getNombreE(), dtohardskill.getDescripcionE()
            );
        sHardskill.save(hardskill);
        return new ResponseEntity(new Mensaje("Hardskill creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardskill dtohardskill){
        if(!sHardskill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sHardskill.existsByNombreE(dtohardskill.getNombreE()) && sHardskill.getByNmbreE(dtohardskill.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohardskill.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Hardskill hardskill = sHardskill.getOne(id).get();
        
        hardskill.setNombreE(dtohardskill.getNombreE());
        hardskill.setDescripcionE(dtohardskill.getDescripcionE());
        
        sHardskill.save(hardskill);
        
        return new ResponseEntity(new Mensaje("Hardskill actualizada"), HttpStatus.OK);
    }
}