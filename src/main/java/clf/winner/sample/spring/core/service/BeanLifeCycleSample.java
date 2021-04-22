package clf.winner.sample.spring.core.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.transaction.TransactionManager;

public class BeanLifeCycleSample extends InstantiationAwareBeanPostProcessorAdapter implements InitializingBean, DisposableBean, BeanPostProcessor, BeanFactoryPostProcessor {

    private Integer num;

    public BeanLifeCycleSample() {
        System.out.println("---construct---");
    }

    public void initMethod() {
        System.out.println("---init-method---");
    }

    public void destroyMethod() {
        System.out.println("---destroy-method---");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---DisposableBean.destroy---");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---InitializingBean.afterPropertiesSet---");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleSample) {
            System.out.println("---BeanPostProcessor.postProcessBeforeInitialization---");
        }
        if (bean instanceof TransactionManager) {
            System.out.println("---TransactionManager---" + bean.getClass().getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleSample) {
            System.out.println("---BeanPostProcessor.postProcessAfterInitialization---");
        }
        return bean;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
        System.out.println("---set properties---");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("---BeanFactoryPostProcessor.postProcessBeanFactory---");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.equals(this.getClass())) {
            System.out.println("---InstantiationAwareBeanPostProcessorAdapter.postProcessBeforeInstantiation---");
        }

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleSample) {
            System.out.println("---InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation---");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycleSample) {
            System.out.println("---InstantiationAwareBeanPostProcessorAdapter.postProcessProperties---");
        }
        return null;
    }
}
