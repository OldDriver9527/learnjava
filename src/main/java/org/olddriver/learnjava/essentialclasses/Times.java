package org.olddriver.learnjava.essentialclasses;

/**
 * 20200527
 * part 1
 */
public class Times {
    /*
     * jdk8前日期时间API问题
     * 日期时间不方便计算
     * Date，Calendar，SimpleDateFormat线程不安全，多个线程使用同一实例会发生潜在并发问题
     * SimpleDateFormat 中 calendar字段存储操作时间，在执行操作过程中会将calendar清空，多线程情况下
     * 会影响其他线程执行
     * 设置Calendar时间可以使用未定义的魔法数字，不符合开发规范
     *
     * jdk8中新增日期时间API
     * 线程安全
     * 不提供公共构造器，只能通过工厂方法创建对象
     * 不可变对象，每进行一次计算都会创建新对象
     *
     * 常用类
     * Duration 表示秒或纳秒的时间间隔
     * Period   表示一段时间，实现TemporalAmount接口
     * of(int,int,int)  创建Period对象，封装指定时间段，参数为年月日
     *
     * Instant  表示时间线上一点
     * now()    创建Instant对象，封装当前格林尼治时间
     *
     * LocalDate
     * now()    创建LocalDate对象，封装当前年月日
     * of(int,int,int)  创建LocalDate对象，封装指定年月日，月取值范围从1~12，日取值范围从1~31
     * plusDays(long)   在当前时间上增加指定天数，返回新LocalDate对象
     * plusWeeks(long)  在当前时间上增加指定周数，返回新LocalDate对象
     * plusMonths(long) 在当前时间上增加指定月数，返回新LocalDate对象
     * plusYears(long)  在当前时间上增加指定年数，返回新LocalDate对象
     * plus(TemporalAmount) 在当前时间上增加指定时间段，返回新LocalDate对象
     *                      Period实现TemporalAmount接口
     * plus(long,TemporalUnit)  当前时间上添加指定时间，通过TemporalUnit控制时间单位
     *                          ChronoUnit枚举实现TemporalUnit接口
     * minusDays(long)  在当前时间上减少指定天数，返回新LocalDate对象
     * minusWeeks(long) 在当前时间上减少指定周数，返回新LocalDate对象
     * minusMonths(long)    在当前时间上减少指定月数，返回新LocalDate对象
     * minusYears(long) 在当前时间上减少指定年数，返回新LocalDate对象
     * minus(TemporalAmount)    在当前时间上减少指定时间段，返回新LocalDate对象
     * minus(long, TemporalUnit)
     * withMonth(int)   将当前时间中月修改为指定参数
     * with(TemporalField, long)    对当前时间中时间字段进行修改，通过TemporalField指定时间字段
     *                              ChronoField枚举实现TemporalField接口
     * with(TemporalAdjuster)   通过时间调节器，将时间修改为指定参数
     *                          TemporalAdjusters中提供创建TemporalAdjuster static方法
     * isAfter(ChronoLocalDate) 判断当前时间是否在指定时间之后
     * isBefore(ChronoLocalDate)    判断当前时间是否在指定时间之前
     * isEqual(ChronoLocalDate) 判断当前时间与指定时间是否相等
     * format(DateTimeFormatter)    将LocalDate格式化为String
     * parse(CharSequence, DateTimeFormatter)   将字符序列解析为LocalDate
     *
     * LocalTime
     * now()    创建LocalTime对象，封装当前时分秒
     * of(int,int)  创建LocalTime对象，封装指定时分，小时取值范围0~23，分钟取值范围0~59
     * of(int,int,int)  创建LocalTime对象，封装指定时分秒
     * plusNanos(long)  在当前时间上增加指定纳秒，返回新LocalTime对象
     * plusSeconds(long)    在当前时间上增加指定秒，返回新LocalTime对象
     * plusMinutes(long)    在当前时间上增加指定分钟，返回新LocalTime对象
     * plusHours(long)  在当前时间上增加指定小时，返回新LocalTime对象
     * minusNanos(long) 在当前时间上减少指定纳秒，返回新LocalTime对象
     * minusSeconds(long)   在当前时间上减少指定秒，返回新LocalTime对象
     * minusMinutes(long)   在当前时间上减少指定分钟，返回新LocalTime对象
     * minusHours(long) 在当前时间上减少指定小时，返回新LocalTime对象
     *
     * LocalDateTime
     * now()    创建LocalDateTime对象，封装当前年月日时分秒
     * of(int,int,int,int,int,int)  创建LocalDateTime对象，封装指定年月日时分秒
     * of(LocalDate,LocalTime)  创建LocalDateTime对象，封装指定LocalDate对象和LocalTime对象
     * atZone(ZoneId)   结合LocalDateTime和指定时区，创建ZonedDateTime对象
     *
     * Year
     * now()    创建Year对象，封装当前年
     *
     * YearMonth
     * now()    创建YearMonth对象，封装当前年月
     *
     * MonthDay
     * now()    创建MonthDay对象，封装当前月日
     *
     * ZoneId
     * getAvailableZoneIds()    获取封装所有可用时区set集合，元素类型为String
     * systemDefault()  获取系统默认时区，返回ZoneId对象
     * of(String)   创建指定时区的ZoneId对象
     *
     * ZonedDateTime
     * now()    创建ZonedDateTime对象，封装当前年月日时分秒，带时区
     * withZoneSameInstant(ZoneId)  复制日期时间，修改时区，创建新ZonedDateTime对象
     *
     * Month    月份枚举，传入月份时建议使用月份枚举，不建议使用数字
     * of(int)  根据指定月份获取枚举常量
     *
     * TemporalAdjusters    用于创建TemporalAdjuster
     * next(DayOfWeek)  创建TemporalAdjuster，将时间调节为下周指定日期
     * previous(DayOfWeek)  创建TemporalAdjuster，将时间调节为上周指定日期
     *
     * ChronoUnit
     * between(Temporal, Temporal)  计算两时间间隔
     *
     * DateTimeFormatter
     * ofPattern(String)    使用指定格式创建格式化器
     */
}
