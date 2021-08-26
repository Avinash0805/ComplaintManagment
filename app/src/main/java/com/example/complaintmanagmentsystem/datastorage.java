package com.example.complaintmanagmentsystem;

public class datastorage {
    String name,branch,complaint;
    public datastorage(String name,String branch,String complaint){
            this.name=name;
            this.branch=branch;
            this.complaint=complaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
