package com.linecode.order.projection.domain.query.resolver;

import com.linecode.order.projection.domain.query.GetSaleOrderDetailQuery;
import com.linecode.order.projection.domain.query.dto.SaleOrderDetailDto;
import com.linecode.order.projection.domain.query.mapper.SaleOrderDetailMapper;
import com.linecode.order.shared.exception.ResourceNotFound;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
@PropertySource("classpath:com/linecode/order/projection/domain/query/resolver/GetSaleOrderDetailResolver.xml")
public class GetSaleOrderDetailResolver implements QueryResolver <GetSaleOrderDetailQuery, SaleOrderDetailDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;

    @Override
    public SaleOrderDetailDto resolve(GetSaleOrderDetailQuery query) {
        var saleOrderDetail = getSaleOrderDetail(query);
        if (saleOrderDetail != null) {
            return saleOrderDetail;
        }
        throw new ResourceNotFound();
    }

    private SaleOrderDetailDto getSaleOrderDetail(GetSaleOrderDetailQuery query) {
        var sql = env.getProperty("getSaleOrderDetail");
        var mapper = new SaleOrderDetailMapper();
        return jdbcTemplate.query(sql, mapper, query.getSaleOrderId());
    }
}
