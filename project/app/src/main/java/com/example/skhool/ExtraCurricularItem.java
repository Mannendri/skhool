package com.example.skhool;

public class ExtraCurricularItem {
    private String name;
    private String years;

    public ExtraCurricularItem(String name, String years){
        this.name = name;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
