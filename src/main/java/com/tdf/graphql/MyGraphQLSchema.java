package com.tdf.graphql;

import com.google.common.base.Charsets;
import com.tdf.Device;
import com.tdf.DeviceDAO;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.dropwizard.util.Resources;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

public class MyGraphQLSchema{
    private GraphQL graphQL;
    private DeviceDataFetcher df;
    public GraphQL getGraphQL(){
        return this.graphQL;
    }

    @Inject
    public MyGraphQLSchema(DeviceDataFetcher fet){
        if(null==fet){
            System.out.println("FET is NULL");
        }
        this.df=fet;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("device.graphql");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("devices", df.getAllResumeData()))
                .build();
    }
}

