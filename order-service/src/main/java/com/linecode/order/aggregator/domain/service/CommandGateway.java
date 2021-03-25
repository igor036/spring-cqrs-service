package com.linecode.order.aggregator.domain.service;

import java.util.List;

import com.linecode.order.aggregator.domain.command.Command;
import com.linecode.order.aggregator.domain.command.handler.CommandHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class CommandGateway {

    @Autowired
    private List<CommandHandler> handlers;
    
    public void handler(Command command) {
        var commandHandler = getCommandHandler(command);
        commandHandler.run(command);
    }

    private CommandHandler getCommandHandler(Command command) {

        var beanName = getCommandHandlerBeanName(command);
        var commandHandler = handlers
            .stream().filter(handler -> isBeanName(handler, beanName))
            .findFirst();

        if (commandHandler.isPresent()) {
            return commandHandler.get();
        }

        throw commandHandlerNotFoundException(command);
    }

    private String getCommandHandlerBeanName(Command command) {
        return command.getClass().getSimpleName().replace("Command", "Handler");
    }

    private boolean isBeanName(CommandHandler handler, String beanName) {
        return handler.getClass().getSimpleName().equals(beanName);
    }

    private IllegalArgumentException commandHandlerNotFoundException(Command command) {
        var message = String.format("Error when try find command hendler to %s", command.getClass().toString());
        return new IllegalArgumentException(message);
    }
}
