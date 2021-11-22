package org.olddriver.learnjava.concurrency;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * future模式
 * 20200907
 * 第二部分
 */
public class FuturePattern {
    /**
     * future模式
     * 一种多线程设计模式，可以将算法中比较耗时的步骤异步执行，先获取虚拟结果，之后通过虚拟结果获取实际结果。
     * 缩短总体执行时间
     * jdk中future模式实现
     * Future   未来虚拟结果
     * RunnableFuture   既是线程任务也是虚拟结果
     * FutureTask   RunnableFuture实现类，其中封装Runnable或Callable任务。Callable相比于Runnable具有返回值，可以抛异常，更易操作
     * CompletableFuture    jdk1.8后推出执行异步任务的一种新方式
     *                      Future，CompletionStage实现类，通过函数式编程方式构建一系列异步执行的阶段，
     *                      一个阶段完成触发下一阶段执行，当前阶段的结果会作为下一阶段的输入参数
     *                      具有Async后缀的方法创建的阶段交给线程池执行，不具有Async后缀的方法创建的阶段由线程池执行或当前线程执行
     *                      函数式接口的返回值就是阶段返回值。
     *                      supplyAsync 构建异步执行阶段，阶段返回指定返回值
     *                      thenCompose 将前一个阶段结果作为新阶段输入，新阶段的结果作为当前阶段结果返回。
     *                                  Function接口返回值必须是CompletableFuture，通过CompletableFuture获取处理结果。
     *                                  涉及三个阶段
     *
     *                      thenCombine 将前一阶段结果与参数阶段结果进行合并处理，合并结果作为当前阶段的结果。
     *                                  两个阶段不具有先后顺序，可以并发执行
     *                      thenAcceptBoth  将前一阶段的结果与参数阶段结果进行合并处理，不再产生结果
     *                      runAfterBoth    在前一阶段和参数阶段执行结束后执行Runnable任务，不再产生结果
     *
     *                      thenApply   将前一阶段结果作为当前阶段输入进行处理，Function接口返回值无具体要求
     *                                  两个阶段具有先后顺序
     *                      thenAccept  将前一阶段结果作为当前阶段输入，不再产生结果
     *                      thenRun     在前一阶段结束后执行当前阶段，不产生结果
     *
     *                      applyToEither   对前一阶段或参数阶段两者中一个结果进行处理，对先结束的阶段结果进行处理
     *                      acceptEither    对前一阶段或参数阶段两者中任意一个结果进行处理，不再产生结果，对先结束的阶段结果进行处理
     *                      runAfterEither  在前一阶段或参数阶段两者中任意一个阶段完成后执行，不再产生结果
     *
     *                      exceptionally   对前一阶段的异常进行处理
     *                                      若前一阶段不发生异常，当前阶段不执行
     *                                      若前一阶段发生异常，执行当前阶段对异常进行处理，返回结果
     *                      handle          对前一阶段的结果进行处理，产生结果
     *                                      参数BiFunction中apply方法的两个参数，一个为前一阶段结果，一个为前一阶段异常
     *                      whenComplete    对前一阶段的结果进行处理，不再产生结果
     *                                      参数BiConsumer中accept方法的两个参数，一个为前一阶段结果，一个为前一阶段异常
     */

    @Test
    public void test(){
        CompletableFuture.supplyAsync(()->{
            return 1/0;
        }).exceptionally((e)->{
            e.printStackTrace();
            throw new RuntimeException(e);
        });


        CompletableFuture.runAsync(()->{
            System.out.println("run");
        }).runAfterEither(CompletableFuture.runAsync(()->{
            System.out.println("AfterEither");
        }),()->{
            System.out.println("runAfterEither");
        });

        CompletableFuture.supplyAsync(()->{
            return "accept";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            return "Either";
        }),(str)->{
            System.out.println(str);
        });

