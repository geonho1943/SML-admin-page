package com.manage.sml.smlAdminPage.entity;

public class DateTimeTemp {
    private String ldt;
    private int count;

    public DateTimeTemp(String ldt, int count) {
        this.ldt = ldt;
        this.count = count;
    }

    public String getLdt() {
        return ldt;
    }

    public void setLdt(String ldt) {
        this.ldt = ldt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
