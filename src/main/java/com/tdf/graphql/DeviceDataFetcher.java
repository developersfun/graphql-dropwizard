package com.tdf.graphql;

import com.tdf.Config;
import com.tdf.Device;
import com.tdf.DeviceDAO;
import graphql.schema.DataFetcher;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

import javax.inject.Inject;


public class DeviceDataFetcher {

    private DeviceDAO deviceDAO;

    @Inject
    public DeviceDataFetcher(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    public DataFetcher getAllResumeData() {
        return dataFetchingEnvironment -> {
            //String dev = dataFetchingEnvironment.getArgument("device_id");
            return deviceDAO.findAll();
        };
    }
}