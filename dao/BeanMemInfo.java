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
public class BeanMemInfo {
    private int mid;
    private int sel_group;
    private String mem_name;
    private String contact_no;
    private String Address;

    /**
     * @return the mid
     */
    public int getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(int mid) {
        this.mid = mid;
    }

    /**
     * @return the sel_group
     */
    public int getSel_group() {
        return sel_group;
    }

    /**
     * @param sel_group the sel_group to set
     */
    public void setSel_group(int sel_group) {
        this.sel_group = sel_group;
    }

    /**
     * @return the mem_name
     */
    public String getMem_name() {
        return mem_name;
    }

    /**
     * @param mem_name the mem_name to set
     */
    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    /**
     * @return the contact_no
     */
    public String getContact_no() {
        return contact_no;
    }

    /**
     * @param contact_no the contact_no to set
     */
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
