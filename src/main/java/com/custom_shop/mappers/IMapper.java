package com.custom_shop.mappers;

public interface IMapper<I, O> {
    public O map(I in);
}
