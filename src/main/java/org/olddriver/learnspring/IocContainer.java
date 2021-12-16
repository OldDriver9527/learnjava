package org.olddriver.learnspring;

/**
 * 反转控制容器
 * 20211213
 * 第二部分
 */
public class IocContainer {
    /**
     * ioc
     * ioc(Inversion of Control)也可以称为di(Dependency Injection)
     * 只要将对象纳入ioc容器的管理范围，ioc容器负责创建对象，装配依赖项，管理对象生命周期
     * 不再需要对象自行创建依赖项
     *
     * ioc容器分类
     * BeanFactory（bean工厂）
     * ioc容器的根接口，bean工厂包含bean管理功能
     * ApplicationContext（应用上下文）
     * BeanFactory的子接口，对BeanFactory的功能拓展
     *
     * ApplicationContext实现
     * ClassPathXmlApplicationContext	用于读取类路径下（classes目录中）的元数据
     * FileSystemXmlApplicationContext	用于读取文件系统中的元数据
     * AnnotationConfigApplicationContext
     *
     * BeanDefinition
     * 用于存储bean的元数据，与bean一一对应
     *
     * 命名bean
     * ioc容器中每个bean具有名称，通过名称从容器中获取bean。
     * 在使用@Component，@Controller，@Service，@Repository，@Configuration等注解时可以指定bean名称，默认使用首字母小写的类名作为名称
     * 在使用@Bean注解时可以指定bean名称，默认使用方法名作为bean名称
     *
     * 实例化bean
     * ioc容器能够通过构造器，静态工厂方法，实例工厂方法实例化bean
     * i.ioc容器默认通过无参构造器实例化bean，若类中存在多个构造器会进行构造器推断
     * 若类中构造器唯一，就选择唯一构造器实例化。若类中构造器不唯一继续推断
     * 是否唯一存在@Autowired修饰的构造器，若存在使用该构造器，若不存在继续推断
     * 在多个@Autowired修饰的构造器中选择，会选择满足依赖项最多的构造器，若满足依赖项个数相同，按声明顺序使用最上面
     * ii.使用@Bean注解修饰工厂方法可实例化bean
     *
     * 依赖注入
     * 明确指定为bean注入的依赖项
     * ioc容器能够通过构造器参数，工厂方法参数，set方法注入依赖项
     *
     * 注入基本数据类型值和String
     * ioc容器只管理bean，当需要注入基本类型或String类型依赖项时，一般通过@Value注解读取配置文件
     *
     * 循环依赖
     * 两个以上的bean相互依赖，形成引用闭环称为循环依赖
     * spring解决单例bean通过set方法注入依赖所引起的循环依赖，但其他场景导致的抛出异常无法解决
     * ioc容器中存在三级缓存，
     * 一级缓存用于存储已初始化完的单例对象，称为singletonObjects(单例池)
     * 二级缓存用于存储
     * 三级缓存用于存储
     *
     * 懒加载
     * 推迟bean的实例化时机，当第一次通过ioc容器获取bean时才会实例化
     * 当懒加载bean作为单例非懒加载bean的依赖项时，懒加载的bean会在ioc容器启动时实例化
     *
     * 自动装配
     * 不明确指定为bean注入的依赖项，由ioc容器寻找合适的依赖项进行注入
     * 自动装配包含四种模式
     * no   不进行自动装配
     * byName   在ioc容器中寻找指定名称的bean
     * byType   在ioc容器中寻找类型相同的bean
     * constructor  在ioc容器中寻找与构造器参数类型相同的bean
     * 当容器中存在类型一致的bean，可以将bean装配到List，Map中
     *
     * bean作用域
     * singleton    默认作用域，ioc容器中只会包含bean的一个实例。单例对象存储在单例池中
     * prototype
     * request
     * session
     * application
     * websocke
     *
     * bean生命周期
     * 生成BeanDefinition
     * 实例化前
     * 实例化      遍历每个BeanDefinition，推断合适构造器实例化bean
     * 实例化后
     * 属性填充     注入依赖项，可能触发其他bean的创建
     * 执行aware方法    如BeanNameAware，BeanFactoryAware中方法
     * 初始化前     执行初始化前方法，可通过BeanPostProcessor及@PostConstruct指定初始化前方法
     * 初始化      执行bean的初始化方法，通过实现InitializingBean接口可指定初始化方法
     * 初始化后     执行初始化后方法，aop在初始化后生成代理
     * 销毁前      执行销毁前方法，通过@PreDestroy指定销毁前方法
     * 销毁       执行bean的销毁方法，通过实现DisposableBean接口指定销毁方法
     *
     * @Autowired
     * 用于进行自动装配，默认根据类型进行匹配。当有多个候选bean时，会进一步根据名称匹配。若仍有多个候选bean，会抛异常
     * required元素默认为true，当required元素为true的@Autowired修饰构造器时，其他构造器不能使用@Autowired修饰
     * @Autowired 不支持对static成员的装配
     *
     * @Resource
     * 用于进行自动装配，根据名称进行匹配。
     * 当未指定名称，使用字段名或属性名作为名称。不会存在多个候选bean的情况。当没有匹配的bean，会按类型匹配
     *
     * @Primary
     * 对自动装配进行微调，标识主要候选bean。当存在多个候选bean时，若存在主要候选bean，会使用主要候选bean
     *
     * @Qualifier
     * 对自动装配进行微调，标识bean的限定名。与自动装配注解组合使用，只会装配具有相同限定名的bean
     *
     * @Profile @ActiveProfiles
     * @Profile用于配置运行环境相关bean，便于运行环境切换
     * @ActiveProfiles用于指定激活的环境
     *
     * @Conditional
     * 用于配置条件条件化bean
     *
     * @Bean
     * 创建的bean默认是代理对象
     *
     * @ComponentScan
     * 用于进行组件扫描，扫描基础包及其子包中组件。若未指定基础包，将当前类所在的包作为基础包
     *
     * @Import
     * 用于导入其他配置类
     *
     * @ImportResource
     * 用于导入xml配置文件中配置
     *
     *
     */
}
