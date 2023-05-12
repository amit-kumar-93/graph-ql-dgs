package com.amit.server.context;

import com.netflix.graphql.dgs.context.GraphQLContextContributor;
import com.netflix.graphql.dgs.internal.DgsRequestData;
import graphql.GraphQLContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GQlContextContributor implements GraphQLContextContributor {

    public static final String CONTRIBUTOR_ENABLED_CONTEXT_KEY = "contributorEnabled";
    public static final String CONTRIBUTOR_ENABLED_CONTEXT_VALUE = "true";
    public static final String CONTEXT_CONTRIBUTOR_HEADER_NAME = "context-contributor-header";
    public static final String CONTEXT_CONTRIBUTOR_HEADER_VALUE = "enabled";

    @Override
    public void contribute(@NotNull GraphQLContext.Builder builder, @Nullable Map<String, ?> map, @Nullable DgsRequestData dgsRequestData) {
        builder.put("exampleGraphQLContextEnabled", true);
        if(dgsRequestData != null && dgsRequestData.getHeaders() != null){
            String contributedContextHeader = dgsRequestData.getHeaders().getFirst(CONTEXT_CONTRIBUTOR_HEADER_NAME);
            if(CONTEXT_CONTRIBUTOR_HEADER_VALUE.equals(contributedContextHeader)){
                builder.put(CONTRIBUTOR_ENABLED_CONTEXT_KEY, CONTRIBUTOR_ENABLED_CONTEXT_VALUE);
            }
        }
    }
}
