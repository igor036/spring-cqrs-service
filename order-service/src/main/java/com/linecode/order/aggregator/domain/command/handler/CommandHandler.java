package com.linecode.order.aggregator.domain.command.handler;

import com.linecode.order.aggregator.domain.command.Command;

public interface CommandHandler <T extends Command> {
    
    void run(T command);

}
