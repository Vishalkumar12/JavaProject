/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author tyagi
 */
public class BeanTransEntry {
    private int e_id;
    private int mem_id;
    private int g_id;
    private String term_no;
    private String amount;
    private String deposit_date;

    /**
     * @return the e_id
     */
    public int getE_id() {
        return e_id;
    }

    /**
     * @param e_id the e_id to set
     */
    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    /**
     * @return the mem_id
     */
    public int getMem_id() {
        return mem_id;
    }

    /**
     * @param mem_id the mem_id to set
     */
    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    /**
     * @return the g_id
     */
    public int getG_id() {
        return g_id;
    }

    /**
     * @param g_id the g_id to set
     */
    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    /**
     * @return the term_no
     */
    public String getTerm_no() {
        return term_no;
    }

    /**
     * @param term_no the term_no to set
     */
    public void setTerm_no(String term_no) {
        this.term_no = term_no;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the deposit_date
     */
    public String getDeposit_date() {
        return deposit_date;
    }

    /**
     * @param deposit_date the deposit_date to set
     */
    public void setDeposit_date(String deposit_date) {
        this.deposit_date = deposit_date;
    }
    
    
}
