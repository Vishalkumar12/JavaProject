/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tyagi
 */
public class ActionProject {

    /*code for Sign_up.java */
    public boolean Signup(BeanSignup data) {
        boolean ans = false;
        String StrInsert = "insert into Signup(uname,password,email,contact) values(?,?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(StrInsert);
            ps.setString(1, data.getUname());
            ps.setString(2, data.getPassword());
            ps.setString(3, data.getEmail());
            ps.setString(4, data.getContact());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*Code used for Login */
    public boolean getLogin(String uname, String password) {
        boolean ans = false;
        String strSelect = "select * from Signup where uname=? and password=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(strSelect);
            ps.setString(1, uname);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code used for Forgot password*/
    public String getPassword(String uname, String email) {
        String data = null;
        String mysql = "select * from Signup where uname=? and email=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(mysql);
            ps.setString(1, uname);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data = rs.getString(2);

            }
        } catch (Exception ex) {
            // System.out.println(ex);
            return null;
        }
        return data;
    }

    public String getTerm(int mid) {
        String data = null;
        String mysql = "SELECT count(term_no)+1 as term FROM transactionentry where select_member=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(mysql);
            ps.setInt(1, mid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data = rs.getString(1);

            }
        } catch (Exception ex) {
            // System.out.println(ex);
            return null;
        }
        return data;
    }

    public String getTermAmount(int cid, int tno) {
        String data = null;
        String mysql = "SELECT * FROM commiteeslab where select_commitee=? and term_no=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(mysql);
            ps.setInt(1, cid);
            ps.setInt(2, tno);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data = rs.getString(4);

            }
        } catch (Exception ex) {
            // System.out.println(ex);
            return null;
        }
        return data;
    }

    /*code used for changing password in Manage_user.java First Method is  used for checking */
    public boolean checkUser(String uname, String Oldpwd, String Newpwd) {
        boolean ans = false;
        String sql = "select * from Signup where uname=? and password=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, Oldpwd);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (updatePassword(uname, Newpwd)) {
                    ans = true;
                } else {
                    ans = false;
                }
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*Code used for Updating password in Manage_user.java Second method is used for updating password*/
    public boolean updatePassword(String uname, String Newpwd) {
        boolean ans = false;
        String sql = "update Signup set password=? where uname=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setString(1, Newpwd);
            ps.setString(2, uname);

            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code used for storing data or inserting data to the sql server that is used in CommiteeInfo.java with the help of BeanComtInfo.java*/
    public Boolean insertCommiteeInfo(BeanComtInfo data) {
        boolean ans = false;
        String sql = "insert into CommiteeInfo(commitee_name,commitee_type,total_amount,term_amount,terms) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setString(1, data.getCommitee_name());
            ps.setString(2, data.getCommitee_type());
            ps.setString(3, data.getTotal_amount());
            ps.setString(4, data.getTerm_amount());
            ps.setString(5, data.getTerms());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }

        return ans;
    }

    /*code used for inserting data in CommiteeSlab.java using BeanComtSlab.java*/
    public boolean InsertCommiteeSlab(BeanComtSlab data) {
        boolean ans = false;
        String sql = "insert into CommiteeSlab(term_no,amount_given,select_commitee) values(?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setString(1, data.getTerm_no());
            ps.setString(2, data.getAmount_given());
            ps.setInt(3, data.getSelect_commitee());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code for retreiving the data from CommiteeInfo sql server and display it in combobox of 
    CommiteeSlab.java*/
    public ArrayList<BeanComtInfo> getAllRecords() {
        ArrayList<BeanComtInfo> list = null;
        String sql = "select * from commiteeinfo";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtInfo data = null;
                do {
                    data = new BeanComtInfo();
                    data.setCid(rs.getInt(1));
                    data.setCommitee_name(rs.getString(2));
                    data.setCommitee_type(rs.getString(3));
                    data.setTotal_amount(rs.getString(4));
                    data.setTerm_amount(rs.getString(5));
                    data.setTerms(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for inserting data into mysql server using BeanComtGroup.java in CommiteeGroup.java */
    public boolean InsertCommiteeGroup(BeanComtGroup data) {
        boolean ans = false;
        String sql = "insert into Commiteegroup(select_commitee,start_date,end_date,collection_date,total_member) values(?,?,?,?,?) ";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, data.getSelect_commitee());
            ps.setString(2, data.getStart_date());
            ps.setString(3, data.getEnd_date());
            ps.setString(4, data.getCollection_date());
            ps.setString(5, data.getTotal_member());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }

        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code used for retreiving data from commiteeGroup group_id sql_server and displaying it in Select_group in MemberInfo.java */
    public ArrayList<BeanComtGroup> getGroupRecords() {
        ArrayList<BeanComtGroup> list = null;
        String sql = "select * from CommiteeGroup";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtGroup data = null;

                do {
                    data = new BeanComtGroup();
                    data.setGid(rs.getInt(1));
                    data.setSelect_commitee(rs.getInt(2));
                    data.setStart_date(rs.getString(3));
                    data.setEnd_date(rs.getString(4));
                    data.setCollection_date(rs.getString(5));
                    data.setTotal_member(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    public ArrayList<BeanGroupDetail> getGroupDetails() {
        ArrayList<BeanGroupDetail> list = null;
        String sql = "SELECT * FROM commiteegroup c1 join commiteeinfo c2 on c1.select_commitee=c2.commitee_id";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanGroupDetail data = null;

                do {
                    data = new BeanGroupDetail();
                    data.setGroupId(rs.getInt(1));
                    data.setCommiteeName(rs.getString(8));
                    data.setCommiteeId(rs.getInt(7));

                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for inserting data into mysql server using BeanMemInfo.java in MemberInfo.java*/
    public boolean InsertMemberInfo(BeanMemInfo data) {
        boolean ans = false;
        String sql = "insert into MemberInfo(select_group,member_name,contact_no,address) values(?,?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, data.getSel_group());
            ps.setString(2, data.getMem_name());
            ps.setString(3, data.getContact_no());
            ps.setString(4, data.getAddress());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }

        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code used for reteriving data from MemberInfo sql server and displaying it in the jcomboBox */
    public ArrayList<BeanMemInfo> getMemberRecords(int gid) {
        ArrayList<BeanMemInfo> list = null;
        String sql = "select * from memberinfo where select_group=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, gid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanMemInfo data = null;

                do {
                    data = new BeanMemInfo();
                    data.setMid(rs.getInt(1));
                    data.setSel_group(rs.getInt(2));
                    data.setMem_name(rs.getString(3));
                    data.setContact_no(rs.getString(4));
                    data.setAddress(rs.getString(5));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
           //System.out.println(ex);
            return null;
        }
        return list;
    }

    public ArrayList<BeanMemInfo> getMemberRecords() {
        ArrayList<BeanMemInfo> list = null;
        String sql = "select * from memberinfo";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanMemInfo data = null;

                do {
                    data = new BeanMemInfo();
                    data.setMid(rs.getInt(1));
                    data.setSel_group(rs.getInt(2));
                    data.setMem_name(rs.getString(3));
                    data.setContact_no(rs.getString(4));
                    data.setAddress(rs.getString(5));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for inserting data into TransactionEntry sql server using BeanTransEntry.java in TransactionEntry.java*/
    public boolean InsertTransactionEntry(BeanTransEntry data) {
        boolean ans = false;
        String sql = "insert into TransactionEntry(select_member,select_group,term_no,amount,deposit_date) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, data.getMem_id());
            ps.setInt(2, data.getG_id());
            ps.setString(3, data.getTerm_no());
            ps.setString(4, data.getAmount());
            ps.setString(5, data.getDeposit_date());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }

        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

    /*code used for reteriving data from commiteeslab*/
    public ArrayList<BeanComtSlab> getSlabRecords(int cid) {
        ArrayList<BeanComtSlab> list = null;
        String sql = "select * from commiteeslab where select_commitee=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtSlab data = null;

                do {
                    data = new BeanComtSlab();
                    data.setSlab_id(rs.getInt(1));
                    data.setSelect_commitee(rs.getInt(2));
                    data.setTerm_no(rs.getString(3));
                    data.setAmount_given(rs.getString(4));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for reteriving data from transactionentry mysql server*/
    public ArrayList<BeanTransEntry> getTransEntry() {
        ArrayList<BeanTransEntry> list = null;
        String sql = "select * from transactionentry";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanTransEntry data = null;

                do {
                    data = new BeanTransEntry();
                    data.setE_id(rs.getInt(1));
                    data.setMem_id(rs.getInt(2));
                    data.setG_id(rs.getInt(3));
                    data.setTerm_no(rs.getString(4));
                    data.setAmount(rs.getString(5));
                    data.setDeposit_date(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //ystem.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for reteriving data from pickeddetails mysql server*/
    public ArrayList<BeanPickDetails> getPickDetails() {
        ArrayList<BeanPickDetails> list = null;
        String sql = "select * from pickeddetails";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanPickDetails data = null;

                do {
                    data = new BeanPickDetails();
                    data.setPick_id(rs.getInt(1));
                    data.setG_id(rs.getInt(2));
                    data.setMem_id(rs.getInt(3));
                    data.setTerm_no(rs.getString(4));
                    data.setPick_date(rs.getString(5));
                    data.setAmount(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    public boolean InsertPickedDetails(BeanPickDetails data) {
        boolean ans = false;
        String sql = "insert into PickedDetails(select_group,select_member,term_no,picked_date,amount) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, data.getG_id());
            ps.setInt(2, data.getMem_id());
            ps.setString(3, data.getTerm_no());
            ps.setString(4, data.getPick_date());
            ps.setString(5, data.getAmount());

            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;

    }

    /*code used for search in CommiteeInfoTable*/
    public ArrayList<BeanComtInfo> searchinfo(String sql) {
        ArrayList<BeanComtInfo> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtInfo data = null;
                do {
                    data = new BeanComtInfo();
                    data.setCid(rs.getInt(1));
                    data.setCommitee_name(rs.getString(2));
                    data.setCommitee_type(rs.getString(3));
                    data.setTotal_amount(rs.getString(4));
                    data.setTerm_amount(rs.getString(5));
                    data.setTerms(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }
    
    /*code used for search in CommiteeGroupTable*/
    public ArrayList<BeanComtGroup> searchgroup(String sql) {
        ArrayList<BeanComtGroup> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtGroup data = null;
                do {
                    data = new BeanComtGroup();
                    data.setGid(rs.getInt(1));
                    data.setSelect_commitee(rs.getInt(2));
                    data.setStart_date(rs.getString(3));
                    data.setEnd_date(rs.getString(4));
                    data.setCollection_date(rs.getString(5));
                    data.setTotal_member(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }
    
      /*code used for search in CommiteeSlabTable*/
    public ArrayList<BeanComtSlab> searchslab(String sql) {
        ArrayList<BeanComtSlab> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanComtSlab data = null;
                do {
                    data = new BeanComtSlab();
                    data.setSlab_id(rs.getInt(1));
                    data.setSelect_commitee(rs.getInt(2));
                    data.setTerm_no(rs.getString(3));
                    data.setAmount_given(rs.getString(4));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }
    
      /*code used for search in MemeberInfoTable*/
    public ArrayList<BeanMemInfo> searchmem(String sql) {
        ArrayList<BeanMemInfo> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanMemInfo data = null;
                do {
                    data = new BeanMemInfo();
                    data.setMid(rs.getInt(1));
                    data.setSel_group(rs.getInt(2));
                    data.setMem_name(rs.getString(3));
                    data.setContact_no(rs.getString(4));
                    data.setAddress(rs.getString(5));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }
    
      /*code used for search in TransactionEntryTable*/
    public ArrayList<BeanTransEntry> searchtrans(String sql) {
        ArrayList<BeanTransEntry> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanTransEntry data = null;
                do {
                    data = new BeanTransEntry();
                    data.setE_id(rs.getInt(1));
                    data.setMem_id(rs.getInt(2));
                    data.setG_id(rs.getInt(3));
                    data.setTerm_no(rs.getString(4));
                    data.setAmount(rs.getString(5));
                    data.setDeposit_date(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
           // System.out.println(ex);
            return null;
        }
        return list;
    }
    
      /*code used for search in PickedDetailsTableexit*/
    public ArrayList<BeanPickDetails> searchpick(String sql) {
        ArrayList<BeanPickDetails> list = null;
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list = new ArrayList<>();
                BeanPickDetails data = null;
                do {
                    data = new BeanPickDetails();
                    data.setPick_id(rs.getInt(1));
                    data.setG_id(rs.getInt(2));
                    data.setMem_id(rs.getInt(3));
                    data.setTerm_no(rs.getString(4));
                    data.setPick_date(rs.getString(5));
                    data.setAmount(rs.getString(6));
                    list.add(data);
                } while (rs.next());
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return null;
        }
        return list;
    }

    /*code used for updating data in CommiteeInfoUpdate.java*/  
    public Boolean updateCommiteeInfo(BeanComtInfo data) {
        boolean ans = false;
        String sql = "update CommiteeInfo set  commitee_name=?, commitee_type=?,total_amount=?,term_amount=?,terms=? where commitee_id=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setString(1, data.getCommitee_name());
            ps.setString(2, data.getCommitee_type());
            ps.setString(3, data.getTotal_amount());
            ps.setString(4, data.getTerm_amount());
            ps.setString(5, data.getTerms());
            ps.setInt(6, data.getCid());
            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }

        return ans;
    }
   
    
    public Boolean updateMemberInfo(BeanMemInfo data) {
        boolean ans = false;
        String sql = "update MemberInfo set  select_group=?, member_name=?,contact_no=?,address=? where member_id=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(sql);
            ps.setInt(1, data.getSel_group());
            ps.setString(2, data.getMem_name());
            ps.setString(3, data.getContact_no());
            ps.setString(4, data.getAddress());
            ps.setInt(5, data.getMid());
            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }

        return ans;
    }
     
    
    public boolean deleteCommiteeGroup(int gid) 
    {
        boolean ans = false;
        String StrInsert = "delete from  commiteegroup where group_id=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(StrInsert);
            ps.setInt(1, gid);
          
            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

     public boolean deleteTransactionEntry(int eid) 
    {
        boolean ans = false;
        String StrInsert = "delete from TransactionEntry where entry_id=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(StrInsert);
            ps.setInt(1, eid);
          
            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }

      public boolean deletePickedDetails(int pid) 
    {
        boolean ans = false;
        String StrInsert = "delete from pickeddetails where picked_id=?";
        try {
            PreparedStatement ps = DataConnection.createConnection().prepareStatement(StrInsert);
            ps.setInt(1, pid);
          
            if (ps.executeUpdate() > 0) {
                ans = true;
            }
        } catch (Exception ex) {
            //System.out.println(ex);
            return false;
        }
        return ans;
    }
     
   
}
