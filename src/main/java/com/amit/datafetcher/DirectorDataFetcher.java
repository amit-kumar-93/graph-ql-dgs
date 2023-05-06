package com.amit.datafetcher;

import com.amit.DgsConstants;
import com.amit.dataloader.mapped.DirectorsMappedDataLoader;
import com.amit.types.Director;
import com.amit.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class DirectorDataFetcher {

    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME,field = "directors")
    public CompletableFuture<List<Director>> directors(DataFetchingEnvironment dfe) {
        DataLoader<String, List<Director>> dataloader = dfe.getDataLoader("directorsMappedDataLoaderLambda");
        Show show = dfe.getSource();
        return dataloader.load(show.getTitle());
    }

//    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME, field = DgsConstants.DIRECTOR.TYPE_NAME)
//    public CompletableFuture<List<Director>> directors(DgsDataFetchingEnvironment dfe) {
//        DataLoader<String, List<Director>> dataloader = dfe.getDataLoader(DirectorDataLoader.class);
//        Show show = dfe.getSource();
//        return dataloader.load(show.getTitle());
//    }
}
