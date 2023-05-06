package com.amit.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;

import java.util.List;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name="directors")
public class DirectorDataLoader implements BatchLoader<String, Director> {
    @Override
    public CompletionStage<List<Director>> load(List<String> list) {
        return null;
    }
}
