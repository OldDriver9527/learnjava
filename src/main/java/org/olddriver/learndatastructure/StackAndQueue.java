package org.olddriver.learndatastructure;

import java.util.LinkedList;

/**
 * 20200924
 * part 3
 */
public class StackAndQueue {
    /*
     * 栈stack，队列queue
     * 栈和队列是特殊的线性表
     *
     * 栈
     * 仅能在一端进行插入，删除操作的线性表，通常在表尾操作。称为后进先出的线性表，简称LIFO结构
     * 表尾称为栈顶(top)，表头称为栈底(base)
     * 插入元素到栈顶，称为入栈(push)；删除栈顶元素，称为出栈(pop)
     * 栈与线性表仅运算规则不同
     *
     * 栈的案例
     * 十进制转其他进制
     * 将十进制数与基数进行多次模运算，将结果存放在栈中；从栈中获取最终结果
     * 校验表达式中括号是否匹配
     * 对于左括号执行入栈操作，对于右括号执行出栈操作；出栈时将右括号与栈顶括号匹配，若匹配进行出栈；
     * 若栈已空但仍存在右括号或无右括号但栈仍存在元素，存在错误
     * 表达式运算
     *
     * 栈操作
     * 初始化栈
     * 销毁栈
     * 判断栈是否为空
     * 求栈长度
     * 取栈顶元素
     * 清空栈
     * 入栈
     * 出栈
     *
     * 顺序栈
     * 栈的顺序存储结构称为顺序栈。使用数组依次存放从栈底到栈顶的数据元素，top指针指向栈顶元素后的位置，base指针指向栈底元素，
     * stacksize变量存放栈的容量
     * top指针减base指针等于元素个数，top指针减base指针等于0表示空栈，top指针减base指针等于stacksize表示栈满
     * 栈满仍插入元素称为上溢overflow
     * 栈空仍移除元素称为下溢underflow
     * 上溢是一种错误，下溢是一种结束标志
     *
     * 顺序栈操作
     * 初始化
     * 创建指定长度数组，将top指针，base指针指向数组中第一个元素
     * 判断是否为空栈
     * 判断top指针与base指针是否相等
     * 获取栈长度
     * top指针减base指针
     * 清空栈
     * 将base指针赋值给top指针
     * 销毁栈
     * 将数组销毁
     * 入栈
     * 预先判断栈是否已满，若未满将元素存放到top指针指向位置，top指针后移
     * 出栈
     * 预先判断栈是否为空，若不为空将top指针前移一位，将top指针指向元素返回
     *
     * 链栈实现
     * 链栈是插入，删除操作受限的单链表，只能在链表头部进行操作。数据域存放数据，指针域存放前趋元素地址
     * 链栈中无头结点，头指针最初指向首元结点
     *
     * 链栈操作
     * 初始化
     * 创建头指针，赋值为null
     * 判断链栈是否为空
     * 头指针为空，链栈为空
     * 入栈(头插)
     * 创建新结点，使用指针p指向新结点。将s赋值给p的next域，将p赋值给s
     * 出栈
     * 创建指针p，将头指针s赋值给p，将p的next域赋值给s，销毁p指向的结点
     *
     * 队列
     * 仅能在一端进行插入，另一端进行删除的线性表，一般头删尾插。称为先进先出的线性表，简称FIFO结构
     * 表尾称为队尾rear，表头称为队头front
     * 在队尾插入元素入队，在队头删除元素出队
     *
     * 顺序循环队实现
     * 使用数组存放元素，使用变量front存放队头元素下标，变量rear存放队尾元素后一个元素下标。
     * 禁用数组中的一个存储单元区分队空队满情况
     * 当front等于rear，队空
     * (rear+1)%maxqsize=front，队满
     *
     * 顺序循环队列操作
     * 初始化
     * 创建数组，将rear，front变量赋值为0
     * 获取队列长度
     * (rear-front+maxqsize)%maxqsize
     * 入队
     * 预先判断队列是否已满，若队列未满，将元素添加在rear表示的位置，rear重新赋值，rear=(rear+1)%maxqsize
     * 出队
     * 预先判断队列是否为空，若不为空，将front表示的元素返回，front重新赋值，(front+1)%maxqsize
     * 取队头元素
     * 判断队列是否为空，若不为空，返回front表示的元素
     *
     * 链队实现
     * 插入，删除操作受限的单链表，存在头结点，头尾指针
     * 头指针等于尾指针表示队空
     *
     * 链队操作
     * 初始化
     * 创建头结点，将头尾指针指向头结点
     * 销毁
     * 判断头指针是否为空，不为空，将头指针next域赋值给临时变量p，销毁头指针，将p赋值给头指针，继续判断
     * 入队
     * 创建新结点，将新结点地址赋值给尾指针next域，将新结点地址赋值为尾指针
     * 出队
     * 判断队列是否为空，若不为空将头指针next域赋值给指针p，将p的next域赋值给头指针的next域，若p指针指向尾结点，将头指针赋值给尾指针，
     * 销毁p指针指向结点
     * 获取队头元素
     * 返回头指针的next域对应的结点
     */

