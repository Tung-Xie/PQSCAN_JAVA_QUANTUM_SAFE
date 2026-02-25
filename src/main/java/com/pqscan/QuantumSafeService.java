package com.pqscan;

import java.security.*;
import javax.crypto.*;

public class QuantumSafeService {
    public void forceScan() throws Exception {
        // --- [KEM / KEX] ---
        KeyPairGenerator.getInstance("ML-KEM", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("Kyber", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("BIKE", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("Classic-McEliece", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("HQC", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("FrodoKEM", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("NTRU", "BCPQC").generateKeyPair();
        KeyPairGenerator.getInstance("sntrup761", "BCPQC").generateKeyPair();

        // --- [PKI / Signature] ---
        Signature.getInstance("ML-DSA", "BCPQC");
        Signature.getInstance("Dilithium", "BCPQC");
        Signature.getInstance("SLH-DSA", "BCPQC");
        Signature.getInstance("Falcon", "BCPQC");
        Signature.getInstance("Mayo", "BCPQC");
        Signature.getInstance("SNOVA", "BCPQC");
        Signature.getInstance("UOV", "BCPQC");
        Signature.getInstance("CROSS", "BCPQC");

        // --- [Cipher & Hash] ---
        // 強制 AES-256 (必須 init 256 才會被判定為抗量子)
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(256);
        Cipher.getInstance("AES/GCM/NoPadding").init(Cipher.ENCRYPT_MODE, kg.generateKey());

        MessageDigest.getInstance("SHA-256").digest();
        MessageDigest.getInstance("SHA-384").digest();
        MessageDigest.getInstance("SHA-512").digest();
        MessageDigest.getInstance("SHA3-384").digest();
        MessageDigest.getInstance("SHA3-512").digest();
    }
}
