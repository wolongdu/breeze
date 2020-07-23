package com.breeze.common.security.service;

import javax.sql.DataSource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import com.breeze.common.core.constant.CacheConstants;
import com.breeze.common.core.constant.SecurityConstants;

/**
 * 重写原生方法支持redis缓存
 *
 * @author breeze
 */
public class RedisClientDetailsService extends JdbcClientDetailsService
{
    public RedisClientDetailsService(DataSource dataSource)
    {
        super(dataSource);
        super.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
        super.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
    }

    @Override
    @Cacheable(value = CacheConstants.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId)
    {
        return super.loadClientByClientId(clientId);
    }
}
