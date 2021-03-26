package com.linecode.order.projection.domain.query.resolver;

import java.util.Optional;

import com.linecode.order.projection.domain.query.Query;

public interface QueryResolver <T extends Query, R> {
    
    Optional<R> resolve(T query);
    
}
