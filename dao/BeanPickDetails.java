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
public class BeanPickDetails {
    private int pick_id;
    private int g_id;
    private int mem_id;
    private String Term_no;
    private String pick_date;
    private String amount;

    /**
     * @return the pick_id
     */
    public int getPick_id() {
        return pick_id;
    }

    /**
     * @param pick_id the pick_id to set
     */
    public void setPick_id(int pick_id) {
        this.pick_id = pick_id;
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
     * @return the Term_no
     */
    public String getTerm_no() {
        return Term_no;
    }

    /**
     * @param Term_no the Term_no to set
     */
    public void setTerm_no(String Term_no) {
        this.Term_no = Term_no;
    }

    /**
     * @return the pick_date
     */
    public String getPick_date() {
        return pick_date;
    }

    /**
     * @param pick_date the pick_date to set
     */
    public void setPick_date(String pick_date) {
        this.pick_date = pick_date;
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
}
