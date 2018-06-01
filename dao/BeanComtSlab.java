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
public class BeanComtSlab {
    private int slab_id;
    private int select_commitee;
    private String term_no;
    private String amount_given;

   
    /**
     * @return the select_commitee
     */
    public int getSelect_commitee() {
        return select_commitee;
    }

    /**
     * @param select_commitee the select_commitee to set
     */
    public void setSelect_commitee(int select_commitee) {
        this.select_commitee = select_commitee;
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
     * @return the amount_given
     */
    public String getAmount_given() {
        return amount_given;
    }

    /**
     * @param amount_given the amount_given to set
     */
    public void setAmount_given(String amount_given) {
        this.amount_given = amount_given;
    }

    /**
     * @return the slab_id
     */
    public int getSlab_id() {
        return slab_id;
    }

    /**
     * @param slab_id the slab_id to set
     */
    public void setSlab_id(int slab_id) {
        this.slab_id = slab_id;
    }
  
    
}
