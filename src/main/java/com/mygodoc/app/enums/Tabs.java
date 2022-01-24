package com.mygodoc.app.enums;

public enum Tabs {
    MANAGE_PRACTICES("Manage Practices"),
    USER_LOOKUP("User Lookup"),
    GOCREW_ADMIN("GoCrew Admin"),
    EULA("EULA");

    public String name;
    Tabs(String name){
        this.name=name;
    }

    public String toString(){
        return name;
    }
}
