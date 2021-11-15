package com.example.javierortizfeliz.utils;

import java.io.Serializable;

public class Calculo implements Serializable {

    private int op1,op2,suma,resta,multiplicacion,division,modulo,resultado;

    public Calculo(int op1, int op2, int suma, int resta, int multiplicacion, int division, int modulo, int resultado) {
        this.op1 = op1;
        this.op2 = op2;
        this.suma = suma;
        this.resta = resta;
        this.multiplicacion = multiplicacion;
        this.division = division;
        this.modulo = modulo;
        this.resultado = resultado;
    }

    public Calculo(){

    }



}
