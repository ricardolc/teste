package com.e4developer.foodorderpublisher;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CustomerSource {

    @Input("customerChannelInput")
    MessageChannel customerOrder();

}
