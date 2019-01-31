/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

/**
 *
 * @author Mishil
 */
public class SelectedProduct {
    int pid,qty;

    public SelectedProduct(int pid, int qty) {
        this.pid = pid;
        this.qty = qty;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
}
