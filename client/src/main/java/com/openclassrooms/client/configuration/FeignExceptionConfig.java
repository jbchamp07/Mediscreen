package com.openclassrooms.client.configuration;

import com.openclassrooms.client.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Feign exception config.
 */
//@Configuration
public class FeignExceptionConfig {

    /**
     * M custom error decoder custom error decoder.
     *
     * @return the custom error decoder
     */
    @Bean
    public CustomErrorDecoder mCustomErrorDecoder(){
        return new CustomErrorDecoder();
    }

}
