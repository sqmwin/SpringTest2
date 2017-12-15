import com.sqm.pojo.MyCollections;
import com.sqm.pojo.Person;
import com.sqm.pojo.Student;
import com.sqm.pojo.Student2;
import com.sqm.service.IService;
import com.sqm.service.StudentServiceImpl;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * <p>
 *      测试类
 * </p>
 *
 * @author sqm
 * @version 1.0
 */
public class Test {
    //bean后处理器
    @org.junit.Test
    public void test01(){
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
        IService studentService = (IService) context.getBean("studentService");
        studentService.some();
        studentService.other();
        IService teacherService = (IService) context.getBean("teacherService");
        teacherService.some();
        teacherService.other();
    }

    //bean的生命周期
    @org.junit.Test
    public void test02() {
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentService = (StudentServiceImpl) context.getBean("studentService2");
        studentService.some();
        studentService.other();
        //只有容器关闭后才执行destroy-method
        ((FileSystemXmlApplicationContext)context).close();
    }
    /*
    实现了BeanNameAware接口
    实现了BeanFactoryAware接口
    bean后处理器执行postProcessBeforeInitialization()
    init-method初始化完毕
    bean后处理器执行postProcessAfterInitialization()
    StudentServiceImpl do some()
    StudentServiceImpl do other()
    Close()
    实现了DispoableBean接口
    destroy-method销毁
    */

    //设值注入与构造注入
    @org.junit.Test
    public void test03() {
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext2.xml");
        Student sqm = (Student) context.getBean("sqmStudent");
        System.out.println(sqm.toString());
        Student lili = (Student) context.getBean("liliStudent");
        System.out.println(lili.toString());

        //通过p命名空间(parameter)和c命名空间(constructor)注入
        Student sqm2 = (Student) context.getBean("sqmStudent2");
        System.out.println(sqm2.toString());
        Student lili2 = (Student) context.getBean("liliStudent2");
        System.out.println(lili2.toString());

    }

    //集合注入
    @org.junit.Test
    public void test04() {
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext2.xml");
        MyCollections myCollections = (MyCollections) context.getBean("myCollections");
        System.out.println(myCollections.toString());
    }

    //autowire自动注入域属性
    @org.junit.Test
    public void test05() {
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext2.xml");
        //byName
        Student autowire = (Student) context.getBean("autowire");
        System.out.println(autowire.toString());
        //byType
        Student autowire2 = (Student) context.getBean("autowire2");
        System.out.println(autowire2.toString());
    }

    //SpEL
    @org.junit.Test
    public void test06() {
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext3.xml");
        Person sqmAsPerson = (Person) context.getBean("sqmAsPerson");
        Student2 sqmAsStudent = (Student2) context.getBean("sqmAsStudent");
        Student2 sqmAsStudent2 = (Student2) context.getBean("sqmAsStudent2");
        System.out.println(sqmAsPerson.toString());
        System.out.println(sqmAsStudent.toString());
        System.out.println(sqmAsStudent2.toString());
    }

    //继承抽象bean
    @org.junit.Test
    public void test07(){
        ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext3.xml");
        //同类继承Bean
        Student2 student1 = (Student2) context.getBean("student1");
        Student2 student2 = (Student2) context.getBean("student2");
        System.out.println(student1.toString());
        System.out.println(student2.toString());

        //异类继承bean
        Person sqmPerson = (Person) context.getBean("sqmPerson");
        Student2 sqmStudent = (Student2) context.getBean("sqmStudent");
        System.out.println(sqmPerson.toString());
        System.out.println(sqmStudent.toString());

        
    }
}

