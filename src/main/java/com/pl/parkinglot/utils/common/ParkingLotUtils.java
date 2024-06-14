package com.pl.parkinglot.utils.common;

import com.pl.parkinglot.service.SlotAssginStartergy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class ParkingLotUtils {


    @Autowired
    private BeanFactory beanFactory;

    Logger logger = LoggerFactory.getLogger(ParkingLotUtils.class);

    public String generateGuid() {
        return UUID.randomUUID().toString();
    }

    public SlotAssginStartergy getSlotAssginStartergyService(String beanName) {
        return getBean(beanName + "_SLOT_ASSGIN_STARTERGY", SlotAssginStartergy.class);
    }

    private <T> T getBean(String name, Class<T> tClass) {
        try {
            return (T) beanFactory.getBean(name);
        } catch (Exception e) {

        }
        return null;
    }
}
