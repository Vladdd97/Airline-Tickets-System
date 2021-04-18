package com.airiline.tickets.configuration.event;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
@EnableRabbit
@RequiredArgsConstructor
public class AmpqConfiguration {

    private final EventConfig eventConfig;

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Declarables directBindings() {
        val emailQueue = QueueBuilder.durable(eventConfig.getEmailQueue()).build();
        val notificationExchange = new TopicExchange(eventConfig.getNotificationExchange());

        return new Declarables(
                emailQueue,
                notificationExchange,
                bind(emailQueue).to(notificationExchange).with(eventConfig.getNotificationEmailRoutingKey())
        );
    }
}
