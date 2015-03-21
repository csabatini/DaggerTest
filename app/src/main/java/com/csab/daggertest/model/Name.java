package com.csab.daggertest.model;

import com.google.gson.annotations.Expose;

public class Name {

    @Expose
    private String gender;
    @Expose
    private Integer id;
    @Expose
    private String name;

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Name)) return false;
        if (!this.id.equals(((Name) object).getId())) return false;
        if (!this.name.equals(((Name) object).getName())) return false;
        if (!this.gender.equals(((Name) object).getGender())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);

        return result;
    }
}

