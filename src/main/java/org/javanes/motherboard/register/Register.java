package org.javanes.motherboard.register;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a register that will be accessed and modified.
 * 
 * @author Stéphane Meny
 */
public final class Register {
    /** Our default logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(Register.class.getName());

    /**
     * Mask used to get the first byte from the register.
     */
    private static final int FIRST_BYTE_MASK = 0xFF;

    /**
     * Mask used to get the second byte from the register.
     */
    private static final int SECOND_BYTE_MASK = 0xFF00;

    /**
     * Shift used to move the second byte on the first byte.
     */
    private static final int SECOND_BYTE_SHIFT = 8;

    /**
     * Mask used to insure that value of register will never be more than two
     * bytes long.
     */
    private static final int TWO_BYTES_MASK = 0xFFFF;

    /**
     * The register's data represented as a integer. Integer primary type is
     * used to optimise further computations since in Java all computations are
     * done on integers.
     */
    private int registerData;

    /**
     * Default constructor which initialises the register's data to 0.
     */
    public Register() {
        registerData = 0;
    }

    /**
     * Default constructor which initialises the register's data to given
     * address.
     */
    public Register(int address) {
        registerData = address;
    }

    /**
     * Returns the data contained inside the register.
     * 
     * @return The register's data as an integer.
     */
    public int getRegisterData() {
        return (registerData & TWO_BYTES_MASK);
    }

    /**
     * Returns the first ordered byte extracted from the register's data.
     * 
     * @return The register's low byte.
     */
    public byte getRegisterFirstByte() {
        return (byte) (registerData & FIRST_BYTE_MASK);
    }

    /**
     * Returns the second ordered byte extracted from the register's data.
     * 
     * @return The register's high byte.
     */
    public byte getRegisterSecondByte() {
        return (byte) ((registerData & SECOND_BYTE_MASK) >>> SECOND_BYTE_SHIFT);
    }

    /**
     * Sets the data to store inside the register.
     * 
     * @param data
     *            The data to store as an integer.
     */
    public void setRegisterData(final int data) {
        registerData = data & TWO_BYTES_MASK;
    }
    
    public void increment() {
        increment(1);
    }

    public void increment(final int times) {
        for (int i = 0; i < times; i++) {
            if (registerData < TWO_BYTES_MASK) {
                registerData++;
            } else {
                LOGGER.log(Level.SEVERE, "Buffer overflow in register");
                System.exit(1);
            }
        }
    }
    
    public void decrement() {
        decrement(1);
    }

    public void decrement(final int times) {
        for (int i = 0; i < times; i++) {
            if (registerData > 0) {
                registerData--;
            } else {
                LOGGER.log(Level.SEVERE, "Buffer overflow in register");
                System.exit(1);
            }
        }
    }

}
