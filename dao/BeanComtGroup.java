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
public class BeanComtGroup {
    private int gid;
    private int select_commitee;
    private String Start_date;
    private String End_date;
    private String Collection_date;
    private String Total_member;

    /**
     * @return the gid
     */
    public int getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(int gid) {
        this.gid = gid;
    }

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
     * @return the Total_member
     */
    public String getTotal_member() {
        return Total_member;
    }

    /**
     * @param Total_member the Total_member to set
     */
    public void setTotal_member(String Total_member) {
        this.Total_member = Total_member;
    }

    /**
     * @return the Start_date
     */
    public String getStart_date() {
        return Start_date;
    }

    /**
     * @param Start_date the Start_date to set
     */
    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }

    /**
     * @return the End_date
     */
    public String getEnd_date() {
        return End_date;
    }

    /**
     * @param End_date the End_date to set
     */
    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }

    /**
     * @return the Collection_date
     */
    public String getCollection_date() {
        return Collection_date;
    }

    /**
     * @param Collection_date the Collection_date to set
     */
    public void setCollection_date(String Collection_date) {
        this.Collection_date = Collection_date;
    }

  
       
}
