package com.mygodoc.app.enums;

public enum Setting {
    BUSINESS_INFORMATION("Business information"),
    BRAND_SETTINGS("Brand settings"),
    LOCATIONS("Locations"),
    PRACTICE_TEAM("Practice team"),
    CONTENT_LIBRARY("Content library"),
    ANALYTICS("Analytics"),
    ACCOUNT_BILLING("Account billing");

    public String name;
    Setting(String setting) {
        name=setting;
    }
}
