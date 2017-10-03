package com.company.organization;

public enum Organizations {
    EPAM(10, "Effective Programming After Midnight"),
    ITECHART(12, "ITechArt"),
    ITRANSITION(14, "Itransition"),
    WARGAMING(10, "Wargaming"),
    BELHARD(11, "Belhard");

    private int price;
    private String company_name;

    Organizations(int price, String company_name) {
        this.price = price;
        this.company_name = company_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}