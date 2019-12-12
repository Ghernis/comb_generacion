/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruct;

import java.util.Date;



/**
 *
 * @author hgomez
 */
public class energia {
    
    double t,en,eb;
    public energia(double t,double en, double eb){
        this.t=t;
        this.en=en;
        this.eb=eb;
    }

    public double getT() {
        return t;
    }

    public double getEn() {
        return en;
    }

    public double getEb() {
        return eb;
    }
    
}
