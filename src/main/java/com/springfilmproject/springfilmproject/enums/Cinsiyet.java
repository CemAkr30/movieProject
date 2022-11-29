package com.springfilmproject.springfilmproject.enums;

import java.io.Serializable;
import java.util.stream.Stream;

public enum Cinsiyet implements Serializable {
    ERKEK(1L, "ERKEK"),
    KADIN(2L, "KADIN");

    private Long id;
    private String adi;

    Cinsiyet(Long id, String adi) {
        this.id = id;
        this.adi = adi;
    }

    public static Stream<Cinsiyet> stream() {
        return Stream.of(Cinsiyet.values());
    }
}