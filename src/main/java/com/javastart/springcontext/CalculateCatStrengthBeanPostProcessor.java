package com.javastart.springcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class CalculateCatStrengthBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declareFields = bean.getClass().getDeclaredFields();
        for (Field field : declareFields) {
            CalculateCatStrength annotation = field.getAnnotation(CalculateCatStrength.class);
            if (annotation != null) {
                int minStrength = annotation.minStrength();
                int maxStrength = annotation.maxStrength();
                Random random = new Random();
                int result = minStrength + random.nextInt(maxStrength - minStrength);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, result);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
