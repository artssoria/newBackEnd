
package com.porfolio.arts.Dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import javax.validation.constraints.NotBlank;

public class dtoProyecto{
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    //Constructores

    public dtoProyecto(){
    }

    public dtoProyecto(String nombreE, String descripcionE){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}