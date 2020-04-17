package com.tdf;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.hibernate.sql.Select;

import javax.persistence.criteria.*;
import java.util.List;

import static java.lang.System.*;

public class DeviceDAO extends AbstractDAO<Device> {
    public DeviceDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Device> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Device> cq = builder.createQuery(Device.class);
        //cq.getOrderList();
        Root<Device> dev = cq.from(Device.class);
        cq.select(dev);
        out.println("Results : "  + list(cq).size());
        return  list(cq);
                //list(cq);
    }

    public List<Device> findAllDeviceBrands() {
        Criteria cr = currentSession().createCriteria(Device.class);
        return list(cr);
    }

    public List<Device> findAllAppleDevices() {
        Criteria cr = currentSession().createCriteria(Device.class);
        cr.add(Restrictions.eq("device_brand", "Apple"));
        return list(cr);
    }

    public List<Device> findAllSamsungDevices() {
        Criteria cr = currentSession().createCriteria(Device.class);
        cr.add(Restrictions.eq("device_brand", "Samsung"));
        return list(cr);
    }

    public String create(Device device) {
        return persist(device).getDevice_name();
    }

    public String edit(Device device) {
        return persist(device).getDevice_name();
    }

    public Device findDeviceById(String id) {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Device> cq = builder.createQuery(Device.class);
        Root<Device> d = cq.from(Device.class);

        cq =  cq.select(d).where(builder.like(d.get("device_id"),id));

        try{
            return list(cq).get(0);
        }
        catch (Exception e){
            return null;
        }

    }


    public List<Device> findDeviceByName(String name) {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Device> cq = builder.createQuery(Device.class);
        Root<Device> d = cq.from(Device.class);

        out.println("LIST STARTED...........");
        list(cq.select(d).where(builder.equal(d.<String>get("device_name"),name))).stream().forEach(out::println);

        cq =  cq.select(d).where(builder.like(d.get("device_name"),"%"+name+"%"));


        try{
            return list(cq);
        }
        catch (Exception e){
            return null;
        }

    }
}