//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.saasovation.common.notification;

import java.util.List;

public interface PublishedNotificationTrackerStore {

    public PublishedNotificationTracker publishedNotificationTracker();

    public PublishedNotificationTracker publishedNotificationTracker(String aTypeName);

    public void trackMostRecentPublishedNotification(PublishedNotificationTracker aPublishedNotificationTracker, List<Notification> aNotifications);

    public String typeName();
}
