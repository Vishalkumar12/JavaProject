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
public class BeanComtInfo 
{
    private int cid;
    private String commitee_name;
    private String commitee_type;
    private String total_amount;
    private String term_amount;
    private String terms;

   
    /**
     * @return the commitee_name
     */
    public String getCommitee_name() {
        return commitee_name;
    }

    /**
     * @param commitee_name the commitee_name to set
     */
    public void setCommitee_name(String commitee_name) {
        this.commitee_name = commitee_name;
    }

    /**
     * @return the commitee_type
     */
    public String getCommitee_type() {
        return commitee_type;
    }

    /**
     * @param commitee_type the commitee_type to set
     */
    public void setCommitee_type(String commitee_type) {
        this.commitee_type = commitee_type;
    }

    /**
     * @return the total_amount
     */
    public String getTotal_amount() {
        return total_amount;
    }

    /**
     * @param total_amount the total_amount to set
     */
    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * @return the term_amount
     */
    public String getTerm_amount() {
        return term_amount;
    }

    /**
     * @param term_amount the term_amount to set
     */
    public void setTerm_amount(String term_amount) {
        this.term_amount = term_amount;
    }

    /**
     * @return the terms
     */
    public String getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String toString()
    {
        return commitee_name;
    }
}
