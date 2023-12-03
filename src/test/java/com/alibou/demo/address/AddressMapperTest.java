package com.alibou.demo.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressMapperTest {

    private final AddressMapperImpl mapper = new AddressMapperImpl();

    @Test
    public void should_map_address_request_to_address() {
        AddressRequest request = new AddressRequest();
        request.setHomeAddress("home address");

        Address address = mapper.toAddress(request);

        assertNotNull(address);
        assertEquals("home address", address.getHomeAddress());

    }

    @Test
    public void should_return_not_null_address_if_request_is_null() {

        Address address = mapper.toAddress(null);
        assertNotNull(address);
    }

}
