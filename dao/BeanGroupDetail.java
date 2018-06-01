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
public class BeanGroupDetail 
{
    private int groupId;
    private String commiteeName;
    private int commiteeId;

    /**
     * @return the groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the commiteeName
     */
    public String getCommiteeName() {
        return commiteeName;
    }

    /**
     * @param commiteeName the commiteeName to set
     */
    public void setCommiteeName(String commiteeName) {
        this.commiteeName = commiteeName;
    }

    /**
     * @return the commiteeId
     */
    public int getCommiteeId() {
        return commiteeId;
    }

    /**
     * @param commiteeId the commiteeId to set
     */
    public void setCommiteeId(int commiteeId) {
        this.commiteeId = commiteeId;
    }
    
    
}
