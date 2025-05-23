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

package com.saasovation.identityaccess.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import com.saasovation.common.media.OvationsMediaType;
import com.saasovation.common.serializer.ObjectSerializer;
import com.saasovation.identityaccess.domain.model.identity.Group;

@Path("/tenants/{tenantId}/groups")
public class GroupResource extends AbstractResource {

    public GroupResource() {
        super();
    }

    @GET
    @Path("{groupName}")
    @Produces({OvationsMediaType.ID_OVATION_TYPE})
    public Response getGroup(@PathParam("tenantId") String aTenantId, @PathParam("groupName") String aGroupName, @Context Request aRequest) {

        Group group = this.identityApplicationService().group(aTenantId, aGroupName);

        if (group == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        Response response = this.groupResponse(aRequest, group);

        return response;
    }

    private Response groupResponse(Request aRequest, Group aGroup) {

        Response response = null;

        String representation = ObjectSerializer.instance().serialize(aGroup);

        response = Response.ok(representation).cacheControl(this.cacheControlFor(30)).build();

        return response;
    }
}
