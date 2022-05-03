package org.example.java8.domain;

import java.util.Objects;

public class Profile {
    private String name;
    private Long genderId;
    private LegalityStatusType legalityStatusType;

    public Profile() {
    }

    public Profile(String name, Long genderId, LegalityStatusType legalityStatusType) {
        this.name = name;
        this.genderId = genderId;
        this.legalityStatusType = legalityStatusType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public LegalityStatusType getLegalityStatusType() {
        return legalityStatusType;
    }

    public void setLegalityStatusType(LegalityStatusType legalityStatusType) {
        this.legalityStatusType = legalityStatusType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name) && Objects.equals(genderId, profile.genderId) && legalityStatusType == profile.legalityStatusType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genderId, legalityStatusType);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", genderId=" + genderId +
                ", legalityStatusType=" + legalityStatusType +
                '}';
    }
}
