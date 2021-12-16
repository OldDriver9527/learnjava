package org.olddriver.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 校验
 * 20211215
 * 第三部分
 */
@SpringBootApplication
public class Validations {
    /**
     * spring支持bean validation规范，可以将参数校验逻辑定义在bean中而非controller层
     * hibernate validator是对bean validation规范的一种实现
     *
     * 约束注解
     * bean validation提供一系列约束注解用于校验数据，可以指定校验失败时的错误信息
     * 当校验失败会抛出异常
     * 一般的约束注解在参数不为null时才会校验
     *
     * @Validated
     * 由spring提供，与@Valid略有不同。均用于对目标进行校验
     * @Validated 可用于类型，方法，方法参数上，无法在字段，类型参数上使用。支持分组校验
     *            在类型上使用@Validated表示类支持方法级校验，可以对方法返回值，参数直接添加约束注解
     * @Valid   可用于字段，类型参数，方法，方法参数上，无法在类型上使用。不支持分组校验，支持级联校验
     *
     * 级联验证
     * 需要对对象中的嵌套对象或嵌套对象集合进行级联验证时，可在嵌套对象或嵌套对象集合上添加@Valid
     * 对于嵌套对象集合也可将@Valid添加在实际泛型参数前
     *
     * service层校验
     *
     * 分组校验
     * 将约束注解分组，不同组的约束应用于不同场景。若未指定分组，约束属于默认组(Default组)
     * 最终通过@Validated指定启用分组，@Validated可以为类，方法，方法参数指定校验分组，无法为类型参数指定校验分组
     * 当需要为类型参数指定校验分组时，需要将@Validated声明在方法上，然后通过@Valid对集合元素进行级联校验；或者自定义注解@ValidPart
     *
     * 自定义约束注解
     * 自定义注解中需声明message，groups，payload抽象方法
     * 使用@Constraint的validatedBy元素指定注解对应的校验逻辑
     *
     * 快速失败模式
     *
     * 运行时决定校验组
     * 使用@GroupSequenceProvider指定组序列供应商，组序列供应商中包含决定校验组的逻辑
     * 组序列供应商需实现DefaultGroupSequenceProvider接口
     */

    public static void main(String[] args) {
        SpringApplication.run(Validations.class,args);
    }
}
