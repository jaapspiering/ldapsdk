/*
 * Copyright 2008-2019 Ping Identity Corporation
 * All Rights Reserved.
 */
/*
 * Copyright (C) 2008-2019 Ping Identity Corporation
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
package com.unboundid.ldap.sdk;



import java.util.concurrent.atomic.AtomicInteger;



/**
 * This class provides a simple unsolicited notification handler that may be
 * used for testing purposes.
 */
public class TestUnsolicitedNotificationHandler
       implements UnsolicitedNotificationHandler
{
  // The number of times the handler has been invoked.
  private final AtomicInteger notificationCount;



  /**
   * Creates a new instance of this test notification handler.
   */
  public TestUnsolicitedNotificationHandler()
  {
    notificationCount = new AtomicInteger(0);
  }



  /**
   * Retrieves the number of times this unsolicited notification handler has
   * been invoked.
   *
   * @return  The number of times this unsolicited notification handler has been
   *          invoked.
   */
  public int getNotificationCount()
  {
    return notificationCount.get();
  }



  /**
   * {@inheritDoc}
   */
  @Override()
  public void handleUnsolicitedNotification(final LDAPConnection connection,
                                            final ExtendedResult notification)
  {
    notificationCount.incrementAndGet();
  }
}

