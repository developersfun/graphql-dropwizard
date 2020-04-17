package com.tdf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Config extends Configuration {

    private String person;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }


    @Valid()
    @NotNull()
    @JsonProperty
    private DataSourceFactory database;

    public DataSourceFactory getDatabase() {
        if(database == null){
            database = new DataSourceFactory();
        }
        return database;
    }

    public void setDatabase(final DataSourceFactory database) {
        this.database = database;
    }
}
