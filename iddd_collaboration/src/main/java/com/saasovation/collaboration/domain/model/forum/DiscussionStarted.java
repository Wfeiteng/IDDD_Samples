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

package com.saasovation.collaboration.domain.model.forum;

import java.util.Date;

import com.saasovation.collaboration.domain.model.collaborator.Author;
import com.saasovation.collaboration.domain.model.tenant.Tenant;
import com.saasovation.common.domain.model.DomainEvent;

public class DiscussionStarted implements DomainEvent {

    private Author author;
    private DiscussionId discussionId;
    private int eventVersion;
    private String exclusiveOwner;
    private ForumId forumId;
    private Date occurredOn;
    private String subject;
    private Tenant tenant;

    public DiscussionStarted(Tenant aTenant, ForumId aForumId, DiscussionId aDiscussionId, Author anAuthor, String aSubject, String anExclusiveOwner) {

        super();

        this.author = anAuthor;
        this.discussionId = aDiscussionId;
        this.eventVersion = 1;
        this.exclusiveOwner = anExclusiveOwner;
        this.forumId = aForumId;
        this.occurredOn = new Date();
        this.subject = aSubject;
        this.tenant = aTenant;
    }

    public Author author() {
        return this.author;
    }

    public DiscussionId discussionId() {
        return this.discussionId;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    public String exclusiveOwner() {
        return this.exclusiveOwner;
    }

    public ForumId forumId() {
        return this.forumId;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }

    public String subject() {
        return this.subject;
    }

    public Tenant tenant() {
        return this.tenant;
    }
}
