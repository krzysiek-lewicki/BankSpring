package pl.training.bank.operation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class OperationResolver implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public Operation get(String name) {
        try {
            return beanFactory.getBean(name, Operation.class);
        } catch (NoSuchBeanDefinitionException ex) {
            throw new NoSuchOperationException();
        }
    }

}
