/**
 * IFlags
 *
 * Copyright 2013 Stéphane MENY
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.smeny.retrobox.motherboard.nes.register.flags;

/**
 * This interface is used to define flags used in a flags register. Each String constant must match an enum instance name which is
 * implementing this interface. This is because these strings will be used to retrieve enum instances.
 */
interface IFlags {

  public static final String CARRY = "CARRY";
  public static final String ADD_SUBSTRACT = "ADD_SUBSTRACT";
  public static final String PARITY_OVERFLOW = "PARITY_OVERFLOW";
  public static final String HALF_CARRY = "HALF_CARRY";
  public static final String ZERO = "ZERO";
  public static final String OVERFLOW = "OVERFLOW";
  public static final String NEGATIVE = "NEGATIVE";
  public static final String SIGN = "SIGN";

  public int getPosition();

}
