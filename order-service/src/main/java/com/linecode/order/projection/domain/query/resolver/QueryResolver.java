package com.linecode.order.projection.domain.query.resolver;

import com.linecode.order.projection.domain.query.Query;

public interface QueryResolver <T extends Query, R> {
    
    R resolve(T query);
    
}
