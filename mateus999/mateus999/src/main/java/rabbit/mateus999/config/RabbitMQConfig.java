package rabbit.mateus999.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

    private final static String PAYMENT_QUEUE = "payment.queue";
    private final static String PAYMENT_DLQ_QUEUE = "payment.dlq.queue";
    private final static String PAYMENT_DLX = "payment.dlx";
    private final static String PAYMENT_DLQ_ROUTING_KEY = "payment.failed";

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(
                PAYMENT_DLX
        );
    }

    @Bean
    public Queue deadLetterQueue () {
        return QueueBuilder
                .durable(PAYMENT_DLQ_QUEUE)
                .build();
    }

    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(PAYMENT_DLQ_ROUTING_KEY);
    }

    @Bean
    // criei uma fila do payment queue
    public Queue paymentQueue () {
        return QueueBuilder
                .durable(PAYMENT_QUEUE)
                .deadLetterExchange(PAYMENT_DLX)
                .deadLetterRoutingKey(PAYMENT_DLQ_ROUTING_KEY)
                .build();
    }



}
