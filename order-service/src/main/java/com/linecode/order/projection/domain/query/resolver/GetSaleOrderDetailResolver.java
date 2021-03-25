package com.linecode.order.projection.domain.query.resolver;

import java.sql.ResultSet;

import com.linecode.order.projection.domain.query.GetSaleOrderDetailQuery;
import com.linecode.order.projection.domain.query.dto.SaleOrderDetailDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:com/linecode/order/projection/domain/query/resolver/GetSaleOrderDetailResolver.xml")
public class GetSaleOrderDetailResolver implements QueryResolver <GetSaleOrderDetailQuery, SaleOrderDetailDto> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;

    @Override
    public SaleOrderDetailDto resolve(GetSaleOrderDetailQuery query) {
        return getSaleOrderDetail(query);
    }

    private SaleOrderDetailDto getSaleOrderDetail(GetSaleOrderDetailQuery query) {

        var sql = env.getProperty("getSaleOrderDetail");
        var mapper = getSaleOrderDetailMapper();

        return jdbcTemplate.query(sql, mapper, query.getSaleOrderId());

    }
    
    private static ResultSetExtractor<SaleOrderDetailDto> getSaleOrderDetailMapper() {
        return (ResultSet rs) -> {

            if (rs.next()) {

                var saleOrderDetai = SaleOrderDetailDto.builder()
                    .id(rs.getString("SALE_ORDER_ID"))
                    .status(rs.getString("SALE_ORDER_STATUS"))
                    .build();

            }

            return null;
        };
    }
}
