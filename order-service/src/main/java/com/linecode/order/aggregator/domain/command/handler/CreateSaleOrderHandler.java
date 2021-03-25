package com.linecode.order.aggregator.domain.command.handler;

import com.linecode.order.aggregator.domain.command.CreateSaleOrderCommand;
import com.linecode.order.aggregator.domain.command.dto.CreateSaleOrderPackageDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@PropertySource("classpath:com/linecode/order/aggregator/domain/command/handler/CreateSaleOrderHandler.xml")
public class CreateSaleOrderHandler implements CommandHandler<CreateSaleOrderCommand> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Environment env;

    @Override
    public void run(CreateSaleOrderCommand command) {
        createSaleOrder(command);
        createSaleOrderPackages(command);
    }

    private void createSaleOrder(CreateSaleOrderCommand command) {
        var sql = env.getProperty("createSaleOrder");
        jdbcTemplate.update(sql, command.getId(), command.getBuyerName());
    }

    private void createSaleOrderPackages(CreateSaleOrderCommand command) {
        command.getPackages().stream().forEach(orderPackage -> 
            createSaleOrderPackage(command.getId(), orderPackage)
        );
    }

    private void createSaleOrderPackage(String orderId, CreateSaleOrderPackageDto orderPackage) {
        var sql = env.getProperty("createSaleOrderPackage");
        jdbcTemplate.update(sql, orderId, orderPackage.getId(), 
            orderPackage.getProductGTIN(), orderPackage.getAmount()
        );
    }
}
