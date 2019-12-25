package com.example.demo.Service;

public class PasswordCrypto implements Crypto {


    @Override
    public byte[] encrypt(byte[] password) {
        byte[] enc = new byte[password.length];
        for(int i = 0; i < password.length; i++)
        {
            enc[i] = (byte) ((i % 2 == 0) ? password[i] + 1 : password[i] -1);
        }

        return enc;
    }

    @Override
    public byte[] decrypt(byte[] encrytedPassword) {
        byte[] dec = new byte[encrytedPassword.length];
        for(int i = 0; i < encrytedPassword.length; i++)
        {
            dec[i] = (byte) ((i % 2 == 0) ? encrytedPassword[i] - 1 : encrytedPassword[i] + 1);
        }
        return dec;
    }

    ///asdtest
}