        CompletableFuture.supplyAsync(()->{
            return "apply";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            return "ToEither";
        }),(str)->{
            return str.toUpperCase();
        }).thenAccept((str)->{
            System.out.println(str);
        });

        CompletableFuture.runAsync(()->{
            System.out.println("runAsync");
        }).thenRun(()->{
            System.out.println("thenRun");
        });

        CompletableFuture.supplyAsync(()->{
            return "thenAccept";
        }).thenAccept((str)->{
            System.out.println(str);
        });

        CompletableFuture.supplyAsync(()->{
            return "thenApply";
        }).thenApply((str)->{
            return str.toLowerCase();
        }).thenAccept((str)->{
            System.out.println(str);
        });

        CompletableFuture.supplyAsync(()->{
            System.out.println("run");
            return "run";
        }).runAfterBoth(CompletableFuture.supplyAsync(()->{
            System.out.println("AfterBoth");
            return "AfterBoth";
        }),()->{
            System.out.println("runAfterBoth");
        });

        CompletableFuture.supplyAsync(()->{
            return "then";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            return "AcceptBoth";
        }),(left,right)->{
            System.out.println(left.concat(right));
        });

        CompletableFuture.supplyAsync(()->{
            return "then";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return "combine";
        }),(left,right)->{
            return left.concat(right);
        }).thenAccept((str)->{
            System.out.println(str);
        });

        CompletableFuture.supplyAsync(()->{
            return "thenCompose";
        }).thenCompose((str)->{
            return CompletableFuture.supplyAsync(()->{
               return str.toUpperCase();
            });
        }).thenAccept((str)->{
            System.out.println(str);
        });

        CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"@@"+Thread.currentThread().getState()+"@@"+Thread.currentThread().isDaemon());
        });

        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"@@"+Thread.currentThread().getState()+"@@"+Thread.currentThread().isDaemon());
            return "supplyAsync";
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }


    @Test
    public void testWhenComplete(){
        CompletableFuture.supplyAsync(()->{
            if(true){
                throw new RuntimeException("qq");
            }
            return "hello";
        }).whenComplete((str,e)->{
            if(Objects.isNull(e)){
                System.out.println(str.toUpperCase());
            }else{
                System.out.println("exception");
            }
        });
    }

    @Test
    public void testHandle(){
        CompletableFuture.supplyAsync(()->{
            if(true){
                throw new RuntimeException("jjj");
            }
            return "hello";
        }).handle((str,e)->{
            if(Objects.isNull(e)){
                return str.toUpperCase();
            }else{
                return "exception";
            }
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }


    @Test
    public void testExceptionally(){
        CompletableFuture.supplyAsync(() -> {
            if(true){
                throw new RuntimeException("qqq");
            }
            return "hello";
        }).exceptionally((e) -> {
            System.out.println("-----");
            e.printStackTrace();
            return "exceptionally";
        }).thenAccept((str)->{
            System.out.println(str);
        });


    }



    @Test
    public void testRunAfterEither(){
        CompletableFuture.supplyAsync(()->{
            return "hello";
        }).runAfterEither(CompletableFuture.supplyAsync(()->{
            return "java";
        }),()->{
            System.out.println("run after either");
        });
    }

    @Test
    public void testAcceptEither(){
        CompletableFuture.supplyAsync(()->{
           return "hello";
        }).acceptEither(CompletableFuture.supplyAsync(()->{
            return "java";
        }),(str)->{
            System.out.println(str);
        });
    }


    @Test
    public void testApplyToEither(){
        CompletableFuture.supplyAsync(()->{
            return "hello";
        }).applyToEither(CompletableFuture.supplyAsync(()->{
            return "java";
        }),(str)->{
            return str.toUpperCase();
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }

    @Test
    public void testThenRun(){
        CompletableFuture.supplyAsync(()->{
            return "good luck";
        }).thenRun(()->{
            System.out.println("hello");
        });
    }

    @Test
    public void testThenAccept(){
        CompletableFuture.supplyAsync(()->{
            return "hello java";
        }).thenAccept((str)->{
            System.out.println(str.toUpperCase());
        });
    }

    @Test
    public void testThenApply(){
        CompletableFuture.supplyAsync(()->{
            return "hello";
        }).thenApply((str)->{
            return str.concat(" java");
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }


    @Test
    public void testRunAfterBoth(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("stage one");
            return "hello";
        }).runAfterBoth(CompletableFuture.supplyAsync(()->{
            System.out.println("stage two");
            return "java";
        }),()->{
            System.out.println("run after both");
        });
    }


    @Test
    public void testThenAcceptBoth(){
        CompletableFuture.supplyAsync(()->{
            return "hello";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            return "java";
        }),(left, right)->{
            System.out.println(left + right);
        });
    }


    /**
     * thenCombine
     * 将前一阶段的结果与参数阶段的结果合并，合并结果作为当前阶段结果返回
     */
    @Test
    public void testThenCombine(){
        CompletableFuture.supplyAsync(()->{
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            return "java";
        }),(left,right)->{
            return left.concat(right);
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }

    /**
     * thenCompose 连接
     * 前一阶段的结果作为新阶段的输入，新阶段的结果作为当前阶段的结果返回
     */
    @Test
    public void testThenCompose(){
        CompletableFuture.supplyAsync(()->{
            return "hello java";
        }).thenCompose((str)->{
            return CompletableFuture.supplyAsync(()->{
                return str.toUpperCase();
            });
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }


    /**
     * supplyAsync  创建异步执行的阶段，阶段需要存在返回值
     */
    @Test
    public void testSupplyAsync(){
        CompletableFuture.supplyAsync(()->{
            return "hello future";
        }).thenAccept((str)->{
            System.out.println(str);
        });
    }

    /**
     * runAsync 创建异步执行阶段，阶段不需要返回值
     */
    @Test
    public void testRunAsync(){
        CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"@"+Thread.currentThread().getState());
        });
    }

}