    public static void main(String[] args) {

        String str = "1002-58";
        char[] eles = new char[str.length()];
        int endIndex;
        str.getChars(0, str.length(), eles, 0);

        LinkedList<Character> op = new LinkedList<>();
        LinkedList<String> expression = new LinkedList<>();
        LinkedList<Double> number = new LinkedList<>();

        for (int i = 0; i < eles.length;) {
            char ele = eles[i];
            if (Character.isDigit(ele)) {
                endIndex = readDouble(str,i);
                String num = str.substring(i, endIndex);
                expression.push(num);
                i = endIndex;
            } else if(ele == '('){
                op.push(ele);
                i++;
            }else if(isOperator(ele)){
                while(true){
                    Character topOp = op.peek();
                    if(topOp != null){
                        if(topOp == '('){
                            op.push(ele);
                            break;
                        }else{
                            int result = priorityCompare(ele, topOp);
                            if(result > 0){
                                op.push(ele);
                                i++;
                                break;
                            }else{
                                topOp = op.pop();
                                expression.push(String.valueOf(topOp));
                            }
                        }

                    }else{
                        op.push(ele);
                        break;
                    }
                }
                i++;

            }else if(ele == ')'){
                while(true){
                    Character topOp = op.peek();
                    if(topOp != '('){
                        expression.push(String.valueOf(op.pop()));
                    }else{
                        op.pop();
                        break;
                    }
                }
                i++;
            }
        }

        for(int i = 0 ; i < op.size();i++){
            expression.push(String.valueOf(op.pop()));
        }

        for(int i = expression.size()-1 ; i >=0  ; i--){
            String peek = expression.get(i);

            try {
                Double parse = Double.parseDouble(peek);
                number.push(parse);
            }catch (Exception e){

                Double top = number.pop();
                Double ttt = number.pop();

                double calc = calc(ttt, top, peek);
                number.push(calc);
            }



        }

        System.out.println(number);


    }

    private static int readDouble(String exp, int startIndex) {

        char ele;
        int i = startIndex;
        for (; i < exp.length(); i++) {
            ele = exp.charAt(i);
            if(Character.isDigit(ele)){
            }else if( ele == '.'){
            }else{
                break;
            }
        }
        return i;
    }

    private static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


    private static int priorityCompare(char op1, char op2){
        switch (op1) {
            case '+':
            case '-':
                return (op2 == '*' || op2 == '/' ? -1 : 0);
            case '*':
            case '/':
                return (op2 == '+' || op2 == '-' ? 1 : 0);
            default:
                throw new RuntimeException("not support");
        }
    }


    private static double calc(double num1, double num2, String op)
            {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0; // will never catch up here
        }
    }

}
