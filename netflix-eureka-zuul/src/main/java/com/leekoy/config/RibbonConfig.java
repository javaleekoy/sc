package com.leekoy.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author leekoy
 *         <p>
 *         Spring Cloud Netflix provides the following beans by default for ribbon (BeanType beanName: ClassName):
 *         <p>
 *         IClientConfig ribbonClientConfig: DefaultClientConfigImpl
 *         IRule ribbonRule: ZoneAvoidanceRule
 *         IPing ribbonPing: DummyPing
 *         ServerList<Server> ribbonServerList: ConfigurationBasedServerList
 *         ServerListFilter<Server> ribbonServerListFilter: ZonePreferenceServerListFilter
 *         ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
 *         ServerListUpdater ribbonServerListUpdater: PollingServerListUpdater
 */
//@Configuration
public class RibbonConfig {

    //    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
