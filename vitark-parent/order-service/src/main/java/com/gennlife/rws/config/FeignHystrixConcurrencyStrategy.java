package com.gennlife.rws.config;

import com.hmily.tcc.common.bean.context.TccTransactionContext;
import com.hmily.tcc.core.concurrent.threadlocal.TransactionContextLocal;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.Callable;

/**
 * https://blog.csdn.net/songhaifengshuaige/article/details/80345012
 */
public class FeignHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new RequestAttributeAwareCallable<>(callable, RequestContextHolder.getRequestAttributes(), SecurityContextHolder.getContext(), TransactionContextLocal.getInstance().get());
    }

    static class RequestAttributeAwareCallable<T> implements Callable<T> {

        private final Callable<T> delegate;
        private final RequestAttributes requestAttributes;
        private final SecurityContext context;
        private final TccTransactionContext transactionContext;

        public RequestAttributeAwareCallable(Callable<T> callable, RequestAttributes requestAttributes, SecurityContext context,TccTransactionContext transactionContext) {
            this.delegate = callable;
            this.requestAttributes = requestAttributes;
            this.context = context;
            this.transactionContext = transactionContext;
        }

        @Override
        public T call() throws Exception {
            try {
                TransactionContextLocal.getInstance().set(transactionContext);
                SecurityContextHolder.setContext(context);
                RequestContextHolder.setRequestAttributes(requestAttributes);
                return delegate.call();
            } finally {
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }


  /*public FeignHystrixConcurrencyStrategy() {
    try {
      this.delegate = HystrixPlugins.getInstance().getConcurrencyStrategy();
      if (this.delegate instanceof FeignHystrixConcurrencyStrategy) {
        // Welcome to singleton hell...
        return;
      }
      HystrixCommandExecutionHook commandExecutionHook =
          HystrixPlugins.getInstance().getCommandExecutionHook();
      HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
      HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
      HystrixPropertiesStrategy propertiesStrategy =
          HystrixPlugins.getInstance().getPropertiesStrategy();
      this.logCurrentStateOfHystrixPlugins(eventNotifier, metricsPublisher, propertiesStrategy);
      HystrixPlugins.reset();
      HystrixPlugins.getInstance().registerConcurrencyStrategy(this);
      HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
      HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
      HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
      HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
    } catch (Exception e) {
      log.error("Failed to register Sleuth Hystrix Concurrency Strategy", e);
    }
  }

  private void logCurrentStateOfHystrixPlugins(HystrixEventNotifier eventNotifier,
                                               HystrixMetricsPublisher metricsPublisher, HystrixPropertiesStrategy propertiesStrategy) {
    if (log.isDebugEnabled()) {
      log.debug("Current Hystrix plugins configuration is [" + "concurrencyStrategy ["
          + this.delegate + "]," + "eventNotifier [" + eventNotifier + "]," + "metricPublisher ["
          + metricsPublisher + "]," + "propertiesStrategy [" + propertiesStrategy + "]," + "]");
      log.debug("Registering Sleuth Hystrix Concurrency Strategy.");
    }
  }

  @Override
  public <T> Callable<T> wrapCallable(Callable<T> callable) {
      RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
      HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
      Principal userPrincipal = req.getUserPrincipal();
      return new WrappedCallable<>(callable, requestAttributes);
  }

  @Override
  public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
                                          HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize,
                                          HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    return this.delegate.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime,
        unit, workQueue);
  }

  @Override
  public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey,
      HystrixThreadPoolProperties threadPoolProperties) {
    return this.delegate.getThreadPool(threadPoolKey, threadPoolProperties);
  }

  @Override
  public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize) {
    return this.delegate.getBlockingQueue(maxQueueSize);
  }

  @Override
  public <T> HystrixRequestVariable<T> getRequestVariable(HystrixRequestVariableLifecycle<T> rv) {
    return this.delegate.getRequestVariable(rv);
  }

  static class WrappedCallable<T> implements Callable<T> {
    private final Callable<T> target;
    private final RequestAttributes requestAttributes;

    public WrappedCallable(Callable<T> target, RequestAttributes requestAttributes) {
      this.target = target;
      HttpServletRequest req = ((ServletRequestAttributes) requestAttributes).getRequest();
      this.requestAttributes = requestAttributes;//new HttpServletRequestWrapper(req).getRequest();

      System.out.println();
    }

    @Override
    public T call() throws Exception {
      try {
          HttpServletRequest req = ((ServletRequestAttributes) requestAttributes).getRequest();
          Principal userPrincipal = req.getUserPrincipal();
          RequestContextHolder.setRequestAttributes(requestAttributes);
        return target.call();
      } catch (Exception e){
          System.out.println("=======================");
          e.printStackTrace();
          System.out.println("=======================");
          return null;
      }finally {
        RequestContextHolder.resetRequestAttributes();
      }
    }
  }*/
}
