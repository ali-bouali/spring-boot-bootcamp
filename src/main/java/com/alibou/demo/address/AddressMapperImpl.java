package com.alibou.demo.address;

public class AddressMapperImpl {
    public Address toAddress(AddressRequest request) {
        if (request == null) {
            return Address.builder().build();
        }
        return Address.builder()
                .homeAddress(request.getHomeAddress())
                .build();
    }
}
