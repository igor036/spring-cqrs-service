package com.linecode.order.projection.domain.query.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.linecode.order.projection.domain.query.dto.SaleOrderDetailDto;
import com.linecode.order.projection.domain.query.dto.SaleOrderPackageDetailDto;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SaleOrderDetailMapper implements ResultSetExtractor<SaleOrderDetailDto> {

    @Override
    public SaleOrderDetailDto extractData(ResultSet rs) throws SQLException, DataAccessException {
        return null;
    }
    
    public SaleOrderDetailDto extractSaleOrderDetai(ResultSet rs) throws SQLException {
        return SaleOrderDetailDto.builder()
            .id(rs.getString("SALE_ORDER_ID"))
            .status(rs.getString("SALE_ORDER_STATUS"))
            .createdAt(rs.getString("SALE_ORDER_CREATED_AT"))
            .buyerName(rs.getString("BUYER_NAME"))
            .build();
    }

    public List<SaleOrderPackageDetailDto> extractSaleOrderPackageList(ResultSet rs) throws SQLException {

        var saleOrderPackageList = new LinkedList<SaleOrderPackageDetailDto>();

        do {

            var saleOrderPackage = SaleOrderPackageDetailDto.builder()
                .id(rs.getString("ODER_PACKAGE_ID"))
                .status(rs.getString("ODER_PACKAGE_STATUS"))
                .createdAt(rs.getString("ORDER_PACKAGE_CREATED_AT"))
                .productGTIN(rs.getString("PRODUCT_GTIN"))
                .amount(rs.getInt("AMOUNT"))
                .build();
                
            saleOrderPackageList.add(saleOrderPackage);

        } while(rs.next());

        return saleOrderPackageList;
    }
}
