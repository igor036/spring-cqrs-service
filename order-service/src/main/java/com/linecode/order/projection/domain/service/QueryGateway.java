package com.linecode.order.projection.domain.service;

import java.util.List;

import com.linecode.order.projection.domain.query.Query;
import com.linecode.order.projection.domain.query.resolver.QueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class QueryGateway {
    
    @Autowired
    private List<QueryResolver> resolvers;

    public <R> R resolve(Query query) {
        var queryResolver = getQueryResolver(query);
        return (R) queryResolver.resolve(query);
    }

    private QueryResolver getQueryResolver(Query query) {

        var beanName = getQueryResolverBeanName(query);
        var queryResolver = resolvers
            .stream().filter(resolver -> isBeanName(resolver, beanName))
            .findFirst();

        if (queryResolver.isPresent()) {
            return queryResolver.get();
        }

        throw commandHandlerNotFoundException(query);
    }


    private String getQueryResolverBeanName(Query query) {
        return query.getClass().getSimpleName().replace("Query", "Resolver");
    }

    private boolean isBeanName(QueryResolver resolver, String beanName) {
        return resolver.getClass().getSimpleName().equals(beanName);
    }
    
    private IllegalArgumentException commandHandlerNotFoundException(Query query) {
        var message = String.format("Error when try find query resolver to %s", query.getClass().toString());
        return new IllegalArgumentException(message);
    }
}
