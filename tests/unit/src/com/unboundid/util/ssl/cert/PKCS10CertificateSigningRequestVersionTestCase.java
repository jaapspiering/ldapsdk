/*
 * Copyright 2017-2018 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2017-2018 Ping Identity Corporation
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.util.ssl.cert;



import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import com.unboundid.ldap.sdk.LDAPSDKTestCase;



/**
 * This class provides test coverage for the
 * PKCS10CertificateSigningRequestVersion class.
 */
public class PKCS10CertificateSigningRequestVersionTestCase
       extends LDAPSDKTestCase
{
  /**
   * Performs a number of tests for the defined set of values.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testValues()
         throws Exception
  {
    for (final PKCS10CertificateSigningRequestVersion v :
         PKCS10CertificateSigningRequestVersion.values())
    {
      assertNotNull(v);

      assertNotNull(v.getIntValue());

      assertNotNull(v.getName());

      assertNotNull(PKCS10CertificateSigningRequestVersion.valueOf(
           v.getIntValue()));
      assertEquals(PKCS10CertificateSigningRequestVersion.valueOf(
           v.getIntValue()), v);

      assertNotNull(PKCS10CertificateSigningRequestVersion.valueOf(v.name()));
      assertEquals(PKCS10CertificateSigningRequestVersion.valueOf(v.name()), v);
    }
  }



  /**
   * Tests the behavior when attempting to use a nonexistent value.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testNonexistentValue()
         throws Exception
  {
    assertNull(PKCS10CertificateSigningRequestVersion.valueOf(1234));

    try
    {
      PKCS10CertificateSigningRequestVersion.valueOf("nonexistent");
      fail("Expected an exception from valueOf with a nonexistent name");
    }
    catch (final IllegalArgumentException iae)
    {
      // This was expected.
    }
  }



  /**
   * Tests the {@code forName} method with automated tests based on the actual
   * name of the enum values.
   *
   * @throws  Exception  If an unexpected problem occurs.
   */
  @Test()
  public void testForNameAutomated()
         throws Exception
  {
    for (final PKCS10CertificateSigningRequestVersion value :
         PKCS10CertificateSigningRequestVersion.values())
    {
      for (final String name : getNames(value.name(), value.getName()))
      {
        assertNotNull(PKCS10CertificateSigningRequestVersion.forName(name));
        assertEquals(PKCS10CertificateSigningRequestVersion.forName(name),
             value);
      }
    }

    assertNull(PKCS10CertificateSigningRequestVersion.forName(
         "some undefined name"));
  }



  /**
   * Retrieves a set of names for testing the {@code forName} method based on
   * the provided set of names.
   *
   * @param  baseNames  The base set of names to use to generate the full set of
   *                    names.  It must not be {@code null} or empty.
   *
   * @return  The full set of names to use for testing.
   */
  private static Set<String> getNames(final String... baseNames)
  {
    final HashSet<String> nameSet = new HashSet<>(10);
    for (final String name : baseNames)
    {
      nameSet.add(name);
      nameSet.add(name.toLowerCase());
      nameSet.add(name.toUpperCase());

      final String nameWithDashesInsteadOfUnderscores = name.replace('_', '-');
      nameSet.add(nameWithDashesInsteadOfUnderscores);
      nameSet.add(nameWithDashesInsteadOfUnderscores.toLowerCase());
      nameSet.add(nameWithDashesInsteadOfUnderscores.toUpperCase());

      final String nameWithUnderscoresInsteadOfDashes = name.replace('-', '_');
      nameSet.add(nameWithUnderscoresInsteadOfDashes);
      nameSet.add(nameWithUnderscoresInsteadOfDashes.toLowerCase());
      nameSet.add(nameWithUnderscoresInsteadOfDashes.toUpperCase());

      final StringBuilder nameWithoutUnderscoresOrDashes = new StringBuilder();
      for (final char c : name.toCharArray())
      {
        if ((c != '-') && (c != '_'))
        {
          nameWithoutUnderscoresOrDashes.append(c);
        }
      }
      nameSet.add(nameWithoutUnderscoresOrDashes.toString());
      nameSet.add(nameWithoutUnderscoresOrDashes.toString().toLowerCase());
      nameSet.add(nameWithoutUnderscoresOrDashes.toString().toUpperCase());
    }

    return nameSet;
  }
}