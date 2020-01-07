package com.example.demo.Service;

public interface Crypto {

    byte[] encrypt(byte[] password);

    byte[] decrypt(byte [] encrytedPassword);
}
