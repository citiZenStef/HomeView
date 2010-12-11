package beans;

public class UserBeanFactory {
	/**
     * Generate a new instance of UserBeanImpl
     */
    public static UserBean newInstance() {
        return new UserBeanImpl();
    }
}
