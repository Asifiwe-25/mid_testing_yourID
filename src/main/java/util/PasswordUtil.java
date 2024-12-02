/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author the-ceo
 */
public class PasswordUtil {
    // Method to hash a password using BCrypt
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12)); // Generate hash with a salt strength of 12
    }

    // Method to check if the provided password matches the stored hash
    public static boolean verify(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
